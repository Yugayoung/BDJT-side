<%@ page contentType="text/html; charset=UTF-8" %>
    
<!DOCTYPE html>

<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />

    <title>ProPlan SignUp</title>
    
     <!-- Google Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
    <link
      href="https://fonts.googleapis.com/css2?family=Nanum+Pen+Script&family=Open+Sans:wght@400;600&display=swap"
      rel="stylesheet"
    />
    
    <!-- CSS -->
    <link rel="stylesheet" type="text/css" href="signUpStyle.css">

  </head>
  <body>
    <!-- Sign Up -->
    <div id="signup">
      <section id="signup" class="section">
        <div class="max-container">
          <div class="login__logo">
            <img class="login__logo__img" src="images/logo.ico" alt="logo" />
          </div>

          <div class="signup">
            <h2 class="signup__title">Sign Up</h2>

            <form id="signup__form">
              <div class="signup__form">
                <label for="new-username" class="signup__label">
                  <input
                    class="signup__input"
                    type="text"
                    id="new-username"
                    placeholder="아이디"
                  />
                </label>

                <label for="new-password" class="signup__label">
                  <input
                    class="signup__input"
                    type="password"
                    id="new-password"
                    placeholder="비밀번호"
                  />
                </label>

                <label for="confirm-password" class="signup__label">
                  <input
                    class="signup__input"
                    type="password"
                    id="confirm__password"
                    placeholder="비밀번호 확"
                  />
                </label>

                <div class="signup__userInfo">
                  <label for="full-name" class="signup__label">
                    <input
                      class="signup__input"
                      type="text"
                      id="full-name"
                      placeholder="이름"
                    />
                  </label>

                  <label for="dob" class="signup__label">
                    <input
                      class="signup__input"
                      type="date"
                      id="dob"
                      placeholder="생년월일"
                    />
                  </label>

                  <label for="phone" class="signup__label">
                    <input
                      class="signup__input"
                      type="tel"
                      id="phone"
                      placeholder="깃허브 주소"
                    />
                  </label>
                </div>
              </div>

              <div id="password-match-message"></div>
              <!--추가: 비밀번호 일치 여부 메시지-->
              <button class="signup__submit__button" type="submit">
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
            &copy; 🧄육쪼마늘 - All rights reserved
          </p>
        </div>
      </div>
    </footer>
  </body>
</html>
