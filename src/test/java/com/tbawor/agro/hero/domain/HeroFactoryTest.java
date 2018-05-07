package com.tbawor.agro.hero.domain;

import com.tbawor.agro.security.domain.ApplicationUser;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

public class HeroFactoryTest {

    @Test
    public void shouldCreateNotNullHero() {
        // given
        final String heroName = "Euzebiusz";
        final ApplicationUser owner = mock(ApplicationUser.class);

        // when
        final HeroFactory factory = new HeroFactory();
        final Hero newHero = factory.createNewHero(heroName, new Statistics.Stub(), owner);

        // then
        assertThat(newHero).isNotNull();
    }

    @Test
    public void shouldCreateHeroWithProperName() {
        // given
        final String heroName = "Komornik";
        final ApplicationUser owner = mock(ApplicationUser.class);

        // when
        final HeroFactory factory = new HeroFactory();
        final Hero newHero = factory.createNewHero(heroName, new Statistics.Stub(), owner);

        // then
        assertThat(newHero.getName()).isEqualTo(heroName);
    }

    @Test
    public void shouldCreateHeroWithProperStatistics() {
        // given
        final ApplicationUser owner = mock(ApplicationUser.class);
        final String heroName = "Themen";
        final Integer strengthVal = 12;
        final Statistics statistics = new Statistics.Stub();
        statistics.setStrength(strengthVal);

        // when
        final HeroFactory factory = new HeroFactory();
        final Hero newHero = factory.createNewHero(heroName, statistics, owner);

        // then
        assertThat(newHero.getStatistics().getStrength()).isEqualTo(strengthVal);
        assertThat(newHero.getStatistics()).isEqualTo(statistics);
    }

    @Test
    public void shouldCreateHeroWithNonNullHealth() {
        // given
        final ApplicationUser owner = mock(ApplicationUser.class);
        final String heroName = "Themen";
        final Statistics statistics = new Statistics.Stub();

        // when
        final HeroFactory heroFactory = new HeroFactory();
        final Hero newHero = heroFactory.createNewHero(heroName, statistics, owner);

        // then
        final Health heroHealth = newHero.getHealth();
        assertThat(heroHealth).isNotNull();
        assertThat(heroHealth.getMaxHealth()).isEqualTo(heroHealth.getHealth());
    }

}