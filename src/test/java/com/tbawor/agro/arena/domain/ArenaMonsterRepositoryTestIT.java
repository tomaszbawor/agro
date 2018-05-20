package com.tbawor.agro.arena.domain;

import io.vavr.collection.Seq;
import io.vavr.control.Option;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@DataJpaTest
public class ArenaMonsterRepositoryTestIT {

    @Autowired
    private ArenaMonsterRepository repository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void shouldListAllArenaMonsters() {
        // given
        final ArenaMonster arenaMonster = new ArenaMonster();
        arenaMonster.setName("NAME");
        arenaMonster.setDefence(12);
        arenaMonster.setStrength(11);
        arenaMonster.setMaxHealth(10);

        entityManager.persist(arenaMonster);

        // when
        final Seq<ArenaMonster> allMonsters = repository.findAll();

        // then
        assertThat(allMonsters).isNotNull();
        assertThat(allMonsters).contains(arenaMonster);
        assertThat(allMonsters).hasSize(1);
    }

    @Test
    public void shouldReturnMonsterById() {
        // given
        final ArenaMonster arenaMonster = new ArenaMonster();
        arenaMonster.setName("NAME");
        arenaMonster.setDefence(12);
        arenaMonster.setStrength(11);
        arenaMonster.setMaxHealth(10);
        entityManager.persist(arenaMonster);
        final Integer monsterId = arenaMonster.getId();

        // when
        final Option<ArenaMonster> monsterFoundById = repository.findById(monsterId);

        // then
        assertThat(monsterFoundById.isDefined()).isTrue();
    }

}