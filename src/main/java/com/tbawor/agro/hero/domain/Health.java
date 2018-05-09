package com.tbawor.agro.hero.domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
class Health implements Serializable {

    @Column(name = "max_health", nullable = false)
    private Integer maxHealth;

    @Column(name = "health", nullable = false)
    private Integer health;

    public Health() {
    }

    public Integer getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(Integer maxHealth) {
        this.maxHealth = maxHealth;
    }

    public Integer getHealth() {
        return health;
    }

    public void setHealth(Integer health) {
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
        Health health1 = (Health) o;
        return Objects.equals(maxHealth, health1.maxHealth)
                && Objects.equals(health, health1.health);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maxHealth, health);
    }
}
