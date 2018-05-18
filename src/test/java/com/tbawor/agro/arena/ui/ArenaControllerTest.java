package com.tbawor.agro.arena.ui;

import com.tbawor.agro.arena.application.query.ArenaQueryService;
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
public class ArenaControllerTest {

    @InjectMocks
    private ArenaController controller;

    @Mock
    private ArenaQueryService queryService;

    @Test
    public void shouldQueryServiceForMonsters() {
        // given
        when(queryService.findAll()).thenReturn(List.empty());

        // when
        controller.findAll();

        // then
        verify(queryService, times(1)).findAll();
    }
}