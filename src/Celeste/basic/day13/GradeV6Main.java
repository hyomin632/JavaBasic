package Celeste.basic.day13;

import Celeste.basic.grade.*;

import java.util.Scanner;

public class GradeV6Main {
    public static void main(String[] args) {
        // 성적 처리 프로그램 V6 - ArrayList + CRUD
        // 동적 배열을 이용해서 대량의 성적 데이터를 저장할 수 있게 함
        // 즉, 입력받은 성적 데이터는 동적 배열에 저장하고, 저장한 데이터들을 조회/수정/삭제할 수 있도록 함
        // GradeService V2
        // (1) newGrade, (2) showGrade, (3) ShowOneGrade, (4) modifyGrade, (5) removeGrade
        // computeGrade, displayMenu
        Scanner sc = new Scanner(System.in);
        GradeServiceV2 gsrv = GradeServiceV2Impl.getInstance();
        String menu = "";
        while(true) {
            gsrv.displayMenu();
            menu = sc.next();
            switch(menu) {
                case "1": gsrv.newGrade(); break;
                case "2": gsrv.showGrade(); break;
                case "3": gsrv.showOneGrade(); break;
                case "4": gsrv.modifyGrade(); break;
                case "5": gsrv.removeGrade(); break;
                case "0": System.exit(0); break;
                default: System.out.println("잘못 입력하셨습니다!");
            }
    }
}
}
