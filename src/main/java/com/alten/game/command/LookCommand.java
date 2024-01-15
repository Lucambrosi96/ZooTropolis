package com.alten.game.command;

import com.alten.game.controller.GameController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class LookCommand implements Command {

    private final GameController gameController;

    @Autowired
    public LookCommand(GameController gameController) {
        this.gameController = gameController;
    }

    @Override
    public void execute(List<String> parameters) {
        gameController.getCurrentRoom().getInformation();
    }
}