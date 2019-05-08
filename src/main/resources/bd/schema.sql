CREATE DATABASE IF NOT EXISTS pricing;
CREATE TABLE Client
(
    id INT PRIMARY KEY NOT NULL,
    ip VARCHAR(100),
    idcr int foreing key not null
)