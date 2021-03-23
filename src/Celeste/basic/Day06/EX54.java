package Celeste.basic.Day06;

public class EX54 {
    public static void main(String[] args) {
        // 배열 다루는 예제의 1
        char [] letter; // 배열변수 선언
        letter = new char[3]; // 문자 3개를 저장할 수 있는 배열 정
        letter[0] = 'a';
        letter[1] = 'b';
        letter[2] = 'c';
        // letter 배열의 각 요소에 a, b, c 문자를 저장

        // char[] letter = {'a', 'b', 'c'}; // 위 5줄 코드를 한 줄로 작성하는 방법

        for(int i = 0; i < 3; ++i) {

                System.out.print(letter[i] + ",");
        }

        // 배열 다루는 예제 2
        double[] a = {1.1, 2.2, 3.3};
        System.out.println(a[0] + " " + a[1] + " " + a[2]);
        a[1] = a[2]; // 3번째 요소값을 2번째 요소에 대입
        System.out.println(a[0] + " " + a[1] + " " + a[2]);

        // 배열 다루는 예제 3
        int[] sampleArray = new int[10]; // 배열 인덱스 범위: 0 ~ 9
        // for(int idx = 1; idx <= sampleArray.length; ++idx) // 반복문 인덱스 범위: 1 ~ 10
        //    sampleArray[idx] = 3 * idx;                     // => ArrayIndexOutOfBoundsException 예외 발생
        for(int idx = 1; idx < sampleArray.length; ++idx) // 배열변수명.length: 배열의 크기를 알려주는 특수한 변수
            sampleArray[idx] = 3 * idx;
        for(int idx = 0; idx < sampleArray.length; ++idx)
            System.out.println(sampleArray[idx] + ",");


    }
}
