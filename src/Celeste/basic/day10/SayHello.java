package Celeste.basic.day10;

public class SayHello {
    public static void main(String[] args) {
        // 다국어(한국어, 영어, 일본어)로 인사하는 프로그램 작성
        // 다국어 인삿말 하기 - 국가별 인삿말을 개별적으로 작성
        SayHellokor say1 = new SayHellokor();
        say1.sayHello();
        SayHelloeng say2 = new SayHelloeng();
        say2.sayHello();
        SayHellojpn say3 = new SayHellojpn();
        say3.sayHello();

        // 다형성을 이용해서 인삿말을 세련되게 하기
        SayHelloService say = new SayHellokor();
        say.sayHello();
        say = new SayHelloeng();
        say.sayHello();
        say = new SayHellojpn();
        say.sayHello();

    }
}

interface SayHelloService {
    void sayHello();
}

class SayHellokor implements SayHelloService {
    @Override
    public void sayHello() {
        System.out.println("안녕하세요, 자바!");
    }
}

class SayHelloeng implements SayHelloService {
    @Override
    public void sayHello() {
        System.out.println("Hello, Java!");
    }
}

class SayHellojpn implements SayHelloService {
    @Override
    public void sayHello() {
        System.out.println("こんにちは、ジャワ！");
    }
}
