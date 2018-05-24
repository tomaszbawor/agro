package com.tbawor.agro.common;

public interface Attackable {

    Integer currentHealth();

    Integer maxHealth();

    default Boolean isAlive() {
        return currentHealth() > 0;
    }

    void inflictDamage(Integer value);
}
