package Celeste.basic.day17;

import java.sql.*;

public class JDBCCRUD2 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // ex) playground 데이터베이스의 books 테이블에 저장된 테이터들을 조회하는 프로그램 작성
        // 조회 대상: 모든 컬럼

        // JDBC 접속 정보
        String drv = "org.mariadb.jdbc.Driver";
        String amz = "bigdata.ce67r0x8wwmd.ap-northeast-2.rds.amazonaws.com";
        String url = "jdbc:mariadb://"+amz+":3306/playground";
        String usr = "playground";
        String pwd = "bigdata2020";

        // JDBC 관련 sql 정의
        String readAll = " select * from books ";
        String readAll2 = " select bookname, price from books ";
        String readOne = " select * from books where publisher = 'oracle' ";

        Class.forName(drv);

        try (Connection conn = DriverManager.getConnection(url, usr, pwd);
             Statement stmt = conn.createStatement();

             ResultSet rs = stmt.executeQuery(readAll);
         // 지정한 SQL을 실행하고 결과 집합을 받아옴
         // 단, select 실행시에만 사용!
        ){
            StringBuffer sb = new StringBuffer();

            while(rs.next()) {
                // 결과 집합에서 불러올 데이터가 없을 때까지 다음을 반복
                sb.append(rs.getString(1))
                        // 결과 집합에서 첫 번째 컬럼값을 문자 형태로 읽어옴
                  .append(rs.getString("bookname"))
                        // 결과 집합에서 bookname 컬럼값을 문자 형태로 읽어옴
                  .append(rs.getString(3))
                  .append(rs.getString(4))
                  .append("\n");
            }

            System.out.println(sb.toString()); // 결과 출력
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        // readAll2
        try (Connection conn = DriverManager.getConnection(url, usr, pwd);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(readAll2);
        ) {
            StringBuffer sb = new StringBuffer();
            while(rs.next()) {
                sb.append(rs.getString("bookname")).append(" ")
                  .append(rs.getString("price")).append(" ")
                  .append("\n");
            }
            System.out.println(sb.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        // readOne
        try (Connection conn = DriverManager.getConnection(url, usr, pwd);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(readOne);
        ) {
            String fmt = "%s / %s / %s / %s \n";
            StringBuffer sb = new StringBuffer();
            while(rs.next()) {
                String result = String.format(fmt, rs.getString(1), rs.getString(2),
                                              rs.getString(3), rs.getString(4));
                sb.append(result);
            }
            System.out.println(sb.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
        }


    }
}
