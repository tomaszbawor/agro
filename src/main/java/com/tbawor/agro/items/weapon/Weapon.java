package com.tbawor.agro.items.weapon;

import com.tbawor.agro.items.AbstractItem;
import com.tbawor.agro.items.ItemType;

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
