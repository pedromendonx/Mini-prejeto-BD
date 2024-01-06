DROP DATABASE IF EXISTS 20211164010033_miniProjeto;
CREATE DATABASE 20211164010033_miniProjeto;

use 20211164010033_miniProjeto;

create table paciente (
	id int primary key auto_increment not null,
    nome varcharacter(150) not null,
    cpf char(14) unique not null,
    doenca varchar(50) not null
);

create table medico (
	id int primary key auto_increment not null,
    nome varcharacter(150) not null,
    matricula int unique not null,
    especialidade varchar(50) not null,
    salario decimal(6,2) not null
);

create table consulta (
	id_medico int not null,
    id_paciente int not null,
    horario datetime not null,
    valor decimal(5,2) not null,
	
    primary key (id_medico, id_paciente, horario),
    foreign key (id_medico) references medico(id) on delete restrict on update cascade,
    foreign key (id_paciente) references paciente(id) on delete restrict on update cascade
); 

select * from medico;
select * from paciente;
select * from consulta;