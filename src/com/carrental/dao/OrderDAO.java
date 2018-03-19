/*
 * IOrderDAO.java 2014/03/30
 *
 * Copyright (C) 2014 Florin.
 *
 */
package com.carrental.dao;

import com.carrental.entities.Order;
import java.util.List;

/**
 * An interface for Order DAO
 *
 * @author Florin
 */
public interface OrderDAO {

    public int insert(Order order);

    public int update(Order order);

    public int delete(Order order);

    public List<Order> findAll();

    public Order findByID(int orderIDParam);
}
