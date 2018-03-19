/*
 * CreateOrderCommand.java 2014/04/05
 *
 * Copyright (C) 2014 Florin.
 *
 */
package com.carrental.commands;

import com.carrental.util.CommandHelper;
import com.carrental.util.Lgr;
import com.carrental.config.ConfigManager;
import com.carrental.daoImpl.DAOHelper;
import com.carrental.daofactory.DAOFactory;
import com.carrental.entities.Order;
import com.carrental.entities.Passport;
import com.carrental.entities.User;
import com.carrental.entities.Vehicle;
import com.carrental.exceptions.SessionTimeoutException;
import com.carrental.dao.OrderDAO;
import com.carrental.dao.PassportDAO;
import com.carrental.dao.UserDAO;
import com.carrental.dao.VehicleDAO;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Class that represents command to add information about new order to database.
 *
 * @author Florin
 */
public class CreateOrderCommand implements Command {

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res,
            HttpSession session) throws ServletException, IOException {
        Lgr.LOGGER.info("Command called: " + this.getClass().getSimpleName());
        String page;
        try {
            CommandHelper.validateSession(session);

            //get DAOs
            PassportDAO passportDAO = DAOFactory.getPassportDAO();
            OrderDAO orderDAO = DAOFactory.getOrderDAO();
            VehicleDAO vehicleDAO = DAOFactory.getVehicleDAO();
            UserDAO userDAO = DAOFactory.getUserDAO();

            //create and insert new pasport
            Passport passport = new Passport();
            passport.setLastName(req.getParameter(REQ_PARAM_LAST_NAME));
            passport.setFirstName(req.getParameter(REQ_PARAM_FIRST_NAME));
            passport.setPatronymic(req.getParameter(REQ_PARAM_PATRONYMIC));
            passport.setBirthday(Date.valueOf(req.getParameter(REQ_PARAM_BIRTHDAY)));
            passport.setpSeries(req.getParameter(REQ_PARAM_P_SERIES));
            passport.setpNumber(req.getParameter(REQ_PARAM_P_NUMBER));
            passport.setWhoIssued(req.getParameter(REQ_PARAM_WHO_ISSUED));
            passport.setWhenIssued(Date.valueOf(req.getParameter(REQ_PARAM_WHEN_ISSUED)));
            int passportID = passportDAO.insert(passport);
            if (passportID == DAOHelper.EXECUTE_UPDATE_ERROR_CODE) {
                throw new IllegalArgumentException("Passport entry in DB was not created");
            } else {
                passport.setPassportID(passportID);
            }

            //create and insert new order
            Order order = new Order();
            int vehicleID = Integer.valueOf(req.getParameter(REQ_PARAM_VEHICLE_ID));
            Vehicle vehicle = vehicleDAO.findByID(vehicleID);
            order.setVehicle(vehicle);
            int userID = (Integer) session.getAttribute(SESS_PARAM_USER_ID);
            User user = userDAO.findByID(userID);
            order.setUser(user);
            order.setPassport(passport);
            order.setPickUpDate(Timestamp.valueOf(CalculateCostCommand
                    .convertDateFormat(req
                            .getParameter(CalculateCostCommand.REQ_PARAM_PICK_UP_DATE))));
            order.setDropOffDate(Timestamp.valueOf(CalculateCostCommand
                    .convertDateFormat(req
                            .getParameter(CalculateCostCommand.REQ_PARAM_DROP_OFF_DATE))));
            order.setRentCost(BigDecimal.valueOf((Double.valueOf(req.
                    getParameter(CalculateCostCommand.REQ_PARAM_RENT_COST)))));
            int insertOrderCode = orderDAO.insert(order);
            if (insertOrderCode == DAOHelper.EXECUTE_UPDATE_ERROR_CODE) {
                throw new IllegalArgumentException("Order entry in DB was not created");
            }

            page = ConfigManager.getInstance()
                    .getProperty(ConfigManager.INFO_ORDER_PAGE_PATH);
        } catch (SessionTimeoutException e) {
            Lgr.LOGGER.error("session timed out: " + e);
            req.setAttribute(SESS_PARAM_ERROR_MESSAGE, SESSION_TIMEOUT_ERROR_MESSAGE);
            page = ConfigManager.getInstance()
                    .getProperty(ConfigManager.ERROR_PAGE_PATH);
        } catch (IllegalArgumentException e) {
            Lgr.LOGGER.error("Error while creating order " + e);
            req.setAttribute(SESS_PARAM_ERROR_MESSAGE, ORDER_NOT_CREATED_ERROR_MESSAGE);
            page = ConfigManager.getInstance()
                    .getProperty(ConfigManager.ERROR_PAGE_PATH);
        }
        return page;
    }
}
