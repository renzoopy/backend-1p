create table public.concepto_uso_puntos (
    id integer primary key,
    descripcion character varying(150) not null,
    puntos_requeridos integer not null
);
create sequence public.concepto_uso_puntos_sec;
