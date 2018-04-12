/*
 * IPassportDAO.java 2014/03/30
 *
 * Copyright (C) 2014 Florin.
 *
 */
package com.carrental.dao;

import com.carrental.entities.Licence;
import java.util.List;

/**
 * An interface for Passport DAO
 *
 * @author Florin
 */
public interface LicenceDAO {

    public int insert(Licence passport);

    public int update(Licence passport);

    public int delete(Licence passport);

    public List<Licence> findAll();

    public Licence findByID(int licenceIDParam);
}
