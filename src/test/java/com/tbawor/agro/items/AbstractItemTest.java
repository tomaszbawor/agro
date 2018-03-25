package com.tbawor.agro.items;

import org.junit.Test;

public class AbstractItemTest {

    @Test(expected = NullItemNameException.class)
    public void shouldThrowNullItemNameExceptionWhenTryingToCreateItemWithNullName() {
        // given
        final String name = null;

        // when
        new AbstractItem(name, ItemType.WEAPON) {
            @Override
            public String getName() {
                return super.getName();
            }

            @Override
            public ItemType getItemType() {
                return super.getItemType();
            }
        };
    }

}