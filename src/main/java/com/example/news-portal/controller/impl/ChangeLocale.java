package com.example.news-portal.controller.impl;

import com.example.news-portal.controller.Command;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class ChangeLocale implements Command {
    private static final String LOCAL = "local";
    private static final String REFERER = "referer";

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().setAttribute(LOCAL, req.getParameter(LOCAL));
        resp.sendRedirect(req.getHeader(REFERER));
    }
}