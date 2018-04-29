package com.tbawor.agro.security.ui;

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
public class RegisterUserDtoJsonTestIT {

    @Autowired
    private JacksonTester<RegisterUserDto> json;

    @Test
    public void shouldDeserializeRegisterUserDto() throws IOException {
        // given
        String jsonContent = ("{'" +
                "login':'someLogin', " +
                "'password':'somePass'" +
                "}").replace('\'','"');

        // when
        final ObjectContent<RegisterUserDto> parsedContent = json.parse(jsonContent);
        final RegisterUserDto registerUserDto = parsedContent.getObject();

        // then
        assertThat(registerUserDto).isNotNull();
        assertThat(registerUserDto.getLogin()).isEqualTo("someLogin");
        assertThat(registerUserDto.getPassword()).isEqualTo("somePass");
    }

}