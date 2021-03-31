package Celeste.basic.day12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Collections {
    public static void main(String[] args) {
        // 컬렉션 프레임워크
        // 다수의 데이터를 쉽고 효과적으로 처리할 수 있도록 표준화된 방법을 제공하는 클래스의 집합
        // 즉, 데이터를 저장하는 자료구조와 데이터를 처리하는 알고리즘을 구조화하여 클래스로 구현한 것

        // 주요 인터페이스
        // List: 자료 입력 순서 중요 o, 중복 요소 허용 x
        // Set: 자료 입력 순서 중요 x, 중복 요소 허용 x
        // Map: 키와 값으로 구성된 자료구조, 검색 속도가 빠름

        // ArrayList
        // List인터페이스를 구현한 클래스
        // 크기가 가변적으로 변하는 선형(-) 리스트(동적 배열)
        // 즉, 리스트의 저장용량이 꽉 차면 자동으로 용량이 늘어나는 특징
        List<Integer> nums = new ArrayList<>();
        nums.add(123);                    // add: 뒤에서부터 데이터 추가
        nums.add(456);
        nums.add(789);
        nums.add(1, 000); // 특정 위치에 요소 추가
        System.out.println(nums.size());  // 리스트의 크기 출력

        System.out.println(nums.get(1));  // get: 지정한 위치의 요소 추가

        // 리스트의 모든 요소 출력 1
        for (int i = 0; i < nums.size(); ++i)
            System.out.print(nums.get(i) + "/");
        System.out.println("");

        // 리스트의 모든 요소 출력 2 (추천) - 향상된 for문 사용
        // for(객체요소타입 변수명: 객체명)
        for (Integer num : nums) {
            System.out.print(num + "/");
        }
        System.out.print("");

        // 리스트의 모든 요소 출력 3 (추천)
        Iterator iter = nums.iterator();
        while(iter.hasNext())
            System.out.println(iter.next() + "/");
        System.out.print("");

        // 리스트에서 요소 검색
        // contains(찾을 데이터), 결과는 true 또는 false
        // indexOf(찾을 데이터), 결과는 위치값 또는 -1
        System.out.println(nums.contains(456));
        System.out.println(nums.contains(987));
        System.out.println(nums.indexOf(456));
        System.out.println(nums.indexOf(987));

        // 회원 객체를 리스트로 저장
        List<Member> members = new ArrayList<>();
        members.add(new Member("abc123", "987xyz"));
        members.add(new Member("def456", "xyz987"));
        members.add(new Member("ghi789", "456uvw"));

        // 모든 회원 정보 출력
        for (Member member : members) {
            // System.out.print(member.userid + "," + member.passwd + "/");
            System.out.println(member);
            // toString을 정의했기 때문에, member의 참조값이 출력되는 것이 아니라 미리 정의한 결과값이 출
        }

        // def456 회원 검색
        // System.out.println(members.contains("def456"));
        // System.out.println(members.indexOf("def456"));
        // 비교 대상을 잘못 지정

        // 즉, member 객체의 멤버변수와 비교해야 함
        // members.get(0).userid.equals("def456");
        // members.get(1).userid.equals("def456");
        // members.get(2).userid.equals("def456");

        // 반복문으로 코드를 최적화시킴
        for(Member m : members) {
            if (m.userid.equals(("def456"))) {
                System.out.print("데이터 확인");
                break;
            }
        }
    }
}

class Member {
    String passwd;
    String userid;

    public Member(String userid, String passwd) {
        this.userid = userid;
        this.passwd = passwd;
    }
    @Override
    public String toString() {
        String fmt = "{userid: %s, passwd: %s}";
        String result = String.format(fmt, userid, passwd);
        return result;
    }
}