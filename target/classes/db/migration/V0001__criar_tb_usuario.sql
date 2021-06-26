CREATE TABLE usuario(
	id int(11) not null auto_increment,
	nome varchar(100) not null,
	email varchar(100) not null unique,
	cpf varchar(11) not null unique,
	data_nascimento date ,
	telefone varchar(20),
	ativo boolean default false,
	senha varchar(500) not null,
	primary key(id)
);