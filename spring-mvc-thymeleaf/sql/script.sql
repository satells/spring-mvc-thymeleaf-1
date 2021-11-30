drop table if exists funcionarios;
drop table if exists enderecos;
drop table if exists cargos;
drop table if exists departamentos;


create table departamentos(
	id 		serial not null,
	nome 		varchar(60) not null,
	primary key	(id)
);

create table cargos (
	id 		serial not null,
	nome 		varchar(60) not null,
	departamento_id	int not null references departamentos,
	primary key	(id)
);


create table enderecos(
	id 		serial not null,
	bairro		varchar (255),
	cep 		varchar(9) not null,
	cidade		varchar(255) not null,
	complemento	varchar(255) not null,
	logradouro 	varchar(255) not null,
	numero		int not null,
	uf		varchar(2) not null,
	primary key	(id)

);

create table funcionarios(
	id 		serial not null,
	dataeentrada	date not null,
	datasaida 	date,
	nome 		varchar(255) not null,
	salario 	decimal not null,
	cargo_id 	int not null references cargos,
	endereco_id	int not null references enderecos,
	primary key	(id)

);
