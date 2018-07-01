-- Project

CREATE SEQUENCE project_id_seq AS BIGINT INCREMENT BY 1 MINVALUE 1 NO MAXVALUE;

CREATE TABLE project (
    id       BIGINT NOT NULL DEFAULT nextval('project_id_seq'),
    codename VARCHAR(10),
    summary  VARCHAR(256),
    url      VARCHAR(1024)
);

ALTER SEQUENCE project_id_seq OWNED BY project.id;


-- Story

CREATE SEQUENCE story_id_seq AS BIGINT INCREMENT BY 1 MINVALUE 1 NO MAXVALUE;

CREATE TABLE story (
    id          BIGINT NOT NULL DEFAULT nextval('story_id_seq'),
    summary     VARCHAR(256),
    description TEXT
);

ALTER SEQUENCE story_id_seq OWNED BY story.id;