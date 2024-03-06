USE comidasdb;

-- Insertar o actualizar el usuario "Usuario1" con rol 2
INSERT INTO usuarios (id_usuario, rol, pass, nombre, apellido1, apellido2)
VALUES (1, 2, 'password', 'Usuario1', 'Apellido1Usuario1', NULL)
ON DUPLICATE KEY UPDATE rol = 2, pass = 'password', nombre = 'Usuario1', apellido1 = 'Apellido1Usuario1';

-- Insertar o actualizar el usuario "Admin" con rol 1
INSERT INTO usuarios (id_usuario, rol, pass, nombre, apellido1, apellido2)
VALUES (2, 1, 'password', 'Admin', 'Apellido1Admin', NULL)
ON DUPLICATE KEY UPDATE rol = 1, pass = 'password', nombre = 'Admin', apellido1 = 'Apellido1Admin';

-- Insertar o actualizar el registro de comida con id 1
INSERT INTO comida (id_comida, nombre, cantidad) VALUES (1, 'Prueba', 5)
ON DUPLICATE KEY UPDATE nombre = 'Prueba', cantidad = 5;