package com.tbawor.agro.items.armor;

import com.tbawor.agro.items.AbstractItem;
import com.tbawor.agro.items.ItemType;

public abstract class Armor extends AbstractItem {

    private final int defence;

    public Armor(String name, int defence, ItemType itemType) {
        super(name, itemType);
        this.defence = defence;
        if (itemType == ItemType.WEAPON) {
            throw new InvalidArmorTypeException();
        }
    }

    public int getDefence() {
        return defence;
    }
}
