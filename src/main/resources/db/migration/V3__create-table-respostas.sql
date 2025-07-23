CREATE TABLE respostas (
    id bigint not null auto_increment,
    mensagem text not null,
    data_criacao datetime not null,
    topico_id bigint not null,
    autor_id bigint not null,

    primary key (id),
    constraint fk_resposta_topico_id foreign key (topico_id) references topicos(id),
    constraint fk_resposta_autor_id foreign key (autor_id) references usuarios(id)
);
