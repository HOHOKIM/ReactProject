package controller;


import org.springframework.stereotype.Controller;

import dao.AdminDAO;
import dao.UsersDAO;

@Controller
public class ProductsController {
	
	AdminDAO adminDAO;
	UsersDAO user_dao;
	
	public ProductsController(AdminDAO adminDAO, UsersDAO user_dao) {
		this.adminDAO = adminDAO;
		this.user_dao = user_dao;
	}
	
	
}
