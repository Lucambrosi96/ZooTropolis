package com.alten.game.command;

import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class CommandFactory {
    private final ListableBeanFactory beanFactory;

    public CommandFactory(ListableBeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    @Bean
    public Map<String, Command> createCommandMap() {
        return Arrays.stream(beanFactory.getBeanNamesForType(Command.class))
                .collect(Collectors.toMap(Function.identity(),
                        name -> beanFactory.getBean(name, Command.class)));
    }

}
