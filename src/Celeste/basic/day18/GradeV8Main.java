package Celeste.basic.day18;

import Celeste.basic.grade.GradeServiceV4;
import Celeste.basic.grade.GradeServiceV4Impl;

import java.util.Scanner;

public class GradeV8Main {
    public static void main(String[] args) {
        // 성적 처리 프로그램 V8 -  JDBC 프로그래밍
        // 입력한 성적 데이터를 DBMS를 이용해서 관리
        // 따라서 프로그램 종료시 입력했던 데이터는 그대로 유지

        // 새로운 프로그래밍 패턴 도입: 3 layer architecture
        // 프레젠테이션 - 비즈니스 로직 - 데이터 액세스
        //                ~Service        ~DAO

        // GradeService V4
        // JDBCUtil (JDBC 관련 정보 및 객체 생성)
        // GradeDAO (insertGrade, selectGrade, selectOneGrade, updateGrade, deleteGrade)

        Scanner sc = new Scanner(System.in);
        GradeServiceV4 gsrv = GradeServiceV4Impl.getInstance();
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
