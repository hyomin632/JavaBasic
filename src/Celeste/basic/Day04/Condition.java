package Celeste.basic.Day04;

import java.util.Scanner;

public class Condition {

	public static void main(String[] args) {
		// 조건문
		// 일반적으로 프로그램의 실행 순서는 순차적임(sequence)
		// 하지만 특수한 상황 발생시 선택적으로 코드를 싱행해야 할 필요가 생기는데, 이때 조건문을 사용함
	    // if: 조건식의 결과가 true와 false일 때 각각 주어진 명령문을 실행
		// if(조건식) { // 조건이 참일 때 
		// 
		// } else {     // 조건이 거짓일 때 
		//
		// }
		
		// ex) 1 ~ 100 사이 정수 중 짝수를 출력
		for(int i = 1; i <= 100; ++i) {
			if(i % 2 == 0) // i가 짝수라면 
				System.out.print(i + " ");
			
		} // for
		
        // ex) 1 ~ 100 사이 정수 중 짝수라면 "짝수입니다"를. 홀수라면 "홀수입니다"라고 출력
	    for(int i = 0; i <= 100; ++i) {
	    	if(i % 2 == 0)
	    		System.out.println(i + "는 짝수입니다");
	    	else
	    	    System.out.println(i + "는 홀수입니다");
	    }
	    
	    System.out.println(" ");
	    
	    // ex) 사용자가 연봉salary과 결혼 여부isMarried(0/1)를 입력 -> 다음 세금율에 의해 납부해야 할 세금tax을 계산하는 프로그램 작성
	    // 미혼인 경우: 연봉 3,000만원 미만 - 10%, 연봉 3,000만원 이상 - 25%
	    // 기혼인 경우: 연봉 6,000만원 미만 - 15%, 연봉 6,000만원 이상 - 35%
	    int salary;
	    int isMarried;
	    double tax;
	    Scanner sc = new Scanner(System.in);
	    System.out.print("연봉은? ");
	    salary = sc.nextInt();
	    System.out.print("결혼 여부는?(0: 미혼, 1: 기혼) ");
	    isMarried = sc.nextInt();
	    if (isMarried == 0) // 미혼 
	    	if (salary < 3000) tax = salary * 0.1;
	    	else tax = salary * 0.25;
	    else // 기혼
	        if (salary < 6000) tax = salary * 0.15;
	        else tax = salary * 0.35;
	    
	    String fmt = "연봉은 %d이고, 결혼 여부는 %d일 때 \n" + "세금은 %.1f입니다";
	    System.out.printf(fmt, salary, isMarried, tax);
	    	  
 	    
	   
	    
	}

}
