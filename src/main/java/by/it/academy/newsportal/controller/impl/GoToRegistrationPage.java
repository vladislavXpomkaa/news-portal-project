package by.it.academy.newsportal.controller.impl;

import java.io.IOException;

import by.it.academy.newsportal.controller.Command;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class GoToRegistrationPage implements Command {
	
	private static final String SESSION_PATH = "path";
	private static final String SESSION_PATH_COMMAND = "REGISTRATION";
	private static final String REGISTRATION_PAIGE = "/WEB-INF/jsp/registration.jsp";
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession(true).setAttribute(SESSION_PATH, SESSION_PATH_COMMAND);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(REGISTRATION_PAIGE);
		requestDispatcher.forward(request, response);
	}

}
