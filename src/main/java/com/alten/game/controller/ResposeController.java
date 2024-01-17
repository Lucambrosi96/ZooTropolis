package com.alten.game.controller;

import com.alten.game.command.Command;
import com.alten.game.command.CommandFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Component
public class ResposeController {
    private final CommandFactory commandFactory;
    private Map<String, Command> commandMap;

    public void showAvailableCommands() {
        System.out.println("Available commands: \n-look \n-bag \n-go \n-get \n-drop \n-exit");
    }

    public void setCommandMap() {
        commandMap = commandFactory.createCommandMap();
    }

    public void manageResponse(String answer) {
        List<String> parameters = List.of(answer.trim().split("\\s+", 2));
        if (answer.trim().isEmpty()) {
            System.out.println("Use one of the commands");
            showAvailableCommands();
        } else {
            String commandKey = parameters.get(0);
            commandKey = commandKey + "Command";
            List<String> commandValues = parameters.subList(1, parameters.size());
            Command command = commandMap.get(commandKey);
            if (command == null) {
                System.out.println("Invalid command. Try again");
            } else {
                command.execute(commandValues);
            }
        }
    }
}
