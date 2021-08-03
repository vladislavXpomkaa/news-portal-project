package by.it.academy.newsportal.controller.impl;

import java.io.IOException;

import by.it.academy.newsportal.controller.Command;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UnknownCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/error.jsp");
		requestDispatcher.forward(request, response);
	}

}
