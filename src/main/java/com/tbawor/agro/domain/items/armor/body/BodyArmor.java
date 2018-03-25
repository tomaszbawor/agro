package com.tbawor.agro.domain.items.armor.body;

import com.tbawor.agro.domain.items.ItemType;
import com.tbawor.agro.domain.items.armor.Armor;

public class BodyArmor extends Armor {

    public BodyArmor(String name, int defence) {
        super(name, defence, ItemType.BODY_ARMOR);
    }
}
