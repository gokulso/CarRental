/*
 * CommandHelper.java 
 *
 * 
 *
 */
package com.carrental.util;

import static com.carrental.commands.Command.SESS_PARAM_USER_NAME;
import com.carrental.exceptions.SessionTimeoutException;
import javax.servlet.http.HttpSession;

/**
 * Class contains auxiliary methods for commands package
 *
 * @author Florin
 */
public class CommandHelper {

    /**
     * Method checks if session is still valid, or it has expired.
     *
     * @param session
     * @throws SessionTimeoutException
     */
    public static void validateSession(HttpSession session) throws SessionTimeoutException {
        try {
            Lgr.LOGGER.info("Validate session called. Session id: " + session.getId());
            session.setAttribute(SESS_PARAM_USER_NAME,
                    session.getAttribute(SESS_PARAM_USER_NAME));
        } catch (NullPointerException e) {
            Lgr.LOGGER.warn("Session expired");
            throw new SessionTimeoutException(e);
        }
    }
}
