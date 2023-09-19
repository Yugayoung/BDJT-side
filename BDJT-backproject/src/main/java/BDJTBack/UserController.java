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
                response.sendRedirect(request.getContextPath() + "/WEB-INF/BDJTViews/main.jsp");
                System.out.println(loggedIn);
            } else if (loggedIn == false){
            	System.out.println(loggedIn);
                request.setAttribute("loginError", "아이디 또는 비밀번호가 올바르지 않습니다.");
                request.getRequestDispatcher("/WEB-INF/BDJTViews/login.jsp").forward(request, response);
            }
        } else if (action.equals("register")) {
            request.getRequestDispatcher("/WEB-INF/BDJTViews/signUp.jsp").forward(request, response);
        }
    }
}


