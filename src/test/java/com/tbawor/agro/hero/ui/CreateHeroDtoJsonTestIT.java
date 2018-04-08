package com.tbawor.agro.hero.ui;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.json.ObjectContent;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@JsonTest
public class CreateHeroDtoJsonTestIT {

    @Autowired
    private JacksonTester<CreateHeroDto> json;

    @Test
    public void shouldDeserializeCreateHeroDto() throws IOException {
        // given
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
                "}")
                .replace('\'','"');

        // when
        final ObjectContent<CreateHeroDto> parsedContent = json.parse(jsonContent);
        CreateHeroDto dto = parsedContent.getObject();

        // then
        assertThat(dto.getName()).isEqualTo("TestName");
        assertThat(dto.getStrength()).isEqualTo(1);
        assertThat(dto.getEndurance()).isEqualTo(2);
        assertThat(dto.getDefense()).isEqualTo(3);
        assertThat(dto.getAgility()).isEqualTo(4);
        assertThat(dto.getDexterity()).isEqualTo(5);
        assertThat(dto.getIntelligence()).isEqualTo(6);
        assertThat(dto.getCharisma()).isEqualTo(7);
        assertThat(dto.getWisdom()).isEqualTo(8);
        assertThat(dto.getWillpower()).isEqualTo(9);
        assertThat(dto.getPerception()).isEqualTo(10);
        assertThat(dto.getLuck()).isEqualTo(11);
    }
}