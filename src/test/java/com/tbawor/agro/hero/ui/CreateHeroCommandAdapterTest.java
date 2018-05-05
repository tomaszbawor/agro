package com.tbawor.agro.hero.ui;

import org.junit.Test;

import java.security.Principal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CreateHeroCommandAdapterTest {

    @Test
    public void shouldReturnPrincipalNameAsOwnerName() {
        // given
        final String userName = "FakeUsername";
        Principal principal = mock(Principal.class);
        doReturn(userName).when(principal).getName();

        // when
        final CreateHeroCommandAdapter adapter = new CreateHeroCommandAdapter(null, principal);

        // then
        assertThat(adapter.getOwnerLogin()).isEqualTo(userName);
    }

    @Test
    public void shouldReturnNameFromTransferObject() {
        // given
        final String heroName = "ExampleHeroName";
        Principal principal = mock(Principal.class);
        CreateHeroDto createHeroDto = mock(CreateHeroDto.class);
        when(createHeroDto.getName()).thenReturn(heroName);

        // when
        final CreateHeroCommandAdapter commandAdapter = new CreateHeroCommandAdapter(createHeroDto, principal);

        // then
        assertThat(commandAdapter.getName()).isEqualTo(heroName);
    }

    @Test
    public void shouldReturnStrengthFromTransferObject() {
        // given
        final Integer strength = 123;
        Principal principal = mock(Principal.class);
        CreateHeroDto createHeroDto = mock(CreateHeroDto.class);
        when(createHeroDto.getStrength()).thenReturn(strength);

        // when
        final CreateHeroCommandAdapter commandAdapter = new CreateHeroCommandAdapter(createHeroDto, principal);

        // then
        assertThat(commandAdapter.getStrength()).isEqualTo(strength);
    }

    @Test
    public void shouldReturnEnduranceFromTransferObject() {
        // given
        final Integer endurance = 13;
        Principal principal = mock(Principal.class);
        CreateHeroDto createHeroDto = mock(CreateHeroDto.class);
        when(createHeroDto.getEndurance()).thenReturn(endurance);

        // when
        final CreateHeroCommandAdapter commandAdapter = new CreateHeroCommandAdapter(createHeroDto, principal);

        // then
        assertThat(commandAdapter.getEndurance()).isEqualTo(endurance);
    }

    @Test
    public void shouldReturnDefenceFromTransferObject() {
        // given
        final Integer defence = 12;
        Principal principal = mock(Principal.class);
        CreateHeroDto createHeroDto = mock(CreateHeroDto.class);
        when(createHeroDto.getDefense()).thenReturn(defence);

        // when
        final CreateHeroCommandAdapter commandAdapter = new CreateHeroCommandAdapter(createHeroDto, principal);

        // then
        assertThat(commandAdapter.getDefense()).isEqualTo(defence);
    }

    @Test
    public void shouldReturnAgilityFromTransferObject() {
        // given
        final Integer agility = 123;
        Principal principal = mock(Principal.class);
        CreateHeroDto createHeroDto = mock(CreateHeroDto.class);
        when(createHeroDto.getAgility()).thenReturn(agility);

        // when
        final CreateHeroCommandAdapter commandAdapter = new CreateHeroCommandAdapter(createHeroDto, principal);

        // then
        assertThat(commandAdapter.getAgility()).isEqualTo(agility);
    }

    @Test
    public void shouldReturnDexterityFromTransferObject() {
        // given
        final Integer dexterity = 13;
        Principal principal = mock(Principal.class);
        CreateHeroDto createHeroDto = mock(CreateHeroDto.class);
        when(createHeroDto.getDexterity()).thenReturn(dexterity);

        // when
        final CreateHeroCommandAdapter commandAdapter = new CreateHeroCommandAdapter(createHeroDto, principal);

        // then
        assertThat(commandAdapter.getDexterity()).isEqualTo(dexterity);
    }

    @Test
    public void shouldReturnIntelligenceFromTransferObject() {
        // given
        final Integer intelligence = 34;
        Principal principal = mock(Principal.class);
        CreateHeroDto createHeroDto = mock(CreateHeroDto.class);
        when(createHeroDto.getIntelligence()).thenReturn(intelligence);

        // when
        final CreateHeroCommandAdapter commandAdapter = new CreateHeroCommandAdapter(createHeroDto, principal);

        // then
        assertThat(commandAdapter.getIntelligence()).isEqualTo(intelligence);
    }

    @Test
    public void shouldReturnCharismaFromTransferObject() {
        // given
        final Integer charisma = 123;
        Principal principal = mock(Principal.class);
        CreateHeroDto createHeroDto = mock(CreateHeroDto.class);
        when(createHeroDto.getCharisma()).thenReturn(charisma);

        // when
        final CreateHeroCommandAdapter commandAdapter = new CreateHeroCommandAdapter(createHeroDto, principal);

        // then
        assertThat(commandAdapter.getCharisma()).isEqualTo(charisma);
    }

    @Test
    public void shouldReturnWisdomFromTransferObject() {
        // given
        final Integer wisdom = 43;
        Principal principal = mock(Principal.class);
        CreateHeroDto createHeroDto = mock(CreateHeroDto.class);
        when(createHeroDto.getWisdom()).thenReturn(wisdom);

        // when
        final CreateHeroCommandAdapter commandAdapter = new CreateHeroCommandAdapter(createHeroDto, principal);

        // then
        assertThat(commandAdapter.getWisdom()).isEqualTo(wisdom);
    }

    @Test
    public void shouldReturnWillpowerFromTransferObject() {
        // given
        final Integer willpower = 14;
        Principal principal = mock(Principal.class);
        CreateHeroDto createHeroDto = mock(CreateHeroDto.class);
        when(createHeroDto.getWillpower()).thenReturn(willpower);

        // when
        final CreateHeroCommandAdapter commandAdapter = new CreateHeroCommandAdapter(createHeroDto, principal);

        // then
        assertThat(commandAdapter.getWillpower()).isEqualTo(willpower);
    }

    @Test
    public void shouldReturnPerceptionFromTransferObject() {
        // given
        final Integer perception = 1233;
        Principal principal = mock(Principal.class);
        CreateHeroDto createHeroDto = mock(CreateHeroDto.class);
        when(createHeroDto.getPerception()).thenReturn(perception);

        // when
        final CreateHeroCommandAdapter commandAdapter = new CreateHeroCommandAdapter(createHeroDto, principal);

        // then
        assertThat(commandAdapter.getPerception()).isEqualTo(perception);
    }


    @Test
    public void shouldReturnLuckFromTransferObject() {
        // given
        final Integer luck = 193;
        Principal principal = mock(Principal.class);
        CreateHeroDto createHeroDto = mock(CreateHeroDto.class);
        when(createHeroDto.getLuck()).thenReturn(luck);

        // when
        final CreateHeroCommandAdapter commandAdapter = new CreateHeroCommandAdapter(createHeroDto, principal);

        // then
        assertThat(commandAdapter.getLuck()).isEqualTo(luck);
    }
}