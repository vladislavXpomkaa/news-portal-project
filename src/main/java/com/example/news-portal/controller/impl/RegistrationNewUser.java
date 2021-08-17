package com.example.news-portal.controller.impl;

import com.example.news-portal.bean.RegistrationInfo;
import com.example.news-portal.bean.User;
import com.example.news-portal.controller.Command;
import com.example.news-portal.service.exception.ServiceException;
import com.example.news-portal.service.ServiceProvider;
import com.example.news-portal.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.Optional;

@Slf4j
public class RegistrationNewUser implements Command {
    private static final ServiceProvider PROVIDER = ServiceProvider.getInstance();
    private static final UserService USER_SERVICE = PROVIDER.getUSER_SERVICE();

    private static final String USER_SESSION = "user";
    private static final String MAIN_PAGE_COMMAND = "controller?command=MAIN_PAGE";
    private static final String MESSAGE_ERROR_PARAM = "message";
    private static final String REGISTRATION_PAGE = "/WEB-INF/view/registration.jsp";
    private static final String LOG_ERROR = "unknown command";
    private static final String UNKNOWN_COMMAND = "controller?command=UNKNOWN_COMMAND";

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RegistrationInfo info = new RegistrationInfo(req);

        try {
            Optional<User> userOptional = USER_SERVICE.registration(info);

            if (!userOptional.isPresent()) {
                HttpSession session = req.getSession(true);
                session.setAttribute(USER_SESSION, new User(info.getLogin(), info.getDate()));
                resp.sendRedirect(MAIN_PAGE_COMMAND);
            } else {
                req.setAttribute(MESSAGE_ERROR_PARAM, MESSAGE_ERROR_PARAM);
                req.getRequestDispatcher(REGISTRATION_PAGE).forward(req, resp);
            }
        } catch (ServiceException e) {
            log.error(LOG_ERROR, e);
            e.printStackTrace();
            resp.sendRedirect(UNKNOWN_COMMAND);
        }
    }
}
