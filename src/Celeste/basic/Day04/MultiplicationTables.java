package Celeste.basic.Day04;

import java.util.Scanner;

public class MultiplicationTables {

	public static void main(String[] args) {
		// 구구단 출력하기
		// ex) 7단 출력 v1
		System.out.println("7 * 1 = 7");
		System.out.println("7 * 2 = 14");
		System.out.println("7 * 3 = 21");
		System.out.println("7 * 4 = 28");
		System.out.println("7 * 5 = 35");
		System.out.println("7 * 6 = 42");
		System.out.println("7 * 7 = 49");
		System.out.println("7 * 8 = 56");
		System.out.println("7 * 9 = 63");
		System.out.println("-----------");
		
		// ex) 7단 출력 v2
		for(int i = 1; i <= 9; ++i) {
			System.out.println("7 * " + i + " = " + (7*i));
		}
		System.out.println("-----------");
		
		// ex) 7단 출력 v3 - while, printf
	    String fmt = "7 * %d = %d \n";
		int i = 1;
		while(i <= 9) {
			System.out.printf(fmt, i, 7*i);
			++i;
		}
		System.out.println("-----------");
		
		// ex) 3단 출력 v1 - while, printf
		fmt = "3 * %d = %2d \n"; // %2d: 자리 정렬 
		i = 1;
		while(i <= 9) {
			System.out.printf(fmt, i, 3*i);
			++i; 
		}
		System.out.println("-----------");
		
		// 구구단 프로그램 v1
		// 사용자로부터 숫자(1 ~ 9)를 하나 입력 받아, 구구단을 출력하는 프로그램을 작성
		Scanner sc = new Scanner(System.in);
		System.out.print("출력할 구구단의 단을 입력하세요: ");
		int j = sc.nextInt();
		i = 1;
		String fmt1 = "%d * %d = %2d \n";
		while(i <= 9) {
			System.out.printf(fmt1, j, i, (j*i));
			++i;
		}
		
		// 구구단 프로그램 v2
		// 단, 1 ~ 9 이외의 숫자나 문자를 입력하면 "잘못 입력하셨습니다!"라는 메시지 출력 
		System.out.print("출력할 구구단의 단을 입력하세요: ");
		char j1 = sc.next().charAt(0);
		// 입력한 문자열 중 첫 번째 글자만 뽑아서 char형 변수에 대입 
		
		// 입력한 문자의 ASCII 코드값이 49 ~ 57인지 검사
		String result = (57 >= j1 && j1 >= 49) ? "구구단 출력" : "잘못 입력하셨습니다!";		
	    System.out.println(result);
		
		// 구구단 프로그램 v3
		// 단, 1 ~ 9 이외의 숫자나 문자를 입력하면 "잘못 입력하셨습니다!"라는 메시지 출력 
        System.out.print("출력할 구구단의 단을 입력하세요: ");
        String j2 = sc.next();
        i = 1;
        try {
          while(i <= 0) {
        	System.out.printf(fmt1, j2, i, (Integer.parseInt(j2)*i));
        	++i;
        }
	} catch(Exception ex) {
	    System.out.println("잘못 입력하셨습니다!");
	}
        // 예외 처리 코드(try-catch)를 이용해서 프로그램 실행 중 오류 발생시 제어를 catch 코드쪽으로 넘김
        
        // ex) 주민등록번호를 이용하여 성별을 출력하는 코드 작성
        // 주민등록번호 123456-7654321에서 7이 성별을 나타내는 코드
        // 1: 1999년 이전에 출생한 남자
        // 2: 1999년 이전에 출생한 여자
        // 3: 2000년 이후에 출생한 남자
        // 4: 2000년 이후에 출생한 여자 
        // charAt을 이용
        String jumin = "123456-1654332";
        System.out.print("출력할 주민등록번호를 입력하세요: ");
        jumin = sc.next();
        char gender = jumin.charAt(7);
        
        result = (gender == '1') ? "1999년 이전에 출생한 남자" :
        	     (gender == '2') ? "1999년 이전에 출생한 여자" :
        	     (gender == '3') ? "2000년 이후에 출생한 남자" : "2000년 이후에 출생한 여자";
        System.out.println(result);
        
	}
}
