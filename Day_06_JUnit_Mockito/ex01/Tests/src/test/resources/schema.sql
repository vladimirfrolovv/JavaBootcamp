DROP SCHEMA if exists tests cascade;
DROP TABLE if exists tests.product;

CREATE SCHEMA if not exists tests;
CREATE TABLE IF NOT EXISTS tests.product
(
    id   INT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    cost INT          NOT NULL
);