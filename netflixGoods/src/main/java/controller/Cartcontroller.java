package controller;

import org.springframework.stereotype.Controller;

import dao.UsersDAO;

@Controller
public class Cartcontroller {
	UsersDAO userDAO;
	
	public Cartcontroller(UsersDAO userDAO) {
		this.userDAO = userDAO;
	}
}
