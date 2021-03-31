package Celeste.basic.day11;

import java.util.Scanner;

public class WrapperClass {
    public static void main(String[] args) {
        // wrapper class
        // 프로그램에 따라 기본 자료형의 데이터를 참조자료형으로 바꿔 취급해야 할 때가 있음
        // 메서드의 매개변수가 객체형을 요구하면 그에 따른 객체형 사용
        // 기본 자료형 변수를 참조 자료형 변수로 변환하는 클래스를 래퍼 클래스라 함
        // int -> Integer, double -> Double, char -> Character, boolean -> Boolean

        int a = 123;
        Integer b = new Integer(a); // 박싱: 기본 자료형 변수를 참조 자료형 변수로 변환
        System.out.println(a);
        System.out.println(b); // 박싱을 통해 클래스의 장점을 활용할 수 있는 변수로 변환

        Scanner sc = new Scanner(System.in);
        System.out.println("숫자를 하나 입력하세요: ");
        int number = Integer.parseInt(sc.next());
        // 문자 입력값을 정수로 변환

        int c = b.intValue(); // 언박싱: 참조 자료형 변수를 기본 자료형 변수로 변환
        Integer d = 456;      // 자동 박싱 적용 => newInteger 사용 안 함
        int e = d;            // 자동 언박싱 적용 => intValue 사용 안 함

        // 10진수를 2진수로 변환하기
        // 4 => 100
        System.out.println(Integer.toBinaryString(4));

        // 두 수를 비교해서 작거나 같거나 큰지 출력
        // compareTo(수1, 수2)
        // 결과: -1, 0, 1
        System.out.println(b.compareTo(d));
        System.out.println(Integer.compare(b, d));






    }
}
