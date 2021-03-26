package Celeste.basic.Day09;

public class StarCraft {
    public static void main(String[] args) {
        // SCV s = new SCV("SCV", 45, 5, 2.81, 50, 0);
        // SCV 유닛을 만들 때마다 초기값을 지정하는 것은 다소 번거로움
        // 즉, 동일한 속성을 가진 유닛을 만들 때마다 매개변수를 통해 객체를 만드는 것은 비효율적임
        // 이런 경우에는 생성자 내에서 초기값을 지정하는 것이 수월

        SCV s = new SCV();
        System.out.println( "SCV의 체력: " + s.hp );
        s.attack();
        s.move();
        s.specialAbility();
        System.out.println("");

        Marine m = new Marine();
        System.out.println( "해병대의 체력: " + m.hp);
        m.attack();
        m.move();
        m.specialAbility();
        System.out.println("");

        Firebat f = new Firebat();
        System.out.println( "화염방사병의 체력: " + f.hp);
        f.attack();
        f.move();
        f.specialAbility();
        System.out.println("");
    }
}

abstract class Unit {
    protected String name;
    protected int hp;
    protected int power;
    protected double mvspd;
    protected int mineral;
    protected int gas;

    public Unit() { }

    // public Unit(String name, int hp, int power, double mvspd, int mineral, int gas) {
    //    this.name = name;
    //    this.hp = hp;
    //    this.power = power;
    //    this.mvspd = mvspd;
    //    this.mineral = mineral;
    //    this.gas = gas;
    // }

    abstract public void attack();
    abstract public void move();
    abstract public void specialAbility();
}

class SCV extends Unit {
    final String fmtattack = "융합절단기를 이용해서 대상에 %d의 피해를 주고 있습니다. \n";
    final String fmtmove = "지정한 위치로 %.2f 속도로 이동 중입니다. \n";
    final String fmtspecialAbility = "대상을 수리하는 중입니다. \n";

    public SCV() {
        name = "SCV";
        hp = 50;
        power = 5;
        mvspd = 2.344;
        mineral = 50;
        gas = 0;
    }

    @Override
    public void attack() {
        // sout("융합절단기를 이용해서 ...")
        // 추상 메서드를 이용해서 부모 클래스에 정의된 attack 메서드를 유닛에 맞게 재정의
        System.out.printf(fmtattack, power);
    }
    @Override
    public void move() {
        System.out.printf(fmtmove, mvspd);
    }
    @Override
    public void specialAbility() {
        System.out.printf(fmtspecialAbility);
    }
}

class Marine extends Unit {
    final String fmtattack = "가우스소총을 이용해서 대상에 %d의 피해를 주고 있습니다.\n";
    final String fmtmove = "지정한 위치로 %.2f 속도로 이동 중입니다.\n";
    final String fmtspecialAbility = "전투자극제를 사용해서 이동 속도는 50%% 증가, 공격 속도는 33%% 증가합니다\n";

    public Marine() {
        name = "해병대";
        hp = 50;
        power = 30;
        mvspd = 2.95;
        mineral = 50;
        gas = 0;
    }

    @Override
    public void attack() {
        System.out.printf(fmtattack, power);
    }

    @Override
    public void move() {
        System.out.printf(fmtmove, mvspd);
    }

    @Override
    public void specialAbility() {
        System.out.printf(fmtspecialAbility);
    }
}

class Firebat extends Unit {
    final String fmtattack = "화염방사기를 이용해서 대상에 %d의 피해를 주고 있습니다.\n";
    final String fmtmove = "지정한 위치로 %.2f 속도로 이동 중입니다.\n";
    final String fmtspecialAbility = "전투자극제를 사용해서 이동 속도는 50%% 증가, 공격 속도는 33%% 증가합니다.\n";

    public Firebat() {
        name = "화염방사병";
        hp = 50;
        power = 8 * 2;
        mvspd = 1.875;
        mineral = 50;
        gas = 25;
    }

    @Override
    public void attack() {
        System.out.printf(fmtattack, power);
    }

    @Override
    public void move() {
        System.out.printf(fmtmove, mvspd);
    }

    @Override
    public void specialAbility() {
        System.out.printf(fmtspecialAbility);
    }
}