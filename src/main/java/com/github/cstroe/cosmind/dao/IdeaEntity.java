package com.github.cstroe.cosmind.dao;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.ZonedDateTime;

@Entity
@Table(name = "idea")
public class IdeaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "idea_id_seq_generator")
    @SequenceGenerator(name = "idea_id_seq_generator", sequenceName = "idea_id_seq", allocationSize = 1)
    private Long id;

    @Column
    private String description;

    // See: https://stackoverflow.com/a/14703754/1591777
    @Column(name = "created_date", insertable = false)
    private ZonedDateTime createdDate;

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

    public ZonedDateTime getCreatedDate() {
        return createdDate;
    }
}
