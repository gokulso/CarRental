/*
 * SelectOrderCommand.java 2014/04/20
 *
 * Copyright (C) 2014 Florin.
 *
 */
package com.carrental.commands;

import com.carrental.util.CommandHelper;
import com.carrental.util.Lgr;
import com.carrental.config.ConfigManager;
import com.carrental.exceptions.SessionTimeoutException;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Class that represents command to select the specified order for further
 * processing.
 *
 * 
 */
public class SelectOrderCommand implements Command {

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res,
            HttpSession session) throws ServletException, IOException {
        Lgr.LOGGER.info("Command called: " + this.getClass().getSimpleName());
        String page;
        try {
            CommandHelper.validateSession(session);

            int orderID = Integer.valueOf(req.getParameter(REQ_PARAM_ORDER_CHOICE));
            req.setAttribute(REQ_PARAM_ORDER_ID, orderID);

            page = ConfigManager.getInstance()
                    .getProperty(ConfigManager.ADMIN_PAGE_PATH);
        } catch (SessionTimeoutException e) {
            req.setAttribute(SESS_PARAM_ERROR_MESSAGE, SESSION_TIMEOUT_ERROR_MESSAGE);
            page = ConfigManager.getInstance()
                    .getProperty(ConfigManager.ERROR_PAGE_PATH);
        } catch (NumberFormatException e) {
            Lgr.LOGGER.error(e);
            req.setAttribute(SESS_PARAM_ERROR_MESSAGE, UNKNOWN_ERROR_MESSAGE);
            page = ConfigManager.getInstance()
                    .getProperty(ConfigManager.ERROR_PAGE_PATH);
        }
        return page;
    }
}
