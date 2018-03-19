/*
 * CommandFactory.java 2014/04/10
 *
 * Copyright (C) 2014 Florin.
 *
 */
package com.carrental.util;

import com.carrental.commands.AdminZoneButtonCommand;
import com.carrental.commands.CalculateCostCommand;
import com.carrental.commands.ConfirmOrderCommand;
import com.carrental.commands.ConfirmPaymentCommand;
import com.carrental.commands.CreateOrderCommand;
import com.carrental.commands.GiveVehicleCommand;
import com.carrental.commands.HomeButtonCommand;
import com.carrental.commands.Command;
import com.carrental.commands.LoadOrderListCommand;
import com.carrental.commands.LogInCommand;
import com.carrental.commands.LogOutCommand;
import com.carrental.commands.MakeOrderButtonCommand;
import com.carrental.commands.NoCommand;
import com.carrental.commands.RegisterCommand;
import com.carrental.commands.RejectOrderCommand;
import com.carrental.commands.ResetOrderCommand;
import com.carrental.commands.ReturnDamagedVehicleCommand;
import com.carrental.commands.ReturnVehicleCommand;
import com.carrental.commands.SelectOrderCommand;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;

/**
 * Class is a factory method that produces an instance of the proper command
 *
 * @author Florin
 */
public class CommandFactory {

    private static CommandFactory instance;
    HashMap<String, Command> commands = new HashMap<>();

    private CommandFactory() {
        //filling the map with available commands
        commands.put("login", new LogInCommand());
        commands.put("logout", new LogOutCommand());
        commands.put("homeButton", new HomeButtonCommand());
        commands.put("registration", new RegisterCommand());

        commands.put("makeOrderButton", new MakeOrderButtonCommand());
        commands.put("adminZoneButton", new AdminZoneButtonCommand());

        commands.put("calculateCost", new CalculateCostCommand());
        commands.put("createOrder", new CreateOrderCommand());

        commands.put("loadOrderList", new LoadOrderListCommand());
        commands.put("selectOrder", new SelectOrderCommand());

        commands.put("confirmOrder", new ConfirmOrderCommand());
        commands.put("rejectOrder", new RejectOrderCommand());
        commands.put("giveVehicle", new GiveVehicleCommand());
        commands.put("returnVehicle", new ReturnVehicleCommand());
        commands.put("returnDamagedVehicle", new ReturnDamagedVehicleCommand());
        commands.put("confirmPayment", new ConfirmPaymentCommand());
        commands.put("resetOrder", new ResetOrderCommand());
    }

    public static synchronized CommandFactory getInstance() {
        if (instance == null) {
            instance = new CommandFactory();
        }
        return instance;
    }

    public Command getCommand(HttpServletRequest req) {
        String action = req.getParameter("command");
        Command command = commands.get(action);
        if (command == null) {
            command = new NoCommand();
        }
        return command;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }
}
