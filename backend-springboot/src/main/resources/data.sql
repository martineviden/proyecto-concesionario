-- USUARIOS
INSERT INTO usuario (usuario_id, nombre, apellidos, correo, contrasena, telefono, foto_perfil, rol) VALUES
    (1, 'Carlos', 'Gomez', 'carlos@example.com', '1234', '600123456', NULL, 'CLIENTE');
INSERT INTO usuario (usuario_id, nombre, apellidos, correo, contrasena, telefono, foto_perfil, rol) VALUES
    (2, 'Laura', 'Martinez', 'laura@example.com', '1234', '600654321', NULL, 'CLIENTE');
INSERT INTO usuario (usuario_id, nombre, apellidos, correo, contrasena, telefono, foto_perfil, rol) VALUES
    (3, 'Admin', 'Admin', 'admin@concesionario.com', 'admin', '600000000', NULL, 'ADMIN');

-- COCHES
INSERT INTO coche (coche_id, marca, modelo, ano, precio_por_dia, disponible, color, kilometraje, matricula, tipo, imagen, transmision) VALUES
    (1, 'Toyota', 'Corolla', 2020, 15.00, true, 'Rojo', 45000, '1234ABC', 'Sedan', NULL, 'AUTOMATICA');
INSERT INTO coche (coche_id, marca, modelo, ano, precio_por_dia, disponible, color, kilometraje, matricula, tipo, imagen, transmision) VALUES
    (2, 'BMW', 'Serie 3', 2022, 25.00, true, 'Negro', 15000, '5678DEF', 'Sedan', NULL, 'MANUAL');

-- MOTOS
INSERT INTO moto (moto_id, marca, modelo, ano, precio_por_dia, disponible, color, kilometraje, matricula, tipo, imagen, transmision) VALUES
    (1, 'Yamaha', 'MT-07', 2021, 10.00, true, 'Azul', 10000, 'MOTO123', 'Naked', NULL, 'MANUAL');

-- FURGONETAS
INSERT INTO furgoneta (furgoneta_id, marca, modelo, ano, precio_por_dia, disponible, color, kilometraje, matricula, tipo, imagen, transmision) VALUES
    (1, 'Ford', 'Transit', 2019, 20.00, true, 'Blanca', 60000, 'FURGO456', 'Carga', NULL, 'AUTOMATICA');

-- RESERVAS
INSERT INTO reserva (reserva_id, id_usuario, id_coche, id_moto, id_furgoneta, fecha_reserva, dias_reserva, estado, precio_total) VALUES
    (1, 1, 1, NULL, NULL, '2025-06-01', 3, 'CONFIRMADA', 45.00);
INSERT INTO reserva (reserva_id, id_usuario, id_coche, id_moto, id_furgoneta, fecha_reserva, dias_reserva, estado, precio_total) VALUES
    (2, 2, NULL, 1, NULL, '2025-06-05', 2, 'PENDIENTE', 10.00);
INSERT INTO reserva (reserva_id, id_usuario, id_coche, id_moto, id_furgoneta, fecha_reserva, dias_reserva, estado, precio_total) VALUES
    (3, 1, NULL, NULL, 1, '2025-06-10', 2, 'CANCELADA', 20.00);

-- RESENAS
INSERT INTO resena (resena_id, id_reserva, texto, puntuacion, fecha) VALUES
    (1, 1, 'Muy buen servicio y atencion.', 5, '2025-06-04');
INSERT INTO resena (resena_id, id_reserva, texto, puntuacion, fecha) VALUES
    (2, 2, 'La moto estaba en perfectas condiciones.', 4, '2025-06-07');
INSERT INTO resena (resena_id, id_reserva, texto, puntuacion, fecha) VALUES
    (3, 3, 'La furgoneta tenia demasiados kilometros.', 3, '2025-06-12');
