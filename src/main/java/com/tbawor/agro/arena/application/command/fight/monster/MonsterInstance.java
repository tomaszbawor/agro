package com.tbawor.agro.arena.application.command.fight.monster;

import com.tbawor.agro.arena.domain.ArenaMonster;
import com.tbawor.agro.common.Attackable;
import lombok.Getter;

public class MonsterInstance implements Attackable {

    @Getter
    private final String name;

    @Getter
    private final Integer strength;

    @Getter
    private final Integer defence;
    private final MonsterHealth health;

    public MonsterInstance(final ArenaMonster arenaMonster) {
        this.name = arenaMonster.getName();
        this.strength = arenaMonster.getStrength();
        this.defence = arenaMonster.getDefence();
        health = new MonsterHealth(arenaMonster.getMaxHealth());
    }

    @Override
    public Integer currentHealth() {
        return health.getCurrentHealth();
    }

    @Override
    public Integer maxHealth() {
        return health.getMaxHealth();
    }

    @Override
    public void inflictDamage(Integer value) {
        health.inflictDamage(value);
    }

}
