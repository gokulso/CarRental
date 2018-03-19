/*
 * IPassportDAO.java 2014/03/30
 *
 * Copyright (C) 2014 Florin.
 *
 */
package com.carrental.dao;

import com.carrental.entities.Passport;
import java.util.List;

/**
 * An interface for Passport DAO
 *
 * @author Florin
 */
public interface PassportDAO {

    public int insert(Passport passport);

    public int update(Passport passport);

    public int delete(Passport passport);

    public List<Passport> findAll();

    public Passport findByID(int passportIDParam);
}
