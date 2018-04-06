package com.tbawor.agro.hero.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@DataJpaTest
public class HeroRepositoryTestIT {

    @Autowired
    private HeroRepository repository;

    @Test
    public void shouldSaveHeroAndStatisticsObjectInOneOperation() {
        // given
        final HeroFactory factory = new HeroFactory();
        final Hero myHero = factory.createNewHero("MyHero", new Statistics.Stub());

        // when
        repository.save(myHero);

        // then
        assertThat(myHero.getId()).isNotNull();
        assertThat(myHero.getStatistics().getId()).isNotNull();
    }

}