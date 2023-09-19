<%@ page contentType="text/html; charset=UTF-8" %>
<%@include file = "/WEB-INF/BDJTViews/header.jsp" %>
  </head>
  <body>
    <!-- Sign Up -->
    <div id="signup">
      <section id="signup" class="section">
        <div class="max-container">
          <div class="login__logo">
            <img class="login__logo__img" src="${pageContext.request.contextPath }/BDJT/images/logo.ico" alt="logo" />
          </div>
          <div class="signup">
            <h2 class="signup__title">Sign Up</h2>
            <form id="signup__form" method="post" action="UserController">
              <div class="signup__form">
                <label for="new-username" class="signup__label">
                  <input
                    class="signup__input"
                    type="text"
                    id="new-username"
                    name="id"
                    placeholder="아이디"
                  />
                </label>
                <label for="new-password" class="signup__label">
                  <input
                    class="signup__input"
                    type="password"
                    id="new-password"
                    name="password"
                    placeholder="비밀번호"
                  />
                </label>
                <label for="confirm-password" class="signup__label">
                  <input
                    class="signup__input"
                    type="password"
                    id="confirm__passworda"
                    placeholder="비밀번호 확인"
                  />
                </label>
                <div class="signup__userInfo">
                  <label for="full-name" class="signup__label">
                    <input
                      class="signup__input"
                      type="text"
                      id="full-name"
                      name="name"
                      placeholder="이름"
                    />
                  </label>
                  <label for="dob" class="signup__label">
                    <input
                      class="signup__input"
                      type="date"
                      id="dob"
                      name="birthdate"
                      placeholder="생년월일"
                    />
                  </label>
                  <label for="phone" class="signup__label">
                    <input
                      class="signup__input"
                      type="tel"
                      id="phone"
                      name="github"
                      placeholder="깃허브 주소"
                    />
                  </label>
                </div>
              </div>
              <div id="password-match-message"></div>
              <!--추가: 비밀번호 일치 여부 메시지-->
              <button class="signup__submit__button" type="submit" name="action" value="register">
                회원가입
              </button>
              <button class="back__button" type="button" id="back__button">
                뒤로가기
              </button>
            </form>
          </div>
        </div>
      </section>
    </div>
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