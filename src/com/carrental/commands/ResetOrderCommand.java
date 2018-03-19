/*
 * ResetOrderCommand.java 2014/04/22
 *
 * Copyright (C) 2014 Florin.
 *
 */
package com.carrental.commands;

import static com.carrental.commands.Command.REQ_PARAM_ORDER_ID;
import static com.carrental.commands.Command.SESS_PARAM_ERROR_MESSAGE;
import com.carrental.config.ConfigManager;
import com.carrental.dao.OrderDAO;
import com.carrental.daoImpl.DAOHelper;
import com.carrental.daofactory.DAOFactory;
import com.carrental.entities.Order;
import com.carrental.exceptions.SessionTimeoutException;
import com.carrental.util.CommandHelper;
import com.carrental.util.Lgr;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Class that represents command to reset order entity to the state before
 * manager's processing.
 *
 * @author Florin
 */
public class ResetOrderCommand implements Command {

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
            order.setProcessed(false);
            order.setRejected(false);
            order.setRejectDesc(null);
            order.setPicked(false);
            order.setReturned(false);
            order.setDamaged(false);
            order.setDamageDesc(null);
            order.setDamageCost(null);
            order.setPaid(false);
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
