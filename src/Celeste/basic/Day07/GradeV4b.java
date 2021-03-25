package Celeste.basic.Day07;

public class GradeV4b {
    // 클래스의 종류: VO/DTO, Service, DAO
    // VO/DTO: Value Object/Data Transfer Object -> 값만 저장하기 위해 사용하는 클래스
    //                                              주로 데이터베이스 테이블의 각 열과 연계해서 작성함
    // Service: 비즈니스 로직을 구성하는 클래스. 데이터 영속화 전에 처리하는 코드들로 구성
    // DAO: Data Access Object -> 데이터 영속화와 관련된 코드들로 구성된 클래스
    //                            주로 데이터베이스를 사용해서 데이터를 추가/조회/수정/삭제하는 기능을 작성

    public static void main(String[] args) {
        // 성적 데이터 생성
        Grade g = new Grade("지현", 78, 86, 95);

        // 성적 처리를 위한 service 객체 생성
        GradeService gsrv = new GradeService();

        // 성적 처리
        gsrv.computeGrade(g);

        // 결과 출력
        gsrv.printGrade(g);
    }

    static class Grade {
        // 멤버변수
        private String name;
        private int kor;
        private int eng;
        private int mat;
        private int tot;
        private double avg;
        private char grd;
        // 생성자
        public Grade() { }

        public Grade(String name, int kor, int eng, int mat) {
            this.name = name;
            this.kor = kor;
            this.eng = eng;
            this.mat = mat;
        }

    }
    static class GradeService {
        // 성적 데이터 입력
        public Grade readGrade() {
            return null;
        }

        // 성적 처리
        public void computeGrade(Grade g) { // 포인트는 'Grade g' -> 이걸 입력하면 다 입력할 필요 없음
            g.tot = g.kor + g.eng + g.mat;
            g.avg = (double) g.tot / 3;
            switch ((int)g.avg / 10) {
                case 10: case 9: g.grd = '수'; break;
                case 8: g.grd = '우'; break;
                case 7: g.grd = '미'; break;
                case 6: g.grd = '양'; break;
                default: g.grd = '가'; break;
            }
        }

        // 결과 출력
        public void printGrade(Grade g) {
            String fmt = "%s %d %d %d \n%d %.1f %c\n";
            System.out.printf(fmt, g.name, g.kor, g.eng, g.mat, g.tot, g.avg, g.grd);
        }


        public void Grade(Grade g) {
        }
    }
}
