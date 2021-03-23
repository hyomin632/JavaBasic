package Celeste.basic.Day06;

public class Breaks {
    public static void main(String[] args) {
        // 반복문 제어하기 break, continue
        // break: 반복문 실행을 중단하는 명령

        // ex) 1 ~ 100까지의 총합을 구하는 프로그램 작성
        // 단, 총합이 500을 넘는 경우 실행 중단
        int sum = 0;
        int i;
        for(i = 0; i <= 100; ++i) {
            sum += i;
            if(sum >= 500) break; // 부분합이 500이상인 경우 반복 실행을 중지
        }
        System.out.println("총합: " + sum);
        System.out.println("중지지점: " + i);

        // ex) 주사위 눈이 6이 나올 때까지 굴려서 횟수까지 출력하는 프로그램
        // Math.random, break 사용
        int dice = 0;
        int count = 0;
        while(true) {
            dice = (int)(Math.random() * 6) + 1;
            ++count;
            System.out.print(dice + " ");
            if (dice == 6) break;
        }
        System.out.println("총 굴린 횟수: " + count);





    }
}
