/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads3.pi03b.projetoautomata.services;

import br.senac.tads3.pi03b.projetoautomata.models.Unidade;

/**
 *
 * @author matheus.esanto1
 */
public class UnidadeService {

    public boolean validarCampos(Unidade unidade) {
        return !(!unidade.getEmail().contains("@") || !unidade.getEmail().contains(".")
                || unidade.getFantasia().equals("") || unidade.getRazao().equals("")
                || unidade.getCidade().equals("") ||  unidade.getTelefone().equals(""));
    }
}
