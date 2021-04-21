package Celeste.basic.day17;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class JDBCCRUD3 {
    public static void main(String[] args) {
        // ex) playground 데이터베이스의 books 테이블에 저장된 데이터들 중에서
        // 출판사가 oracle인 도서의 제목을 python으로 변경
        String sql = " update books set bookname = 'python' where publisher = 'oracle' ";

        MariaJDBC jdbc = new MariaJDBC();

        try (
                Connection conn = jdbc.openConn();
                PreparedStatement pstmt = conn.prepareStatement(sql);
        ) {
            int cnt = pstmt.executeUpdate(); // cnt = count
            if (cnt > 0) System.out.println("데이터 수정 완료!");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        // ex) playgound 데이터베이스의 books 테이블에 저장된 데이터들 중에서
        // 도서명이 python인 도서를 삭제
        String sql1 = " delete from books where bookname = 'python' ";

        MariaJDBC jdbc1 = new MariaJDBC();

        try (
                Connection conn = jdbc1.openConn();
                PreparedStatement pstmt = conn.prepareStatement(sql1);
        ) {
            int cnt = pstmt.executeUpdate();
            if (cnt > 0) System.out.println("데이터 삭제 완료!");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
