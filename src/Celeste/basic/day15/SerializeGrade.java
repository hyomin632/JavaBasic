package Celeste.basic.day15;

import Celeste.basic.grade.GradeVO;

import java.io.*;
import java.util.Scanner;

public class SerializeGrade {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String name = "";
        int kor = 0;
        int eng = 0;
        int mat = 0;

        Scanner sc = new Scanner(System.in);
        System.out.println("성적은?(이름, 국어, 영어, 수학 순으로): ");
        name = sc.next();
        kor = sc.nextInt();
        eng = sc.nextInt();
        mat = sc.nextInt();

        // 입력받은 데이터를 GradeVO에 저장
        GradeVO g = new GradeVO(name, kor, eng, mat);

        // 직렬화
        String fpath = "/Users/Celeste/Documents/grade.bin";

        FileOutputStream fos = new FileOutputStream(fpath);
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        ObjectOutputStream oos = new ObjectOutputStream(bos);

        oos.writeObject(g);

        oos.close();
        bos.close();
        fos.close();

        // 역직렬화: 바이트 형태로 저장된 객체를 데이터로 변환
        FileInputStream fis = new FileInputStream(fpath);
        BufferedInputStream bis = new BufferedInputStream(fis);
        ObjectInputStream ois = new ObjectInputStream(bis);

        GradeVO gvo = (GradeVO) ois.readObject();

        ois.close();
        bis.close();
        fis.close();

        int tot = gvo.getKor() + gvo.getEng() + gvo.getMat();
        double avg = (double) tot / 3;

        String fmt = "%s, %d, %d, %d, %d, %.1f\n";
        System.out.printf(fmt, gvo.getName(), gvo.getKor(), gvo.getEng(), gvo.getMat(), tot, avg);

    }
}
