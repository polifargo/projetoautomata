-- !!! SCRIPT CONTÉM ERROS
CREATE TRIGGER atusaldo BEFORE INSERT ON itemvenda FOR EACH ROW BEGIN
	Declare Saldo integer;
	
	Select quantidade
		From Estoque
		Where (idUnidade = New.idUnidade) and (idProduto = New.idProduto)
		Order By idUnidade, idProduto Desc
		Limit 0, 1
		Into SaldoAnterior;
	IF SaldoAnterior = NULL THEN
		SET SaldoAnterior = 0;
	END 
	SET New.quantidade = SaldoAnterior - New.QtdeMov;
END;

 CREATE TRIGGER atusaldo BEFORE INSERT ON Produto FOR EACH ROW BEGIN
	Declare Saldo integer;
	
	insert into Saldo(idUnidade, idProduto, quantidade) values (New.idUnidade,New.idProduto,0)
	
END;
