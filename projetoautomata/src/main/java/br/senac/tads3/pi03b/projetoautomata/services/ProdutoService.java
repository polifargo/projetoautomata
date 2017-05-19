package br.senac.tads3.pi03b.projetoautomata.services;

import br.senac.tads3.pi03b.projetoautomata.models.Produto;

public class ProdutoService {

    public boolean validarCampos(Produto produto) {
        return !(produto.getModelo().equals("") || produto.getUnidade().equals(""));
    }
}
