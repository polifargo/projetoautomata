insert into produtos (inativo, id, modelo, unidade, valorvenda, valorcusto, notasinternas) values (1, 'MEM1','pente memória 8gb dell power edge t610', 'pc', 0, 0, ' ');
insert into produtos (inativo, id, modelo, unidade, valorvenda, valorcusto, notasinternas) values (1, 'HD01', 'hard drive 3tb sata dell power edge 190y', 'pc', 0, 0, ' ');
insert into produtos (inativo, id, modelo, unidade, valorvenda, valorcusto, notasinternas) values (1, 'MEM2', 'memoria dimm - 64mb', 'pc', 0, 0, 'memoria dimm - 64mg');
insert into produtos (inativo, id, modelo, unidade, valorvenda, valorcusto, notasinternas) values (1, 'MON01', 'monitor 15"', 'pc', 984.492000, 856.0800, 'monitor 15"');
insert into produtos (inativo, id, modelo, unidade, valorvenda, valorcusto, notasinternas) values (1, 'MEM3', 'memoria dimm pc133', 'pc', 175.950000, 153, 'memoria dimm 256 pc133');

insert into clientes (inativo, nome, apelido, tipo, uf, cep, cidade, logradouro, bairro, email, telefone) values (1, 'flávia siqueira', 'flávia siqueira', 'f', 'pe', '52070-000', 'recife', 'estrada do encanamento, 1731 - 1101', 'casa forte', 'flaviamichelle@uol.com.br', '30883954');
insert into clientes (inativo, nome, apelido, tipo, uf, cep, cidade, logradouro, bairro, email, telefone) values (1, 'josé carlos santana de souza', 'josé carlos santana', 'f', 'pe', '50740-520', 'recife', 'avenida professor artur de sá, 1190-a -', 'cidade universitária', 'carlos-morrison@hotmail.com', '99695946');
insert into clientes (inativo, nome, apelido, tipo, uf, cep, cidade, logradouro, bairro, email, telefone) values (1, 'leandro escobar', 'leandro escobar', 'f', 'sp', '01452-001', 'são paulo', 'avenida brigadeiro faria lima, 1663 - 1º andar', 'jardim paulistano', 'leandroescobar@cetip.com.br', '31111962');
insert into clientes (inativo, nome, apelido, tipo, uf, cep, cidade, logradouro, bairro, email, telefone) values (1, 'aline domingues lorusso', 'aline domingues loru', 'f', 'sp', '12233-002', 'são josé dos campos', 'avenida cidade jardim, 3141 - casa 102', 'bosque dos eucaliptos', 'li_lorusso@hotmail.com', '39361833');
insert into clientes (inativo, nome, apelido, tipo, uf, cep, cidade, logradouro, bairro, email, telefone) values (1, 'renato garcia gil', 'renato garcia gil', 'f', 'rs', '06070-130', 'porto alegre', 'rua joaquim jacinto, 120 -', 'bela vista', 'rggil@uol.com.br', '1198982858');
insert into clientes (inativo, nome, apelido, tipo, uf, cep, cidade, logradouro, bairro, email, telefone) values (1, 'antonio denisson martins barbosa', 'antonio denisson mar', 'j', 'rs', '14784-200', 'porto alegre', 'via conselheiro antonio prado, 1400 - dep. financeiro', 'pedro cavalini', 'denisson_445@hotmail.com', '1778123731');

insert into Unidades (inativo, id, fantasia, razao, uf, cidade, logradouro, bairro, CadastroNacional) values (1, 'ESP', 'Unidade SP', 'UNIDADE DE SÃO PAULO LTDA', 'SP', 'SÃO PAULO', 'AV PAULISTA, 2002', 'CERQUEIRA CESAR', '56.259.656/0001-88');
insert into Unidades (inativo, id, fantasia, razao, uf, cidade, logradouro, bairro, CadastroNacional) values (1, 'EPE', 'Unidade PE', 'UNIDADE DE PERNAMBUCO LTDA', 'PE', 'PERNAMBUCO', 'AV PERNAMBUCANA, 564', 'PANELAS', '56.259.656/0002-69');
insert into Unidades (inativo, id, fantasia, razao, uf, cidade, logradouro, bairro, CadastroNacional) values (1, 'ERS', 'Unidade RS', 'UNIDADE DO RIO GRANDE DO S LTDA', 'RS', 'RIO GRANDE DO S', 'AV RIO GRANDE, 22', 'FLORIPA', '56.259.656/0003-40');

insert into TipoServico (id, Descricao) values (1, 'Conserto de notebooks');
insert into TipoServico (id, Descricao) values (2, 'Upgrade equipamento');
insert into TipoServico (id, Descricao) values (3, 'Upgrade software');

insert into Tecnico(id, NomeTecnico, TipoServPreferencial) values (1, 'Renato', 3);
insert into Tecnico(id, NomeTecnico, TipoServPreferencial) values (2, 'Carlos', 1);
insert into Tecnico(id, NomeTecnico, TipoServPreferencial) values (3, 'Vitor', 2);

insert into Servicos (inativo, id, descricao, tipo, valor) values (1, '1', 'Conserto de tela', '1', 350.00 );
insert into Servicos (inativo, id, descricao, tipo, valor) values (1, '2', 'Aumento de memória RAM', '2', 450.00 );
insert into Servicos (inativo, id, descricao, tipo, valor) values (1, '3', 'Atualização versão Windows', '3', 60.00 );
