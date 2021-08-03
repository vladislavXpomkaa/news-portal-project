package by.it.academy.newsportal.listener;

import jakarta.servlet.ServletRequestEvent;
import jakarta.servlet.ServletRequestListener;
import jakarta.servlet.http.HttpServletRequest;

public class ProjectRequestListener implements ServletRequestListener {

	public ProjectRequestListener() {

	}

	public void requestDestroyed(ServletRequestEvent arg0) {
		HttpServletRequest request = (HttpServletRequest) arg0.getServletRequest();
		System.out.println("Request from " + request.getContextPath() + " was destroyed.");
	}

	public void requesInitialization(ServletRequestEvent arg0) {

		HttpServletRequest request = (HttpServletRequest) arg0.getServletContext();
		System.out.println("Reqest from " + request.getContextPath() + "was initialization.");
	}
}
