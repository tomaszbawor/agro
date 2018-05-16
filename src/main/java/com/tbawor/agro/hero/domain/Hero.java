package com.tbawor.agro.hero.domain;

import com.tbawor.agro.security.domain.ApplicationUser;

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
import lombok.Data;

@Entity
@Table(name = "hero")
@Data
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

    public boolean isAlive() {
        return health.getCurrentHealth() > 0;
    }

    public void getDamage(Integer damageValue) {
        final Integer healthValue = this.health.getCurrentHealth();
        if (damageValue < healthValue) {
            this.health.setCurrentHealth(healthValue - damageValue);
        } else {
            this.health.setCurrentHealth(0);
        }
    }
}
