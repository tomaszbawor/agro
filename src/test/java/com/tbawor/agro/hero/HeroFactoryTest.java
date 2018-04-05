package com.tbawor.agro.hero;


import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HeroFactoryTest {

    @Test
    public void shouldCreateNotNullHero() {
        // given
        final String heroName = "Euzebiusz";

        // when
        final HeroFactory factory = new HeroFactory();
        final Hero newHero = factory.createNewHero(heroName, new Statistics.Stub());

        // then
        assertThat(newHero).isNotNull();
    }

}