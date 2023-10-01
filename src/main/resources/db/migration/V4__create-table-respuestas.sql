create table respuestas(

id bigint not null auto_increment,
mensaje varchar(5000) not null,
topico_id BIGINT not null,
fecha_creacion DATE not null,
usuario_id BIGINT NOT NULL,
solucion TINYINT not null,
primary key(id)
);