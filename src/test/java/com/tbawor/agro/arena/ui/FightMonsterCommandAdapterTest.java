package com.tbawor.agro.arena.ui;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FightMonsterCommandAdapterTest {

    @Test
    public void shouldProperlyReturnParameters() {
        // given
        final String heroLogin = "HeroLogin";
        final int monsterId = 13;

        // when
        final FightMonsterCommandAdapter commandAdapter = new FightMonsterCommandAdapter(monsterId, heroLogin);

        // then
        assertThat(commandAdapter.getHeroOwnerLogin()).isEqualTo(heroLogin);
        assertThat(commandAdapter.getMonsterId()).isEqualTo(monsterId);
    }

}