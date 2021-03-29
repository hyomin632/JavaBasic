package Celeste.basic.grade;

import java.util.Scanner;

public class GradeServiceImpl implements GradeService {
    // 싱글톤 패턴 시작
    private static GradeService gsrv = null;
    public GradeServiceImpl() { }
    public static GradeService getInstance() {
        if (gsrv == null) gsrv = new GradeServiceImpl();
        return null;
    }
    @Override
    public void displayMenu() {
        String displaymenu =
                        "------------------------- \n" +
                        "    성적 프로그램 v3      \n" +
                        "------------------------- \n" +
                        " 1. 성적 데이터 입력      \n" +
                        " 2. 성적 데이터 조회      \n" +
                        " 3. 성적 데이터 상세 조회 \n" +
                        " 4. 성적 데이터 수정      \n" +
                        " 5. 성적 데이터 삭제      \n" +
                        " 0. 프로그램 종료         \n" +
                        "------------------------- \n" +
                        " 작업을 선택하세요:       \n";
        System.out.println(displaymenu);
    }

    @Override
    public GradeVO readGrade() {
        Scanner sc = new Scanner(System.in);
        System.out.print("이름은?: ");
        String name = sc.next();
        System.out.print("국어는?: ");
        int kor = sc.nextInt();
        System.out.print("영어는?: ");
        int eng = sc.nextInt();
        System.out.print("수학은?: ");
        int mat = sc.nextInt();

        return new GradeVO(name, kor, eng, mat);
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
    public void printGrade(GradeVO g) {
        String fmt = "%s %d %d %d \n%d %.1f %c\n";
        System.out.printf(fmt, g.getName(), g.getKor(), g.getEng(), g.getMat(), g.getTot(), g.getAvg(), g.getGrd());
    }
}
