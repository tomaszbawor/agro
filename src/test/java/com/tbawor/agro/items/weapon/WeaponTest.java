package com.tbawor.agro.items.weapon;

import com.tbawor.agro.items.ItemType;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WeaponTest {

    @Test
    public void shouldHaveProperlyInitializedName() {
        // given
        final String weaponName = "Ultimate sword";

        // when
        final Weapon sword = new Weapon(weaponName, WeaponType.SWORD);

        // then
        assertThat(sword.getName()).isEqualTo(weaponName);
    }

    @Test
    public void shouldHaveItemTypeSetToWeapon() {
        // given
        final String weaponName = "Ultimate Axe";

        // when
        final Weapon axe = new Weapon(weaponName, WeaponType.AXE);

        // then
        assertThat(axe.getItemType()).isEqualTo(ItemType.WEAPON);
    }

    @Test
    public void shouldHaveTypeProperlyInitalized() {
        // given
        final String weaponName = "Funny dagger";

        // when
        final Weapon dagger = new Weapon(weaponName, WeaponType.DAGGER);

        // then
        assertThat(dagger.getWeaponType()).isEqualTo(WeaponType.DAGGER);
    }

}