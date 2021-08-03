package by.it.academy.newsportal.dao.impl;

import by.it.academy.newsportal.bean.RegistrationInfo;
import by.it.academy.newsportal.bean.User;
import by.it.academy.newsportal.dao.DAOException;
import by.it.academy.newsportal.dao.DAOUser;

public class SQLUserDAO implements DAOUser {

	@Override
	public void registration(RegistrationInfo info) throws DAOException {

		System.out.println(info.toString());
	}

	@Override
	public User authorization(String login, String password) throws DAOException {
		
		return new User("user","admin");
	}

	
}
