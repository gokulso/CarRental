/*
 * IUserTypeDAO.java 2014/03/30
 *
 * Copyright (C) 2014 Florin.
 *
 */
package com.carrental.dao;

import com.carrental.entities.UserType;
import java.util.List;

/**
 * An interface for UserType DAO
 *
 * @author Florin
 */
public interface UserTypeDAO {

    public int insert(UserType userType);

    public int update(UserType userType);

    public int delete(UserType userType);

    public List<UserType> findAll();
}
