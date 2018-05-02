package com.tbawor.agro.security.domain;

import io.vavr.collection.Seq;
import io.vavr.control.Option;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ApplicationUserRepositoryTestIT {

    @Autowired
    private ApplicationUserRepository repository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void shouldFindApplicationUserByLogin() {
        // given
        final String login = "FakeLogin";
        final String password = "FakePassword";

        ApplicationUser user = new ApplicationUser();
        user.setLogin(login);
        user.setPassword(password);

        entityManager.persist(user);

        // when
        final Option<ApplicationUser> maybeUser = repository.findByLogin(login);

        // then
        assertThat(maybeUser.isDefined()).isTrue();
    }

    @Test
    public void shouldSaveApplicationUser() {
        // given
        final String userLogin = "ExampleLogin";
        final String userPassword = "ExamplePassword";

        final ApplicationUser user = new ApplicationUser();
        user.setLogin(userLogin);
        user.setPassword(userPassword);

        // when
        repository.save(user);

        // then
        assertThat(user.getId()).isNotNull();
        assertThat(repository.findByLogin(userLogin).isDefined()).isTrue();
    }

    @Test
    public void shouldFindAllUsers() {
        // given
        entityManager.clear();
        final String login = "FakeLogin";
        final String password = "FakePassword";

        ApplicationUser user = new ApplicationUser();
        user.setLogin(login);
        user.setPassword(password);

        entityManager.persist(user);

        // when
        final Seq<ApplicationUser> users = repository.findAll();

        // then
        assertThat(users).isNotNull();
        assertThat(users).anyMatch(u -> u.getLogin().equals(login)
                && u.getPassword().equals(password));
    }

}