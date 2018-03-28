package com.carrental.commands;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.carrental.config.ConfigManager;
import com.carrental.exceptions.SessionTimeoutException;
import com.carrental.util.CommandHelper;
import com.carrental.util.Lgr;


public class OrderHistoryCommand implements Command {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res, HttpSession session)
			throws ServletException, IOException {
		Lgr.LOGGER.info("Command called: " + this.getClass().getSimpleName());
		String page;
		try {
			CommandHelper.validateSession(session);
			page = ConfigManager.getInstance().getProperty(ConfigManager.ORDER_HISTORY_PATH);

		} catch (SessionTimeoutException e) {
			Lgr.LOGGER.error("session timed out: " + e);
			req.setAttribute(SESS_PARAM_ERROR_MESSAGE, SESSION_TIMEOUT_ERROR_MESSAGE);
			page = ConfigManager.getInstance().getProperty(ConfigManager.ERROR_PAGE_PATH);
		}
		return page;

	}

}
