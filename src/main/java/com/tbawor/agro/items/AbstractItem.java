package com.tbawor.agro.items;

public abstract class AbstractItem {

    private final String name;
    private final ItemType itemType;

    public AbstractItem(String name, ItemType itemType) {
        this.name = name;
        this.itemType = itemType;
    }

    public String getName() {
        return name;
    }

    public ItemType getItemType() {
        return itemType;
    }

}
