package com.github.cstroe.cosmind.dao;

import javax.persistence.*;

@Entity
@Table(name = "idea")
public class IdeaEntity {
    @Id
    private Long id;

    @Column
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
