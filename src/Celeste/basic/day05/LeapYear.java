package Celeste.basic.day05;

import java.util.Scanner;


public class LeapYear {
    public static void main(String[] args) {
        // 윤년 여부 출력 프로그램
        // 지구의 공전 주기와 자전 주기의 불일치로 발생
        // 공전 주기: 365.24일
        // 자전 주기: 0.24일
        // 이 둘 사이의 오차로 인하여 4년마다 하루를 추가하는 방버으로 오류를 보정
        // 조건 1: 4로 나누어 떨이지지만, 100으로 나누어 떨어지지 않음
        // 조건 2: 400으로 나누어 떨어짐
        // ex) 1600년(윤년), 2020(윤년), 1900(평년)

        int year;
        String result;
        Scanner sc = new Scanner(System.in);
        System.out.print("연도를 입력하세요: ");
        year = sc.nextInt();

        if (year % 4 == 0 && year % 100 != 0 || (year % 400 == 0))
            result = "윤년입니다";
        else
            result = "평년입니다";

        System.out.println(result);



    }
}




