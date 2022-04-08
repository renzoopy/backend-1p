create table public.parametrizacion_puntos(
    id integer not null,
    fecha_inicio date not null,
    fecha_fin date not null,
    duracion integer not null,
    constraint parametrizacion_key primary key(id)
);

create sequence public.parametrizacion_sec;