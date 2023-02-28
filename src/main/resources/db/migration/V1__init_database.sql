CREATE TABLE IF NOT EXISTS social_network
(
    id               VARCHAR(255) PRIMARY KEY,
    description      TEXT NOT NULL,
    url              TEXT NOT NULL,
    version          BIGINT,
    creation_date    TIMESTAMP,
    last_update_date TIMESTAMP
);

CREATE TABLE IF NOT EXISTS role
(
    id               VARCHAR(255) PRIMARY KEY,
    name             VARCHAR(30) NOT NULL UNIQUE,
    version          BIGINT,
    creation_date    TIMESTAMP,
    last_update_date TIMESTAMP
);

CREATE TABLE IF NOT EXISTS title_image
(
    id               VARCHAR(255) PRIMARY KEY,
    path             TEXT NOT NULL,
    version          BIGINT,
    creation_date    TIMESTAMP,
    last_update_date TIMESTAMP
);

CREATE TABLE IF NOT EXISTS work
(
    id               VARCHAR(255) PRIMARY KEY,
    title            VARCHAR(255) NOT NULL,
    url              TEXT,
    title_image_id   VARCHAR(255) REFERENCES title_image (id) UNIQUE,
    version          BIGINT,
    creation_date    TIMESTAMP,
    last_update_date TIMESTAMP
);

CREATE TABLE IF NOT EXISTS image
(
    id               VARCHAR(255) PRIMARY KEY,
    path             TEXT NOT NULL,
    work_id          VARCHAR(255) REFERENCES work (id),
    version          BIGINT,
    creation_date    TIMESTAMP,
    last_update_date TIMESTAMP
);

CREATE TABLE IF NOT EXISTS topic
(
    id               VARCHAR(255) PRIMARY KEY,
    name             VARCHAR(50)                       NOT NULL,
    work_id          VARCHAR(255) REFERENCES work (id) NOT NULL,
    version          BIGINT,
    creation_date    TIMESTAMP,
    last_update_date TIMESTAMP
);

CREATE TABLE IF NOT EXISTS users
(
    id               VARCHAR(255) PRIMARY KEY,
    name             VARCHAR(50)                        NOT NULL,
    login            VARCHAR(50)                        NOT NULL UNIQUE,
    password         VARCHAR(50)                        NOT NULL,
    role_id          VARCHAR(255) REFERENCES users (id) NOT NULL,
    version          BIGINT,
    creation_date    TIMESTAMP,
    last_update_date TIMESTAMP
);

CREATE TABLE IF NOT EXISTS work_topic
(
    work_id  VARCHAR(255) REFERENCES work (id),
    topic_id VARCHAR(255) REFERENCES topic (id),
    CONSTRAINT work_topic_pk PRIMARY KEY (work_id, topic_id)
);