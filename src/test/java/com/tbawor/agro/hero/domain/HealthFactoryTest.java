package com.tbawor.agro.hero.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class HealthFactoryTest {

    @Test
    public void shouldReturnNullPointerExceptionWhenNullStatisticsProvided() {
        // given
        final HealthFactory factory = new HealthFactory();

        try {
            // when
            factory.createHealthFromStatistics(null);
            fail("Should throw exception");
        } catch (Exception ex) {
            // then
            assertThat(ex).isInstanceOf(NullPointerException.class);
        }
    }

    @Test
    public void shouldReturnMaxHealtValueByDoublingEndurance() {
        // given
        final int enduranceVal = 12;
        final Statistics statistics = mock(Statistics.class);
        when(statistics.getEndurance()).thenReturn(enduranceVal);

        final HealthFactory factory = new HealthFactory();

        // when
        final Health health = factory.createHealthFromStatistics(statistics);

        // then
        assertThat(health.getCurrentHealth())
                .isEqualTo(health.getMaxHealth())
                .isEqualTo(enduranceVal * 2);
    }

}