package com.alten.game.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class CommandFactory {

    @Autowired
    private ApplicationContext applicationContext;


    @Bean
    public Map<String, Command> createCommandMap() {
        Map<String, Command> commandMap = new HashMap<>();

        LookCommand lookCommand = applicationContext.getBean(LookCommand.class);
        BagCommand bagCommand = applicationContext.getBean(BagCommand.class);
        GoCommand goCommand = applicationContext.getBean(GoCommand.class);
        GetCommand getCommand = applicationContext.getBean(GetCommand.class);
        DropCommand dropCommand = applicationContext.getBean(DropCommand.class);

        commandMap.put("look", lookCommand);
        commandMap.put("bag", bagCommand);
        commandMap.put("go", goCommand);
        commandMap.put("get", getCommand);
        commandMap.put("drop", dropCommand);

        return commandMap;
    }
}
