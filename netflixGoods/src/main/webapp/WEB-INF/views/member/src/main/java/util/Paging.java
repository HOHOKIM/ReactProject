	package util;
	
	public class Paging {
		
		public static String getPaging(String pageURL,int nowPage, int rowTotal,int blockList, int blockPage){
	
			int totalPage/*전체페이지수*/,
			startPage/*시작페이지번호*/,
			endPage;/*마지막페이지번호*/
	
			boolean  isPrevPage,isNextPage;
			StringBuffer sb; //모든 상황을 판단하여 HTML코드를 저장할 곳
	
	
			isPrevPage=isNextPage=false;
			//입력된 전체 자원을 통해 전체 페이지 수를 구한다..
			totalPage = (int)(rowTotal/blockList);
			if(rowTotal%blockList!=0)totalPage++;
	
	
			//만약 잘못된 연산과 움직임으로 인하여 현재 페이지 수가 전체 페이지 수를
			//넘을 경우 강제로 현재페이지 값을 전체 페이지 값으로 변경
			if(nowPage > totalPage)nowPage = totalPage;
	
	
			//시작 페이지와 마지막 페이지를 구함.
			startPage = (int)(((nowPage-1)/blockPage)*blockPage+1);
			endPage = startPage + blockPage - 1; //
	
			//마지막 페이지 수가 전체페이지수보다 크면 마지막페이지 값을 변경
			if(endPage > totalPage)endPage = totalPage;
	
			//마지막페이지가 전체페이지보다 작을 경우 다음 페이징이 적용할 수 있도록
			//boolean형 변수의 값을 설정
			if(endPage < totalPage) isNextPage = true;
			//시작페이지의 값이 1보다 작으면 이전페이징 적용할 수 있도록 값설정
			if(startPage > 1)isPrevPage = true;
	
			//HTML코드를 저장할 StringBuffer생성=>코드생성
			sb = new StringBuffer();
			//-----그룹페이지처리 이전 --------------------------------------------------------------------------------------------		
			if(isPrevPage){
				//<a href="#" onclick="comment_list222(2)";>2</a>"
				sb.append("<a href='#' onclick='comment_list(");			
				sb.append( startPage-1 );
				sb.append(");'>◀</a>");
			}
			else
				sb.append("◀");
	
			//------페이지 목록 출력 -------------------------------------------------------------------------------------------------
			// sb.append("|");
			for(int i=startPage; i<= endPage ;i++){
				if(i>totalPage)break;
				if(i == nowPage){ //현재 있는 페이지
					//색상변경은 font태그에서 ↓↓
					sb.append("&nbsp;<b><font color='blue'>");
					sb.append(i);
					sb.append("</font></b>");
				}
				else{//현재 페이지가 아니면
					sb.append("<a href='#' onclick='comment_list(");
					sb.append(i);
					//색상변경은 font태그에서 ↓↓
					sb.append(");'>&nbsp;<font color='black'>");
					sb.append(i);
					sb.append("</a></font>");
				}
			}// end for
	
			sb.append("&nbsp;");
	
			//-----그룹페이지처리 다음 ----------------------------------------------------------------------------------------------
			if(isNextPage){
				sb.append("<a href='#' onclick='comment_list(");
	
				sb.append(endPage + 1);
				sb.append(");'>▶</a>");
			}
			else
				sb.append("▶");
			//---------------------------------------------------------------------------------------------------------------------	    
	
			return sb.toString();
		}
	
		//getPaging의 오버로드 메서드
		public static String getPaging(String pageURL,int nowPage, int rowTotal, String search_param, int blockList, int blockPage){
	
			int totalPage/*전체페이지수*/,
			startPage/*시작페이지번호*/,
			endPage;/*마지막페이지번호*/
	
			boolean  isPrevPage,isNextPage;
			StringBuffer sb; //모든 상황을 판단하여 HTML코드를 저장할 곳
	
	
			isPrevPage=isNextPage=false;
			//입력된 전체 자원을 통해 전체 페이지 수를 구한다..
			totalPage = (int)(rowTotal/blockList);
			if(rowTotal%blockList!=0)totalPage++;
	
	
			//만약 잘못된 연산과 움직임으로 인하여 현재 페이지 수가 전체 페이지 수를
			//넘을 경우 강제로 현재페이지 값을 전체 페이지 값으로 변경
			if(nowPage > totalPage)nowPage = totalPage;
	
	
			//시작 페이지와 마지막 페이지를 구함.
			startPage = (int)(((nowPage-1)/blockPage)*blockPage+1);
			endPage = startPage + blockPage - 1; //
	
			//마지막 페이지 수가 전체페이지수보다 크면 마지막페이지 값을 변경
			if(endPage > totalPage)endPage = totalPage;
	
			//마지막페이지가 전체페이지보다 작을 경우 다음 페이징이 적용할 수 있도록
			//boolean형 변수의 값을 설정
			if(endPage < totalPage) isNextPage = true;
			//시작페이지의 값이 1보다 작으면 이전페이징 적용할 수 있도록 값설정
			if(startPage > 1)isPrevPage = true;
	
			//HTML코드를 저장할 StringBuffer생성=>코드생성
			sb = new StringBuffer();
			//-----그룹페이지처리 이전 --------------------------------------------------------------------------------------------		
			if(isPrevPage){
				sb.append("<a href ='"+pageURL+"?page=");
				//sb.append(nowPage - blockPage);
				sb.append( startPage-1 );
				sb.append("&"+search_param);
				sb.append("'><img src='/bbs/resources/img/btn_prev.gif'></a>");
			}
			else
				sb.append("<img src='/bbs/resources/img/btn_prev.gif'>");
	
			//------페이지 목록 출력 -------------------------------------------------------------------------------------------------
			// sb.append("|");
			for(int i=startPage; i<= endPage ;i++){
				if(i>totalPage)break;
				if(i == nowPage){ //현재 있는 페이지
					//색상변경은 font태그에서 ↓↓
					sb.append("&nbsp;<b><font color='blue'>");
					sb.append(i);
					sb.append("</font></b>");
				}
				else{//현재 페이지가 아니면
					sb.append("&nbsp;<a href='"+pageURL+"?page=");
					sb.append(i);
					sb.append("&"+search_param);
	
					//색상변경은 font태그에서 ↓↓
					sb.append("'><font color='black'>");
					sb.append(i);
					sb.append("</a></font>");
				}
			}// end for
	
			sb.append("&nbsp;");
	
			//-----그룹페이지처리 다음 ----------------------------------------------------------------------------------------------
			if(isNextPage){
				sb.append("<a href='"+pageURL+"?page=");
	
				sb.append(endPage + 1);
				sb.append("&"+search_param);
				
				sb.append("'><img src='/bbs/resources/img/btn_next.gif'></a>");
			}
			else
				sb.append("<img src='/bbs/resources/img/btn_next.gif'>");
			//---------------------------------------------------------------------------------------------------------------------	    
	
			return sb.toString();
		}
		
		
		//쇼핑몰에서 쓸 새로 만든 오버로드 메서드
		public static String getPaging(String pageURL, int nowPage, int rowTotal, int blockList, int blockPage, String searchParams) {
	        int totalPage, startPage, endPage;
	        boolean isPrevPage, isNextPage;
	        StringBuilder sb = new StringBuilder();

	        totalPage = (int) Math.ceil((double) rowTotal / blockList); 

	        if (nowPage > totalPage) {
	            nowPage = totalPage;
	        }

	        startPage = ((nowPage - 1) / blockPage) * blockPage + 1;
	        endPage = startPage + blockPage - 1;
	        if (endPage > totalPage) {
	            endPage = totalPage;
	        }

	        isPrevPage = startPage > 1;
	        isNextPage = endPage < totalPage;

	        // 이전 페이지 버튼
	        if (isPrevPage) {
	            sb.append("<a href='").append(pageURL).append("?page=").append(startPage - 1).append(searchParams).append("'>◀</a>");
	        } else {
	            sb.append("◀");
	        }

	        // 페이지 목록 출력
	        for (int i = startPage; i <= endPage; i++) {
	            if (i == nowPage) {
	                sb.append("<b>").append(i).append("</b>");
	            } else {
	                sb.append("<a href='").append(pageURL).append("?page=").append(i).append(searchParams).append("'>").append(i).append("</a>");
	            }
	        }

	        // 다음 페이지 버튼
	        if (isNextPage) {
	            sb.append("<a href='").append(pageURL).append("?page=").append(endPage + 1).append(searchParams).append("'>▶</a>");
	        } else {
	            sb.append("▶"); 
	        }

	        return sb.toString();
	    }
	    
	    
	}
