/*
 * IUserDAO.java 2014/03/30
 *
 * Copyright (C) 2014 Florin.
 *
 */
package com.carrental.dao;

import com.carrental.entities.User;
import java.util.List;

/**
 * An interface for User DAO
 *
 * @author Florin
 */
public interface UserDAO {

    public int insert(User user);

    public int update(User user);

    public int delete(User user);

    public List<User> findAll();

    public User findByLogin(String loginParam);

    public User findByID(int userIDParam);
}
