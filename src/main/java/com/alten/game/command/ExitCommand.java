package com.alten.game.command;

import com.alten.game.controller.GameController;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class ExitCommand implements Command {
    private final GameController gameController;

    @Override
    public void execute(List<String> parameters) {
        gameController.setEndGame(true);
        System.out.println("Thanks for playing");
    }
}
