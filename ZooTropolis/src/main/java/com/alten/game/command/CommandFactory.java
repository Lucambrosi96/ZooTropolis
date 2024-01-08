package com.alten.game.command;

import java.util.HashMap;
import java.util.Map;

public class CommandFactory {

    private static CommandFactory instance;

    public static CommandFactory getInstance() {
        if (instance == null) {
            instance = new CommandFactory();
        }
        return instance;
    }

    public Map<String, Command> createCommandMap() {
        Map<String, Command> commandMap = new HashMap<>();

        LookCommand lookCommand = new LookCommand();
        BagCommand bagCommand = new BagCommand();
        GoCommand goCommand = new GoCommand();
        GetCommand getCommand = new GetCommand();
        DropCommand dropCommand = new DropCommand();

        commandMap.put("look", lookCommand);
        commandMap.put("bag", bagCommand);
        commandMap.put("go", goCommand);
        commandMap.put("get", getCommand);
        commandMap.put("drop", dropCommand);

        return commandMap;
    }
}
