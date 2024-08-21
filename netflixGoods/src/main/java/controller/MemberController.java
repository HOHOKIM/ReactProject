package controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import dao.MemberDAO;
import util.Common;
import vo.MemberVO;

@Controller
public class MemberController {

	MemberDAO memberDAO;
	
	public MemberController(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}
	
	@RequestMapping(value = {"/", "main.do"})
	public String mainPage() {
		return Common.Member.VIEW_PATH + "main_page.jsp";
	}
	
	@RequestMapping(value = "login_form.do")
	public String login_form() {
		return Common.Member.VIEW_PATH + "login_form.jsp";
	}
	@RequestMapping(value = "shop.do")
	public String shop_Page() {
		return Common.Member.VIEW_PATH+"shop_page.jsp";
	}
	@RequestMapping(value = "insert_page.do")
	public String insert_Page() {
		return Common.Member.VIEW_PATH+"insert_page.jsp";
	}

}
