package by.it.academy.newsportal.controller.impl;

import java.io.IOException;

import by.it.academy.newsportal.bean.User;
import by.it.academy.newsportal.controller.Command;
import by.it.academy.newsportal.service.ServiceException;
import by.it.academy.newsportal.service.ServiceProvider;
import by.it.academy.newsportal.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class SignIn implements Command {
	private static final ServiceProvider provider = ServiceProvider.getInstance();
	private static final UserService userService = provider.getUserService();

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// validate login and password
		try {
			User user = userService.authorization(request.getParameter("login"),request.getParameter("password"));
			System.out.println(request.getParameter("login") + request.getParameter("password"));
			HttpSession session = request.getSession(true);
			session.setAttribute("user", user);

			response.sendRedirect("Controller?command=GO_TO_MAIN_PAIGE");
		} catch (ServiceException e) {

			e.printStackTrace();
		}

	}

}
