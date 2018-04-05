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

    @Test
    public void shouldCreateHeroWithProperName() {
        // given
        final String heroName = "Komornik";

        // when
        final HeroFactory factory = new HeroFactory();
        final Hero newHero = factory.createNewHero(heroName, new Statistics.Stub());

        // then
        assertThat(newHero.getName()).isEqualTo(heroName);
    }

    @Test
    public void shouldCreateHeroWithProperStatistics() {
        // given
        final String heroName = "Themen";
        final Integer strengthVal = 12;
        final Statistics statistics = new Statistics.Stub();
        statistics.setStrength(strengthVal);

        // when
        final HeroFactory factory = new HeroFactory();
        final Hero newHero = factory.createNewHero(heroName, statistics);

        // then
        assertThat(newHero.getStatistics().getStrength()).isEqualTo(strengthVal);
        assertThat(newHero.getStatistics()).isEqualTo(statistics);
    }

}