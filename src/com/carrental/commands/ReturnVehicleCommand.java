/*
 * ReturnVehicleCommand.java 2014/04/05
 *
 * Copyright (C) 2014 Florin.
 *
 */
package com.carrental.commands;

import com.carrental.util.CommandHelper;
import com.carrental.util.Lgr;
import com.carrental.config.ConfigManager;
import com.carrental.dao.OrderDAO;
import com.carrental.daoImpl.DAOHelper;
import com.carrental.daofactory.DAOFactory;
import com.carrental.entities.Order;
import com.carrental.exceptions.SessionTimeoutException;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Class that represents command to set returned field of "orders" table to
 * true.
 *
 * @author Florin
 */
public class ReturnVehicleCommand implements Command {

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res,
            HttpSession session) throws ServletException, IOException {
        Lgr.LOGGER.info("Command called: " + this.getClass().getSimpleName());
        String page;
        try {
            CommandHelper.validateSession(session);

            OrderDAO orderDAO = DAOFactory.getOrderDAO();
            Order order = orderDAO.findByID(Integer.valueOf(req.
                    getParameter(REQ_PARAM_ORDER_ID)));
            order.setReturned(true);
            int updateOrderCode = orderDAO.update(order);
            if (updateOrderCode == DAOHelper.EXECUTE_UPDATE_ERROR_CODE) {
                throw new IllegalArgumentException("Order entry in DB was not updated");
            }

            page = ConfigManager.getInstance()
                    .getProperty(ConfigManager.ADMIN_PAGE_PATH);
        } catch (SessionTimeoutException e) {
            req.setAttribute(SESS_PARAM_ERROR_MESSAGE, SESSION_TIMEOUT_ERROR_MESSAGE);
            page = ConfigManager.getInstance()
                    .getProperty(ConfigManager.ERROR_PAGE_PATH);
        } catch (IllegalArgumentException e) {
            Lgr.LOGGER.error("Error while updating order " + e);
            req.setAttribute(SESS_PARAM_ERROR_MESSAGE, ORDER_NOT_UPDATED_ERROR_MESSAGE);
            page = ConfigManager.getInstance()
                    .getProperty(ConfigManager.ERROR_PAGE_PATH);
        }
        return page;
    }
}
