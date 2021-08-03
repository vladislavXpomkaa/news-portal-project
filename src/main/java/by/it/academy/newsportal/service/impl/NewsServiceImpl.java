package by.it.academy.newsportal.service.impl;

import by.it.academy.newsportal.bean.News;
import by.it.academy.newsportal.dao.DAOException;
import by.it.academy.newsportal.dao.DAOProvider;
import by.it.academy.newsportal.dao.impl.SQLNewsDAO;
import by.it.academy.newsportal.service.NewsService;
import by.it.academy.newsportal.service.ServiceException;

public class NewsServiceImpl implements NewsService {

	private static final DAOProvider provider = DAOProvider.getInstance();
	private final SQLNewsDAO newsDAO = provider.getSqlNews();

	@Override
	public void add(News news) throws ServiceException {
		validate(news);
		try {
			newsDAO.add(news);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	@Override
	public void update(News news) throws ServiceException {
		validate(news);
		try {
			newsDAO.update(news);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e);
		}

	}

	@Override
	public void delete(News news) throws ServiceException {

		validate(news);
		try {
			newsDAO.delete(news);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	private void validate(News news) throws ServiceException {
		if (news.getTitle() == null || news.getTitle().isEmpty()) {
			throw new ServiceException("Title is empty");
		}
		if (news.getBrief() == null || news.getBrief().isEmpty()) {
			throw new ServiceException("Brief is empty");
		}
	}
}
