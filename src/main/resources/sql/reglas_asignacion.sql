CREATE TABLE public.REGLA_ASIGNACION_PUNTOS(
    id integer primary key,
    limite_inferior integer,
    limite_superior integer,
    equivalencia integer
);

create sequence public.regla_asignacion_puntos_seq;