package Celeste.basic.day16;

import Celeste.basic.grade.GradeServiceV3;
import Celeste.basic.grade.GradeServiceV3Impl;

import java.util.Scanner;

public class GradeV7cMain {
    public static void main(String[] args) {
        // 성적 처리 프로그램 V7c - ArrayList + 텍스트 기반 스트림
        // 입력한 성적 데이터를 json직렬화를 통해 텍스트 기반 파일에 저장
        // json직렬화: 각 데이터 항목을 반정형 형식으로 구분해서 파일에 저장하는 방식
        // { 항목명 1:항목값1, 항목명 2:항목값2, 항목명 3:항목값3, ... }
        // 따라서, 프로그램 종료시 입력했던 데이터는 그대로 유지
        // GradeService V3
        // initGrade3, saveGrade3 (파일 처리/ json직렬화) 추가
        Scanner sc = new Scanner(System.in);
        GradeServiceV3 gsrv = GradeServiceV3Impl.getInstance();

        String menu = "";
        gsrv.initGrade3();

        while(true) {
            gsrv.displayMenu();
            menu = sc.next();
            switch(menu) {
                case "1": gsrv.newGrade(); break;
                case "2": gsrv.showGrade(); break;
                case "3": gsrv.showOneGrade(); break;
                case "4": gsrv.modifyGrade(); break;
                case "5": gsrv.removeGrade(); break;
                case "0": gsrv.saveGrade3();
                          System.exit(0); break;
                default: System.out.println("잘못 입력하셨습니다!");
            }
    }
}
}
