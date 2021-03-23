package Celeste.basic.Day06;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        // 간단한 계산 프로그램 작성
        // ex) 두 수를 입력 받아 더하기를 수행하는 프로그램 작성1
        // int a, b;
        // int sum = 0;
        // Scanner sc = new Scanner(System.in);
        // System.out.println("두 수를 입력하세요");
        // System.out.print("첫 번째 숫자는?: ");
        // a = sc.nextInt();
        // System.out.print("두 번째 숫자는?: ");
        // b = sc.nextInt();
        // sum = a + b;
        // String fmt = "입력한 수는 각각 %d, %d이며, \n" + "두 수의 총합은 %d입니다";
        // System.out.printf(fmt, a, b, sum);

        // ex) 두 수를 입력 받아 더하기를 수행하는 프로그램 작성2
        plusTwo1();
    }
    // 두 수를 입력 받아 더하기를 수행하는 메서드
    public static void plusTwo1() {
        int a, b;
        int sum = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("두 수를 입력하세요");
        System.out.print("첫 번째 숫자는?: ");
        a = sc.nextInt();
        System.out.print("두 번째 숫자는?: ");
        b = sc.nextInt();
        sum = a + b;
        String fmt = "입력한 수는 각각 %d, %d이며, \n" + "두 수의 총합은 %d입니다";
        System.out.printf(fmt, a, b, sum);
    }


}
