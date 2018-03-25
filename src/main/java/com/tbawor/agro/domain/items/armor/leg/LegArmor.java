package com.tbawor.agro.domain.items.armor.leg;

import com.tbawor.agro.domain.items.ItemType;
import com.tbawor.agro.domain.items.armor.Armor;

public class LegArmor extends Armor {

    public LegArmor(String name, int defence) {
        super(name, defence, ItemType.LEG_ARMOR);
    }
}
