create Table Clientes (
id int not null primary key AUTO_INCREMENT,
nome varchar(120),
apelido varchar(60),
sexo char(20),
tipo char(1),
uf char(2),
Cep numeric(8),
Cidade varchar(60),
Logradouro varchar(60),
Bairro varchar(60),
Email varchar(80),
Telefone numeric(14),
NotasInternas varchar(1000),
Inativo integer,
CadastroNacional char(18)
);

create table Produtos(
CodigoProduto char(15) not null,
modelo varchar(60),
unidade varchar(30),
ValorVenda numeric(14,2),
ValorCusto numeric(14,2),
NotasInternas varchar(1000),
Inativo integer,
Primary Key (id)
);

create table Venda(
CodigoVenda int not null generated always as identity (start with 1, increment by 1),
CodigoCliente int not null,
FormaPagamento varchar(30),
DataVenda date,
ValorVenda numeric(14,2),
ValorDesconto numeric (14,2),
NotasInternas varchar(1000),
primary key (CodigoVenda),
FOREIGN KEY (CodigoCliente) REFERENCES Cliente (CodigoCliente)
);

create table ItensVenda(
CodigoMovimento int not null generated always as identity (start with 1, increment by 1),
CodigoProduto char(15) not null,
CodigoVenda int not null,
QtVendida int,
ValorTotal numeric(14,2),
ValorUnitario numeric(14,2),
primary key (CodigoMovimento),
FOREIGN KEY (CodigoProduto) REFERENCES Produto (CodigoProduto),
FOREIGN KEY (CodigoVenda) REFERENCES Venda (CodigoVenda)
);

create table TipoServico(
CodigoTipoServ integer not null,
Descricao varchar(60),
NotasInternas varchar(1000),
Primary Key (CodigoTipoServ)
);

create table Servicos(
CodigoServico char(15) not null,
Descricao varchar(60),
TipoServico varchar(30),
ValorPrestado numeric(14,2),
NotasInternas varchar(1000),
Inativo integer,
Primary Key (CodigoServico)
);

create table Tecnico(
Codigo varchar(8) not null,
NomeTecnico varchar(30),
TipoServPreferencial int,
FOREIGN KEY (TipoServPreferencial) REFERENCES TipoServico (CodigoTipoServ)
);

create table ServicoPrestado(
Codigo int not null generated always as identity (start with 1, increment by 1),
CodigoCliente int not null,
FormaPagamento varchar(30),
DataSolicitado date,
ValorTotal numeric(14,2),
ValorDesconto numeric (14,2),
NotasInternas varchar(1000),
primary key (Codigo),
FOREIGN KEY (CodigoCliente) REFERENCES Cliente (CodigoCliente)
);

create table ItensServico(
CodigoMovimento int not null generated always as identity (start with 1, increment by 1),
TecnicoServico integer,
CodigoServico char(15) not null,
DataServico date,
CodigoVenda int not null,
ValorTotal numeric(14,2),
ValorUnitario numeric(14,2),
primary key (CodigoMovimento),
FOREIGN KEY (CodigoServico) REFERENCES Servico (CodigoServico),
FOREIGN KEY (TecnicoServico) REFERENCES Cliente (TecnicoServico)
);

create table Usuarios(
id int not null AUTO_INCREMENT,
nome varchar(30) not null,
login varchar(30) not null,
senha varchar(15) not null,
papel varchar(10) not null,
email varchar(30),
primary key (id)
);

create table Unidades(
codigoUnidade varchar(3) not null,
fantasia varchar(40),
razaoSocial varchar(80),
uf char(2),
Cep numeric(8),
Cidade varchar(60),
Logradouro varchar(60),
Bairro varchar(60),
Email varchar(80),
Telefone numeric(14),
NotasInternas varchar(1000),
Inativo integer,
CadastroNacional char(18),
primary key (codigoUnidade)
);

create table Saldo(
codigoUnidade varchar(3) not null,
codigoProduto char(15) not null,
quantidade integer not null,
FOREIGN KEY (CodigoUnidade) REFERENCES Unidade (CodigoUnidade),
FOREIGN KEY (codigoProduto) REFERENCES Produto (codigoProduto)
);


insert into Usuarios values (2, 'Retaguarda', 'retaguarda', 'retaguarda', 'BASICO', 'retaguarda@automata.com');
