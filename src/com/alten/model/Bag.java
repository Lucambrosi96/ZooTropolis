package com.alten.model;

import java.util.ArrayList;
import java.util.List;

public class Bag {
    private List<Item> itemList;
    private final int slots;

    public Bag() {
        this.itemList = new ArrayList<>();
        this.slots = 10;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    public int getSlots() {
        return slots;
    }
}
