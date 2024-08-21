package controller;

import org.springframework.stereotype.Controller;

import dao.UsersDAO;

@Controller
public class PaymentController {
	UsersDAO userDAO;
	
	public PaymentController(UsersDAO userDAO) {
		this.userDAO = userDAO;
	}
}
