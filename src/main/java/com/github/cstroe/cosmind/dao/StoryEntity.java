package com.github.cstroe.cosmind.dao;

import javax.persistence.*;

@Entity
@Table(name = "story")
public class StoryEntity {
    @Id
    @GeneratedValue(generator = "story_id_seq_generator")
    @SequenceGenerator(name = "story_id_seq_generator", sequenceName = "story_id_seq", allocationSize = 1)
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
