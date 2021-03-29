package Celeste.basic.day05;

import java.util.Scanner;

public class Login {

	public static void main(String[] args) {
		// 키보드로 아이디, 비밀번호를 입력해서 로그인 성공여부를 출력하는 프로그램
		// 아이디: abc123
		// 비밀번호: 987xyz
		// 1. 아이디 x, 비밀번호 x - 로그인 실패!
		// 2. 아이디 o, 비밀번호 x - 비밀번호 오류!
		// 3. 아이디 x, 비밀번호 o - 아이디 오류!
		// 4. 아이디 o, 비밀번호 o - 로그인 성공!
		// => 입력값에 따른 결과 처리가 복잡하므로 단순화해야 함
		// 입력 처리가 복잡해지면 코드도 복잡하게 처리될 수밖에 없
		// 즉 1, 2, 3은 로그인 실패! / 4는 로그인 성공!
		
		// 변수 선언
		String userid ;
		String passwd;
		Scanner sc = new Scanner(System.in);
		String result;
		
		// 아이디, 비밀번호 입력 받아 비교
	    System.out.print("아이디는? ");
	    userid = sc.next();
	    System.out.print("비밀번호는? ");
		passwd = sc.next();
		
		// 1.
		// if (userid.equals("abc123")) { // 문자열 비교시 '=='이 아닌 'equals' 메서드 사
		// 	if (passwd.equals("987xyz"))
		// 		result = "로그인 성공!";
		// 	else
		// 		result = "아이디 성공, 비밀번호 오류!";   			
		// } else {
		// 	if (passwd.equals("987xyz"))
		// 		result = "아이디 오류, 비밀번호 성공!";
		// 	else
		// 		result = "로그인 실패!";
		// }
		// 로그인 성공 여부를 4가지 경우에 따라 작성하면 코드가 복잡
		
		// 2.
		// if (userid.equals("abc123")) {
		// 	if (passwd.equals("987xyz"))
		// 		result = "로그인 성공!";
		// 	else
		// 		result = "로그인 실패!";
		// 	} else
		//		result = "로그인 실패!";
		// 로그인 성공 여부를 3가지 경우에 따라 작성하면 코드가 다소 단순 
	    
		// 3. 
	    if (userid.equals("abc123") &&
	    		passwd.equals("987xyz"))
	    	result = "로그인 성공!";
	    else
	    	result = "로그인 실패!";
	    // 조건식들을 논리식으로 재작성하여 코드가 단순
	    
		// 결과 출력 
	    System.out.println(result);
	    
	    
	}

}
