/*
 * LoadOrderListTag.java 2014/04/21
 *
 * Copyright (C) 2014 Florin.
 *
 */
package com.carrental.tags;

import com.carrental.commands.Command;
import com.carrental.dao.OrderDAO;
import com.carrental.daofactory.DAOFactory;
import com.carrental.entities.Order;
import java.util.List;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * Defines custom tag that loads order list from database to JSP.
 *
 * @author Florin
 * @see TagSupport
 */
public class LoadOrderListTag extends TagSupport {

    /**
     * Loads order list from database to JSP.
     *
     * @return SKIP_BODY
     * @throws JspException
     */
    @Override
    public int doStartTag() throws JspException {
        OrderDAO orderDAO = DAOFactory.getOrderDAO();
        List<Order> orders = orderDAO.findAll();
        pageContext.setAttribute(Command.REQ_PARAM_ORDER_LIST, orders);
        return SKIP_BODY;
    }

}
