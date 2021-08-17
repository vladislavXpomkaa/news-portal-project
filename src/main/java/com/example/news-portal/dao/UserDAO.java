package com.example.news-portal.dao;

import com.example.news-portal.bean.RegistrationInfo;
import com.example.news-portal.bean.User;
import com.example.news-portal.dao.exception.DAOException;

import java.util.Optional;

public interface UserDAO {
    Optional<User> get(RegistrationInfo info) throws DAOException;
    void add(RegistrationInfo info) throws DAOException;
    void update(User user, String firstName, String lastName, String email, String age) throws DAOException;
}
