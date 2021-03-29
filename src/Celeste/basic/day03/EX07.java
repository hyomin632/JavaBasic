package Celeste.basic.day03;

public class EX07 {
   public static void main(String[] args) {
	   
	   System.out.println(3 + 4.5 * 2 + 27 / 8);
	   
	   System.out.println(true || false && 3 < 4 || !(5 == 7));
	   
	   System.out.println(true || (3 < 5 && 6 >= 2));
	   
	   // System.out.println(!true > 'A'); // 잘못된 비교 대상으로 오류
	   
	   System.out.println(7 % 4 + 3 - 2 / 6 * 'Z'); // Z: 90
	   // 단일 문자를 수식에 사용하면 자동으로 숫자형으로 바뀜 
	   // 숫자형으로 변환되는 기준은 ASCII 코드값을 참조함 
	   // 0: 48, A: 65, a: 97(10진수)
	   
	   System.out.println('D' + 1 + 'M' % 2 / 3); // D: 68, M: 77
	   
	   System.out.println(5.0 / 3 + 3 / 3);
	   
	   System.out.println(53 % 21 < 45 / 18);
	   
	   System.out.println((4 < 6) || true && false || false && (2 > 3));
	   
	   System.out.println(7 - (3 + 8 * 6 + 3) - (2 + 5 * 2));
	   
	   
	   
	   
	   
	   
   }
}
