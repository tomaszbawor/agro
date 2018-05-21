package com.tbawor.agro.arena.application.command.fight.monster;

import lombok.Getter;

@Getter
class MonsterHealth {

    private final Integer maxHealth;
    private Integer currentHealth;

    MonsterHealth(Integer maxHealth) {
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth;
    }

    boolean isAlive() {
        return currentHealth > 0;
    }

    void inflictDamage(Integer damage) {
        currentHealth = Math.max(0, currentHealth - damage);
    }

}
