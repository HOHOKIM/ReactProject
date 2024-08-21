package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import dao.AdminDAO;
import dao.BoardDAO;
import dao.OrderDAO;
import dao.ProductsDAO;
import dao.UsersDAO;
import util.Common;
import util.Paging;
import vo.BoardVO;
import vo.OrderVO;
import vo.ProductsVO;
import vo.UsersVO; 

@Controller
public class AdminController {

	AdminDAO adminDAO;
	UsersDAO user_dao;
	ProductsDAO products_dao;
	BoardDAO board_dao;
	OrderDAO order_dao;

	public AdminController(AdminDAO adminDAO, UsersDAO user_dao, 
			ProductsDAO products_dao, BoardDAO board_dao,
			OrderDAO order_dao) { 
		this.adminDAO = adminDAO;  
		this.user_dao = user_dao;
		this.products_dao = products_dao;
		this.board_dao = board_dao;
		this.order_dao = order_dao;
	}

	//메인페이지 테이블 넣기  
	@RequestMapping("/admin.do")  
	public String adminPage(Model model1 , Model model2, Model model3, Model model4) {
		List<UsersVO> list = adminDAO.selectList();
		List<ProductsVO> list2 = products_dao.selectList();
		List<BoardVO> list3 = board_dao.selectSmallList();
		List<OrderVO> list4 = order_dao.selectList();
		model1.addAttribute("list1", list); // 사용자 전체보기 
		model2.addAttribute("list2", list2); // 제품 전체보기
		model3.addAttribute("list3", list3); // 게시글 전체보기
		model4.addAttribute("list4", list4); // 주문 게시글 보기
		return Common.Admin.VIEW_PATH + "admin.jsp";
	}

	//사용자 블락 처리 
	@RequestMapping("/user_delete.do") 
	@ResponseBody 
	public String user_block(int u_idx) { 
		int res = adminDAO.user_block(u_idx);
		String resultStr = "";
		String result = "fail";

		if(res > 0) {
			result = "success"; 
			resultStr = String.format("[{'result':'%s'}]", result);
			return resultStr;
		}
		return result;   
	} 

	//사용자 전체 보기
	@RequestMapping("/users_detail_list.do")
	public String users_detail_list(Model model, Integer is_approved, 
			String search_user, String page) {
		System.out.println("is_approved: " + is_approved);


		//start, end변수를 Map에 저장
		Map<String, Object> map = new HashMap<String, Object>(); 

		List<UsersVO> list = null;

		// 검색어가 존재하면 검색 기능 실행
		if (search_user != null && !search_user.trim().isEmpty()) {
			map.put("email", search_user);
			list = adminDAO.selecDetailtList(map);  

		} else if (is_approved != null) { 

			// is_approved가 null이 아닐 경우 처리 
			// 전체보기
			if (is_approved == 2) { 
				map.put("is_approved", is_approved);
				list = adminDAO.selecDetailtList();
				model.addAttribute("list", list);

			// 사용자, 판매자 구분하기
			} else if (is_approved == 1 || is_approved == 0) { 
				map.put("is_approved", is_approved);
				list = adminDAO.user_status(is_approved);
				model.addAttribute("list", list);
			}  
		} else {
			//추가해야됨
		} 

		//list객체 바인딩 및 포워딩
		model.addAttribute("list", list); 

		return Common.Admin.VIEW_PATH + "users_detail_list.jsp";
	}

	// 사용자 구분 
	@RequestMapping("/user_status.do")
	@ResponseBody
	public String user_status(@RequestParam int is_approved) {
		List<UsersVO> res = adminDAO.user_status(is_approved);

		String resultStr = "";  
		String result = "fail"; 
		int isApprovedValue = 0;

		if (!res.isEmpty()) {
			result = "success"; 
			UsersVO is_approved2 = res.get(is_approved);  
			isApprovedValue = is_approved2.getIs_approved();
		}else {
			result = "success";
			isApprovedValue = 2; 
		}

		resultStr = String.format("[{'result':'%s'},{'is_approved2':'%s'}]", result, isApprovedValue);

		return resultStr;
	}


	//사용자 검색 
	//수정필요
	@RequestMapping("/search_users.do")
	@ResponseBody
	public String search_users(Model model, String search_user ) {
		List<UsersVO> res = adminDAO.search_user(search_user);

		String resultStr = "";  
		String result = "fail";  
		int is_approved = 0;
		
		if (!res.isEmpty()) {
			result = "success"; 
			UsersVO user = res.get(0);
	        is_approved = user.getIs_approved();
		}

		resultStr = String.format("[{'result':'%s'},{'result2':'%s'},{'result3':'%s'}]", result, search_user, is_approved);

		return resultStr; 
	}


}