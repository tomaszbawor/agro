package com.tbawor.agro.items.armor.body;

import com.tbawor.agro.items.ItemType;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BodyArmorTest {

    @Test
    public void shouldBeInitializedWithProperName() {
        // given
        final String name = "Some Armor";
        final int defence = 10;

        // when
        BodyArmor bodyArmor = new BodyArmor(name, defence);

        // then
        assertThat(bodyArmor.getName()).isEqualTo(name);
    }

    @Test
    public void shouldHaveProperItemType() {
        // given
        final String name = "Some Fancy Armor";
        final int defence = 11;

        // when
        BodyArmor bodyArmor = new BodyArmor(name, defence);

        // then
        assertThat(bodyArmor.getItemType()).isEqualTo(ItemType.BODY_ARMOR);
    }

    @Test
    public void shouldHaveBeenInitializedWithProperDefence() {
        // given
        final String name = "Some Werid Armor";
        final int defence = 12;

        // when
        BodyArmor bodyArmor = new BodyArmor(name, defence);

        // then
        assertThat(bodyArmor.getDefence()).isEqualTo(defence);
    }

}