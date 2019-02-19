DROP TABLE IF EXISTS e_sample;

-- ======== ======== ======== ========
-- sample
-- ======== ======== ======== ========
CREATE TABLE e_sample (
    id_      BIGINT AUTO_INCREMENT NOT NULL,
    name_    VARCHAR(50)           NULL,
    mail_    VARCHAR(200)          NULL,
    deleted_ BOOLEAN DEFAULT FALSE NULL,
    created_ DATETIME              NULL,
    updated_ DATETIME              NULL,
    CONSTRAINT sample_pk PRIMARY KEY (id_)
);

-- ======== ======== ======== ========
-- sample data
-- ======== ======== ======== ========
INSERT INTO e_sample(id_, name_, deleted_, created_, updated_)
VALUES (1, 'sample1', 0, now(), now()),
       (2, 'sample2', 0, now(), now()),
       (3, 'sample3', 1, now(), now());
