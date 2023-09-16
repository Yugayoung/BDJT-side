<%@ page contentType="text/html; charset=UTF-8" %>
    
<!DOCTYPE html>

<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />

    <title>ProPlan Login</title>
    
     <!-- Google Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
    <link
      href="https://fonts.googleapis.com/css2?family=Nanum+Pen+Script&family=Open+Sans:wght@400;600&display=swap"
      rel="stylesheet"
    />
    
    <!-- CSS -->
    <link rel="stylesheet" type="text/css" href="loginStyle.css">

  </head>
  <body>
    <!-- Login -->
    <section id="login" class="section">
        <div class="max-container">
            <div class="login__logo">
                <img class="login__logo__img" src="images/logo.ico" alt="logo">
            </div>

            <div class="login" >
                <h2 class="login__title">Login</h2>

                <form id="login__form">
                    <div class="login__form"></div>
                        <label for="username" class="login__label">
                            <input class="login__input" type="text" id="username" placeholder="아이디"> <br>
                        </label>
                        
                        <label for="password" class="login__label">
                            <input class="login__input" type="password" id="password" placeholder="비밀번호"> <br>
                        </label>
                        
                        <button class="login__button" type="submit">로그인</button>
                        <button class="signup__button" id="signup-button">회원가입</button>
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
            &copy; 🧄육쪼마늘 - All rights reserved
          </p>
        </div>
      </div>
    </footer>
  </body>
</html>