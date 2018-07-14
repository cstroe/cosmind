package com.github.cstroe.cosmind.dao;

import javax.persistence.*;

@Entity
@Table(name = "idea")
public class IdeaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "idea_id_seq_generator")
    @SequenceGenerator(name = "idea_id_seq_generator", sequenceName = "idea_id_seq", allocationSize = 1)
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
