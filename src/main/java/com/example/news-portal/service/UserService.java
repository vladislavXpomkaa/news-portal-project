package com.example.news-portal.service;

import com.example.news-portal.bean.RegistrationInfo;
import com.example.news-portal.bean.User;
import com.example.news-portal.service.exception.ServiceException;

import java.util.Optional;

public interface UserService {
    Optional<User> registration(RegistrationInfo info) throws ServiceException;
    Optional<User> authorization(RegistrationInfo info) throws ServiceException;
    void personalUpdate(User user, String firstName, String lastName, String email, String age) throws ServiceException;
}
