CREATE TABLE items IF NOT EXISTS
(
    id      serial primary key,
    name    text,
    created timestamp
);