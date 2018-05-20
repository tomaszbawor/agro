package com.tbawor.agro.arena.application.query;

import com.tbawor.agro.arena.domain.ArenaMonster;
import lombok.Value;

@Value
public class ArenaMonsterDto {

    private Integer id;
    private String name;
    private Integer strength;
    private Integer defence;
    private Integer maxHealth;

    public ArenaMonsterDto(ArenaMonster monster) {
        this.id = monster.getId();
        this.name = monster.getName();
        this.strength = monster.getStrength();
        this.defence = monster.getDefence();
        this.maxHealth = monster.getMaxHealth();
    }
}
