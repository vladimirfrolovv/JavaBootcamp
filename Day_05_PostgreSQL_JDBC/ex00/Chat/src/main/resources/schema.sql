DROP SCHEMA IF EXISTS chat CASCADE;

CREATE SCHEMA IF NOT EXISTS chat;

CREATE TABLE IF NOT EXISTS chat.users
(
    id       SERIAL PRIMARY KEY,
    login    TEXT NOT NULL,
    password TEXT
);

CREATE TABLE IF NOT EXISTS chat.room
(
    id           SERIAL PRIMARY KEY,
    chat_name    TEXT    NOT NULL,
    chat_creator INTEGER NOT NULL,
    CONSTRAINT fk_chat_creator FOREIGN KEY (chat_creator) REFERENCES chat.users (id)
);
CREATE TABLE IF NOT EXISTS chat.message
(
    id           SERIAL PRIMARY KEY,
    sender       INTEGER NOT NULL,
    room_id      INTEGER NOT NULL,
    text_message TEXT,
    time         TIMESTAMP,
    CONSTRAINT fk_room_id FOREIGN KEY (room_id) REFERENCES chat.room (id),
    CONSTRAINT fk_sender FOREIGN KEY (sender) REFERENCES chat.users (id)
);

