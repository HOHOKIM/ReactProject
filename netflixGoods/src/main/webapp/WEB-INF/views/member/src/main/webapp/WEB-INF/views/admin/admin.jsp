<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>관리자 페이지</title>
    <link rel="stylesheet" href="/netflixmall/resources/css/main_admin_table.css">
    <script src="/netflixmall/resources/js/httpRequest.js"></script>
    <script>
    </script>
</head>
<body>
<%@ include file="/WEB-INF/views/users/header.jsp" %> 

<!-- 사용자 테이블 -->
<section>
    <div class="item">
        <div class="item-caption">
            <div class="item-title">사용자 목록</div>
            <a href="users_detail_list.do?is_approved=2">자세히보기</a>
        </div>
        <table>
            <thead>
                <tr>
                    <th>이름</th>
                    <th>가입 날짜</th>
                    <th>판매 가능 여부</th>
                    <th>블락 처리 여부</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="vo" items="${list1}">
                    <tr>
                        <td> 
                        	<c:if test="${vo.is_deleted eq 1}">
								<font color="gray">${vo.username}(${vo.email})은 블락처리된 유저입니다</font>
							</c:if> 
							<c:if test="${vo.is_deleted eq 0}">
								${vo.username}(${vo.email})
							</c:if> 
                        </td>
                        <td>${vo.regdate}</td>
                        <td>${vo.is_approved}</td>
                        <td>${vo.is_deleted}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>

    <!-- 제품 테이블 -->
    <div class="item">
        <div class="item-caption">
            <div class="item-title">제품 목록</div>
            <a href="products_detail_list.do">자세히보기</a>
        </div>
        <table>
            <thead>
                <tr>
                    <th>제품명</th>
                    <th>제품 가격</th>
                    <th>제품 수량</th>
                    <th>카테고리</th>
                    <th>비고</th> 
                </tr>
            </thead>
            <tbody> 
                <c:forEach var="vo" items="${list2}">
                    <tr>
                        <td>${vo.name}</td>
                        <td>${vo.price}</td>
                        <td>${vo.stock}</td>
                        <td>${vo.category}</td>
                        <td><input class="block_btn" type="button" value="삭제" onclick="delete_products('${vo.p_idx}')"></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>

    <!-- 게시글 테이블 -->
    <div class="item">
        <div class="item-caption">
            <div class="item-title">게시글 목록</div>
            <a href="board_detail_list.do">자세히보기</a>
        </div>
        <table border="1" width="100%">
            <caption>::: 게시판 연습중 :::</caption>
            <thead>
                <tr>
                    <th>번호</th>
                    <th>제목</th>
                    <th>작성자</th>
                    <th>작성일</th>
                    <th>조회수</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="vo" items="${list}">
                    <tr>
                        <td>${vo.boardNo}</td>
                        <td>${vo.title}</td>
                        <td>${vo.writer}</td>
                        <td>${vo.regDate}</td>
                        <td>${vo.viewCount}</td>
                    </tr>
                </c:forEach>
            </tbody>
            
            <tfoot>
                <tr>
                    <td colspan="5" align="center">
                        <select id="search">
                            <option value="all">전체보기</option>
                            <option value="subject">제목</option>
                            <option value="name">이름</option>
                            <option value="content">내용</option>
                            <option value="name_subject_content">이름+제목+내용</option>                        
                        </select>
                        <input id="search_text">
                        <input class="block_btn" type="button" value="검색" onclick="search();">
                    </td>
                </tr>
                <tr>
                    <td colspan="5" align="center">
                        ${ pageMenu }
                    </td>
                </tr>
                <tr>
                    <td colspan="5" align="right">
                        <img src="/bbs/resources/img/btn_reg.gif" style="cursor:pointer"
                             onclick="location.href='board_write.do'">
                    </td>
                </tr>
            </tfoot>
        </table>
    </div>
    
    <!-- 주문 목록 보기 -->
    <div class="item">
        <div class="item-caption">
            <div class="item-title">주문 목록</div> 
            <a href="order_detail_list.do">자세히보기</a>
        </div>
        <table>
            <thead>
                <tr>
                    <th>주문번호</th>
                    <th>주문한 사람(idx로 대체)</th>
                    <th>총가격</th><!-- 추가해야됨 -->
                    <th>주문 상태</th><!-- 추가해야됨 -->
                    <th>주문날짜</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="vo" items="${list4}">
                    <tr>
                        <td>${vo.o_idx}</td>
                        <td>${vo.u_idx}</td>
                        <td>${vo.total}</td>
                        <td>${vo.status}</td>
                        <td>${vo.order_date}</td>
                        <td><input class="block_btn" type="button" value="삭제" onclick="delete_products('${vo.p_idx}')"></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</section>

</body>
</html>
