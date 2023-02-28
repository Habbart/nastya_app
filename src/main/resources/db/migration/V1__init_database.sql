CREATE TABLE IF NOT EXISTS social_network
(
    id          SERIAL PRIMARY KEY,
    description TEXT NOT NULL,
    url         TEXT NOT NULL
);

CREATE TABLE IF NOT EXISTS role
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(30) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS title_image
(
    id   VARCHAR(255) PRIMARY KEY,
    path TEXT NOT NULL
);

CREATE TABLE IF NOT EXISTS work
(
    id             VARCHAR(255) PRIMARY KEY,
    title          VARCHAR(255) NOT NULL,
    url            TEXT,
    title_image_id VARCHAR(255) REFERENCES title_image(id) UNIQUE
);

CREATE TABLE IF NOT EXISTS image
(
    id      VARCHAR(255) PRIMARY KEY,
    path    TEXT NOT NULL,
    work_id VARCHAR(255) REFERENCES work (id)
);

CREATE TABLE IF NOT EXISTS topic
(
    id      VARCHAR(255) PRIMARY KEY,
    name    VARCHAR(50)                       NOT NULL,
    work_id VARCHAR(255) REFERENCES work (id) NOT NULL
);

CREATE TABLE IF NOT EXISTS users
(
    id       SERIAL PRIMARY KEY,
    name     VARCHAR(50)                    NOT NULL,
    login    VARCHAR(50)                    NOT NULL UNIQUE,
    password VARCHAR(50)                    NOT NULL,
    role_id  INT REFERENCES users (id) NOT NULL
);