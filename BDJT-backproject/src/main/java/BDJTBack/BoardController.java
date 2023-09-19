package BDJTBack;
import java.io.File;
import java.io.IOException;
import java.time.*;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
/**
 * Servlet implementation class BoardController
 */
@WebServlet("/BoardController")
@MultipartConfig
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
        } else if (action.equals("search")) {
            // 기술 검색
            String techStack = request.getParameter("techStack");
            
            if (techStack != null && !techStack.isEmpty()) {
                List<BoardDO> searchResults = boardDAO.searchBoardByTechStack(techStack);
                request.setAttribute("searchResults", searchResults);
            }
            ArrayList<BoardDO> galleryList = boardDAO.initialBoard();
            request.setAttribute("galleryList", galleryList);
            request.getRequestDispatcher("/WEB-INF/BDJTViews/main.jsp").forward(request, response);
        }
    }    
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
        String directory = "D:/000.develop/BF-semi-Project/BDJT-side/BDJT-backproject/BDJT-backproject/src/main/webapp/upload";
        // 디렉토리 관련 오류 시 디렉토리 재설정 필요
        int sizeLimit = 1024 * 1024 * 5; // 5MB 제한
        
    	System.out.println(directory); 
    	
    	MultipartRequest multi = new MultipartRequest(request, directory, sizeLimit,
                "UTF-8", new DefaultFileRenamePolicy());
        

    	String action = multi.getParameter("action");

        if (action != null && action.equals("upload")) {
            // 파일 업로드 액션
            
            
            System.out.println(directory);

            // 디렉토리 생성
            File uploadDir = new File(directory);
            if (!uploadDir.exists()) {
                uploadDir.mkdirs();
            }

            String savedName = "";
            @SuppressWarnings("unchecked")
            Enumeration<String> fileNames = multi.getFileNames();

            if (fileNames.hasMoreElements()) {
                String paramName = fileNames.nextElement();
                savedName = multi.getFilesystemName(paramName);
            }

            // 파일 정보를 photo 변수에 저장
            String photo = "/BDJT/upload/" + savedName; // 웹 경로로 수정

            String title = multi.getParameter("title");
            String url = multi.getParameter("url");
            String skill = multi.getParameter("skill");
            // 날짜 생성
            LocalDateTime currentDate = LocalDateTime.now();
            System.out.println(action + "3");
            // 게시물 생성
            BoardDO newBoard = new BoardDO();
            newBoard.setPhoto(photo);
            newBoard.setTitle(title);
            newBoard.setUrl(url);
            newBoard.setSkill(skill);
            newBoard.setCreationDate(currentDate);
            newBoard.setOrderRcmnd(0);
            // id 설정 - 필요한 경우 수정
            // newBoard.setId(userId);
            // 데이터베이스에 새 게시물 추가
            boardDAO.insertuploadInfo(newBoard);
            System.out.println(action + "4");
        }
        // 업로드 후 다시 갤러리 페이지로 리다이렉트 또는 원하는 페이지로 이동
        response.sendRedirect("BoardController");
    }
   }