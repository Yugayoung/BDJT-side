package BDJTBack;
import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.time.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileItemFactory;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;

@WebServlet("/UserController")
public class UserController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            request.getRequestDispatcher("/WEB-INF/BDJTViews/login.jsp").forward(request, response);
        } else if (action.equals("login")) {
            String id = request.getParameter("id");
            String password = request.getParameter("password");
            
            UsersDAO usersDAO = new UsersDAO();
            boolean loggedIn = usersDAO.loginUser(id, password);
            
            if (loggedIn == true) {
                response.sendRedirect(request.getContextPath() + "/BoardController");
                System.out.println(loggedIn);
            } 
            else if (loggedIn == false){
            	System.out.println(loggedIn);
                request.setAttribute("loginError", "아이디 또는 비밀번호가 올바르지 않습니다.");
                request.getRequestDispatcher("/WEB-INF/BDJTViews/login.jsp").forward(request, response);
            }
        	} else if (action.equals("register")) {
        	System.out.println(action);
            request.getRequestDispatcher("/WEB-INF/BDJTViews/signUp.jsp").forward(request, response);
            String id = request.getParameter("id");
            String password = request.getParameter("password");
            String name = request.getParameter("name");
            String birthdate = request.getParameter("birthdate");
            String github = request.getParameter("github");
            if (id == null || password == null || name == null || birthdate == null || github == null) {
                request.setAttribute("registrationError", "모든 필수 정보를 입력해주세요.");
                request.getRequestDispatcher("/WEB-INF/BDJTViews/signUp.jsp").forward(request, response);
                return;
            }
            UsersDO usersDO = new UsersDO();
            usersDO.setId(id);
            usersDO.setPassword(password);
            usersDO.setName(name);
            usersDO.setBirthdate(birthdate);
            usersDO.setGithub(github);
            UsersDAO usersDAO = new UsersDAO();
            int rowCount = usersDAO.insertUserInfo(usersDO);
            if (rowCount > 0) {
                request.setAttribute("registrationMessage", "회원가입이 완료되었습니다.");
                request.getRequestDispatcher("/WEB-INF/BDJTViews/login.jsp").forward(request, response);
            } else {
                request.setAttribute("registrationError", "회원가입에 실패하였습니다.");
                request.getRequestDispatcher("/WEB-INF/BDJTViews/signUp.jsp").forward(request, response);
            	}
        	}
        	else if (action.equals("logout")) { 
        		System.out.println(action);
                HttpSession session = request.getSession(false); 
                if (session != null) {
                    session.invalidate(); 
                }
                response.sendRedirect(request.getContextPath() + "/UserController");
            }
    }
}

