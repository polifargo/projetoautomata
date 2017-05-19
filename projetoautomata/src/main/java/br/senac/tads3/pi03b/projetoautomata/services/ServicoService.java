/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads3.pi03b.projetoautomata.services;

import br.senac.tads3.pi03b.projetoautomata.models.Servico;

/**
 *
 * @author matheus.esanto1
 */
public class ServicoService {

    public boolean validarCampos(Servico servico) {
        return !(servico.getTipo().equals("") || servico.getDescricao().equals(""));
    }
}
