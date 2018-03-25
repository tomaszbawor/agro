package com.tbawor.agro.domain.items.armor.head;

import com.tbawor.agro.domain.items.ItemType;
import com.tbawor.agro.domain.items.armor.Armor;

public class HeadArmor extends Armor {

    public HeadArmor(String name, int defence) {
        super(name, defence, ItemType.HEAD_ARMOR);
    }

}
