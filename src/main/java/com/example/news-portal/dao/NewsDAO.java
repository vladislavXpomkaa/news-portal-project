package com.example.news-portal.dao;

import com.example.news-portal.bean.News;
import com.example.news-portal.dao.exception.DAOException;

import java.util.List;

public interface NewsDAO {
    void add(String title, String content) throws DAOException;
    void delete(String title) throws DAOException;
    List<News> readAllLast() throws DAOException;
    boolean findByTitle(String title) throws DAOException;
}
