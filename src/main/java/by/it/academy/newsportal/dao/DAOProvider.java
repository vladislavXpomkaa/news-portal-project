package by.it.academy.newsportal.dao;

import by.it.academy.newsportal.dao.impl.SQLNewsDAO;
import by.it.academy.newsportal.dao.impl.SQLUserDAO;

public class DAOProvider {
	private static final DAOProvider instance = new DAOProvider();
	private static SQLUserDAO sqlUser = new SQLUserDAO();
	private static SQLNewsDAO sqlNews = new SQLNewsDAO();

	private DAOProvider() {
	}

	public static DAOProvider getInstance() {
		return instance;
	}

	public SQLUserDAO getSqlUser() {
		return sqlUser;
	}

	public SQLNewsDAO getSqlNews() {
		return sqlNews;
	}

}
