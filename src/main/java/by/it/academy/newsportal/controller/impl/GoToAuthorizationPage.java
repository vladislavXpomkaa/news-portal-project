package by.it.academy.newsportal.controller.impl;

import java.io.IOException;

import by.it.academy.newsportal.controller.Command;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class GoToAuthorizationPage implements Command{
	private static final String SESSION_PATH = "path";
	private static final String SESSION_PATH_COMMAND = "AUTHORIZATION";
	private static final String AUTHORIZATION_PAIGE = "/WEB-INF/jsp/authorization.jsp";
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession(true).setAttribute(SESSION_PATH, SESSION_PATH_COMMAND);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(AUTHORIZATION_PAIGE);
		requestDispatcher.forward(request, response);
	}

}
