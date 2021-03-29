package Celeste.basic.day09;

public class Inheritance2 {
    public static void main(String[] args) {
        // 자바의 조상 클래스: 자바에서 사용하는 모든 클래스는 기본적으로 Object라는 클래스를 상속받고 있음
        // 따라서 Object 클래스 내에 미리 정의된 equals, hashcode, notify, wait, toString 등의 메서드를 사용할 수 있음
        Student s = new Student();
        s.study(); // 개발자가 추가한 메서드
        A a = new A();
        a.toString(); // 조상 클래스에서 물려받음
    }
    public void talk() { }
    public void eat() { }
    public void walk() { }
    public void sleep() { }
}

class A { }

class Student extends Inheritance2 {
    public void study() { }
}

class StudentWorker extends Student {
    public void work() { }
}

class Researcher extends Inheritance2 {
    public void research() { }
}

class Professor extends Researcher {
    public void teach() { }
}
