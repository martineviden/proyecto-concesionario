
-- USUARIOS
INSERT INTO usuario (id, nombre, apellidos, correo, contraseña, telefono, foto_perfil, rol) VALUES
(1, 'Carlos', 'Gómez', 'carlos@example.com', '1234', '600123456', NULL, 'CLIENTE');
INSERT INTO usuario (id, nombre, apellidos, correo, contraseña, telefono, foto_perfil, rol) VALUES
(2, 'Laura', 'Martínez', 'laura@example.com', '1234', '600654321', NULL, 'CLIENTE');
INSERT INTO usuario (id, nombre, apellidos, correo, contraseña, telefono, foto_perfil, rol) VALUES
(3, 'Admin', 'Admin', 'admin@concesionario.com', 'admin', '600000000', NULL, 'ADMIN');

-- COCHES
INSERT INTO coche (id, marca, modelo, año, precio_por_dia, disponible, color, kilometraje, matricula, tipo, imagen, transmision) VALUES
(1, 'Toyota', 'Corolla', 2020, 15.00, true, 'Rojo', 45000, '1234ABC', 'Sedán', NULL, 'AUTOMATICA');
INSERT INTO coche (id, marca, modelo, año, precio_por_dia, disponible, color, kilometraje, matricula, tipo, imagen, transmision) VALUES
(2, 'BMW', 'Serie 3', 2022, 25.00, true, 'Negro', 15000, '5678DEF', 'Sedán', NULL, 'MANUAL');

-- MOTOS
INSERT INTO moto (id, marca, modelo, año, precio_por_dia, disponible, color, kilometraje, matricula, tipo, imagen, transmision) VALUES
(1, 'Yamaha', 'MT-07', 2021, 10.00, true, 'Azul', 10000, 'MOTO123', 'Naked', NULL, 'MANUAL');

-- FURGONETAS
INSERT INTO furgoneta (id, marca, modelo, año, precio_por_dia, disponible, color, kilometraje, matricula, tipo, imagen, transmision) VALUES
(1, 'Ford', 'Transit', 2019, 20.00, true, 'Blanca', 60000, 'FURGO456', 'Carga', NULL, 'AUTOMATICA');

-- RESERVAS
INSERT INTO reserva (id, id_usuario, id_coche, id_moto, id_furgoneta, fecha_inicio, fecha_final, estado, precio_total) VALUES
(1, 1, 1, NULL, NULL, '2025-06-01', '2025-06-03', 'CONFIRMADA', 45.00);
INSERT INTO reserva (id, id_usuario, id_coche, id_moto, id_furgoneta, fecha_inicio, fecha_final, estado, precio_total) VALUES
(2, 2, NULL, 1, NULL, '2025-06-05', '2025-06-06', 'PENDIENTE', 10.00);
INSERT INTO reserva (id, id_usuario, id_coche, id_moto, id_furgoneta, fecha_inicio, fecha_final, estado, precio_total) VALUES
(3, 1, NULL, NULL, 1, '2025-06-10', '2025-06-11', 'CANCELADA', 20.00);

-- RESEÑAS
INSERT INTO reseña (id, id_usuario, texto, puntuacion, fecha) VALUES
(1, 1, 'Muy buen servicio y atención.', 5, '2025-06-04');
INSERT INTO reseña (id, id_usuario, texto, puntuacion, fecha) VALUES
(2, 2, 'La moto estaba en perfectas condiciones.', 4, '2025-06-07');
INSERT INTO reseña (id, id_usuario, texto, puntuacion, fecha) VALUES
(3, 1, 'La furgoneta tenía demasiados kilómetros.', 3, '2025-06-12');
