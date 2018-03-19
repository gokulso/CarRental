/*
 * IVehicleDAO.java 2014/03/30
 *
 * Copyright (C) 2014 Florin.
 *
 */
package com.carrental.dao;

import com.carrental.entities.Vehicle;
import java.math.BigDecimal;
import java.util.List;

/**
 * An interface for Vehicle DAO
 *
 * @author Florin
 */
public interface VehicleDAO {

    public int insert(Vehicle vehicle);

    public int update(Vehicle vehicle);

    public int delete(Vehicle vehicle);

    public List<Vehicle> findAll();

    public Vehicle findByID(int vehicleIDParam);

    public BigDecimal findDailyPriceByVehicleID(int vehicleID);
}
