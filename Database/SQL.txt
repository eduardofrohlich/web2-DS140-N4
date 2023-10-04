CREATE TABLE Endereco (
	idEndereco SERIAL,
	estado VARCHAR(2),
	cidade VARCHAR(30),
	cep VARCHAR(8),
	rua VARCHAR(50),
	numero INT,
	bairro VARCHAR(20),
	CONSTRAINT pk_Endereco PRIMARY KEY (idEndereco)
);

CREATE TABLE Cliente (
	idCliente SERIAL,
	FK_idEndereco INT,
	senha VARCHAR(100),
	email VARCHAR(50) UNIQUE,
	nome VARCHAR(100),
	cpf VARCHAR(11) UNIQUE,
	telefone VARCHAR(9),
	CONSTRAINT pk_Cliente PRIMARY KEY (idCliente),
	CONSTRAINT fk_Cliente FOREIGN KEY (FK_idEndereco) REFERENCES Endereco (idEndereco)
);

CREATE TABLE Funcionario (
	idFuncionario SERIAL,
	FK_idEndereco INT,
	senha VARCHAR(100),
	email VARCHAR(50) UNIQUE,
	nome VARCHAR(100),
	cpf VARCHAR(11) UNIQUE,
	telefone VARCHAR(9),
	dataNascimento VARCHAR(10),
	CONSTRAINT pk_Funcionario PRIMARY KEY (idFuncionario),
	CONSTRAINT fk_Funcionario FOREIGN KEY (FK_idEndereco) REFERENCES Endereco (idEndereco)
);

CREATE TABLE Roupa (
	idRoupa SERIAL,
	nomeRoupa VARCHAR(30),
	valor DOUBLE PRECISION,
	prazo INT,
	imagem VARCHAR(50),
	CONSTRAINT pf_Roupa PRIMARY KEY (idRoupa)
);

CREATE TABLE Pedido (
	idPedido SERIAL,
	FK_idCliente INT,
	estado INT,
	valorTotal DOUBLE PRECISION,
	prazoEntrega INT,
	dataHora VARCHAR(25),
	CONSTRAINT pk_Pedido PRIMARY KEY (idPedido),
	CONSTRAINT fk_Pedido FOREIGN KEY (FK_idCliente) REFERENCES Cliente (idCliente)
);

CREATE TABLE RoupasPedido (
	FK_idPedido INT,
	FK_idRoupa INT,
	qtdRoupa INT,
	valorTotalRoupa DOUBLE PRECISION,
	CONSTRAINT pk_RoupasPedido PRIMARY KEY (FK_idPedido, FK_idRoupa),
	CONSTRAINT fk1_RoupasPedido FOREIGN KEY (FK_idPedido) REFERENCES Pedido (idPedido),
	CONSTRAINT fk2_RoupasPedido FOREIGN KEY (FK_idRoupa) REFERENCES Roupa (idRoupa)
);


/* Insert padrão */
INSERT INTO Endereco(estado, cidade, cep, rua, numero, bairro)
VALUES ('PR', 'Cidade A', '11111111', 'Rua A', 1, 'Bairro A'),
('SC', 'Cidade B', '22222222', 'Rua B', 2, 'Bairro B'),
('AC', 'Cidade C', '33333333', 'Rua C', 3, 'Bairro C'),
('BA', 'Cidade D', '44444444', 'Rua D', 4, 'Bairro D'),
('ES', 'Cidade E', '55555555', 'Rua E', 5, 'Bairro E');

INSERT INTO Funcionario(FK_idEndereco, senha, email, nome, cpf, telefone, dataNascimento)
VALUES (1, 'IlWMzrrN3s24U40G+N6ph99PVHPwdFmQiDbyM6VFmnk=', 'func1@ufpr.br', 'Maria', '11122233344', '11112222', '01/01/2001'),
(2, 'eySVyBVanShC5JaJQ6NhHbY3wQAFfQ2G2ZsRiC5x3kc=', 'func2@ufpr.br', 'Mário', '22233344455', '22223333', '02/02/2002');

INSERT INTO Cliente(FK_idEndereco, senha, email, nome, cpf, telefone)
VALUES (3, 'GvBOBc55VUlXuiOQg4M1nmmXNRW7TtbmVAgaU/Ki2AI=', 'cli1@ufpr.br', 'João', '33344455566', '33334444'),
(4, 'HsBSAciKvokO22ws44tQR0OMZjfenGHINYZEg4fnM34=', 'cli2@ufpr.br', 'José', '44455566677', '44445555'),
(5, 'ekVM2twH193dg2ggW39O/n3AH04+tvM5oKIeYu9jlnE=', 'cli3@ufpr.br', 'Joana', '55566677788', '55556666'),
(5, '+gmcmGDTgIcoygQIEVjnIpkT1c/Hjq3WxylxkRHI7VE=', 'cli4@ufpr.br', 'Joaquina', '66677788899', '66667777');

// As senhas são, respectivamente, 1111/2222/3333/4444/5555/6666

INSERT INTO Roupa(nomeRoupa, valor, prazo, imagem)
VALUES ('calça', 2.0, 3, 'calca.png'),
('camisa', 1.0, 1, 'camisa.png'),
('camiseta', 1.5, 2, 'camiseta.png'),
('meia', 0.5, 1, 'meia.png'),
('cueca', 0.75, 2, 'cueca.png');

INSERT INTO Pedido(FK_idCliente, estado, valorTotal, prazoEntrega, dataHora)
VALUES (1, 1, 100.1, 1, '01/01/2015 01:01'),
(1, 1, 200.2, 2, '02/02/2015 02:02'),
(1, 1, 300.3, 3, '03/03/2015 03:03'),
(1, 2, 100.4, 1, '04/04/2015 04:04'),
(1, 3, 100.5, 1, '05/05/2015 05:05'),
(1, 4, 100.6, 1, '06/06/2015 06:06'),
(1, 4, 200.7, 2, '07/07/2015 07:07'),
(1, 7, 100.8, 1, '08/08/2015 08:08'),
(1, 7, 200.9, 2, '09/09/2015 09:09'),
(2, 1, 100.1, 1, '10/10/2015 10:10'),
(2, 5, 100.2, 1, '11/11/2015 11:11'),
(2, 5, 200.3, 2, '12/12/2015 12:12'),
(2, 6, 100.4, 1, '01/01/2016 13:13'),
(2, 7, 100.5, 1, '02/02/2016 14:14'),
(2, 7, 200.6, 2, '03/03/2016 15:15'),
(3, 4, 100.7, 1, '04/04/2016 16:16'),
(3, 5, 100.8, 1, '05/05/2016 17:17'),
(3, 5, 200.9, 2, '06/06/2016 18:18'),
(3, 6, 100.1, 1, '07/07/2016 19:19'),
(3, 6, 200.2, 2, '08/08/2016 20:20'),
(3, 7, 100.3, 1, '09/09/2016 21:21'),
(3, 7, 200.4, 2, '10/10/2016 22:22'),
(3, 7, 300.5, 3, '11/11/2016 23:23'),
(4, 4, 100.6, 1, '12/12/2016 01:01'),
(4, 4, 200.7, 2, '01/01/2017 02:02'),
(4, 5, 100.8, 1, '02/02/2017 03:03'),
(4, 6, 100.9, 1, '03/03/2017 04:04'),
(4, 6, 200.1, 2, '04/04/2017 05:05'),
(4, 7, 100.2, 1, '05/05/2017 06:06'),
(4, 7, 200.3, 2, '06/06/2017 07:07');

INSERT INTO RoupasPedido(FK_idPedido, FK_idRoupa, qtdRoupa, valorTotalRoupa)
VALUES (1, 1, 3, 10.0),
(1, 2, 3, 20.0),
(1, 3, 3, 30.0),
(1, 4, 3, 40.0),
(2, 1, 2, 20.0),
(2, 2, 3, 40.0),
(2, 5, 7, 100.0),
(3, 3, 12, 200.0),
(4, 1, 3, 20.0),
(4, 3, 5, 50.0),
(5, 4, 2, 20.0),
(5, 2, 7, 70.0),
(5, 5, 5, 50.0),
(6, 1, 10, 100.0),
(7, 2, 7, 70.0),
(8, 5, 2, 50.0),
(8, 2, 4, 40.0),
(9, 1, 5, 35.0),
(10, 4, 6, 31.0),
(11, 2, 5, 50.0),
(12, 3, 2, 20.0),
(12, 5, 5, 53.0),
(13, 1, 12, 200.0),
(14, 3, 5, 23.30),
(14, 4, 7, 51.51),
(15, 1, 1, 10.0),
(16, 3, 6, 63.31),
(16, 5, 7, 31.13),
(16, 4, 3, 13.0),
(17, 2, 4, 31.3),
(18, 4, 4, 54.4),
(18, 1, 3, 10.0),
(18, 2, 4, 23.0),
(19, 5, 3, 20.50),
(20, 1, 4, 40.0),
(21, 2, 7, 31.45),
(22, 3, 5, 34.12),
(23, 4, 1, 0.45),
(24, 5, 4, 2.75),
(25, 1, 4, 56.0),
(25, 3, 4, 56.0),
(25, 5, 4, 56.0),
(26, 2, 4, 41.0),
(26, 4, 4, 41.0),
(27, 1, 13, 89.31),
(27, 5, 12, 41.41),
(28, 2, 7, 12.12),
(28, 3, 7, 13.13),
(28, 4, 7, 14.14),
(29, 5, 12, 41.42),
(29, 1, 1, 0.34),
(30, 4, 4, 4.44);