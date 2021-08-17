package com.example.news-portal.dao.impl;

import com.example.news-portal.bean.News;
import com.example.news-portal.dao.ConnectionPool;
import com.example.news-portal.dao.exception.DAOException;
import com.example.news-portal.dao.NewsDAO;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class NewsDAOImpl implements NewsDAO {

    private static final String QUERY_FOR_ADD = "INSERT INTO news (title, content, date) VALUES (?, ?, current_timestamp)";
    private static final String QUERY_FOR_READ_ALL_LAST = "SELECT * FROM news ORDER BY id DESC LIMIT 10";
//    private static final String QUERY_FOR_READ_ALL_LAST = "SELECT * FROM users INNER JOIN news ORDER BY news.id DESC LIMIT 10";
    private static final String QUERY_FOR_FIND_BY_TITLE = "SELECT * FROM news WHERE title = ?";
    private static final String QUERY_FOR_DELETE = "DELETE FROM news WHERE title = ?";

    private static final String LOG_ON_ADD = "error on add News";
    private static final String LOG_ON_DELETE = "error on delete by title";
    private static final String LOG_ON_READ_ALL_LAST = "error on read news";
    private static final String LOG_ON_FIND_BY_TITLE = "error on find news";
    private static final String TITLE_PARAM = "title";
    private static final String CONTENT_PARAM = "content";
    private static final String DATE_PARAM = "date";

    @Override
    public void add(String title, String content) throws DAOException {
        try (Connection connection = ConnectionPool.getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement(QUERY_FOR_ADD)) {

                statement.setString(1, title);
                statement.setString(2, content);
                statement.execute();
            }
        } catch (SQLException e) {
            log.error(LOG_ON_ADD, e);
            throw new DAOException(e);
        }
    }

    @Override
    // До конца не реализован, т.к. ещё не используется
    public void delete(String title) throws DAOException {
        try (Connection connection = ConnectionPool.getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement(QUERY_FOR_DELETE)) {

                statement.setString(1, title);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            log.error(LOG_ON_DELETE, e);
            throw new DAOException(e);
        }
    }

    @Override
    public List<News> readAllLast() throws DAOException {
        List<News> newsList = new ArrayList<>();

        try (Connection connection = ConnectionPool.getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement(QUERY_FOR_READ_ALL_LAST)) {

                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        newsList.add(new News(
                                resultSet.getString(TITLE_PARAM),
                                resultSet.getString(CONTENT_PARAM),
                                resultSet.getDate(DATE_PARAM)
                        ));
                    }
                }
            }
        } catch (SQLException e) {
            log.error(LOG_ON_READ_ALL_LAST, e);
            throw new DAOException(e);
        }

        return newsList;
    }

    @Override
    public boolean findByTitle(String title) throws DAOException {
        boolean searchResult = false;

        try (Connection connection = ConnectionPool.getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement(QUERY_FOR_FIND_BY_TITLE)) {

                statement.setString(1, title);
                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next() ) {
                        if (title.equals(resultSet.getString(TITLE_PARAM))) {
                            searchResult = true;
                        }
                    }
                }
            }
        } catch (SQLException e) {
            log.error(LOG_ON_FIND_BY_TITLE, e);
            throw new DAOException(e);
        }

        return searchResult;
    }
}
