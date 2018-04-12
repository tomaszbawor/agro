package com.tbawor.agro.hero.application.query;

import com.tbawor.agro.hero.domain.HeroRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class HeroQueryServiceTest {

    @Mock
    private HeroRepository repository;

    @InjectMocks
    private HeroQueryService service;

    @Test
    public void shouldFindAllHeroesFromRepository() {
        // when
        service.listAllHeroes();

        // then
        verify(repository, times(1)).findAll();
    }

}