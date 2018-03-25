package com.tbawor.agro.items.armor.gloves;

import com.tbawor.agro.items.ItemType;
import com.tbawor.agro.items.armor.leg.LegArmor;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GlovesTest {

    @Test
    public void shouldHaveProperItemType() {
        // given
        final String name = "Some Gloves";
        final int def = 1;

        // when
        Gloves gloves = new Gloves(name, def);

        // then
        assertThat(gloves.getItemType()).isEqualTo(ItemType.GLOVES);
    }

}