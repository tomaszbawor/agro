package com.tbawor.agro.domain.items.armor;

import com.tbawor.agro.domain.items.ItemType;
import org.junit.Test;

public class ArmorTest {

    @Test(expected = InvalidArmorTypeException.class)
    public void shouldThrowInvalidItemTypeWhenCreatingArmorWithWeaponType() {
        // given
        final String armorName = "Werid armor";
        final int defence = 10;

        // when
        new Armor(armorName, defence, ItemType.WEAPON) {
        };
    }

}