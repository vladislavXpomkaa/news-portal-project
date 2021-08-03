package by.it.academy.newsportal.controller.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import by.it.academy.newsportal.bean.News;
import by.it.academy.newsportal.controller.Command;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class GoToMainPage implements Command {
	private static final String SESSION_PATH = "path";
	private static final String SESSION_PATH_COMMAND = "GO_TO_MAIN_PAIGE";
	private static final String MAIN_PAIGE = "/WEB-INF/jsp/main.jsp";
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<News> newses = new ArrayList<>();
		newses.add(new News("news1", "a1 a1 a1 a1","zzzzz",new Date()));
		newses.add(new News("news2", "b1 b1 b1 b1","xxxxx", new Date()));
		request.setAttribute("newses", newses);
		
		request.getSession(true).setAttribute(SESSION_PATH, SESSION_PATH_COMMAND);
		RequestDispatcher requesDispatcher = request.getRequestDispatcher(MAIN_PAIGE);
		requesDispatcher.forward(request, response);
	}

}
