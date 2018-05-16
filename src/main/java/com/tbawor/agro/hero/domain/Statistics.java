package com.tbawor.agro.hero.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "statistics")
@Data
public class Statistics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private Integer strength;

    @Column(nullable = false)
    private Integer endurance;

    @Column(nullable = false)
    private Integer defense;

    @Column(nullable = false)
    private Integer agility;

    @Column(nullable = false)
    private Integer dexterity;

    @Column(nullable = false)
    private Integer intelligence;

    @Column(nullable = false)
    private Integer charisma;

    @Column(nullable = false)
    private Integer wisdom;

    @Column(nullable = false)
    private Integer willpower;

    @Column(nullable = false)
    private Integer perception;

    @Column(nullable = false)
    private Integer luck;

    static class Stub extends Statistics {
        Stub() {
            super();
            setStrength(5);
            setEndurance(5);
            setDefense(5);
            setAgility(5);
            setDexterity(5);
            setIntelligence(5);
            setCharisma(4);
            setWisdom(4);
            setWillpower(4);
            setPerception(4);
            setLuck(4);
        }
    }
}
