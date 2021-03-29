package Celeste.basic.day01;

public class EX05 {
	public static void main(String[] args) {
		double number = (1 / 3) * 3;
		System.out.println(" (1/3) * 3 = " + number);
		// 예상값: 1, 실제값: 0.0
		// 정수 나누기 정수의 결과값은 정수이기 때문

		int quotient = 7 / 3;
		System.out.println(" 7 / 3 = " + quotient);
		// 예상값: 2.3333, 실제값: 2

		int remainder = 7 % 3;
		System.out.println(" 7 % 3 = " + remainder);

		int result = 11;
		result /= 2;
		System.out.println(" result /= 2 = " + result);
		// 복합대입연산자
		// 산술연산자와 대입연산자를 합쳐 놓은 연산자
		// ex) a = a + 1 => a += 1
	}
}
