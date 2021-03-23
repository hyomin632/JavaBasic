package Celeste.basic.Day06;

public class EX55 {
    public static void main(String[] args) {
        // 배열에 정의하고 값 저장하기 1
        // 1 2 3 4 5 6 7 8 9 10
        int[] num1 = new int[10];
//        num1[0] = 1;
//        num1[1] = 2;
//        num1[2] = 3;
//        num1[3] = 4;
//        num1[4] = 5;
//        num1[5] = 6;
//        num1[6] = 7;
//        num1[7] = 8;
//        num1[8] = 9;
//        num1[9] = 10;

//        System.out.print(num1[0]);
//        System.out.print(num1[1]);
//        System.out.print(num1[2]);
//        System.out.print(num1[3]);
//        System.out.print(num1[4]);
//        System.out.print(num1[5]);
//        System.out.print(num1[6]);
//        System.out.print(num1[7]);
//        System.out.print(num1[8]);
//        System.out.println(num1[9]);
        // for(int i = 1; i < num1.length; ++i) {
        //     num1[i - 1] = i;
        // }
        for(int i = 0; i < num1.length; ++i) { // 추천
            num1[i] = i + 1;
        }
        for(int i = 0; i < num1.length; ++i) {
            System.out.println(num1[i]);
        }

        // 배열에 정의하고 값 저장하기 2
        // 0 2 4 6 8 10 12 14 16 18 20
        int[] num2 = new int[11];
        for(int i = 0; i < num2.length; ++i) {
            num2[i] = i * 2;
            System.out.print(num2[i] + ", ");
        }
        System.out.println(" ");

        // 배열에 정의하고 값 저장하기 3
        // 1 4 9 16 25 36 49 64 81 100
        int[] num3 = new int[10];
        for(int i = 0; i < num3.length; ++i) {// for(int i = 1; i < num3.length; ++i) {
            // num3[i] = i * i; // num3[i] = (i + 1) * (i + 1);
            num3[i] = (int) Math.pow((i + 1), 2); // pow(밀수, 지수)
            System.out.print(num3[i] + ", ");
        }
        System.out.println(" ");

        // 배열에 정의하고 값 저장하기 4
        // 0 0 0 0 0 0 0 0 0 0
        int[] num4 = new int[10];
        for(int i = 0; i < num4.length; ++i) {
            System.out.print(num4[i] + ", ");
        }
        System.out.println(" ");
        // 참고: 참조자료형 변수는 new 연산자로 객체 생성시 미리 변수에 기본값이 할당됨
        // 숫자형: 0, 객체형: null

        // 배열에 정의하고 값 저장하기 5
        // 1 4 9 16 9 7 4 9 11(규칙 x)
        int[] num5= {1,4,9,16,9,7,4,9,11};
        for(int i = 0; i < num5.length; ++i) {
            System.out.print(num5[i] + ", ");
        }




    }
}
