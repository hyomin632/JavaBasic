package Celeste.basic.grade;

import java.util.List;

public interface GradeV4DAO {
    int insertGrade(GradeVO g);
    List<GradeVO> selectGrade();
    GradeVO selectOneGrade(int gno);
    int updateGrade(GradeVO g);
    int deleteGrade(int gno);
}
