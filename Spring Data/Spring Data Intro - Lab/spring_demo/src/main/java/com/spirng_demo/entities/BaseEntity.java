package com.spirng_demo.entities;

import javax.persistence.*;

@MappedSuperclass
public abstract class BaseEntity {
    private Long id;

    protected BaseEntity() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    protected void setId(Long id) {
        this.id = id;
    }
}
