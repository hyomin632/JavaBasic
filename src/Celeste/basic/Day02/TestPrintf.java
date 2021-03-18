package Celeste.basic.Day02;

public class TestPrintf {
   public static void main(String[] args) {
	   int x = 5;
	   double pi = 3.14;
	   
	   // 4개의 출력문을 사용해서 메시지 출력 
	   System.out.print("x = ");
	   System.out.print(x);
	   
	   System.out.print(" and pi = ");
	   System.out.print(pi);
	   
	   // + 연산자를 사용해서 2개의 출력문을 사용
	   System.out.print("x = " + x);
	   System.out.print(" and pi = " + pi);
	   
	   // printf 메서드를 사용해서 1개의 출력문을 사용
	   // 형식 지정자: 특정 문자열 내에 출력할 대상과 모양을 지정하는데 사용되는 특수한 문
	   // %d: decimal, 정수를 표기할 때 사용 
	   // %f: float, 실수를 표기할 때 사용
	   // %c: character, 문자 하나를 표기할 때 사용 
	   // %s: string, 문자열을 표기할 때 사용
	   
	   System.out.printf("x = %d and pi = %f \n", x, pi);
	   
	   // printf 메서드를 사용하는 또 다른 방법
	   String fmt = "x = %d and pi = %f \n";
	   System.out.printf(fmt, x, pi);
	   
   }
}
