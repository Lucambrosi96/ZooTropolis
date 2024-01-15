package com.alten;

import com.alten.game.controller.GameController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ZooTropolisApplication implements CommandLineRunner {

    @Autowired
    private GameController gameController;

    public static void main(String[] args) {
        SpringApplication.run(ZooTropolisApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        gameController.populateGame();
        gameController.runGame();
    }
}