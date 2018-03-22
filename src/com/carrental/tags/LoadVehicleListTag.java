/*
 * LoadVehicleListTag.java 2014/04/21
 *
 * Copyright (C) 2014 Florin.
 *
 */
package com.carrental.tags;

import com.carrental.commands.Command;
import com.carrental.dao.VehicleDAO;
import com.carrental.daofactory.DAOFactory;
import com.carrental.entities.Vehicle;
import java.util.List;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * Defines custom tag that loads vehicle list from database to JSP.
 *
 * @author Florin
 * @see TagSupport
 */
public class LoadVehicleListTag extends TagSupport {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * Loads vehicle list from database to JSP.
     *
     * @return SKIP_BODY
     * @throws JspException
     */
    @Override
    public int doStartTag() throws JspException {
        VehicleDAO vehicleDAO = DAOFactory.getVehicleDAO();
        List<Vehicle> vehicleList = vehicleDAO.findAll();
        pageContext.setAttribute(Command.REQ_PARAM_VEHICLE_LIST, vehicleList);
        return SKIP_BODY;
    }
}
