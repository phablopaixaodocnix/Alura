insert into aluno (
	nome,
	cpf,
	"observação",
	idade,
	dinheiro,
	altura,
	ativo,
	data_nascimento,
	hora_aula,
	matriculado_em)
VALUES (
	'phablo',
	70778358127,
	'alkbfwafghasdvnoçasncvwipasjdfçljsandv  vasdokdnv asdvjbaskhv sadv asdv lçsadhsadh839hfbs vophw2348yrfbsd9fv awsv9uw2fb as0d a9s8yvc98safpw ',
	21,
	0,
	1.90,
	false,
	'1996-12-02',
	'17:30:00',
	'2001-08-06 15:30'
	); 
	
UPDATE aluno 
	set nome = 'pedro' 
	WHERE id = 1;
	
delete from aluno WHERE nome = 'pedro';
select id, nome as Nome from aluno;

insert into aluno (nome) values ('lucas');
insert into aluno (nome) values ('pap');
insert into aluno (nome) values ('pep');
insert into aluno (nome) values ('pip');

select * from aluno WHERE cpf is not null;


create table alunoSimples(id serial primary key, nome varchar(100));
insert into alunoSimples(nome) values ('pablo');
select * from alunoSimples;

create table aluno_curso(aluno_id integer,
						 curso_id integer,
						 primary key(aluno_id,curso_id),
						 foreign key (aluno_id) references alunosimples(id),
						 foreign key (curso_id) references cursos(id));

