package com.example.news-portal.service;

import com.example.news-portal.bean.News;
import com.example.news-portal.service.exception.ServiceException;

import java.util.List;

public interface NewsService {
    boolean addNews(String title, String content) throws ServiceException;
    void deleteNews(String title) throws ServiceException;
    List<News> newsList() throws ServiceException;
}
