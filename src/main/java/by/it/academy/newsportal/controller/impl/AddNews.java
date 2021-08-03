package by.it.academy.newsportal.controller.impl;

import java.io.IOException;
import java.util.logging.Logger;

import by.it.academy.newsportal.bean.User;
import by.it.academy.newsportal.controller.Command;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class AddNews implements Command {
	private static Logger logger = Logger.getLogger(AddNews.class.getName());

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		if (session == null) {
			response.sendRedirect("Controller?command=AUTHORIZATION&message=Sesion is over. Relogin please.");
		}
		User user = (User) session.getAttribute("user");

		if (user == null) {
			response.sendRedirect("Controller?command=AUTHORIZATION&message=Relogin please.");

		}
		if (!"admin".equals(user.getRole())) {
			logger.info((String) session.getAttribute("user"));
			session.removeAttribute("user");

		}

	
	}

}
