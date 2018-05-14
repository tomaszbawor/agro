package com.tbawor.agro.hero.domain;

import java.util.Objects;

class HealthFactory {

    Health createHealthFromStatistics(final Statistics statistics) {
        Objects.requireNonNull(statistics);
        final Integer calculatedHealthValue = calculateMaxHealth(statistics);
        final Health health = new Health();
        health.setMaxHealth(calculatedHealthValue);
        health.setCurrentHealth(calculatedHealthValue);
        return health;
    }

    private int calculateMaxHealth(Statistics statistics) {
        return statistics.getEndurance() * 2;
    }

}
