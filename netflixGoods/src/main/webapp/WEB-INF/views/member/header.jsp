<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/netflixmall/resources/css/reset.css">
<link rel="stylesheet" href="/netflixmall/resources/css/header.css">
<!-- jQuery CDN 참조 -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<script>
//Document Ready Event : $(document).ready() 함수는 DOM이 완전히 로드되고 파싱된 후에 코드를 실행
$(document).ready(function() {
	//마지막 스크롤 위치를 저장
    let lastScrollLocation = 0;
    //$(window).scroll() 함수는 사용자가 페이지를 스크롤할 때마다 실행
    $(window).scroll(function(event) {
    	//현재 스크롤 위치를 저장, this -> 이벤트객체 여기서는 window
    	//$(this).scrollTop();는 현재 스크롤 위치(수직)를 픽셀 단위로 반환
        let nowScrollLocation = $(this).scrollTop();
        if (nowScrollLocation > lastScrollLocation && nowScrollLocation > 70) {
        	// Scroll Down
            $("#head").fadeOut();
        } else if (nowScrollLocation < lastScrollLocation && nowScrollLocation > 70) {
            // Scroll Up
            $("#head").fadeIn();
        }
        //마지막 스크롤 위치를 현재 스크롤 위치로 업데이트
        lastScrollLocation = nowScrollLocation;
    });
});
</script>

</head>

<body>
	<header id="head">
		<div class="flex-container">
			<div class="flex-item" onclick="location.href='main.do'">
				<img class="logo" alt="logo"
					src="/netflixmall/resources/image/netflixLogo.png">
			</div>
			<div class="flex-item">
				<a href="shop_page.do">상품</a> <a href="insert_page.do">상품등록</a> <a href="#">Q & A??</a>
			</div>
			<div class="flex-item">
				<input type="button" value="로그인" id="loginBtn"
					onclick="location.href='login_form.do'">
					<input type="button" value="관리자" id="loginBtn2"
					onclick="location.href='admin.do'"> 
			</div>
			

		</div>
	</header>
</body>
</html>
