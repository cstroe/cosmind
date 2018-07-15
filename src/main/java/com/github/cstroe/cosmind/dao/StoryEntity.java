package com.github.cstroe.cosmind.dao;

import javax.persistence.*;
import java.time.ZonedDateTime;

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

    @Column(name = "created_date", insertable = false)
    private ZonedDateTime createdDate;

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

    public ZonedDateTime getCreatedDate() {
        return createdDate;
    }
}
