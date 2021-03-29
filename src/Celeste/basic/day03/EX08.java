package Celeste.basic.day03;

public class EX08 {
   public static void main(String[] args) {
	   
	   System.out.print( " Dec 31, 2020 fell on day number ");
	   // 아래의 식은 특정 연도 -1의 12월 31일의 요일 출력
	   // 0: 일요일, 1: 월요일, ..., 6: 토요일
	   // 따라서 특정 연도의 1월 1일의 요일을 출력하고 싶다면 계산식 결과에 +1을 해주면 된다
	   
	   System.out.println( ( (13 + (13 * 3 - 1) / 5 + 2021 % 100 + 2021 % 100 / 4 + 2021 / 400 - 2 * (2021 / 100) ) % 7 + 7) % 7 );
  
	   System.out.print( " Check out this line  ");
	   
	   System.out.println( " //hello there " + '9' + 7 );
	   
	   System.out.print( 'H' + 'I' + " is " + 1 + " more example" ); // H: 72, I: 73
	   // H와 I 사이 산술연산자로 인해 H와 I가 숫자형으로 변환되어 더하기 연산이 수행
	   
	   System.out.print( 'H' + 6.5 + 'I' + " is " + 1 + " more example" );
	   
	   // System.out.printf( " Print both of us", " Me too" );
	   System.out.printf(" Print both of us");
	   System.out.printf("Me too");
	   
	   System.out.print( " Reverse " + 'I' + 'T' );
	   // 앞에 오는 문자에 따라 아스키 코드 또는 문자로 변환
	   
	   System.out.print( " No! Here is" + 1 + " more example" );
	   
	   System.out.println( " Here is " + 10 * 10); // that’s 100 ;
	   
	   System.out.println( " Not x is " + true ); // that’s true.
	   
	   // System.out.print(  );
	   // 출력할 대상을 지정하지 않아 오류 발생 
	   
	   // System.out.println;
	   // 괄호가 필요
	   
	   // System.out.print( " How about this one" ++ '?' + "Huh?" );
	   // 문자열에 사용할 수 없는 증감연산자를 사용 
	   System.out.print( " How about this one" + '?' + "Huh?");
	   
   }
}
