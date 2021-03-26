package Celeste.basic.Day09;

public class AbstractClass {
    public static void main(String[] args) {
        // 추상 클래스: 추상 메서드를 포함한 클래스
        // 추상 메서드: 불완전 메서드 의미. 메서드 선언부만 존재, 몸체는 존재하지 않음
        // 불완전 메서드를 포함하는 불완전 클래스이기 때문에, 이 클래스는 객체화되지 않음

        // 상속 관계에 있는 자식 클래스가 부모 클래스에 정의해둔 메서드를 사용하지 않고
        // 재정의해서 사용하는 경우를 Overriding이라 함
        // 이처럼 부모 클래스의 메서드가 필요 없다면 메서드를 완전하게 정의하지 않고,
        // 형태만 만들어놓고 자식 클래스들이 내용을 채우도록 하면?
    }
}

abstract class Animal2 {
    protected String name;
    abstract public void cry(); // 추상 메서드
}

class Cat2 extends Animal2 {
    @Override
    public void cry() {
        System.out.println( "미야우미야우" );
    }
}

class Dog2 extends Animal2 {
    @Override
    public void cry() {
        System.out.println( "바우와우" );
    }
}