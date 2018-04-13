package com.carrental.tags;

import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import com.carrental.commands.Command;
import com.carrental.dao.OrderDAO;
import com.carrental.daofactory.DAOFactory;
import com.carrental.entities.Order;


public class LoadOrderHistory extends TagSupport {
	   /**
		 * 
		 */
		private static final long serialVersionUID = 1L;

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
