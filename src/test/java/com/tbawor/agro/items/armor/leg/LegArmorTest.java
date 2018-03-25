package com.tbawor.agro.items.armor.leg;

import com.tbawor.agro.items.ItemType;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LegArmorTest {

    @Test
    public void shouldHaveProperItemType() {
        // given
        final String name = "Jeans";
        final int def = 11;

        // when
         LegArmor legArmor = new LegArmor(name, def);

        // then
        assertThat(legArmor.getItemType()).isEqualTo(ItemType.LEG_ARMOR);
    }

}