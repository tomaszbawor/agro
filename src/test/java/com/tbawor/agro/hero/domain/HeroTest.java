package com.tbawor.agro.hero.domain;

import com.tbawor.agro.security.domain.ApplicationUser;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

public class HeroTest {

    @Test
    public void shouldBeEqualWhenAllFieldsAreEqual() {
        // given
        final Integer heroId = 10;
        final String heroName = "ExampleHeroName";
        final Statistics statistics = mock(Statistics.class);
        final ApplicationUser owner = mock(ApplicationUser.class);
        final Health health = mock(Health.class);

        // when
        final Hero firstHero = new Hero();
        firstHero.setId(heroId);
        firstHero.setName(heroName);
        firstHero.setStatistics(statistics);
        firstHero.setOwner(owner);
        firstHero.setHealth(health);
        final Hero secondHero = new Hero();
        secondHero.setId(heroId);
        secondHero.setName(heroName);
        secondHero.setStatistics(statistics);
        secondHero.setOwner(owner);
        secondHero.setHealth(health);

        // then
        assertThat(firstHero).isEqualTo(secondHero);
    }

    @Test
    public void shouldBeAliveWhenHealthIsMoreThanZero() {
        // given
        final Integer heroId = 10;
        final String heroName = "ExampleHeroName";
        final Statistics statistics = mock(Statistics.class);
        final ApplicationUser owner = mock(ApplicationUser.class);
        final Health health = new Health();
        health.setMaxHealth(10);
        health.setCurrentHealth(1);

        // when
        final Hero hero = new Hero();
        hero.setId(heroId);
        hero.setName(heroName);
        hero.setStatistics(statistics);
        hero.setOwner(owner);
        hero.setHealth(health);

        // then
        assertThat(hero.isAlive()).isTrue();
    }

    @Test
    public void shouldNotBeAliveWhenHealthIsZero() {
        // given
        final Integer heroId = 10;
        final String heroName = "ExampleHeroName";
        final Statistics statistics = mock(Statistics.class);
        final ApplicationUser owner = mock(ApplicationUser.class);
        final Health health = new Health();
        health.setMaxHealth(10);
        health.setCurrentHealth(0);

        // when
        final Hero hero = new Hero();
        hero.setId(heroId);
        hero.setName(heroName);
        hero.setStatistics(statistics);
        hero.setOwner(owner);
        hero.setHealth(health);

        // then
        assertThat(hero.isAlive()).isFalse();
    }

    @Test
    public void shouldGetDamage() {
        // given
        final Integer heroId = 10;
        final String heroName = "ExampleHeroName";
        final Statistics statistics = mock(Statistics.class);
        final ApplicationUser owner = mock(ApplicationUser.class);
        final Integer heroHealth = 10;
        final Integer damageValue = 3;
        final Health health = new Health();
        health.setMaxHealth(heroHealth);
        health.setCurrentHealth(heroHealth);

        // when
        final Hero hero = new Hero();
        hero.setId(heroId);
        hero.setName(heroName);
        hero.setStatistics(statistics);
        hero.setOwner(owner);
        hero.setHealth(health);
        hero.getDamage(damageValue);

        // then
        assertThat(hero.getHealth().getCurrentHealth()).isEqualTo(heroHealth - damageValue);
    }

    @Test
    public void shouldNotGetMoreDamageThanHealth() {
        // given
        final Integer heroId = 10;
        final String heroName = "ExampleHeroName";
        final Statistics statistics = mock(Statistics.class);
        final ApplicationUser owner = mock(ApplicationUser.class);
        final Integer heroHealth = 10;
        final Integer gotDamageValue = 11;
        final Health health = new Health();
        health.setMaxHealth(heroHealth);
        health.setCurrentHealth(heroHealth);

        // when
        final Hero hero = new Hero();
        hero.setId(heroId);
        hero.setName(heroName);
        hero.setStatistics(statistics);
        hero.setOwner(owner);
        hero.setHealth(health);
        hero.getDamage(gotDamageValue);

        // then
        assertThat(hero.getHealth().getCurrentHealth()).isZero();
    }


}