package Celeste.basic.lab;

import Celeste.basic.grade.GradeServiceV2;
import Celeste.basic.grade.GradeServiceV2Impl;
import Celeste.basic.grade.GradeVO;

import java.awt.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class EmployeeServiceImpl implements EmployeeService {
    // 멤버변수 선언
    List<EmployeeVO> empdata = new ArrayList<>();
    EmployeeVO emp = null;

    // 단일 상수 선언
    static final  String[] Jobid = {"FI_MGR", "AC_MGR", "SA_MAN", "IT_PROG", "ST_CLERK"};
    static int MINSAL= 2000;
    static int MAXSAL = 40000;
    static int MAXDEPT = 270;
    static int MAXMGRID = 206;

    // 싱글톤 블럭 시작
    private static EmployeeService empsrv = null;
    private EmployeeServiceImpl() { }
    public static EmployeeService getInstance() {
        if (empsrv == null) empsrv = new EmployeeServiceImpl();
        return empsrv;
        } // 싱글톤 블럭 끝

    // 화면에 프로그램 메뉴 출력
    @Override
    public void displayMenu() {
        String displaymenu =
                        "----------------------  \n" +
                        "  사원 관리 프로그램    \n" +
                        "----------------------  \n" +
                        " 1. 사원 정보 입력      \n" +
                        " 2. 사원 정보 조회      \n" +
                        " 3. 사원 정보 상세 조회 \n" +
                        " 4. 사원 정보 수정      \n" +
                        " 5. 사원 정보 삭제      \n" +
                        " 0. 프로그램 종료       \n" +
                        "----------------------  \n" +
                        " 작업을 선택하세요: ";
        System.out.println(displaymenu);
    }

    // 새로운 사원 정보 입력
    @Override
    public void newEmployee() {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("사번: ");
            String empno = sc.next();
            System.out.print("이름: ");
            String fname = sc.next();
            System.out.print("성: ");
            String lname = sc.next();
            System.out.print("이메일: ");
            String email = sc.next();
            System.out.print("전화번호: ");
            String phone = sc.next();
            System.out.print("입사일: ");
            String hdate = sc.next();

            EmployeeVO emp = new EmployeeVO(empno, fname, lname, email, phone, hdate);

            // 사원 추가 정보를 생성해서 사원 정보로 저장
            empsrv.makeExtInfo(emp);

            empdata.add(emp);

        } catch (Exception ex) {
            System.out.println("잘못 입력하셨습니다");
            return;
        }
    }

    // 사원 기본 정보(사번, 이름, 성, 이메일, 전화번호, 입사일) 등을 리스트 형태로 출력
    @Override
    public void showEmployee() {
        String fmt = "%s %s %s %s %s %s \n";
        for (EmployeeVO emp : empdata) {
            System.out.printf(fmt, emp.getEmpno(), emp.getFname(), emp.getLname(), emp.getEmail(), emp.getPhone(), emp.getHdate());
        }
    }

    @Override
    public void showOneEmployee() {
        String fmt = "%s %s %s %s %s %s \n" + "%s %d %.1f %s %s \n";
        Scanner sc = new Scanner(System.in);
        System.out.print("조회할 사원 번호: ");
        String empno = sc.next();

        EmployeeVO emp = null;
        for(EmployeeVO e : empdata) {         // 찾는 데이터가 동적 배열에 존재한다면, emp변수에 그것을 저장하고 반복문 종료
            if (e.getEmpno().equals(empno)) {
                emp = e; break;
            }
        }
        System.out.printf(fmt, emp.getEmpno(), emp.getFname(), emp.getLname(), emp.getEmail(), emp.getPhone(), emp.getHdate(),
                          emp.getJobid(), emp.getSal(), emp.getComm(), emp.getMgrid(), emp.getDeptid());
    }

    @Override
    public void modifyEmployee() {}

    @Override
    public void removeEmployee() {}

    @Override
    public void makeExtInfo(EmployeeVO emp) {
       Random rnd = new Random();

       int key = rnd.nextInt(Jobid.length);
       String jobid = Jobid[key];

       int sal = rnd.nextInt(MAXSAL) + MINSAL;

       int mgrid = rnd.nextInt(MAXMGRID) + 100;

       int deptid = (rnd.nextInt(MAXDEPT) % 100) * 10;

       DecimalFormat df = new DecimalFormat("#.##");
       double comm = Double.parseDouble(df.format(rnd.nextDouble()));

       System.out.println(jobid);
       System.out.println(sal);
       System.out.println(mgrid);
       System.out.println(deptid);
       System.out.println(comm);

        emp.setJobid(jobid);
        emp.setSal(sal);
        emp.setComm(comm);
        emp.setMgrid(mgrid + "");
        emp.setDeptid(deptid + "");


    }

    }




