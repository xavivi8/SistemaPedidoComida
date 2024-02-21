CREATE DATABASE IF NOT EXISTS ComidasDB;
USE ComidasDB;

CREATE TABLE IF NOT EXISTS comida (
    id_comida INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(250),
    cantidad INT CHECK (cantidad >= 0)
);

CREATE TABLE IF NOT EXISTS usuarios (
    id_usuario INT AUTO_INCREMENT PRIMARY KEY,
    rol INT,
    nombre VARCHAR(250) NOT NULL,
    apellido1 VARCHAR(250) NOT NULL,
    apellido2 VARCHAR(250)
);