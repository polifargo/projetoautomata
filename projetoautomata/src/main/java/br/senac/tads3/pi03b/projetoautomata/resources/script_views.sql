CREATE VIEW MOVIMENTOS AS (
select
        ite.idproduto,
        ven.idunidade,
        ite.qtvendida * -1 AS quantidade

        from itensvenda ite
        left join venda ven on ven.id = ite.idvenda
       
        union 

        SELECT 
        IDPRODUTO,
        IDUNIDADE,
        QUANTIDADE
         FROM ENTRADA
        );

CREATE VIEW SALDOS AS (
SELECT 
    IDPRODUTO,
    IDUNIDADE,
    SUM(QUANTIDADE) QUANTIDADE
FROM MOVIMENTOS
GROUP BY IDPRODUTO, IDUNIDADE
)