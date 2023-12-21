package com.alten.game.controller;

import java.util.List;

public interface Command {
    void execute(List<String> parameters);
}
