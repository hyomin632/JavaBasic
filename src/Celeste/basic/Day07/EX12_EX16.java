package Celeste.basic.Day07;

import java.util.Scanner;

public class EX12_EX16 {
    public static void main(String[] args) {
        // 생년월일을 이용해서 나이 계산 프로그램
        // 현재년도 - 생년연도
//        int byear, bmonth, bday; // 생년월일
//        int cyear, cmonth, cday; // 현재년월일
//        Scanner sc = new Scanner(System.in);
//        String fmt = "현재: %d년 %d월 %d일 \n" + "생일: %d년 %d월 %d일 \n" + "나이: %d세";
//        // 현재년월일 설정
//        cyear = 2021;
//        cmonth = 3;
//        cday = 24;
//        // 생년월일 입력
//        System.out.print("생일의 연도는?: ");
//        byear = sc.nextInt();
//        System.out.print("생일의 월은?: ");
//        bmonth = sc.nextInt();
//        System.out.print("생일의 일은?: ");
//        bday = sc.nextInt();
//        // 나이 계산
//        int age = cyear - byear -1; // 현재년도 - 생년연도
//        if (cmonth > bmonth && cday > bday) // 생일이 지난 여부 확인
//            age = age + 1;
//        else
//            age = age - 1;
//        System.out.printf(fmt, cyear, cmonth, cday, byear, bmonth, bday, age);

        computeAge();

        System.out.println("");

        // 잔돈 계산 프로그램
        // 지불 요구 금액: 54,320원
        // 지불액: 100,000원
        // 잔돈: 45,680원
//        int price, pay, change;
//        int w50000, w10000, w5000, w1000, w500, w100, w50, w10;
//        String fmt = "사용 요금은 %d원, 지불액은 %d원일 때, 잔돈은 %d입니다 \n" +
//                "5만원권은 %d원, 1만원권은 %d장, \n" + "5천원권은 %d장, 1천원권은 %d장, \n" +
//                "500원은 %d개, 100원은 %d개 \n" + "50원은 %d개, 10원은 %d개입니다";
//        Scanner sc = new Scanner(System.in);
//        System.out.print("사용 요금은?: ");
//        price = sc.nextInt();
//        System.out.print("지불액은?: ");
//        pay = sc.nextInt();
//        // 잔돈 계산
//        change = pay - price;
//        w50000 = change / 50000;
//        // change = change - (50000 * w50000);
//        change = change % 50000;
//
//        w10000 = change / 10000;
//        // change = change - (10000 * w10000);
//        change = change % 10000;
//
//        w5000 = change / 5000;
//        // change = change - (5000 * w5000);
//        change = change % 5000;
//
//        w1000 = change / 1000;
//        // change = change - (1000 * w1000);
//        change = change % 1000;
//
//        w500 = change / 500;
//        // change = change - (500 * w500);
//        change = change % 500;
//
//        w100 = change / 100;
//        // change = change - (100 * w100);
//        change = change % 100;
//
//        w50 = change / 50;
//        // change = change - (50 * w50);
//        change = change % 50;
//
//        w10 = change / 10;
//
//        System.out.printf(fmt, price, (pay-price), change, w50000, w10000, w5000, w1000, w500, w100, w50, w10);

        computeChange();

    }
    public static void computeAge() {
        // 생년월일을 이용해서 나이 계산 프로그램
        // 현재년도 - 생년연도
        int byear, bmonth, bday; // 생년월일
        int cyear, cmonth, cday; // 현재년월일w
        Scanner sc = new Scanner(System.in);
        String fmt = "현재: %d년 %d월 %d일 \n" + "생일: %d년 %d월 %d일 \n" + "나이: %d세";
        // 현재년월일 설정
        cyear = 2021;
        cmonth = 3;
        cday = 24;
        // 생년월일 입력
        System.out.print("생일의 연도는?: ");
        byear = sc.nextInt();
        System.out.print("생일의 월은?: ");
        bmonth = sc.nextInt();
        System.out.print("생일의 일은?: ");
        bday = sc.nextInt();
        // 나이 계산
        int age = cyear - byear;
        if (cmonth > bmonth)
            age = age;
        else if (cmonth == bmonth && cday >= bday)
            age = age;
        else
            age = age - 1;
        System.out.printf(fmt, cyear, cmonth, cday, byear, bmonth, bday, age);
    }

    public static void computeChange() {
        int price, pay, change;
        int[] wons = new int[8];
        int[] notes = {50000, 10000, 5000, 1000, 500, 100, 50, 10};
        String fmt = "사용 요금은 %d원, 지불액은 %d원일 때, 잔돈은 %d원입니다 \n" +
                     "5만원권은 %d장, 1만원권은 %d장, \n" + "5천원권은 %d장, 1천원권은 %d장, \n" +
                     "500원은 %d개, 100원은 %d개 \n" + "50원은 %d개, 10원은 %d개입니다";
        Scanner sc = new Scanner(System.in);
        System.out.print("사용 요금은?: ");
        price = sc.nextInt();
        System.out.print("지불액은?: ");
        pay = sc.nextInt();
        change = pay - price;
        for(int i = 0; i < wons.length; ++i) {
            wons[i] = change / notes[i];
            change = change % notes[i];
        }

        System.out.printf(fmt, price, pay, (pay-price), wons[0], wons[1], wons[2],
                          wons[3], wons[4], wons[5], wons[6], wons[7]);
    }
}

