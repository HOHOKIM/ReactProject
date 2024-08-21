package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.UsersDAO;
import util.Common;

@Controller
public class UserController {
	
	UsersDAO userDAO;
	
	public UserController(UsersDAO userDAO) {
		this.userDAO = userDAO;
	}
	
//	@RequestMapping(value = {"/", "main.do"})
//	public String mainPage() {
//		return Common.Member.VIEW_PATH + "main_page.jsp";
//	}
//	
////	@RequestMapping(value = "login_form.do")
////	public String login_form() {
////		return Common.Member.VIEW_PATH + "login_form.jsp";
////	}
}
	