/*
 * RegisterCommand.java 2019/03/19
 *
 *
 */
package com.carrental.commands;

import com.carrental.util.Lgr;
import com.carrental.config.ConfigManager;
import com.carrental.dao.UserDAO;
import com.carrental.daoImpl.DAOHelper;
import com.carrental.daofactory.DAOFactory;
import com.carrental.entities.User;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Class that represents command to register new user.
 *
 * @author Florin
 */
public class RegisterCommand implements Command {

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res,
            HttpSession session) throws ServletException, IOException {
        Lgr.LOGGER.info("Command called: " + this.getClass().getSimpleName());

        String login = req.getParameter(REQ_PARAM_LOGIN);
        String password = req.getParameter(REQ_PARAM_PASSWORD);
        String passwordConfirm = req.getParameter(REQ_PARAM_PASSWORD_CONFIRM);

        String page;
        try {
            if (password.equals(passwordConfirm)) {
                UserDAO userDAO = DAOFactory.getUserDAO();
                if (userDAO.findByLogin(login) == null) {
                    User user = new User();
                    user.setUserTypeID(LogInCommand.ACC_TYPE_CLIENT);
                    user.setLogin(login);
                    user.setPassword(password);
                    int insertUserCode = userDAO.insert(user);
                    if (insertUserCode == DAOHelper.EXECUTE_UPDATE_ERROR_CODE) {
                        throw new IllegalArgumentException("Registration failed. Entry was not created");
                    }
                    Lgr.LOGGER.info(user + " registered successfully");
                    page = ConfigManager.getInstance()
                            .getProperty(ConfigManager.INFO_REG_PAGE_PATH);
                } else {
                    throw new SecurityException("User with such login already exists");
                }
            } else {
                throw new IllegalStateException("Not equal confirmation password");
            }
        } catch (IllegalArgumentException e) {
            Lgr.LOGGER.error("Registration entry creation error " + e);
            req.setAttribute(SESS_PARAM_ERROR_MESSAGE, ORDER_NOT_UPDATED_ERROR_MESSAGE);
            page = ConfigManager.getInstance()
                    .getProperty(ConfigManager.ERROR_PAGE_PATH);
        } catch (IllegalStateException e) {
            Lgr.LOGGER.error("Password confirmation failed " + e);
            req.setAttribute(SESS_PARAM_ERROR_MESSAGE, PASSWORD_CONFIRMATION_ERROR_MESSAGE);
            page = ConfigManager.getInstance()
                    .getProperty(ConfigManager.ERROR_PAGE_PATH);
        } catch (SecurityException e) {
            Lgr.LOGGER.error("User with such login already exists " + e);
            req.setAttribute(SESS_PARAM_ERROR_MESSAGE, USER_EXISTS_ERROR_MESSAGE);
            page = ConfigManager.getInstance()
                    .getProperty(ConfigManager.ERROR_PAGE_PATH);
        }
        return page;
    }

}
