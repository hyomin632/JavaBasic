package Celeste.basic.grade;

import Celeste.basic.jdbc.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class GradeV4DAOImpl implements GradeV4DAO {

    private JDBCUtil jdbc;
    private String insertSQL = " insert into grade (name, kor, eng, mat, tot, mean, grd) values (?,?,?,?,?,?,?) ";
    private String selectSQL = " select gno, name, kor, eng, mat, mid(regdate, 1, 10) regdate from grade order by gno ";
    private String selectOneSQL = " select * from grade where gno = ? ";
    private String updateSQL = " update grade set name = ?, kor = ?, eng = ?, mat = ?, " +
                               " tot = ?, mean = ?, grd = ?, regdate = current_timestamp where gno = ? ";
    private String deleteSQL = " delete from grade where gno = ? ";

    public GradeV4DAOImpl() {
        jdbc = new JDBCUtil();
    }

    // Service에서 넘겨준 성적 데이터를 grade 테이블에 저장
    @Override
    public int insertGrade(GradeVO g) {
        int cnt = 0;
        try (
                Connection conn = jdbc.openConn();
                PreparedStatement pstmt = conn.prepareStatement(insertSQL);
        ) {
            pstmt.setString(1, g.getName());
            pstmt.setInt(2, g.getKor());
            pstmt.setInt(3, g.getEng());
            pstmt.setInt(4, g.getMat());
            pstmt.setInt(5, g.getTot());
            pstmt.setDouble(6, g.getAvg());
            pstmt.setString(7, g.getGrd()+"");

            cnt = pstmt.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return cnt;
    }

    // grade 테이블에서 번호, 이름, 국어, 영어, 수학, 등록일 등을 조회한 후, ArrayList에 담아서 Service로 넘김
    @Override
    public List<GradeVO> selectGrade() {
        List<GradeVO> glist = new ArrayList<>();
        try (
                Connection conn = jdbc.openConn();
                PreparedStatement pstmt = conn.prepareStatement(selectSQL);
                ResultSet rs = pstmt.executeQuery();
        ) {
            while (rs.next()) {
                GradeVO g = new GradeVO(rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5));
                g.setGno(rs.getString(1));
                g.setRegdate(rs.getString(6));
                glist.add(g);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return glist;
    }

    // Service에서 넘겨준 학생 번호로 grade 테이블을 조회한 후,
    // 조회된 모든 결과를 GradeVO에 담아서 Service로 넘김
    @Override
    public GradeVO selectOneGrade(int gno) {
        GradeVO g = null;
        try (
                Connection conn = jdbc.openConn();
                PreparedStatement pstmt = conn.prepareStatement(selectOneSQL);
        ) {
            pstmt.setInt(1, gno);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                g = new GradeVO(rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5));
                g.setGno(rs.getString(1));
                g.setTot(rs.getInt(6));
                g.setAvg(rs.getDouble(7));
                g.setGrd(rs.getString(8).charAt(0));
                g.setRegdate(rs.getString(9));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return g;
    }

    // Service에서 넘겨준 학생 번호로 grade 테이블을 조회한 후,
    // 수정할 성적 데이터로 grade 테이블을 수정
    @Override
    public int updateGrade(GradeVO g) {
        int cnt = 0;
        try (
                Connection conn = jdbc.openConn();
                PreparedStatement pstmt = conn.prepareStatement(updateSQL);
        ) {
            pstmt.setString(1, g.getName());
            pstmt.setInt(2, g.getKor());
            pstmt.setInt(3, g.getEng());
            pstmt.setInt(4, g.getMat());
            pstmt.setInt(5, g.getTot());
            pstmt.setDouble(6, g.getAvg());
            pstmt.setString(7, g.getGrd()+"");
            pstmt.setString(8, g.getGno());

            cnt = pstmt.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return cnt;
    }

    // Service에서 넘겨준 학생 번호로 grade 테이블을 조회한 후, 해당 성적 데이터를 삭제
    @Override
    public int deleteGrade(int gno) {
        int cnt = 0;

        try (
                Connection conn = jdbc.openConn();
                PreparedStatement pstmt = conn.prepareStatement(deleteSQL);
        ) {
            pstmt.setInt(1, gno);
            cnt = pstmt.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return cnt;

    }

}
