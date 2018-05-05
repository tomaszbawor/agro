package com.tbawor.agro.hero.domain;

import com.tbawor.agro.security.domain.ApplicationUser;
import com.tbawor.agro.security.domain.ApplicationUserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.security.Principal;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@DataJpaTest
public class HeroRepositoryTestIT {

    @Autowired
    private HeroRepository repository;

    @Autowired
    private ApplicationUserRepository userRepository;

    @Test
    public void shouldSaveHeroAndStatisticsObjectInOneOperation() {
        // given
        final ApplicationUser owner = userRepository.findAll().get(0);
        final HeroFactory factory = new HeroFactory();
        final Hero myHero = factory.createNewHero("MyHero", new Statistics.Stub(), owner);

        // when
        repository.save(myHero);

        // then
        assertThat(myHero.getId()).isNotNull();
        assertThat(myHero.getStatistics().getId()).isNotNull();
    }

}