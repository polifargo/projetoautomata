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