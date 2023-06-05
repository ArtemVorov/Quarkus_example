DROP TABLE IF EXISTS games;
DROP TABLE IF EXISTS platforms;

DROP SEQUENCE IF EXISTS global_seq_platforms;
DROP SEQUENCE IF EXISTS global_seq_games;

CREATE SEQUENCE global_seq_platforms START 1000;
CREATE SEQUENCE global_seq_games START 1000;

CREATE TABLE platforms
(
    id          BIGINT PRIMARY KEY DEFAULT nextval('global_seq_platforms'),
    name        VARCHAR(255) NOT NULL unique
);

CREATE TABLE games
(
    id         BIGINT PRIMARY KEY DEFAULT nextval('global_seq_games'),
    platform_id BIGINT NOT NULL,
    url      VARCHAR(255) NOT NULL,
    name     VARCHAR(255) NOT NULL,
    FOREIGN KEY (platform_id) REFERENCES platforms (id) ON DELETE CASCADE
);

INSERT INTO public.platforms (id, name) VALUES (DEFAULT, 'platform1');
INSERT INTO public.games (id, platform_id, url, name) VALUES (DEFAULT, 1000, '/game/get', 'game1')