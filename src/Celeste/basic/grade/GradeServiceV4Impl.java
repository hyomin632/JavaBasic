package Celeste.basic.grade;

import java.util.ArrayList;
import java.util.Scanner;

public class GradeServiceV4Impl implements GradeServiceV4 {

    // 싱글톤 패턴 시작
    private static GradeServiceV4 gsrv = null;
    private static GradeV4DAO gdao = null;

    private GradeServiceV4Impl() {
        gdao = new GradeV4DAOImpl();
    }

    public static GradeServiceV4 getInstance() {
        if (gsrv == null) gsrv = new GradeServiceV4Impl();
        return gsrv;
    }
    // 싱글톤 패턴 끝

    @Override
    public void displayMenu() {
        String displaymenu =
                        "------------------------- \n" +
                        "    성적 프로그램 v8      \n" +
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

            int cnt = gdao.insertGrade(g);
            if (cnt > 0) System.out.println("성적 데이터 추가 완료!");

        } catch (Exception ex) {
            System.out.println("잘못 입력하셨습니다!");
            return; // 오류 발생시 실행 중단, main으로 복귀
        }
    }

    @Override
    public void showGrade() {
        String fmt = "%s, %s, %d, %d, %d, %s \n";
        ArrayList<GradeVO> glist = (ArrayList<GradeVO>) gdao.selectGrade();

        StringBuffer sb = new StringBuffer();
        for (GradeVO g : glist) {
            String result = String.format(fmt, g.getGno(), g.getName(), g.getKor(), g.getEng(), g.getMat(), g.getRegdate());
            sb.append(result);
        }
        System.out.println(sb.toString());
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
        String fmt = "%s, %s, %d, %d, %d \n" + "%d, %.1f, %c, %s \n";
        Scanner sc = new Scanner(System.in);
        System.out.print("조회할 학생의 번호는?: ");
        int gno = sc.nextInt();
        GradeVO g = gdao.selectOneGrade(gno);

        String result = String.format(fmt, g.getGno(), g.getName(), g.getKor(), g.getEng(),
                                      g.getMat(), g.getTot(), g.getAvg(), g.getGrd(), g.getRegdate());

        System.out.println(result);
    }

    @Override
    public void modifyGrade() {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("수정할 학생의 번호는?: ");
            String gno = sc.next();
            System.out.println("수정할 성적 데이터를 입력하세요");
            System.out.println("입력 순서는 이름, 국어, 영어, 수학: ");
            String name = sc.next();
            int kor = Integer.parseInt(sc.next());
            int eng = Integer.parseInt(sc.next());
            int mat = Integer.parseInt(sc.next());

            GradeVO g = new GradeVO(name, kor, eng, mat);
            g.setGno(gno);
            computeGrade(g); // 수정된 정보로 다시 성적 처리

            int cnt = gdao.updateGrade(g);
            if (cnt > 0) System.out.println("성적 데이터 수정 완료!");

        } catch (Exception ex) {
            System.out.println("잘못 입력하셨습니다!");
            return;
        }

    }

    @Override
    public void removeGrade() {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("삭제할 학생의 번호는? ");
            int gno = Integer.parseInt(sc.next());

            int cnt = gdao.deleteGrade(gno);
            if (cnt > 0) System.out.println("성적 데이터 삭제 완료!");
        } catch (Exception ex) {
            System.out.println("잘못 입력하셨습니다!");
            return;
        }



    }
}
