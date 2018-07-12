package com.github.cstroe.cosmind.dao;

import javax.persistence.*;

@Entity
@Table(name = "story")
public class StoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_seq")
    @SequenceGenerator(name = "id_seq", sequenceName = "story_id_seq")
    private Long id;

    @Column
    private String summary;

    @Column
    private String description;

    public StoryEntity() {}

    public Long getId() {
        return id;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
