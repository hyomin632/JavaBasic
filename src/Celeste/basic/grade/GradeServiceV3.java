package Celeste.basic.grade;

import Celeste.basic.grade.GradeServiceV2;
import Celeste.basic.grade.GradeVO;

// 성적 서비스 V3 -> 입력, 처리, 출력 기능 구현
// 프로그램 메뉴 출력 기능 구현
// 파일 입출력 + 직렬화 기능 추가
public interface GradeServiceV3 extends GradeServiceV2 {

    void initGrade();
    void saveGrade();

    void initGrade2();
    void saveGrade2();

    void initGrade3();
    void saveGrade3();
}
