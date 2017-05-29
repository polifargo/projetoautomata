create Table Clientes (
id int not null generated always as identity (start with 1, increment by 1),
nome varchar(120),
apelido varchar(60),
sexo char(20),
tipo char(1),
uf char(2),
Cep varchar(9),
Cidade varchar(60),
Logradouro varchar(60),
Bairro varchar(60),
Email varchar(80),
Telefone varchar(14),
NotasInternas varchar(1000),
Inativo integer,
CadastroNacional varchar(18),
PRIMARY KEY (id)
);

create table Produtos(
id char(15) not null,
modelo varchar(60),
unidade varchar(30),
ValorVenda numeric(14,2),
ValorCusto numeric(14,2),
NotasInternas varchar(1000),
Inativo integer,
Primary Key (id)
);

create table Venda(
id int not null generated always as identity (start with 1, increment by 1),
idCliente int not null,
idUnidade char(3),
FormaPagamento varchar(30),
Data date,
Valor numeric(14,2),
NotasInternas varchar(1000),
primary key (id),
FOREIGN KEY (idCliente) REFERENCES Clientes (id),
FOREIGN KEY (idUnidade) REFERENCES Unidades (id)
);

create table ItensVenda(
id int not null generated always as identity (start with 1, increment by 1),
idProduto char(15) not null,
idVenda int not null,
QtVendida int,
ValorTotal numeric(14,2),
ValorUnitario numeric(14,2),
primary key (id),
FOREIGN KEY (idProduto) REFERENCES Produtos (id),
FOREIGN KEY (idVenda) REFERENCES Venda(id)
);

create table TipoServico(
id integer not null,
Descricao varchar(60),
NotasInternas varchar(1000),
Primary Key (id)
);

create table Servicos(
id char(15) not null,
descricao varchar(60),
tipo varchar(30),
valor numeric(14,2),
NotasInternas varchar(1000),
Inativo integer,
Primary Key (id)
);

create table Tecnico(
id integer not null,
NomeTecnico varchar(30),
TipoServPreferencial int,
PRIMARY KEY (id),
FOREIGN KEY (TipoServPreferencial) REFERENCES TipoServico (id)
);

create table ServicoPrestado(
id int not null generated always as identity (start with 1, increment by 1),
idCliente int not null,
FormaPagamento varchar(30),
DataSolicitado date,
ValorTotal numeric(14,2),
ValorDesconto numeric (14,2),
NotasInternas varchar(1000),
primary key (id),
FOREIGN KEY (idCliente) REFERENCES Clientes (id)
);

create table ItensServico(
id int not null generated always as identity (start with 1, increment by 1),
idTecnico integer,
idServico char(15) not null,
idServicoPrestado integer,
DataServico date,
idVenda int not null,
ValorTotal numeric(14,2),
ValorUnitario numeric(14,2),
primary key (id),
FOREIGN KEY (idServico) REFERENCES Servicos (id),
FOREIGN KEY (idTecnico) REFERENCES Tecnico (id),
FOREIGN KEY (idServicoPrestado) REFERENCES ServicoPrestado (id)
);

create table Usuarios(
id int not null generated always as identity (start with 1, increment by 1),
nome varchar(30) not null,
login varchar(30) not null,
senha varchar(15) not null,
papel varchar(10) not null,
email varchar(30),
primary key (id)
);

create table Unidades(
id char(3) not null,
fantasia varchar(40),
razao varchar(80),
uf char(2),
Cep varchar(9),
Cidade varchar(60),
Logradouro varchar(60),
Bairro varchar(60),
Email varchar(80),
Telefone varchar(14),
NotasInternas varchar(1000),
Inativo integer,
CadastroNacional varchar(18),
primary key (id)
);

create table Saldo(
id integer not null generated always as identity (start with 1, increment by 1),
idUnidade char(3) not null,
idProduto char(15) not null,
quantidade integer not null,
qtMinina integer,
qtMaxima integer,
primary key (id),
FOREIGN KEY (idUnidade) REFERENCES Unidades (id),
FOREIGN KEY (idProduto) REFERENCES Produtos (id)
);

create table Entrada(
id integer not null generated always as identity (start with 1, increment by 1),
idProduto char(15) not null,
idUnidade char(3) not null,
dataEntrada date,
quantidade integer not null,
primary key (id),
FOREIGN KEY (idUnidade) REFERENCES Unidades (id),
FOREIGN KEY (idProduto) REFERENCES Produtos (id)
);