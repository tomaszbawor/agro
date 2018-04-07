package com.tbawor.agro.hero.ui;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@WebMvcTest(HeroRestController.class)
public class HeroRestControllerTestIT {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private HeroRestController controller;

    @Test
    public void test() {
        assertThat(controller).isNotNull();
    }

}