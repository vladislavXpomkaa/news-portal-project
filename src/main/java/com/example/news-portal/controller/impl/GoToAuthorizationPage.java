package com.example.news-portal.controller.impl;

import com.example.news-portal.controller.Command;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class GoToAuthorizationPage implements Command {
    private static final String AUTHORIZATION_PAGE = "/WEB-INF/view/authorization.jsp";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher(AUTHORIZATION_PAGE).forward(request, response);
    }
}
