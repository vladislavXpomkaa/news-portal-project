package by.it.academy.newsportal.service.impl;

import by.it.academy.newsportal.bean.RegistrationInfo;
import by.it.academy.newsportal.bean.User;
import by.it.academy.newsportal.dao.DAOException;
import by.it.academy.newsportal.dao.DAOProvider;
import by.it.academy.newsportal.dao.impl.SQLUserDAO;
import by.it.academy.newsportal.service.ServiceException;
import by.it.academy.newsportal.service.UserService;

public class UserServiceImpl implements UserService {
	private static final DAOProvider provider = DAOProvider.getInstance();
	private final SQLUserDAO userDAO = provider.getSqlUser();

	@Override
	public void registration(RegistrationInfo info) throws ServiceException {
		
		try {
			validate(info);
			userDAO.registration(info);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	@Override
	public User authorization(String login, String password) throws ServiceException {
		if (login == null || login.isEmpty()) {
			throw new ServiceException("Incorrec Login");
		}
		try {
			return userDAO.authorization(login, password);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e);
		}

	}

	public void validate(RegistrationInfo info) throws ServiceException {
		if (info.getLogin() == null || info.getLogin().isEmpty()) {
			throw new ServiceException("Login shouldn`t be empty");
		}
		
		if (info.getAge() < 0 & info.getAge() > 99) {
			throw new ServiceException("Enter correct age!!!");
		}
		
		if(info.getSurname() == null || info.getSurname().isEmpty()) {
			throw new ServiceException("Surname shouldn`t be empty");
		}
		
		if(info.getEmail() == null || info.getEmail().isEmpty()) {
			throw new ServiceException("email shouldn`t be empty");
		}
		
		if(info.getRole() == null || info.getRole().isEmpty()) {
			throw new ServiceException("Role shouldn`t be empty");
		}
		
		if(info.getPassword() == null ||info.getPassword().isEmpty()) {
			throw new ServiceException("Password shouldn`t be empty");
		}
	}
}
