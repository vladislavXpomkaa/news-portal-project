package by.it.academy.newsportal.controller.impl;

import java.io.IOException;

import by.it.academy.newsportal.bean.RegistrationInfo;
import by.it.academy.newsportal.controller.Command;
import by.it.academy.newsportal.service.ServiceException;
import by.it.academy.newsportal.service.ServiceProvider;
import by.it.academy.newsportal.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class RegistrationNewUser implements Command {
	private static final ServiceProvider provider = ServiceProvider.getInstance();
	private static final UserService userService = provider.getUserService();

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RegistrationInfo info = new RegistrationInfo(request);
		try {
			userService.registration(info);
			response.sendRedirect(
					"Controller?command=AUTHORIZATION&message=Registration complite.Please enter login and password");

		} catch (ServiceException e) {
			e.printStackTrace();
		}

	}

}
