package BDJTBack;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
            // 기본 액션 (로그인 페이지 표시)
            request.getRequestDispatcher("/WEB-INF/BDJTViews/login.jsp").forward(request, response);
        } else if (action.equals("loginpage")) {
            // 기본 액션 (로그인 페이지 표시)
            request.getRequestDispatcher("/WEB-INF/BDJTViews/login.jsp").forward(request, response);
        }else if (action.equals("signUppage")) {
            // 기본 액션 (로그인 페이지 표시)
            request.getRequestDispatcher("/WEB-INF/BDJTViews/signUp.jsp").forward(request, response);
        }
        else if (action.equals("login")) {
            // 로그인 액션
            String id = request.getParameter("id");
            String password = request.getParameter("password");

            if (id == null || id.isEmpty() || password == null || password.isEmpty()) {
                // 필수 입력값이 누락된 경우
                request.setAttribute("loginError", "아이디와 비밀번호를 모두 입력해야 합니다.");
                request.getRequestDispatcher("/WEB-INF/BDJTViews/login.jsp").forward(request, response);
                System.out.println("로그인 실패: 필수 입력값 누락");
                return;
            }

            UsersDAO usersDAO = new UsersDAO();
            boolean loggedIn = usersDAO.loginUser(id, password);

            if (loggedIn) {
                // 로그인 성공
                HttpSession session = request.getSession();
                session.setAttribute("userId", id);
                response.sendRedirect(request.getContextPath() + "/BoardController"); // 로그인 후 페이지로 이동
                System.out.println("로그인 성공: " + id);
            } else {
                // 로그인 실패
                request.setAttribute("loginError", "아이디 또는 비밀번호가 올바르지 않습니다.");
                request.getRequestDispatcher("/WEB-INF/BDJTViews/login.jsp").forward(request, response);
                System.out.println("로그인 실패: 아이디 또는 비밀번호 오류");
            }
        } else if (action.equals("register")) {
            // 회원가입 액션
            String id = request.getParameter("id");
            String password = request.getParameter("password");
            String confirm = request.getParameter("confirm");
            String name = request.getParameter("name");
            String birthdate = request.getParameter("birthdate");
            String github = request.getParameter("github");

            if (id == null || id.isEmpty() || password == null || password.isEmpty() ||
                confirm == null || confirm.isEmpty() || name == null || name.isEmpty() ||
                birthdate == null || birthdate.isEmpty() || github == null || github.isEmpty()) {
                // 필수 입력값이 누락된 경우
                request.setAttribute("registrationError", "모든 필수 입력값을 제공해야 합니다.");
                request.getRequestDispatcher("/WEB-INF/BDJTViews/signUp.jsp").forward(request, response);
                System.out.println("회원가입 실패: 필수 입력값 누락");
                return;
            }

            if (!password.equals(confirm)) {
                // 비밀번호 확인이 일치하지 않을 경우
                request.setAttribute("registrationError", "비밀번호와 비밀번호 확인이 일치하지 않습니다.");
                request.getRequestDispatcher("/WEB-INF/BDJTViews/signUp.jsp").forward(request, response);
                System.out.println("회원가입 실패: 비밀번호 확인 불일치");
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
                // 회원가입 성공
                request.setAttribute("registrationError", "회원가입이 완료되었습니다.");
                request.getRequestDispatcher("/WEB-INF/BDJTViews/login.jsp").forward(request, response);
                System.out.println("회원가입 성공: " + id);
            } else {
                // 회원가입 실패
                request.setAttribute("registrationError", "회원가입에 실패하였습니다.");
                request.getRequestDispatcher("/WEB-INF/BDJTViews/signUp.jsp").forward(request, response);
                System.out.println("회원가입 실패: 데이터베이스 오류 또는 다른 문제로 인한 실패");
            }
        } else if (action.equals("logout")) {
            // 로그아웃 액션
            HttpSession session = request.getSession(false);
            if (session != null) {
                session.invalidate();
            }
            response.sendRedirect(request.getContextPath() + "/UserController");
            System.out.println("로그아웃 성공");
        }
    }
}
