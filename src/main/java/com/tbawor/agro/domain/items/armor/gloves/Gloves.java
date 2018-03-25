package com.tbawor.agro.domain.items.armor.gloves;

import com.tbawor.agro.domain.items.ItemType;
import com.tbawor.agro.domain.items.armor.Armor;

public class Gloves extends Armor {

    public Gloves(String name, int defence) {
        super(name, defence, ItemType.GLOVES);
    }
}
