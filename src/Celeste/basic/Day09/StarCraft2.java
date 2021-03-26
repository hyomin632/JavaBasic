package Celeste.basic.Day09;public class StarCraft2 {
    public static void main(String[] args) {
        SCV1 s = new SCV1();
        System.out.println( "SCV의 체력: " + s.hp );
        s.attack();
        s.move();
        s.specialAbility();
        System.out.println("");

        Marine2 m = new Marine2();
        System.out.println( "해병대의 체력: " + m.hp);
        m.attack();
        m.move();
        m.specialAbility();
        System.out.println("");

        Firebat2 f = new Firebat2();
        System.out.println( "화염방사병의 체력: " + f.hp);
        f.attack();
        f.move();
        f.specialAbility();
        System.out.println("");
    }
}

abstract class Unit2 {
    protected String name;
    protected int hp;
    protected int power;
    protected double mvspd;
    protected int mineral;
    protected int gas;
}

interface Unit2Action {
    abstract public void attack();
    abstract public void move();
    abstract public void specialAbility();
}

class SCV1 extends Unit2 implements Unit2Action {
    public SCV1() {
        name = "SCV";
        hp = 50;
        power = 5;
        mvspd = 2.344;
        mineral = 50;
        gas = 0;
    }

    @Override
    public void attack() {
        System.out.println("융합절단기를 이용해서 대상에 %d의 피해를 주고 있습니다. \n");
    }

    @Override
    public void move() {
        System.out.println("지정한 위치로 %.2f 속도로 이동 중입니다. \n" + mvspd);
    }

    @Override
    public void specialAbility() {
        System.out.println("대상을 수리하는 중입니다. \n");
    }

}

class Marine2 extends Unit2 implements Unit2Action {
    public Marine2() {
        name = "해병대";
        hp = 50;
        power = 30;
        mvspd = 2.95;
        mineral = 50;
        gas = 0;
    }

    @Override
    public void attack() {
        System.out.println("가우스소총을 이용해서 대상에 %d의 피해를 주고 있습니다.\n" + power);
    }

    @Override
    public void move() {
        System.out.println("지정한 위치로 %.2f 속도로 이동 중입니다.\n" + mvspd);
    }

    @Override
    public void specialAbility() {
        System.out.println("전투자극제를 사용해서 이동 속도는 50%% 증가, 공격 속도는 33%% 증가합니다\n");
    }
}

class Firebat2 extends Unit2 implements Unit2Action {
    public Firebat2() {
        name = "화염방사병";
        hp = 50;
        power = 8 * 2;
        mvspd = 1.875;
        mineral = 50;
        gas = 25;
    }

    @Override
    public void attack() {
        System.out.println("화염방사기를 이용해서 대상에 %d의 피해를 주고 있습니다.\n" + power);
    }

    @Override
    public void move() {
        System.out.println("지정한 위치로 %.2f 속도로 이동 중입니다.\n" + mvspd);
    }

    @Override
    public void specialAbility() {
        System.out.println("전투자극제를 사용해서 이동 속도는 50%% 증가, 공격 속도는 33%% 증가합니다.\n");
    }
}
