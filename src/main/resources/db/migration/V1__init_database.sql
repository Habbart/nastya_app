CREATE TABLE IF NOT EXISTS social_network
(
    id               VARCHAR(255) PRIMARY KEY,
    description      TEXT,
    url              TEXT      NOT NULL,
    version          BIGINT    NOT NULL,
    creation_date    TIMESTAMP NOT NULL,
    last_update_date TIMESTAMP NOT NULL
);

CREATE TABLE IF NOT EXISTS role
(
    id               VARCHAR(255) PRIMARY KEY,
    name             VARCHAR(30) NOT NULL UNIQUE,
    version          BIGINT      NOT NULL,
    creation_date    TIMESTAMP   NOT NULL,
    last_update_date TIMESTAMP   NOT NULL
);

CREATE TABLE IF NOT EXISTS title_image
(
    id               VARCHAR(255) PRIMARY KEY,
    path             TEXT      NOT NULL,
    version          BIGINT    NOT NULL,
    creation_date    TIMESTAMP NOT NULL,
    last_update_date TIMESTAMP NOT NULL
);

CREATE TABLE IF NOT EXISTS work
(
    id               VARCHAR(255) PRIMARY KEY,
    title            VARCHAR(255) NOT NULL,
    url              TEXT,
    front_id         TEXT         NOT NULL UNIQUE,
    title_image_id   VARCHAR(255) REFERENCES title_image (id) UNIQUE,
    version          BIGINT       NOT NULL,
    creation_date    TIMESTAMP    NOT NULL,
    last_update_date TIMESTAMP    NOT NULL
);

CREATE TABLE IF NOT EXISTS image
(
    id               VARCHAR(255) PRIMARY KEY,
    path             TEXT      NOT NULL,
    front_id         TEXT      NOT NULL UNIQUE,
    work_id          VARCHAR(255) REFERENCES work (id),
    version          BIGINT    NOT NULL,
    creation_date    TIMESTAMP NOT NULL,
    last_update_date TIMESTAMP NOT NULL
);

CREATE TABLE IF NOT EXISTS tag
(
    id               VARCHAR(255) PRIMARY KEY,
    name             VARCHAR(50)                       NOT NULL UNIQUE,
    work_id          VARCHAR(255) REFERENCES work (id) NOT NULL,
    version          BIGINT                            NOT NULL,
    creation_date    TIMESTAMP                         NOT NULL,
    last_update_date TIMESTAMP                         NOT NULL
);

CREATE TABLE IF NOT EXISTS users
(
    id               VARCHAR(255) PRIMARY KEY,
    name             VARCHAR(50)                       NOT NULL,
    login            VARCHAR(50)                       NOT NULL UNIQUE,
    password         VARCHAR(50)                       NOT NULL,
    role_id          VARCHAR(255) REFERENCES role (id) NOT NULL,
    version          BIGINT                            NOT NULL,
    creation_date    TIMESTAMP                         NOT NULL,
    last_update_date TIMESTAMP                         NOT NULL
);

CREATE TABLE IF NOT EXISTS work_tag
(
    id               VARCHAR(255) PRIMARY KEY,
    work_id          VARCHAR(255) REFERENCES work (id) ON DELETE CASCADE NOT NULL,
    tag_id           VARCHAR(255) REFERENCES tag (id) ON DELETE CASCADE  NOT NULL,
    version          BIGINT                                              NOT NULL,
    creation_date    TIMESTAMP                                           NOT NULL,
    last_update_date TIMESTAMP                                           NOT NULL,
    UNIQUE (work_id, tag_id)
);