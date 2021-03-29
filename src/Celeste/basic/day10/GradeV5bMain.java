package Celeste.basic.day10;

import Celeste.basic.grade.GradeService;
import Celeste.basic.grade.GradeServiceImpl;
import Celeste.basic.grade.GradeVO;

public class GradeV5bMain {
    public static void main(String[] args) {
        // GradeService gsrv = new GradeServiceImpl();
        GradeService gsrv = GradeServiceImpl.getInstance();
        GradeVO g = gsrv.readGrade();
        gsrv.computeGrade(g);
        gsrv.printGrade(g);
    }
}
