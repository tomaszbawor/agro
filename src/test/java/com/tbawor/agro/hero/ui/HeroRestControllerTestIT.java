package com.tbawor.agro.hero.ui;

import com.tbawor.agro.hero.application.command.HeroCommandHandler;
import com.tbawor.agro.hero.application.query.HeroQueryService;
import com.tbawor.agro.hero.domain.Hero;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(value = HeroRestController.class, secure = false)
public class HeroRestControllerTestIT {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private HeroCommandHandler commandHandler;

    @MockBean
    private HeroQueryService queryService;

    @Test
    public void shouldGetHeroes() throws Exception {
        mockMvc.perform(
                get("/api/hero")
                        .accept(MediaType.APPLICATION_JSON)
        ).andExpect(
                status().isOk()
        );
    }

    @Test
    public void shouldCreateHeroByPostJson() throws Exception {
        // given

        when(commandHandler.createHero(any())).thenReturn(new Hero());

        String jsonContent = ("{" +
                "'name': 'TestName'," +
                "'strength': 1," +
                "'endurance': 2," +
                "'defense': 3," +
                "'agility': 4," +
                "'dexterity': 5," +
                "'intelligence': 6," +
                "'charisma': 7," +
                "'wisdom': 8," +
                "'willpower': 9," +
                "'perception': 10," +
                "'luck': 11" +
                "}").replace('\'', '"');
        // when
        mockMvc
                .perform(
                        post("/api/hero")
                                .content(jsonContent)
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON)
                )
                // then
                .andExpect(
                        status().isOk()
                );
    }

}