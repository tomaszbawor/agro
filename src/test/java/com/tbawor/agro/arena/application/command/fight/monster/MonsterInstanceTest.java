package com.tbawor.agro.arena.application.command.fight.monster;

import com.tbawor.agro.arena.domain.ArenaMonster;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class MonsterInstanceTest {

    private static final int MONSTER_STRENGTH = 15;
    private static final int MONSTER_DEFENCE = 32;
    private static final int MONSTER_MAX_HEALTH = 14;
    private static final String MONSTER_NAME = "Monster Name";

    @Test
    public void shouldBeInitializedWithArenaMonsterParameters() {
        // given
        final ArenaMonster arenaMonster = new ArenaMonster();
        arenaMonster.setName(MONSTER_NAME);
        arenaMonster.setStrength(MONSTER_STRENGTH);
        arenaMonster.setDefence(MONSTER_DEFENCE);
        arenaMonster.setMaxHealth(MONSTER_MAX_HEALTH);

        // when
        final MonsterInstance monster = new MonsterInstance(arenaMonster);

        // then
        assertThat(monster.getName()).isEqualTo(MONSTER_NAME);
        assertThat(monster.getStrength()).isEqualTo(MONSTER_STRENGTH);
        assertThat(monster.getDefence()).isEqualTo(MONSTER_DEFENCE);
        assertThat(monster.currentHealth()).isEqualTo(MONSTER_MAX_HEALTH);
        assertThat(monster.maxHealth()).isEqualTo(MONSTER_MAX_HEALTH);
    }

    @Test
    public void shouldBeAbleToInflictDamageToMonster() {
        // given
        final ArenaMonster arenaMonster = new ArenaMonster();
        arenaMonster.setName(MONSTER_NAME);
        arenaMonster.setStrength(MONSTER_STRENGTH);
        arenaMonster.setDefence(MONSTER_DEFENCE);
        arenaMonster.setMaxHealth(MONSTER_MAX_HEALTH);
        final MonsterInstance monster = new MonsterInstance(arenaMonster);

        // when
        monster.inflictDamage(MONSTER_MAX_HEALTH);

        // then
        assertThat(monster.currentHealth()).isZero();
        assertThat(monster.isAlive()).isFalse();
    }

}