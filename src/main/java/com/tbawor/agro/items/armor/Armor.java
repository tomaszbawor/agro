package com.tbawor.agro.items.armor;

import com.tbawor.agro.items.AbstractItem;
import com.tbawor.agro.items.ItemType;

public abstract class Armor extends AbstractItem {

    public Armor(String name, ItemType itemType) {
        super(name, itemType);
        if(itemType == ItemType.WEAPON) throw new InvalidArmorTypeException();
    }
}
