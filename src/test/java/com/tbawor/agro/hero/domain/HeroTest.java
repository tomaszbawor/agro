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

        // when
        final Hero firstHero = new Hero();
        firstHero.setId(heroId);
        firstHero.setName(heroName);
        firstHero.setStatistics(statistics);
        firstHero.setOwner(owner);
        final Hero secondHero = new Hero();
        secondHero.setId(heroId);
        secondHero.setName(heroName);
        secondHero.setStatistics(statistics);
        secondHero.setOwner(owner);

        // then
        assertThat(firstHero).isEqualTo(secondHero);
    }

}