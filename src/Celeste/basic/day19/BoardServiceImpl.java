package Celeste.basic.day19;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class BoardServiceImpl implements BoardService {
    private static BoardService bsrv;
    private static BoardDAO bdao;

    private BoardServiceImpl() { bdao = BoardDAOImpl.getInstance(); }

    public static BoardService getInstance() {
        if (bsrv == null) bsrv = new BoardServiceImpl();
        return bsrv;
    }

    @Override
    public void newBoard() {
        Scanner sc = new Scanner(System.in);
            System.out.print("제목은?: ");
            String title = sc.next();
            System.out.print("아이디는?: ");
            String userid = sc.next();
            System.out.print("본문은?: ");
            String contents = sc.next();

            BoardVO bvo = new BoardVO(null, title, userid, null, null, null, contents);

            int cnt = bdao.insertBoard(bvo);
            if (cnt > 0) System.out.println("새로운 글 추가 완료!");
    }

    @Override
    public void readBoard() {
        String fmt = "%s, %s, %s, %s, %s, %s \n";
        ArrayList<BoardVO> bdlist = (ArrayList<BoardVO>) bdao.selectBoard();

        StringBuffer sb = new StringBuffer();
        for (BoardVO b : bdlist) {
            String result = String.format(fmt, b.getBdno(), b.getTitle(), b.getUserid(), b.getRegdate(),  b.getViews(), b.getThumbup());
            sb.append(result);
        }
        System.out.println(sb.toString());
    }

    @Override
    public void readOneBoard() {
        String fmt = "%s, %s, %s, %s, %s, %s\n %s";
        Scanner sc = new Scanner(System.in);
        System.out.print("조회할 게시글 번호는?: ");
        int bdno = sc.nextInt();

        BoardVO b = bdao.selectOneBoard(bdno);
        String result = String.format(fmt, b.getBdno(), b.getTitle(), b.getUserid(), b.getRegdate(), b.getViews(), b.getThumbup(), b.getContents());

        System.out.println(result);

        System.out.println("본 게시물을 추천하시겠습니까? (Y/N)");
        String thumbup = sc.next();
        if (thumbup.toUpperCase().equals("Y"))
            bdao.thumbupBoard(bdno); // 본문 글 추천하기
    }

    @Override
    public void modifyBoard() {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("수정할 게시글의 번호는?: ");
            String bdno = sc.next();
            System.out.println("수정할 게시글 데이터를 입력하세요");
            System.out.println("입력 순서는 제목, 작성자, 본문: ");
            String title = sc.next();
            String userid = sc.next();
            String contents = sc.next();

            BoardVO b = new BoardVO(title, userid, contents);
            b.setBdno(bdno);

            int cnt = bdao.updateBoard(b);
            if (cnt > 0) System.out.println("게시글 수정 완료!");

        } catch (Exception ex) {
            System.out.println("잘못 입력하셨습니다!");
            return;
        }

    }

    @Override
    public void removeBoard() {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("삭제할 게시글의 번호는? ");
            int bdno = Integer.parseInt(sc.next());

            int cnt = bdao.deleteBoard(bdno);
            if (cnt > 0) System.out.println("게시글 삭제 완료!");
        } catch (Exception ex) {
            System.out.println("잘못 입력하셨습니다!");
            return;
        }

    }
}
