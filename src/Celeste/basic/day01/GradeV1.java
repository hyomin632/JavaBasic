package Celeste.basic.day01;

/**
 * 
 * @author Celeste
 * @category javabasic
 * @version 1.0 자바기초프로그램 - 성적 처리 프로그램 입력: 이름, 국어, 영어, 수학 처리: 총점, 평균, 학점 출력: 이름,
 *          국어, 영어, 수학, 총점, 평균, 학점
 */
public class GradeV1 {
	public static void main(String[] args) {
		// 변수 선언
		String name;
		int korean;
		int english;
		int math;
		int total;
		double average;
		char grade;
		// 처리
		name = "홍길동";
		korean = 90;
		english = 80;
		math = 70;
		total = korean + english + math;
		average = (korean + english + math) / 3;
		average = total / 3;
		grade = '가';

		// 결과 출력
		System.out.print("이름 : ");
		System.out.println(name);
		System.out.print("국어 : ");
		System.out.println(korean);
		System.out.print("영어 : ");
		System.out.println(english);
		System.out.print("수학 : ");
		System.out.println(math);
		System.out.print("총점 : ");
		System.out.println(total);
		System.out.print("평균 : ");
		System.out.println(average);
		System.out.print("학점 : ");
		System.out.println(grade);
	}
}
