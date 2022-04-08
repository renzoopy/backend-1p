create table public.bolsa (
    id_bolsa integer not null,
    id_usuario integer not null,
    fecha_asignacion date not null,
    fecha_caducidad date not null,
    puntaje_asignado integer not null,
    puntaje_utilizado integer not null,
    saldo integer not null,
    monto integer not null,
    constraint bolsa_key primary key(id_bolsa),
    constraint fk_1 foreign key (id_usuario)
        references public.usuarios (id) match simple
        on update no action
        on delete no action
);
create sequence public.bolsa_sec;