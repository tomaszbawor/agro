package com.tbawor.agro.hero.domain;

import com.tbawor.agro.security.domain.ApplicationUser;

import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "hero")
public class Hero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Statistics statistics;

    @OneToOne(fetch = FetchType.EAGER)
    private ApplicationUser owner;

    @Embedded
    private Health health;

    public Hero() {
        // Default constructor for hibernate
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Statistics getStatistics() {
        return statistics;
    }

    public void setStatistics(Statistics statistics) {
        this.statistics = statistics;
    }

    public ApplicationUser getOwner() {
        return owner;
    }

    public void setOwner(ApplicationUser owner) {
        this.owner = owner;
    }

    public Health getHealth() {
        return health;
    }

    public void setHealth(Health health) {
        this.health = health;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Hero hero = (Hero) o;
        return Objects.equals(id, hero.id)
                && Objects.equals(name, hero.name)
                && Objects.equals(statistics, hero.statistics)
                && Objects.equals(owner, hero.owner)
                && Objects.equals(health, hero.health);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, statistics, owner, health);
    }

    public boolean isAlive() {
        return health.getHealth() > 0;
    }

    public void getDamage(Integer damageValue) {
        final Integer healthValue = this.health.getHealth();
        if (damageValue < healthValue) {
            this.health.setHealth(healthValue - damageValue);
        } else {
            this.health.setHealth(0);
        }
    }
}
