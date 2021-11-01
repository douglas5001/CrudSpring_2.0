CREATE TABLE cliente(
  id_cliente bigint not null auto_increment,
  nome varchar(50) not null,
  cpf varchar(20) not null,
  email varchar(50) not null,
  primary key(id_cliente)
);
