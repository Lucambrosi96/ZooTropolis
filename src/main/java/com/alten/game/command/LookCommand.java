package com.alten.game.command;

import com.alten.game.controller.GameController;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Component
public class LookCommand implements Command {

    private final GameController gameController;

    @Override
    public void execute(List<String> parameters) {
        gameController.getCurrentRoom().getInformation();
    }
}