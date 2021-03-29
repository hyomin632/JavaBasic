package Celeste.basic.day10;

import Celeste.basic.grade.GradeService;
import Celeste.basic.grade.GradeServiceImpl;
import Celeste.basic.grade.GradeVO;

import java.util.Scanner;

public class GradeV5cMain {
    private GradeV5cMain() { }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GradeService gsrv = GradeServiceImpl.getInstance();
        // gsrvs는 인스턴스 변수이므로, 객체마다 개별적으로 생성
        // 정적변수로 만들어서 모든 객체가 이것을 공유하도록 변경해야 함
        // singleton 패턴을 이용해서 단일 객체로만 생성되도록 제한

        String menu = "";
        GradeVO g = null;

        while(true) {
            gsrv.displayMenu();
            menu = sc.next();
            switch(menu) {
                case "1": g = gsrv.readGrade();
                          gsrv.computeGrade(g); break;
                case "2": break;
                case "3": gsrv.printGrade(g); break;
                case "4": break;
                case "5": break;
                case "0": System.exit(0); break;
                default: System.out.println("잘못 입력하셨습니다!");
            }
        }
    }
}
