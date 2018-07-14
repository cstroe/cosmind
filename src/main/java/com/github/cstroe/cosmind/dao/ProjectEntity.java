package com.github.cstroe.cosmind.dao;

import javax.persistence.*;

@Entity
@Table(name = "project")
public class ProjectEntity {
    @Id
    @GeneratedValue(generator = "project_id_seq_generator")
    @SequenceGenerator(name = "project_id_seq_generator", sequenceName = "project_id_seq", allocationSize = 1)
    private Long id;

    @Column
    private String codename;

    @Column
    private String summary;

    @Column
    private String url;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodename() {
        return codename;
    }

    public void setCodename(String codename) {
        this.codename = codename;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
