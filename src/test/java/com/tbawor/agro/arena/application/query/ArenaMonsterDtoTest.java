package com.tbawor.agro.arena.application.query;

import com.tbawor.agro.arena.domain.ArenaMonster;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ArenaMonsterDtoTest {

    @Test
    public void shouldProperlyConstructFromArenaMonster() {
        // given
        final int monsterId = 321;
        final String monsterName = "Mouse";
        final int monsterStrength = 21;
        final int monsterDefence = 32;
        final int monsterMaxHealth = 432;

        final ArenaMonster arenaMonster = new ArenaMonster();
        arenaMonster.setId(monsterId);
        arenaMonster.setName(monsterName);
        arenaMonster.setStrength(monsterStrength);
        arenaMonster.setDefence(monsterDefence);
        arenaMonster.setMaxHealth(monsterMaxHealth);

        // when
        final ArenaMonsterDto dto = new ArenaMonsterDto(arenaMonster);

        // then
        assertThat(dto.getId()).isEqualTo(monsterId);
        assertThat(dto.getName()).isEqualTo(monsterName);
        assertThat(dto.getStrength()).isEqualTo(monsterStrength);
        assertThat(dto.getDefence()).isEqualTo(monsterDefence);
        assertThat(dto.getMaxHealth()).isEqualTo(monsterMaxHealth);
    }
}