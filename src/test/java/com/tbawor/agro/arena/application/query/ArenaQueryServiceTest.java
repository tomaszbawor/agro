package com.tbawor.agro.arena.application.query;

import com.tbawor.agro.arena.domain.ArenaMonsterRepository;
import io.vavr.collection.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ArenaQueryServiceTest {

    @InjectMocks
    private ArenaQueryService service;

    @Mock
    private ArenaMonsterRepository repository;


    @Test
    public void shouldFindAllArenaMonstersInRepository() {
        // given
        when(repository.findAll()).thenReturn(List.empty());

        // when
        service.findAll();

        // then
        verify(repository, times(1)).findAll();
    }

}