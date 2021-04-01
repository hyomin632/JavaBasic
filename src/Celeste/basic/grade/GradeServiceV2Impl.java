package Celeste.basic.grade;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GradeServiceV2Impl implements GradeServiceV2 {
    // 멤버변수 선언
    // 입력받은 모든 성적 데이터를 저장하는 동적 배열변수 선언
    List<GradeVO> gdata = new ArrayList<>();
    GradeVO g = null;

    // 싱글톤 패턴 시작
    private static GradeServiceV2 gsrv = null;
    public GradeServiceV2Impl() { }
    public static GradeServiceV2 getInstance() {
        if (gsrv == null) gsrv = new GradeServiceV2Impl();
        return gsrv;
    }
    // 싱글톤 패턴 끝

    @Override
    public void displayMenu() {
        String displaymenu =
                        "------------------------- \n" +
                        "    성적 프로그램 v6      \n" +
                        "------------------------- \n" +
                        " 1. 성적 데이터 입력      \n" +
                        " 2. 성적 데이터 조회      \n" +
                        " 3. 성적 데이터 상세 조회 \n" +
                        " 4. 성적 데이터 수정      \n" +
                        " 5. 성적 데이터 삭제      \n" +
                        " 0. 프로그램 종료         \n" +
                        "------------------------- \n" +
                        " 작업을 선택하세요: ";
        System.out.println(displaymenu);
    }

    @Override
    public void newGrade() {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("이름은?: ");
            String name = sc.next();
            System.out.print("국어는?: ");
            int kor = sc.nextInt();
            System.out.print("영어는?: ");
            int eng = sc.nextInt();
            System.out.print("수학은?: ");
            int mat = sc.nextInt();
            GradeVO g = new GradeVO(name, kor, eng, mat); // 입력받은 성적 데이터를 객체화
            computeGrade(g);                              // 성적 데이터 처리
            gdata.add(g);                                 // 처리된 성적 데이터를 동적 배열에 저장
        } catch (Exception ex) {
            System.out.println("잘못 입력하셨습니다");
            return; // 오류 발생시 실행 중단, main으로 복귀
        }
    }

    // 저장된 성적 데이터들 중에서 배열 인덱스, 이름, 국어, 영어, 수학만 뽑아서 목록(list) 형태로 출력
    @Override
    public void showGrade() {
        String fmt = "번호: %d, 이름: %s, 국어: %d, 영어: %d, 수학: %d \n";
        int pos = 0; // 배열 인덱스
        for(GradeVO g : gdata) {
            System.out.printf(fmt, pos, g.getName(), g.getKor(), g.getEng(), g.getMat());
            ++pos;
        }
    }

    @Override
    public void computeGrade(GradeVO g) {
        g.setTot(g.getKor() + g.getEng() + g.getMat());
        g.setAvg((double) g.getTot() / 3);
        switch ((int)g.getAvg() / 10) {
            case 10: case 9: g.setGrd('수'); break;
            case 8: g.setGrd('우'); break;
            case 7: g.setGrd('미'); break;
            case 6: g.setGrd('양'); break;
            default: g.setGrd('가'); break;
        }
    }

    @Override
    public void showOneGrade() {
        String fmt = "번호: %d, 이름: %s, 국어: %d 영어: %d 수학: %d \n" + "총점: %d, 평균: %.1f, 학점: %c \n";
        Scanner sc = new Scanner(System.in);
        System.out.print("조회할 학생의 번호는?: ");
        int pos = sc.nextInt();

        try {
            GradeVO g = gdata.get(pos);
            System.out.printf(fmt, pos, g.getName(), g.getKor(), g.getEng(), g.getMat(), g.getTot(), g.getAvg(), g.getGrd());
        } catch (Exception ex) {
            System.out.println("데이터가 존재하지 않습니다");
        }
    }


    @Override
    public void modifyGrade() {

    }

    @Override
    public void removeGrade() {

    }
}
