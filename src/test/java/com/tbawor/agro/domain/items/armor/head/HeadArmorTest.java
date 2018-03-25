package com.tbawor.agro.domain.items.armor.head;

import com.tbawor.agro.domain.items.ItemType;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HeadArmorTest {

    @Test
    public void shouldHaveProperItemType() {
        // given
        final String name = "Cap";
        final int def = 14;

        // when
        HeadArmor headArmor = new HeadArmor(name, def);

        // then
        assertThat(headArmor.getItemType()).isEqualTo(ItemType.HEAD_ARMOR);
    }

}