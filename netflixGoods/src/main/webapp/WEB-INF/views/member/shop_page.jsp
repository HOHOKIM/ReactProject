<%@page import="java.util.List"%>
<%@page import="dao.ProductDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>netflix GoodsShop</title>
<link rel="stylesheet" href="/netflixmall/resources/css/Shop_Goods.css">
<link rel="stylesheet" href="/netflixmall/resources/css/reset.css">
<script>
function del(p_idx) {
	if(!confirm("정말 삭제하시겠습니까?")){
		return;
	}
	location.href="delete.do?p_idx="+p_idx;
}



</script>
</head>
<body>
	<%@ include file="/WEB-INF/views/member/header.jsp"%>


	<div id="wrapper">
		<div id="text">넷플릭스 비공식 굿즈 샾</div>

		<div class="GoodsContainer">
			<c:forEach var="product" items="${list}">
				<div class="GoodsBox">

					<div class="ExplainBox">
						<c:if test="${ product.filename ne 'no_file' }">
							<img src="/netflixmall/resources/upload/${product.filename}">
						</c:if>
						<p>이름: ${product.name}</p>
						<p>설명: ${product.description}</p>
						<p>가격: ${product.price}</p>
						<p>재고수량: ${product.stock}</p>
						<p>카테고리: ${product.category}</p>
					</div>
				
				
					<div class="buttonContainer">
						<input type="button"value="수정" class="btn" onclick="location.href='modify_form.do?p_idx=${product.p_idx}'">
						<input type="button"value="삭제" class="btn" onclick="del(${product.p_idx});">	
					</div>
				
				
				</div>
			</c:forEach>
		</div>

	</div>
</body>
</html>





