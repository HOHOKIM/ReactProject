<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>로그인, 회원가입</title>
		<link rel="stylesheet" href="/netflixmall/resources/css/reset.css">
		<link rel="stylesheet" href="/netflixmall/resources/css/login_form.css">
		<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	
		<script>
		$(document).ready(function() {
		    $(".picked").click(function() {
		        // 모든 span 요소의 border-bottom을 초기화
		        $(".picked").css("border-bottom", "2px solid gray");
		        
		        // 클릭된 span 요소의 border-bottom을 굵은 빨간색으로 변경
		        $(this).css("border-bottom", "5px solid red");
		    });
		});
		</script>
	</head>
	
	<body>
		<%@ include file="/WEB-INF/views/users/header.jsp"%>
		<div id="wrapper">
			<div id="text">Welcome to the Netflix Goods Mall</div>
			
			<div id="pick">
				<span class="picked">Log In</span>
				<span class="picked">Sign Up</span>
			</div>
			
			<div id="login_container">
				<input name="id" type="text" placeholder="id를 입력하세요"> <input
					name="pwd" type="password" placeholder="password를 입력하세요">
			</div>
		</div>
	
	</body>
</html>