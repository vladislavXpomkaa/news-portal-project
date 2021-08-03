package by.it.academy.newsportal.dao;

import by.it.academy.newsportal.bean.RegistrationInfo;
import by.it.academy.newsportal.bean.User;

public interface DAOUser {
	void registration(RegistrationInfo info) throws DAOException;
	User authorization(String login, String password) throws DAOException;
}
