
<%@ page  language="java" contentType="text/html; charset=UTF-8"
    	  pageEncoding="UTF-8"
    	  import="BDJTBack.*"
    	  import="com.oreilly.servlet.*, com.oreilly.servlet.multipart.*"
		  import="java.util.*"
    	  %>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
 
<%@ include file = "/WEB-INF/BDJTViews/header.jsp" %>

    </head>
    <body>
         <!-- Header -->
        <header class="header" style="display: none;">
            <section class="header__logo">
                    <img class="header__logo__img" src="${pageContext.request.contextPath }/BDJT/images/logo.ico" alt="logo">
            </section>
        </header>
        

        <!-- main -->
        <main> 
            <!-- Top -->
            <section id="home" class="max-container">
                <div class="home__container">
                    <section class="home__post">
                        <h2 class="home__description">다른 개발자들은 어떤 프로젝트를 만들었을까?</h2>
                        <img class="home__logo" src="${pageContext.request.contextPath }/BDJT/images/beforelogocolor.png" alt="logo" />
                        <h2 class="home__title">
                            개발자 토이프로젝트 모아보기 서비스 <br /> <br />
                        </h2>
                        <h2 class="home__description">
                            선배, 동료 개발자들의 토이프로젝트를 한눈에 모아보고, <br />
                            <strong class="home__title--strong">좋은 프로젝트</strong>는 더 많은 사람들과 공유해보세요.
                        </h2>
                            
                        
                        <div class="home__button">
                            <button class="home__fileButton">FILEUPLOAD</button>      
                            <form method="post" action="UserController">
                            	<button class="home__logoutButton" type="submit" name="action" value="logout">LOGOUT</button>
                            </form>        
                            
                        </div>

                    </section>
                    <section class="home__img">
                        <img class="home__sideImg" src="${pageContext.request.contextPath}/BDJT/images/sideImg.png" alt="sideImg" />
                        
                    </section>
                    

                </div>
            </section>

            <!-- FileUpload -->
            <section id="contents" >
                <div class="max-container displayNone">
                    <section class="fileUpload">
                        <h1 class="fileUpload__title">Upload a completed project</h1>
                        	<form class="fileUpload__input" enctype="multipart/form-data" method="post" action="BoardController">
                                <div class="fileUpload__inputDiv">
                                    <input type="file" name="photo" class="fileInput" /> 
                                    <input type="text" name="title" class="titleInput" placeholder="제목 입력" />
        							<input type="url" name="url" class="urlInput" placeholder="URL 입력" />
                                   	<select type="text"class="skill" name="skill" >
                                        <option value="NONE">기술 스택을 선택해주세요.</option>
                                        <option value="HTML">HTML</option>
                                        <option value="CSS">CSS</option>
                                        <option value="React">React</option>
                                        <!-- 다른 기술 스택 항목들을 추가할 수 있습니다 -->
                                    </select>
                                </div>

                                <div class="fileUpload__submit">                               
                                    <button  name = "action" value = "upload" class="fileUpload__submitButton" type="submit"><i class="fa-solid fa-upload fileUpload__submitIcon"></i></button>                          

                                    <p class="fileUpload__submitMessage">업로드 성공!</p>
                                </div>
                            </form>
                    </section>
                </div>
            </section>

            <!-- Gallery -->
            <section id="gallery__all">
                <div class="max-container">
                    <h1 class="galleryAll__title">Discover the best portfolio</h1>
                    <div class="gallery__array">
                        <p class="gallery__array-text">정렬</p>
                        <span class="gallery__array-divider"></span>
                        <div class="gallery__array-buttons">
                            <button class="sortByLikesButton">최신순</button>
                            <button class="sortByLatestButton">추천순</button>
                        </div>
                        <form id="searchForm" method="get" action="BoardController">
                        	<div class="gallery__search">
                            	<input type="text" class="gallery__searchInput" name="skill" id="searchInput" placeholder="기술 스택 검색" />
                            	<button class="gallery__searchButton" type="submit">
                                	<i class="fa-solid fa-magnifying-glass"></i>
                            	</button>                      
                        	</div>
                        </form>
                    </div>                    

                  <div class="gallery__design">
                  		<section class="gallery__contents">
                  			<c:forEach items="${galleryList}" var="boardDO">
                  					<div class="gallery__image-container">
			                    		<img src="${boardDO.photo}" class="gallery__image" alt="Uploaded Photo" onclick="redirectToURL('${boardDO.url}')">
			                    		<p class="gallery__title">${boardDO.title}</p>
			                    		<p class="gallery__title">${boardDO.skill}</p>			                   
										<button class="gallery__like-button"><i class="fa-regular fa-thumbs-up gallery__like-icon"></i></button>
										<p class="gallery__likes">${boardDO.orderRcmnd}</p>
			        				</div>
			            	</c:forEach>
			            <!-- forEach 루프의 끝 -->
                   		</section>
			        </div>
			    </div>
            </section>
        </main>
        
        <script type="text/javascript">
        	document.addEventListener('DOMContentLoaded', function() {
            	const header = document.querySelector('.header');
            	const headerLogo = document.querySelector('.header__logo');
            	const headerHeight = header.offsetHeight;
            	const home = document.querySelector('.home__container');

            	const homeHeight = home.offsetHeight;

            	document.addEventListener('scroll', () => {
                	if (window.scrollY >= homeHeight / 4) {
                    	header.style.display = 'block'; 
                	} else {
                    	header.style.display = 'none'; 
                	}
            	});
        	});
        	
        	const contents = document.querySelector(".displayNone");
        	const fileUploadButton = document.querySelector(".home__fileButton");

        	fileUploadButton.addEventListener("click", function() {
        	  if (contents.style.display === "none" || contents.style.display === "") {
        	    contents.style.display = "block";
        	  } else {
        	    contents.style.display = "none";
        	  } 
        	});
        	
        	function redirectToURL(url) {
                window.location.href = url;
            }
    	</script>
<%@include file = "footer.jsp" %>