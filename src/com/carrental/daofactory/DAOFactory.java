/*
 * DAOFactory.java 2014/03/31
 *
 * Copyright (C) 2014 Florin.
 *
 */
package com.carrental.daofactory;

import com.carrental.dao.*;
import com.carrental.daoImpl.*;

/**
 * Factory class for creating DAOs
 *
 * @author Florin
 */
public class DAOFactory {

    public static UserTypeDAO getUserTypeDAO() {
        return new UserTypeDAOImpl();
    }

    public static UserDAO getUserDAO() {
        return new UserDAOImpl();
    }

    public static VehicleDAO getVehicleDAO() {
        return new VehicleDAOImpl();
    }

    public static LicenceDAO getLicenceDAO() {
        return new LicenceDAOImpl();
    }

    public static OrderDAO getOrderDAO() {
        return new OrderDAOImpl();
    }
}
