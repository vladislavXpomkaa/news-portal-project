package by.it.academy.newsportal.service;

import by.it.academy.newsportal.bean.News;

public interface NewsService {

	public void add(News news) throws ServiceException;

	public void update(News news) throws ServiceException;

	public void delete(News news) throws ServiceException;
}
