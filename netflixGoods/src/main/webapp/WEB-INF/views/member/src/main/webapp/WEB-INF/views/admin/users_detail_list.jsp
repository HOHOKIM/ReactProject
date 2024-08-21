<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>사용자 상세보기</title>
		<link rel="stylesheet" href="/netflixmall/resources/css/main_admin_table.css">
		<script src="/netflixmall/resources/js/httpRequest.js"></script>
		 <script>
		 
		 window.onload = function(){
				let select_user = document.getElementById("select_user");
				let user_array = [ 1, 2, 0 ];
				
				//for( let i = 0; i < user_array.length; i++ ){
					//     0 - 사용자
					//     1 - 판매자
					//     2 - 전체
					if( '${param.is_approved}' == user_array[2] ){//0
						select_user[1].selected = true;
					}
					
					if( '${param.is_approved}' == user_array[0] ){//1
						select_user[2].selected = true;
					}
					
					if( '${param.is_approved}' == user_array[1] ){//2
						select_user[0].selected = true;
					}
					
					
				//}
			}
		 
	        // 사용자 삭제
	        function user_block(u_idx){
	            if(!confirm("정말 블락처리 하시겠습니까?")){
	                return;
	            }
	            
	            let url = "user_delete.do";
	            let param = "u_idx=" + u_idx;
	            
	            sendRequest(url, param, deleteUsetFn, "post");
	        }
	        
	        // 사용자 삭제 콜백함수
		        function deleteUsetFn(){
		            if(xhr.readyState == 4 && xhr.status == 200){
	                let data = xhr.responseText;
	                let json = (new Function('return '+ data))();
	                
	                if(json[0].result == 'success'){
	                    alert("블락처리 성공했습니다.");
	                    location.href = "users_detail_list.do";
	                }else{
	                    alert("블락처리 실패")
	                }
	                    
	            }
	        }
	        
	        //사용자, 판매자 따로 보여주기
	        function select_user_status(){
	        	let user_status = document.getElementById("select_user").value;
	        	
	        	let url = "user_status.do"
	        	let param = "";

	            if (user_status === "all") {
	                param = "is_approved=2";
	            } else if (user_status === "user") {
	                param = "is_approved=0";
	            } else if (user_status === "seller") {
	                param = "is_approved=1";
	            }
	        	sendRequest(url, param, select_user , "get");
	        }
	        
	        //사용자 구분 콜백함수
	        function select_user(){
	        	if(xhr.readyState == 4 && xhr.status == 200) {
	        		let data = xhr.responseText;
	        		let json = (new Function('return ' +  data))();
	        		if(json[0].result == 'success'){
	        		    let is_approved = json[1].is_approved2;
	        		    location.href = "users_detail_list.do?is_approved=" + is_approved;
	        		} else {
	        		    alert("왜 실패지?");
	        		}
	       		}
	        } 
	        
	        //유저검색
	        function search_users(){
	        	let search_user = 
					document.getElementById("search_user").value;
	        	
	        	if( search_user == '' ){
					alert("입력해주세요");
					return;
				}
	        	
	        	let url = "search_users.do"
	        	let param = "search_user=" + encodeURIComponent(search_user);
	        	
	        	sendRequest(url, param, search_user_callBack, "get");
	        }
	        
	        //유저검색 콜백
	        function search_user_callBack(){
	        	if(xhr.readyState == 4 && xhr.status == 200) {
	        		let data = xhr.responseText;
	        		let json = (new Function('return ' + data))();
	        		if(json[0].result == "success"){
	        			let email = json[1].result2;
	        			let is_approved = json[2].result3;
	        			location.href = "users_detail_list.do?is_approved="+ is_approved +"&search_user=" + email;
	        		}else if(json[0].result = "fail"){
	        			alert("이메일을 다시 입력하세요");
	        			return;
	        		}
	        	}
	        }
	    </script>
	</head>
	<body>
	<%@ include file="/WEB-INF/views/users/header.jsp" %>
	<div class="select" style={background:white}>
		<select id="select_user" onchange="select_user_status()">
			<option value="all">전체보기</option>
			<option value="user">사용자</option>
			<option value="seller">판매자</option>
		</select>
		<input placeholder="이메일을 입력하세여" id="search_user">
		<button onclick="search_users()">검색</button>
		<table id="user_detail_table">
            <thead>
                <tr>
                    <th>이름</th>
                    <th>가입 날짜</th>
                    <th>판매 가능 여부</th>
                    <th>블락 처리 여부</th>
                    <th>비고</th>
                </tr>
            </thead> 
            <tbody>
                <c:forEach var="vo" items="${list}">
	            	<tr class="${vo.is_deleted == 1 ? 'blocked-user' : ''}"> 
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
	                    <td><input class="block_btn" type="button" value="블랙" onclick="user_block('${vo.u_idx}')"></td>
	            	</tr>
	            	
	            	
                </c:forEach>
                
                <!-- <tr>
				<td colspan="5" align="center">
					${ pageMenu }
				</td>
				</tr>-->
            </tbody>
        </table>
        </div>
	</body>
</html>