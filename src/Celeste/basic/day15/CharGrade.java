package Celeste.basic.day15;

import java.io.*;
import java.util.Scanner;

public class CharGrade {
    public static void main(String[] args) {
        String name = "";
        int kor = 0;
        int eng = 0;
        int mat = 0;

        Scanner sc = new Scanner(System.in);
            /*System.out.print("이름은?: ");
            name = sc.next();
            System.out.print("국어는?: ");
            kor = sc.nextInt();
            System.out.print("영어는?: ");
            eng = sc.nextInt();
            System.out.print("수학은?: ");
            mat = sc.nextInt();*/
        System.out.println("성적은?(이름, 국어, 영어, 수학 순으로): ");
        name = sc.next();
        kor = sc.nextInt();
        eng = sc.nextInt();
        mat = sc.nextInt();


        String fpath = "/Users/Celeste/Downloads/info.txt";

        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            fw = new FileWriter(fpath, true);
            // 파일에 데이터 누적 옵션 설정
            bw = new BufferedWriter(fw);

            // bw.write(name + ", " + kor + ", " + eng + ", " + mat + "\n");

            String fmt = "%s, %d, %d, %d\n";
            String data = String.format(fmt, name, kor, eng, mat);
            bw.write(data);

            bw.close();
            fw.close();
        } catch (Exception e) {
            System.out.println("파일 쓰기 오류!");
            e.printStackTrace();
        }

        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader(fpath);
            br = new BufferedReader(fr); // 버퍼 기능이 있는 Reader 선언

            while(br.ready()) {
                System.out.println(br.readLine());
            }
            br.close(); // LIFO 형식으로 객체를 닫음
            fr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

