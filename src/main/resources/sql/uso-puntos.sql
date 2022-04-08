create table public.uso_puntos
(
    id                integer primary key,
    usuario_id        integer,
    puntaje_utilizado integer,
    fecha             date,
    concepto_uso_id   integer,
    constraint fk_usuarios foreign key (usuario_id) REFERENCES usuarios (id),
    constraint fk_conceptos foreign key (concepto_uso_id) REFERENCES  concepto_uso_puntos(id)
);

create table public.detalle_uso_puntos
(
    id                integer primary key,
    uso_puntos_id     integer,
    puntaje_utilizado integer,
    bolsa_id          integer,
    constraint fk_uso_puntos foreign key (uso_puntos_id) references public.uso_puntos(id),
    constraint fk_bolsa_puntos foreign key (bolsa_id) references public.bolsa (id_bolsa)
);

create sequence public.uso_puntos_sec;
create sequence public.detalle_puntos_sec;