package com.tbawor.agro.common;

public interface Attackable {

    Integer currentHealth();

    Integer maxHealth();

    Boolean isAlive();

    void inflictDamage(Integer value);
}
