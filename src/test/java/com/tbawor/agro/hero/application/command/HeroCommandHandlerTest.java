package com.tbawor.agro.hero.application.command;

import com.tbawor.agro.hero.domain.Hero;
import com.tbawor.agro.hero.domain.HeroRepository;
import com.tbawor.agro.hero.domain.Statistics;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class HeroCommandHandlerTest {

    private static final String HERO_NAME = "Fake name";
    private static final int STRENGTH = 10;
    private static final int ENDURANCE = 11;
    private static final int DEFENSE = 12;
    private static final int AGILITY = 13;
    private static final int DEXTERITY = 14;
    private static final int INTELLIGENCE = 15;
    private static final int CHARISMA = 16;
    private static final int WISDOM = 17;
    private static final int WILLPOWER = 18;
    private static final int PERCEPTION = 19;
    private static final int LUCK = 20;

    @Mock
    private HeroRepository repository;

    @InjectMocks
    private HeroCommandHandler commandHandler;

    @Test
    public void shouldSaveNewHeroInRepository() {
        // when
        commandHandler.createHero(stubCreateHeroCommand());

        // then
        verify(repository, times(1)).save(any(Hero.class));
    }

    @Test
    public void shouldSaveHeroWithProperParameters() {
        // given
        final ArgumentCaptor<Hero> heroArgumentCaptor = ArgumentCaptor.forClass(Hero.class);

        // when
        commandHandler.createHero(stubCreateHeroCommand());

        // then
        verify(repository).save(heroArgumentCaptor.capture());
        final Hero savedHero = heroArgumentCaptor.getValue();

        assertThat(savedHero).isNotNull();
        assertThat(savedHero.getName()).isEqualTo(HERO_NAME);

        final Statistics statistics = savedHero.getStatistics();

        assertThat(statistics.getStrength()).isEqualTo(STRENGTH);
        assertThat(statistics.getEndurance()).isEqualTo(ENDURANCE);
        assertThat(statistics.getDefense()).isEqualTo(DEFENSE);
        assertThat(statistics.getAgility()).isEqualTo(AGILITY);
        assertThat(statistics.getDexterity()).isEqualTo(DEXTERITY);
        assertThat(statistics.getIntelligence()).isEqualTo(INTELLIGENCE);
        assertThat(statistics.getCharisma()).isEqualTo(CHARISMA);
        assertThat(statistics.getWisdom()).isEqualTo(WISDOM);
        assertThat(statistics.getWillpower()).isEqualTo(WILLPOWER);
        assertThat(statistics.getPerception()).isEqualTo(PERCEPTION);
        assertThat(statistics.getLuck()).isEqualTo(LUCK);
    }

    private CreateHeroCommand stubCreateHeroCommand() {
        return new CreateHeroCommand() {
            @Override
            public String getName() {
                return HERO_NAME;
            }

            @Override
            public Integer getStrength() {
                return STRENGTH;
            }

            @Override
            public Integer getEndurance() {
                return ENDURANCE;
            }

            @Override
            public Integer getDefense() {
                return DEFENSE;
            }

            @Override
            public Integer getAgility() {
                return AGILITY;
            }

            @Override
            public Integer getDexterity() {
                return DEXTERITY;
            }

            @Override
            public Integer getIntelligence() {
                return INTELLIGENCE;
            }

            @Override
            public Integer getCharisma() {
                return CHARISMA;
            }

            @Override
            public Integer getWisdom() {
                return WISDOM;
            }

            @Override
            public Integer getWillpower() {
                return WILLPOWER;
            }

            @Override
            public Integer getPerception() {
                return PERCEPTION;
            }

            @Override
            public Integer getLuck() {
                return LUCK;
            }
        };
    }

}