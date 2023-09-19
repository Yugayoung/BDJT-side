<%@ page contentType="text/html; charset=UTF-8" %>
<%@include file = "/WEB-INF/BDJTViews/header.jsp" %>
  </head>
  <body>
    <!-- Login -->
    <section id="login" class="section">
        <div class="max-container">
            <div class="login__logo">
                <img class="login__logo__img" src="${pageContext.request.contextPath }/BDJT/images/logo.ico" alt="logo">
            </div>
            <div class="login" >
                <h2 class="login__title">Login</h2>
                <form id="login__form" method="post" action="UserController">
                    <div class="login__form"></div>
                        <label for="username" class="login__label">
                            <input class="login__input" type="text" id="username" name="id" placeholder="아이디"> <br>
                        </label>
                        <label for="password" class="login__label">
                            <input class="login__input" type="password" id="password" name="password" placeholder="비밀번호"> <br>
                        </label>
                        <button class="login__button" type="submit" name="action" value="login">로그인</button>
                        <button class="signup__button" id="signup-button" name="action" type="button">회원가입</button>
                        
                        <p class="login__error">
                			<%= request.getAttribute("loginError") %>
            			</p>
                    </div>
                </form>
            </div>
        </div>
    </section>
    <footer id="information" class="section">
      <div class="information__located">
        <div class="max-container">
          <h2 class="information__title">ProPlan</h2>
          <p class="information__title">
            &copy; :마늘:육쪼마늘 - All rights reserved
          </p>
        </div>
      </div>
    </footer>
  </body>
</html>