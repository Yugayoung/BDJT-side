package BDJTBack;

import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.time.*;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileItemFactory;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;

/**
 * Servlet implementation class BoardController
 */
@WebServlet("/BoardController")
public class BoardController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private BoardDAO boardDAO;
    
    public BoardController() {
        super();
        boardDAO = new BoardDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            // 기본 동작: 갤러리 페이지 로드
            ArrayList<BoardDO> galleryList = boardDAO.initialBoard();
            request.setAttribute("galleryList", galleryList);
            request.getRequestDispatcher("/WEB-INF/BDJTViews/main.jsp").forward(request, response);
        } else if (action.equals("sortLatest")) {
            // 최신순으로 정렬
            ArrayList<BoardDO> galleryList = boardDAO.initialBoard();
            request.setAttribute("galleryList", galleryList);
            request.getRequestDispatcher("/WEB-INF/BDJTViews/main.jsp").forward(request, response);
        } else if (action.equals("sortLikes")) {
            // 추천순으로 정렬
            ArrayList<BoardDO> galleryList = boardDAO.rcmndBoard();
            request.setAttribute("galleryList", galleryList);
            request.getRequestDispatcher("/WEB-INF/BDJTViews/main.jsp").forward(request, response);
        }
    }
    private List<FileItem> uploadFiles(HttpServletRequest request) {
        List<FileItem> items = null;
        try {
            // 업로드를 처리할 FileItemFactory 생성
            FileItemFactory factory = new DiskFileItemFactory(1024 * 1024, new File("./temp"));

            // 파일 업로드를 처리할 ServletFileUpload 생성
            ServletFileUpload upload = new ServletFileUpload(factory);

            // RequestContext 생성
            RequestContext ctx = new ServletRequestContext(request);

            // 업로드된 파일 목록 파싱
            items = upload.parseRequest(ctx);
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
        return items;
    }

    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        List<FileItem> items = uploadFiles(request); // 파일 업로드 처리 및 업로드된 파일 목록 얻기
        if (action != null && action.equals("upload")) {
            // 파일 업로드 액션
            String photo = request.getParameter("photo");
            String title = request.getParameter("title");
            String url = request.getParameter("url");
             String skill = request.getParameter("skill");

            // 날짜 생성
            LocalDateTime currentDate = LocalDateTime.now();

            // 게시물 생성
            BoardDO newBoard = new BoardDO();
            newBoard.setPhoto(photo);
            newBoard.setTitle(title);
            newBoard.setUrl(url);
            newBoard.setSkill(skill);
            newBoard.setCreationDate(currentDate);
            newBoard.setOrderRcmnd(0); // 초기 좋아요 수를 0으로 설정

            // id설정 해야한다고 하는데, 이게 맞는지 ..?

            // 데이터베이스에 새 게시물 추가
            boardDAO.insertuploadInfo(items, newBoard);
        }

        // 업로드 후 다시 갤러리 페이지로 리다이렉트 또는 원하는 페이지로 이동
        response.sendRedirect("BoardController");
    }
   }
