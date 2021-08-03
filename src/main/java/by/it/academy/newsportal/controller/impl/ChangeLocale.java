package by.it.academy.newsportal.controller.impl;

import java.io.IOException;

import by.it.academy.newsportal.controller.Command;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ChangeLocale implements Command {
	private static final String SESSION_LOCAL = "local";
	private static final String SESSION_PATH = "path";
	private static final String CONTROLLER_PATH = "Controller?command=";

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession(true).setAttribute(SESSION_LOCAL, request.getParameter(SESSION_LOCAL));
		String path = CONTROLLER_PATH + (String) request.getSession(true).getAttribute(SESSION_PATH);
//		request.getRequestDispatcher(path).forward(request, response);
		response.sendRedirect(path);

	}

}
