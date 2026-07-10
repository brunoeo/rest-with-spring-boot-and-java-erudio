
-- Criação do banco de dados (opcional, dependendo da configuração do Flyway)
-- CREATE DATABASE IF NOT EXISTS erudio;

CREATE TABLE person (
                        id BIGINT PRIMARY KEY AUTO_INCREMENT,
                        first_name VARCHAR(255) NOT NULL,
                        last_name VARCHAR(255) NOT NULL,
                        address VARCHAR(500),
                        gender VARCHAR(50)
);

