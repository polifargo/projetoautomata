package br.senac.tads3.pi03b.projetoautomata.services;

import br.senac.tads3.pi03b.projetoautomata.models.Cliente;

public class ClienteService {

    public boolean validarCampos(Cliente cliente) {
        return !(!cliente.getEmail().contains("@") || !cliente.getEmail().contains(".")
                || cliente.getNome().equals("") || cliente.getApelido().equals("")
                || cliente.getCidade().equals("") || cliente.getTelefone().equals(""));
    }
}
