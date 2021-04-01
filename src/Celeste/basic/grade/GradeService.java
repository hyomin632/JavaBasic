package Celeste.basic.grade;

// 성적 서비스 V1 -> 입력, 처리, 출력 기능 구현
// 프로그램 메뉴 출력 기능 추가
public interface GradeService {

    void displayMenu();
    GradeVO readGrade();
    void computeGrade(GradeVO g);
    void printGrade(GradeVO g);
}
