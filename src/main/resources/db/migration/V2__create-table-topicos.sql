create table topicos (

    id bigint not null auto_increment,
    titulo varchar(100) not null,
    mensagem text not null,
    data_criacao datetime not null,
    estado_topico varchar(20) not null,
    autor_id bigint not null,
    curso varchar(100) not null,

    primary key(id),
    foreign key (autor_id) references usuarios(id)
);
