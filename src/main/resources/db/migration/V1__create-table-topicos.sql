create table topicos(
    id bigint not null auto_increment,
    titulo varchar(100) not null unique,
    mensaje varchar(250) not null unique,
    fecha_creacion DATE not null,
    status_topico varchar(100) not null,
    usuario_id BIGINT NOT NULL,
    curso_id BIGINT not null,
    primary key(id)
);