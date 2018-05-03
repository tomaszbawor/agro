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
public class LoginUserDtoJsonTestIT {

    @Autowired
    private JacksonTester<LoginUserDto> json;

    @Test
    public void shouldDeserializeLoginUserDTO() throws IOException {
        // given
        String jsonContent = ("{'" +
                "login':'someLogin', " +
                "'password':'somePass'" +
                "}").replace('\'', '"');

        // when
        final ObjectContent<LoginUserDto> parsedContent = json.parse(jsonContent);
        final LoginUserDto loginUserDto = parsedContent.getObject();

        // then
        assertThat(loginUserDto).isNotNull();
        assertThat(loginUserDto.getLogin()).isEqualTo("someLogin");
        assertThat(loginUserDto.getPassword()).isEqualTo("somePass");
    }

}