package by.it.academy.newsportal.listener;

import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener {

	public void sessionCreat(HttpSessionEvent session) {
		System.out.println("Session created " + session.getSession().getId());
	}

	public void sessionDelete(HttpSessionEvent session) {
		System.out.println("Session delete " + session.getSession().getId());

	}
}
