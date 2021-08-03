package by.it.academy.newsportal.service;

import by.it.academy.newsportal.bean.RegistrationInfo;
import by.it.academy.newsportal.bean.User;

public interface UserService {
	void registration(RegistrationInfo info) throws ServiceException;
	User authorization(String login, String password) throws ServiceException;
}
