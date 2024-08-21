package controller;

import org.springframework.stereotype.Controller;

import dao.UsersDAO;

@Controller
public class OrderController {
	UsersDAO userDAO;
	
	public OrderController(UsersDAO userDAO) {
		this.userDAO = userDAO;
	}
}
