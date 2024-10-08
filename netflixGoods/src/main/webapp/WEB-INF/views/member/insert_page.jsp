<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 등록</title>
<link rel="stylesheet" href="/netflixmall/resources/css/reset.css">
<link rel="stylesheet" href="/netflixmall/resources/css/Shop_insert.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="/netflixmall/resources/js/uploadImage.js"></script>
</head>
<body>
	<%@ include file="/WEB-INF/views/member/header.jsp"%>

	<div id="wrapper" >
		<form action="insert.do" method="post" enctype="multipart/form-data">
			<label>제품 이름</label> 
			<input type="text" name="name" required /> 
			<label>설명</label>
			<textarea name="description" required></textarea>
			<label>가격</label> <input type="number" name="price" required /> 
			<label>재고수량</label> <input type="number" name="stock" required /> 
			<label>카테고리</label>
			<input type="text" name="category" required /> 
			<label>상품 이미지</label>
			<input type="file" name="photo">
			<button type="submit">상품 등록</button>
		</form>
	</div>

	<script>
		document.getElementById('fileItem').addEventListener(
				'change',
				function(event) {
					var file = event.target.files[0];
					var reader = new FileReader();
					reader.onload = function() {
						var imgElement = document.createElement('img');
						imgElement.src = reader.result;
						var imagePreview = document
								.getElementById('imagePreview');
						imagePreview.innerHTML = '';
						imagePreview.appendChild(imgElement);
					};
					reader.readAsDataURL(file);
				});
	</script>
</body>
</html>
