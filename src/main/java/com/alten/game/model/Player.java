package com.alten.game.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Player {
    @Setter
    @Getter
    private String name;
    @Setter
    private int lifePoints;
    private Bag bag;

    @Autowired
    public Player(@Value("${player.defaultName}") String name, @Value("${player.defaultLifePoints}") int lifePoints, Bag bag) {
        this.name = name;
        this.lifePoints = lifePoints;
        this.bag = bag;
    }

    public boolean addItemToBag(Item item) {
        return bag.addItem(item);
    }

    public void removeItemFromBag(Item item) {
        bag.removeItem(item);
    }

    public List<Item> getItemsFromBag() {
        return bag.getItems();
    }

    public boolean isBagEmpty(){
        return bag.isEmpty();
    }

    public int freeSlotsInBag() {
        return bag.freeSlots();
    }

    public Item getItemByName(String itemName) {
        return bag.getItemByName(itemName);
    }
}