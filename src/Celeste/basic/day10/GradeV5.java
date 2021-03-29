package Celeste.basic.day10;

import Celeste.basic.grade.GradeVO;

import java.util.Scanner;

public class GradeV5 { // 인터페이스를 이용해서 성적 프로그램 작성
    public static void main(String[] args) {
        // 클래스에 대한 객체 생성하기
        // 클래스명 객체명 = new 클래스명()

        // 상속받은 클래스에 대한 객체 생성하기
        // 부모 클래스명 객체명 = new 자식 클래스명()
        // Cat c = new Cat() -> Animal cd = new Cat() or cd = new Dog

        // 인터페이스를 구현한 클래스 객체 생성하기
        // 인터페이스 객체명 = new 클래스명()
        GradeV5Service gsrv = new GradeV5ServiceImpl();
        // 성적 데이터 입력
        GradeVO g = gsrv.readGrade();
        // 입력한 성적 데이터 처리
        gsrv.computeGrade(g);
        // 처리한 성적 데이터 출력
        gsrv.printGrade(g);
    }
}

// 성적 처리와 관련된 메서드를 따로 뽑아 인터페이스로 구현
// 보통 인터페이스의 명명법은 이름 끝에 Service를 추가
interface GradeV5Service {
    GradeVO readGrade();
    void computeGrade(GradeVO g);
    void printGrade(GradeVO g);
}

// 인터페이스를 구현한 클래스는 클래스 이름 끝에 Impl 접미사를 추가
class GradeV5ServiceImpl implements GradeV5Service {
    @Override
    public GradeVO readGrade() {
        Scanner sc = new Scanner(System.in);
        System.out.print("이름은?: ");
        String name = sc.next();
        System.out.print("국어는?: ");
        int kor = sc.nextInt();
        System.out.print("영어는?: ");
        int eng = sc.nextInt();
        System.out.print("수학은?: ");
        int mat = sc.nextInt();

        return new GradeVO(name, kor, eng, mat);
    }

    @Override
    public void computeGrade(GradeVO g) {
        g.setTot(g.getKor() + g.getEng() + g.getMat());
        g.setAvg((double) g.getTot() / 3);
        switch ((int)g.getAvg() / 10) {
            case 10: case 9: g.setGrd('수'); break;
            case 8: g.setGrd('우'); break;
            case 7: g.setGrd('미'); break;
            case 6: g.setGrd('양'); break;
            default: g.setGrd('가'); break;
    }
}

    @Override
    public void printGrade(GradeVO g) {
        String fmt = "%s %d %d %d \n%d %.1f %c\n";
        System.out.printf(fmt, g.getName(), g.getKor(), g.getEng(), g.getMat(), g.getTot(), g.getAvg(), g.getGrd());
    }
}