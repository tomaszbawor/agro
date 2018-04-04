package com.tbawor.agro.items.armor.shoes;

import com.tbawor.agro.items.ItemType;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ShoesTest {

    @Test
    public void shouldHaveProperItemType() {
        // given
        final String name = "Hard Boots";
        final int def = 1;

        // when
        Shoes shoes = new Shoes(name, def);

        // then
        assertThat(shoes.getItemType()).isEqualTo(ItemType.SHOES);
    }

}