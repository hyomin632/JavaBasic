package Celeste.basic.day09;

public class Phones {
    public static void main(String[] args) {
        GeneralPhone g = new GeneralPhone();
        g.calling();

        MPPhone m = new MPPhone();
        m.playMusic();

        SmartPhone s = new SmartPhone();
        s.takePicture();
    }
}

interface Phones1 {
    void calling();
    void accept();
}

interface Phones2 {
    void playMusic();
    void watchVideo();
}

interface Phones3 {
    void takePicture();
    void Internet();
    void playGame();
}

class GeneralPhone implements Phones1 {
    @Override
    public void calling() {
        System.out.println("전화 거는 중...");
    }

    @Override
    public void accept() {
        System.out.println("전화 받는 중...");
    }
}

// 상속extends: 부모 클래스가 가진 특성과 기능을 변화 없이 받음
// 구현implements: 부모 클래스가 정해준 틀에 맞춰 새롭게 작성
// 따라서 상속보다는 구현으로 하는 것이 다소 정렬됨

class MPPhone implements Phones1, Phones2 {
    @Override
    public void calling() { }

    @Override
    public void accept() { }

    @Override
    public void playMusic() {
        System.out.println("음악을 재생합니다");
    }

    @Override
    public void watchVideo() {
        System.out.println("동영상을 재생합니다");
    }
}

class SmartPhone implements Phones1, Phones3 {
    @Override
    public void calling() { }

    @Override
    public void accept() { }

    @Override
    public void takePicture() {
        System.out.println("사진을 찍습니다");
    }

    @Override
    public void Internet() {
        System.out.println("인터넷을 실행합니다");
    }

    @Override
    public void playGame() {
        System.out.println("게임을 실행합니다");
    }
}

