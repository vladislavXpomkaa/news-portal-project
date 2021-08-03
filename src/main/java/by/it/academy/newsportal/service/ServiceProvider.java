package by.it.academy.newsportal.service;

import by.it.academy.newsportal.service.impl.NewsServiceImpl;
import by.it.academy.newsportal.service.impl.UserServiceImpl;

public class ServiceProvider {

	private static final ServiceProvider instance = new ServiceProvider();

	private final UserService userService = new UserServiceImpl();
	private final NewsService newService = new NewsServiceImpl();

	public ServiceProvider() {
	}

	public static ServiceProvider getInstance() {
		return instance;
	}

	public UserService getUserService() {
		return userService;
	}

	public NewsService getNewService() {
		return newService;
	}

}
