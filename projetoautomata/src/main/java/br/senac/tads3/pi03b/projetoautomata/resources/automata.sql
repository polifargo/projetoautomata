CREATE TABLE clientes (
    ID INT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(255) NOT NULL,
    tipo VARCHAR(255),
    cadastronacional VARCHAR(255),
    endereco VARCHAR(255),
    email VARCHAR(255),
    telefone VARCHAR(255),
    PRIMARY KEY (ID)
);

CREATE TABLE servicos (
    ID INT NOT NULL AUTO_INCREMENT,
    descricao VARCHAR(255) NOT NULL,
    tipo VARCHAR(255),
    tecnico VARCHAR(255),
    mediaConclusao VARCHAR(14),
    mediaHoras VARCHAR(14),
    valor FLOAT,
    PRIMARY KEY (ID)
);


CREATE TABLE produtos (
    ID INT NOT NULL AUTO_INCREMENT,
    modelo VARCHAR(255) NOT NULL,
    qtminima INTEGER,
    qtmaxima INTEGER,
    unidade VARCHAR(255),
    tipo VARCHAR(255),
    valor FLOAT,
    PRIMARY KEY (ID)
);