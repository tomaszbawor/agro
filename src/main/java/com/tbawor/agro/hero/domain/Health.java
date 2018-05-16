package com.tbawor.agro.hero.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
class Health implements Serializable {

    @Column(name = "max_health", nullable = false)
    private Integer maxHealth;

    @Column(name = "health", nullable = false)
    private Integer currentHealth;
    
}
