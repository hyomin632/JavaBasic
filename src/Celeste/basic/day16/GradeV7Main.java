package Celeste.basic.day16;

import Celeste.basic.grade.GradeServiceV3;
import Celeste.basic.grade.GradeServiceV3Impl;

import java.util.Scanner;

public class GradeV7Main {
    public static void main(String[] args) {
        // 성적 처리 프로그램 V7 - ArrayList + 텍스트 기반 스트림 + 직렬화
        // 입력한 성적 데이터를 직렬화를 통해 텍스트 파일에 저장
        // 따라서, 프로그램 종료시 입력했던 데이터는 그대로 유지
        // GradeService V3
        // initGrade, saveGrade (파일 처리/ 직렬화) 추가
        Scanner sc = new Scanner(System.in);
        GradeServiceV3 gsrv = GradeServiceV3Impl.getInstance();
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
                case "0": gsrv.saveGrade();
                          System.exit(0); break;
                default: System.out.println("잘못 입력하셨습니다!");
            }
    }
}
}
