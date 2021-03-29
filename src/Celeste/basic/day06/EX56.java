package Celeste.basic.day06;

public class EX56 {
    public static void main(String[] args) {
        // 다음 값을 입력했을 때 다음과 같이 출력
        // 입력: 0 11 2 33 4 55 6 77 8 99
        // 출력: 99 8 77 6 55 4 33 2 11 0
        int[] num1 = {0, 11, 2, 33, 4, 55, 6, 77, 8, 99};
        for(int i = 0; i < num1.length; ++i) {
            System.out.print(num1[i] + ", ");
        }
        System.out.println(" ");

        // for(int i = 0; i < num1.length; ++i) {
        //    System.out.print(num1[num1.length - 1 - i] + ", ");
        // }
        // 인덱스를 증가시키면서 배열을 역순으로 출력

        for(int i = (num1.length - 1); i >= 0; --i) {
            System.out.print(num1[i] + ", ");
        }
        // 인덱스를 감소시키면서 배열을 역순으로 출력
    }
}
