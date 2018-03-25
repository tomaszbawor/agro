package com.tbawor.agro.domain.items.armor.shoes;

import com.tbawor.agro.domain.items.ItemType;
import com.tbawor.agro.domain.items.armor.Armor;

public class Shoes extends Armor {

    public Shoes(String name, int defence) {
        super(name, defence, ItemType.SHOES);
    }

}
