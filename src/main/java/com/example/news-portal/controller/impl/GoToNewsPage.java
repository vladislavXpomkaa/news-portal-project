package com.example.news-portal.controller.impl;

import com.example.news-portal.controller.Command;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class GoToNewsPage implements Command {
    private static final String ADD_NEWS_PAGE = "/WEB-INF/view/addNews.jsp";

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(ADD_NEWS_PAGE).forward(req, resp);
    }
}
