package Celeste.basic.day01;

public class EX04 {
	public static void main(String[] args) {
		// 표현식: expression(계산이나 처리를 위해 작성하는 식을 의미)
		// 수학에서 말하는 수식과 유사
		// 표현식에서 중요한 특징은 평가evaluate임
		// 즉, 코드의 결과를 알아내는 과정을 의미

		int x, y, z, s0, v, t, g;
		int result;
		x = 10;
		y = 20;
		z = 30;
		s0 = 5;
		v = 10;
		t = 15;
		g = 20;

		result = 3 * x;
		System.out.print("3x = ");
		System.out.println(result);

		result = 3 * x + y;
		System.out.print("3x + y = ");
		System.out.println(result);

		result = (x + y) / 7;
		System.out.print("(x + y) / 7 = ");
		System.out.println((x + y) / 7);

		result = (3 * x + y) / (z + 2);
		System.out.print("(3 * x + y) / (z + 2) = ");
		System.out.println(result);

		result = s0 + v * t + (1 / 2) * g * t ^ 2;
		System.out.print("s0 + v * t + (1/2) * g * t ^ 2 = ");
		System.out.println(result);

	}

}
