package by.it.academy.newsportal.controller.impl;

import java.io.IOException;

import by.it.academy.newsportal.controller.Command;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LogOut implements Command {

	private static final String MAIN_PAIGE = "/WEB-INF/jsp/main.jsp";
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession sessionUser = request.getSession();
		sessionUser.removeAttribute("user");
		RequestDispatcher requesDispatcher =request.getRequestDispatcher(MAIN_PAIGE);
		requesDispatcher.forward(request, response);
	}

}
