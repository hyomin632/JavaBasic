package Celeste.basic.day17;

import java.sql.*;
import java.util.Scanner;

public class JDBCMember {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // 네이버 회원가입 기능을 JDBC로 구현
        // 테이블명: NMember (playground)
        // 테이블 컬럼 구성: userid, passwd, name, birth, gender, email, phone
        // 자동 입력 컬럼: mbno(PK), regdate

        String drv = "org.mariadb.jdbc.Driver";
        String amz = "";
        String url = "jdbc:mariadb://"+amz+":3306/playground";
        String usr = "playground";
        String pwd = "bigdata2020";

        // 회원가입 테이블
        /*String NMember = " create table NMember(mbno int primary key auto_increment, userid varchar(20) not null, " +
                         " passwd varchar(20) not null, name varchar(10) not null, birth varchar(10) not null, " +
                         " gender int not null, email varchar(30) not null, phone varchar(20) not null, regdate datetime default current_timestamp ) "; =*/

        // 데이터 삽입 테스트
        /*insert into NMember (userid, passwd, name, birth, gender, email, phone)
                values('abc123', '987xyz', '홍길동', '2021-04-21', 0, '123456@abc.com', '010-1234-5678');*/

        // 데이터 조회 테스트
        // select mbno, userid, name, regdate from NMember order by mbno desc;

        // 데이터 상세 조회 테스트
        // select * from NMember where mbno = 1;

        // 데이터 수정 테스트
        // update NMember set name = "전지현", birth = "2020-04-21", phone = "010-9876-5432" where mbno = 1;

        // 데이터 삭제 테스트
        // delete from NMember where mbno = 1;

        // 회원 정보 입력
        Scanner sc = new Scanner(System.in);
        System.out.println("회원정보를 입력하세요: ");
        System.out.println("아이디, 비밀번호, 이름, 생년월일, 성별, 이메일, 전화번호");
        String userid = sc.next();
        String passwd = sc.next();
        String name = sc.next();
        String birth = sc.next();
        String gender = sc.next();
        String email = sc.next();
        String phone = sc.next();

        // JDBC를 이용해서 NMember 테이블에 회원 정보 저장
        String sql = " insert into NMember (userid, passwd, name, birth, gender, email, phone) values (?,?,?,?,?,?,?) ";

        MariaJDBC jdbc = new MariaJDBC();

        try (Connection conn = jdbc.openConn();
             PreparedStatement pstmt = conn.prepareStatement(sql);
        ) {
            pstmt.setString(1, userid);
            pstmt.setString(2, passwd);
            pstmt.setString(3, name);
            pstmt.setString(4, birth);
            pstmt.setString(5, gender);
            pstmt.setString(6, email);
            pstmt.setString(7, phone);

            int cnt = pstmt.executeUpdate();
            if (cnt > 0) System.out.println("회원가입 성공!");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        // 회원가입 완료 후 지금까지 가입한 모든 회원 조회
        // 조회 대상 컬럼: 회원번호, 아이디, 이름, 가입일
        sql = " select mbno, userid, name, regdate from NMember order by mbno desc ";

        try (
                Connection conn = jdbc.openConn();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                ResultSet rs = pstmt.executeQuery(sql);
        ) {
            String fmt = "%s, %s, %s, %s\n";
            StringBuffer sb = new StringBuffer();
            while(rs.next()) {
                String result = String.format(fmt, rs.getString(1), rs.getString(2),
                                              rs.getString(3), rs.getString(4).substring(0, 10));
                sb.append(result);
            }
            System.out.println(sb.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
