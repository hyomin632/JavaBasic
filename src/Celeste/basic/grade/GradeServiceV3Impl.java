package Celeste.basic.grade;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GradeServiceV3Impl implements GradeServiceV3 {
    // 멤버변수 선언
    // 입력받은 모든 성적 데이터를 저장하는 동적 배열변수 선언
    List<GradeVO> gdata = new ArrayList<>();
    GradeVO g = null;

    // 성적 데이터를 저장해둘 파일 경로 지정
    String fpath = "/Users/celeste/Documents/Grade.data";
    String fpath2 = "/Users/celeste/Documents/Grade.csv";
    String fpath3 = "/Users/celeste/Documents/Grade.json";

    // CSV직렬화를 위한 문자열 포맷
    String csvfmt = "%s,%d,%d,%d,%d,%.1f,%s\n";

    // CSV직렬화를 위한 문자열 포맷
    String jsonfmt = "{\"name\":\"%s\", \"kor\":%d, \"eng\":%d, \"mat\":%d," +
                       "\"tot\":%d, \"avg\":%.1f, \"grd\":\"%s\"},\n";

    // 싱글톤 패턴 시작
    private static GradeServiceV3 gsrv = null;

    private GradeServiceV3Impl() {
    // 프로그램 시작시 initGrade 메서드 호출
    initGrade();
    }

    public static GradeServiceV3 getInstance() {
        if (gsrv == null) gsrv = new GradeServiceV3Impl();
        return gsrv;
    }
    // 싱글톤 패턴 끝

    @Override
    public void displayMenu() {
        String displaymenu =
                        "------------------------- \n" +
                        "    성적 프로그램 v7      \n" +
                        "------------------------- \n" +
                        " 1. 성적 데이터 입력      \n" +
                        " 2. 성적 데이터 조회      \n" +
                        " 3. 성적 데이터 상세 조회 \n" +
                        " 4. 성적 데이터 수정      \n" +
                        " 5. 성적 데이터 삭제      \n" +
                        " 0. 프로그램 종료         \n" +
                        "------------------------- \n" +
                        " 작업을 선택하세요: ";
        System.out.println(displaymenu);
    }

    @Override
    public void newGrade() {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("이름은?: ");
            String name = sc.next();
            System.out.print("국어는?: ");
            int kor = sc.nextInt();
            System.out.print("영어는?: ");
            int eng = sc.nextInt();
            System.out.print("수학은?: ");
            int mat = sc.nextInt();
            GradeVO g = new GradeVO(name, kor, eng, mat); // 입력받은 성적 데이터를 객체화
            computeGrade(g);                              // 성적 데이터 처리
            gdata.add(g);                                 // 처리된 성적 데이터를 동적 배열에 저장

            // 방금 입력된 성적 데이터와 기존에 입력된 성적 데이터 모두를 grade.data 파일에 직렬화해서 저장
            // saveGrade();

        } catch (Exception ex) {
            System.out.println("잘못 입력하셨습니다");
            return; // 오류 발생시 실행 중단, main으로 복귀
        }
    }

    // 저장된 성적 데이터들 중에서 배열 인덱스, 이름, 국어, 영어, 수학만 뽑아서 목록(list) 형태로 출력
    @Override
    public void showGrade() {
        String fmt = "번호: %d, 이름: %s, 국어: %d, 영어: %d, 수학: %d \n";
        int pos = 0; // 배열 인덱스
        for(GradeVO g : gdata) {
            System.out.printf(fmt, pos, g.getName(), g.getKor(), g.getEng(), g.getMat());
            ++pos;
        }
    }

    @Override
    public void computeGrade(GradeVO g) {
        g.setTot(g.getKor() + g.getEng() + g.getMat());
        g.setAvg((double) g.getTot() / 3);
        switch ((int)g.getAvg() / 10) {
            case 10: case 9: g.setGrd('수'); break;
            case 8: g.setGrd('우'); break;
            case 7: g.setGrd('미'); break;
            case 6: g.setGrd('양'); break;
            default: g.setGrd('가'); break;
        }
    }

    @Override
    public void showOneGrade() {
        String fmt = "번호: %d, 이름: %s, 국어: %d 영어: %d 수학: %d \n" + "총점: %d, 평균: %.1f, 학점: %c \n";
        Scanner sc = new Scanner(System.in);
        System.out.print("조회할 학생의 번호는?: ");
        int pos = sc.nextInt();

        try {
            GradeVO g = gdata.get(pos);
            System.out.printf(fmt, pos, g.getName(), g.getKor(), g.getEng(), g.getMat(), g.getTot(), g.getAvg(), g.getGrd());
        } catch (Exception ex) {
            System.out.println("데이터가 존재하지 않습니다");
        }
    }

    @Override
    public void modifyGrade() {

    }

    @Override
    public void removeGrade() {

    }

    // 기존에 입력된 성적 데이터를 역직렬화로 파일에서 읽어서 메모리에 적재하는 기능 담당
    @Override
    public void initGrade() {
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        ObjectInputStream ois = null;

        try {
            fis = new FileInputStream(fpath);
            bis = new BufferedInputStream(fis);
            ois = new ObjectInputStream(bis);

            gdata = (ArrayList) ois.readObject();
        } catch (Exception ex) {
            // ex.printStackTrace();
            System.out.println("파일이 없거나, 시스템 오류입니다!");
        } finally {
            if (ois != null)
                try { ois.close(); } catch (IOException e) { }
            if (bis != null)
                try { bis.close(); } catch (IOException e) { }
            if (fis != null)
                try { fis.close(); } catch (IOException e) { }
        }
    }

    // 메모리 내에 저장된 모든 성적 데이터를 직렬화를 통해 파일에 저장
    @Override
    public void saveGrade() {
        FileOutputStream fos = null;
        BufferedOutputStream bos = null;
        ObjectOutputStream oos = null;

        try {
            fos = new FileOutputStream(fpath);
            bos = new BufferedOutputStream(fos);
            oos = new ObjectOutputStream(bos);

            oos.writeObject(gdata);

        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("파일이 없거나, 시스템 오류입니다!");
        } finally {
            if (oos != null)
                try { oos.close(); } catch (IOException e) { }
            if (bos != null)
                try { bos.close(); } catch (IOException e) { }
            if (fos != null)
                try { fos.close(); } catch (IOException e) { }
    }
}

    // 기존에 입력된 성적 데이터를 CSV역직렬화로 파일에서 읽어서 메모리에 적재하는 기능 담당
    @Override
    public void initGrade2() {
        gdata = new ArrayList<>();

        // try-with-resources 구문 사용
        try (FileReader fr = new FileReader(fpath2);
             BufferedReader br = new BufferedReader(fr);
        ) {
            while (br.ready()) {
                // csv파일에서 문자열 한 줄을 읽어서 쉼표 단위로 분리한 후 배열로 생성
                String line = br.readLine();
                String data[] = line.split(",");

                // 생성된 배열을 이용해서 성적 객체를 만들어 총점, 평균, 학점을 구한 다음 (옵션) ArrayList에 저장
                GradeVO g = new GradeVO(data[0], Integer.parseInt(data[1]),
                                        Integer.parseInt(data[2]), Integer.parseInt(data[3]));
                computeGrade(g);

                gdata.add(g);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // 메모리 내에 저장된 모든 성적 데이터를 CSV직렬화를 통해 파일에 저장
    @Override
    public void saveGrade2() {

        // JDK7부터는 자원을 쉽게 해제할 수 있도록 try-with-resources라는 구문을 지원
        try (
            FileWriter fw = new FileWriter(fpath2);
            BufferedWriter bw = new BufferedWriter(fw);
        ) {
            String result = "";
            for(GradeVO g: gdata) {
               result = String.format(csvfmt, g.getName(), g.getKor(), g.getEng(),
                                      g.getMat(), g.getTot(), g.getAvg(), g.getGrd());
               bw.write(result);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // 기존에 입력된 성적 데이터를 JSON역직렬화로 파일에서 읽어서 메모리에 적재하는 기능 담당
    @Override
    public void initGrade3() {
        gdata = new ArrayList<>();

        // try-with-resources 구문 사용
        try (FileReader fr = new FileReader(fpath3);
             BufferedReader br = new BufferedReader(fr);
        ) {
            // json 파일의 모든 내용을 한 번에 읽어 lines 변수에 저장
            String lines = br.lines().collect(Collectors.joining());
            // System.out.println(lines);

            // 텍스트 파일에 저장된 반정형 데이터를 JSON 분석기(parser)를 이용해서 메모리에 객체 형태로 저장
            JSONParser parser = new JSONParser();
            JSONObject obj = (JSONObject) parser.parse(lines);

            // 메모리에 저장된 객체에서 sj라는 이름의 배열 객체를 가져옴
            JSONArray jsons = (JSONArray) obj.get("g");

            // 반복문을 이용해서 배열 객체의 각 요소를 하나씩 꺼내 성적 객체에 담고 ArrayList에 저장
            for(int i = 0; i < jsons.size(); ++i) {
                JSONObject json = (JSONObject) jsons.get(i);
                GradeVO g = new GradeVO((String) json.get("name"), ((Long)json.get("kor")).intValue(),
                            ((Long)json.get("eng")).intValue(), ((Long)json.get("mat")).intValue());
                computeGrade(g);
                gdata.add(g);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // 메모리 내에 저장된 모든 성적 데이터를 JSON직렬화를 통해 파일에 저장
    @Override
    public void saveGrade3() {
        try (
                FileWriter fw = new FileWriter(fpath3);
                BufferedWriter bw = new BufferedWriter(fw);
        ) {
            String result = "";
            bw.write("{ \"g\":["); // json 배열 시작
            for(GradeVO g: gdata) {
                result = String.format(jsonfmt, g.getName(), g.getKor(), g.getEng(),
                        g.getMat(), g.getTot(), g.getAvg(), g.getGrd());
                // { 'name':'혜교', 'kor':54, 'eng':98, 'mat':74, 'tot':226, 'avg':75.3, 'grd':'미' }
                bw.write(result);
            }
            bw.write("] }"); // json 배열 끝
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}