package com.tbawor.agro.domain.items.weapon;

import com.tbawor.agro.domain.items.AbstractItem;
import com.tbawor.agro.domain.items.ItemType;

public class Weapon extends AbstractItem {

    private final WeaponType weaponType;

    public Weapon(String name, WeaponType weaponType) {
        super(name, ItemType.WEAPON);
        this.weaponType = weaponType;
    }

    public WeaponType getWeaponType() {
        return weaponType;
    }
}
