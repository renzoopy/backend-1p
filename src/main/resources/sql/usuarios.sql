CREATE TABLE PUBLIC.USUARIOS
(
    id               integer primary key,
    nombre           varchar,
    apellido         varchar,
    numero_documento varchar,
    tipo_documento   varchar,
    nacionalidad     varchar,
    email            varchar,
    telefono         varchar,
    fecha_nacimiento date
)

CREATE SEQUENCE PUBLIC.USUARIO_ID_SEQ;