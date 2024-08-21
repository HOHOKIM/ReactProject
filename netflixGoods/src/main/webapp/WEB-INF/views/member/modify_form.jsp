<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 수정</title>
<link rel="stylesheet" href="/netflixmall/resources/css/reset.css">
<link rel="stylesheet" href="/netflixmall/resources/css/Shop_insert.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="/netflixmall/resources/js/uploadImage.js"></script>
</head>
<body>
<%@ include file="/WEB-INF/views/member/header.jsp"%>

<div id="wrapper">
    <form action="update.do" method="post" enctype="multipart/form-data">
       
        <input type="hidden" name="p_idx" value="${vo.p_idx}"> 
        
        <label>제품 이름</label> 
        <input type="text" name="name" value="${vo.name}" required /> 
        
        <label>설명</label>
        <textarea name="description" required>${vo.description}</textarea>
        
        <label>가격</label> 
        <input type="number" name="price" value="${vo.price}" required /> 
        
        <label>재고수량</label> 
        <input type="number" name="stock" value="${vo.stock}" required /> 
        
        <label>카테고리</label>
        <input type="text" name="category" value="${vo.category}" required /> 
        
     
        <button type="submit">수정</button>
    </form>
</div>
</body>
</html>
