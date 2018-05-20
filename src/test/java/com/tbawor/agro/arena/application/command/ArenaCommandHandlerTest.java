package com.tbawor.agro.arena.application.command;

import com.tbawor.agro.arena.domain.ArenaMonster;
import com.tbawor.agro.arena.domain.ArenaMonsterRepository;
import com.tbawor.agro.hero.domain.Hero;
import com.tbawor.agro.hero.domain.HeroRepository;
import io.vavr.control.Option;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ArenaCommandHandlerTest {

    @Mock
    private HeroRepository heroRepository;

    @Mock
    private ArenaMonsterRepository monsterRepository;

    @InjectMocks
    private ArenaCommandHandler commandHandler;

    @Before
    public void setUp() {
       when(heroRepository.findByOwnerLogin(anyString())).thenReturn(Option.of(mock(Hero.class)));
       when(monsterRepository.findById(anyInt())).thenReturn(Option.of(mock(ArenaMonster.class)));
    }

    @Test
    public void shouldSearchHeroByOwnerLoginWhenAttacking() {
        // given
        final String heroOwner = "OwnerFakeName";
        final Integer monsterId = 12;

        // when
        commandHandler.fightMonster(stubFightCommand(heroOwner, monsterId));

        // then
        verify(heroRepository).findByOwnerLogin(eq(heroOwner));
    }

    @Test
    public void shouldSearchMonsterByIdWhenAttacking() {
        // given
        final String heroOwner = "OwnerName";
        final Integer monsterId = 123;

        // when
        commandHandler.fightMonster(stubFightCommand(heroOwner, monsterId));

        // then
        verify(monsterRepository).findById(eq(monsterId));
    }

    private FightMonsterCommand stubFightCommand(
            String heroOwner,
            final Integer monsterId
    ) {
        return new FightMonsterCommand() {
            @Override
            public String getHeroOwnerLogin() {
                return heroOwner;
            }

            @Override
            public Integer getMonsterId() {
                return monsterId;
            }
        };
    }

}