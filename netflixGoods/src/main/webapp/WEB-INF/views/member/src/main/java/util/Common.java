package util;

public class Common {

	public static class Users{
		public static final String VIEW_PATH = "/WEB-INF/views/users/";
	}
	
	public static class Admin{
		public static final String VIEW_PATH = "/WEB-INF/views/admin/";
	}
	
	public static class Comment{
		public static final String VIEW_PATH = "/WEB-INF/views/comment/";
		public final static int BLOCKLIST = 5;
		public final static int BLOCKPAGE = 3;
	}
	
	
	//페이징
	public static class Paging{
		
		public static final String VIEW_PATH = "/WEB-INF/views/admin/";
		
		//한 페이지당 보여줄 수
		public final static int BLOCKLIST = 3;

		//한 화면에 보여지는 페이지 메뉴의 수
		//<- 1 2 3 ->
		public final static int BLOCKPAGE = 5;
	}
	
	//게시판을 위한거 아마 뭐 1:1문의사항이나 이런거에 쓸듯
	public static class Board{
		
		public static final String VIEW_PATH = "/WEB-INF/views/board/";
		
		//한 페이지당 보여줄 게시글 수
		public final static int BLOCKLIST = 10;

		//한 화면에 보여지는 페이지 메뉴의 수
		//<- 1 2 3 ->
		public final static int BLOCKPAGE = 5;
	}

}
