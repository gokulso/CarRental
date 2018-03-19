/*
 * NoCommand.java 2014/04/10
 *
 * Copyright (C) 2014 Florin.
 *
 */
package com.carrental.commands;

import com.carrental.config.ConfigManager;
import com.carrental.util.Lgr;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Class that represents a command with no parameter that forwards user to index
 * page.
 *
 * @author Florin
 */
public class NoCommand implements Command {

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res,
            HttpSession session) throws ServletException, IOException {
        Lgr.LOGGER.info("Command called: " + this.getClass().getSimpleName());
        String page = ConfigManager.getInstance()
                .getProperty(ConfigManager.INDEX_PAGE_PATH);
        return page;
    }
}
