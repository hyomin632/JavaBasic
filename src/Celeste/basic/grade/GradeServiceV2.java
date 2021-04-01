package Celeste.basic.grade;

// 성적 서비스 V2 -> 입력, 처리, 출력 기능 구현
// 프로그램 메뉴 출력 기능 추가
public interface GradeServiceV2 {

    void displayMenu();
    void computeGrade(GradeVO g);
    void newGrade();
    void showGrade();
    void showOneGrade();
    void modifyGrade();
    void removeGrade();

}
