package com.tbawor.agro.arena.application.command.fight.monster;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MonsterHealthTest {

    @Test
    public void shouldHaveInitializedHealthProperly() {
        // given
        final Integer maxHealthVal = 20;

        // when
        final MonsterHealth monsterHealth = new MonsterHealth(maxHealthVal);

        // then
        assertThat(monsterHealth.getCurrentHealth()).isEqualTo(maxHealthVal);
        assertThat(monsterHealth.getMaxHealth()).isEqualTo(maxHealthVal);
    }

    @Test
    public void shouldBeAbleToInflictDamage() {
        // given
        final Integer maxHealth = 10;
        final Integer inflictedDamage = 3;
        final MonsterHealth monsterHealth = new MonsterHealth(maxHealth);

        // when
        monsterHealth.inflictDamage(inflictedDamage);

        // then
        assertThat(monsterHealth.getCurrentHealth()).isEqualTo(maxHealth - inflictedDamage);
    }

    @Test
    public void shouldReturnBeZeroHealthWhenInflictedDamageIsGreaterThanCurrentValue() {
        // given
        final Integer maxHealth = 10;
        final Integer inflictedDamage = 30;
        final MonsterHealth monsterHealth = new MonsterHealth(maxHealth);

        // when
        monsterHealth.inflictDamage(inflictedDamage);

        // then
        assertThat(monsterHealth.getCurrentHealth()).isZero();
    }

    @Test
    public void shouldReturnIsAliveWhenPositiveHealth() {
        // given
        final Integer health = 10;
        final MonsterHealth monsterHealth = new MonsterHealth(health);

        // when
        final boolean alive = monsterHealth.isAlive();

        // then
        assertThat(alive).isTrue();
    }

    @Test
    public void shouldReturnDeadWhenHealthIsZero() {
        // given
        final Integer health = 10;
        final MonsterHealth monsterHealth = new MonsterHealth(health);
        monsterHealth.inflictDamage(400);

        // when
        final boolean alive = monsterHealth.isAlive();

        // then
        assertThat(alive).isFalse();
    }

}