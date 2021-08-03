package by.it.academy.newsportal.dao;

import by.it.academy.newsportal.bean.News;

public interface DAONews {
	public void add(News news) throws DAOException;
	public void update(News news) throws DAOException;
	public void delete(News news) throws DAOException;
}
