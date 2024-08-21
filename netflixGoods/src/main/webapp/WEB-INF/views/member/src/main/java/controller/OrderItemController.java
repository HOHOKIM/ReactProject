package controller;

import org.springframework.stereotype.Controller;

import dao.UsersDAO;


@Controller
public class OrderItemController {
	UsersDAO userDAO;
	
	public OrderItemController(UsersDAO userDAO) {
		this.userDAO = userDAO;
	}
}
