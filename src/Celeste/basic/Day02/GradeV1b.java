package Celeste.basic.Day02;

import java.util.Scanner;

/**
 * 
 * @author Celeste
 * @category javabasic
 * @version 1.1
 * 자바 기초 프로그램 - 성적 처리 프로그램
 * 
 * 이름과 성적 데이터를 키보드로 직접 입력받아 처리
 * 처리 결과 출력시 printf 메서드 사용 
 * 
 */
public class GradeV1b {
   public static void main(String[] args) {
	   // 변수 선언
	   String name;
	   int kor;
	   int eng;
	   int mat;
	   int tot;
	   double avg;
	   char grd;
	   
	   // 처리
	   Scanner sc = new Scanner(System.in);
	   // 키보드를 이용해서 성적 데이터를 입력받기 위해 Scanner 클래스를 초기화함
	   
	   System.out.print("이름은? ");
	   name = sc.next();
	   // 키보드로 문자 데이터를 입력받아 name 변수에 대입 
	   
	   System.out.print("국어는? ");
	   kor = sc.nextInt();
	   // 키보드로 숫자 데이터를 입력받아 kor 변수에 대입
	   
	   System.out.print("영어는? ");
	   eng = sc.nextInt();
	   // 키보드로 숫자 데이터를 입력받아 eng 변수에 대입
	   
	   System.out.print("수학은? ");
	   mat = sc.nextInt();
	   // 키보드로 숫자 데이터를 입력받아 mat 변수에 대입
	   
	   // 총점, 평균 처리
	   tot = kor + eng + mat;
	   avg = tot / 3;
       grd = '수';
	   
	   // 출력 
	   // 이름: ??, 국어: ??, 영어: ??, 수학: ??
	   // 총점: ??. 평균: ??, 학점: ??
	   
	   String fmt = "이름: %s, 국어: %d, 영어: %d, 수학: %d\n";
       System.out.printf(fmt, name, kor, eng, mat);
	   String fmt1 = "tot = %d, avg = %f, grd = %c";
	   System.out.printf(fmt1, tot, avg, grd);
	   
   }
}
   