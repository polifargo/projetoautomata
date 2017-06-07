package br.senac.tads3.pi03b.projetoautomata.services;

import br.senac.tads3.pi03b.projetoautomata.models.ItemVenda;
import br.senac.tads3.pi03b.projetoautomata.models.Venda;
import java.util.ArrayList;

public class VendaService {

    public boolean validarCampos(Venda venda) {
//        return !(!cliente.getEmail().contains("@") || !cliente.getEmail().contains(".")
//                || cliente.getNome().equals("") || cliente.getApelido().equals("")
//                || cliente.getCidade().equals("") || cliente.getTelefone().equals(""));

        ArrayList<ItemVenda> itens = new ArrayList<ItemVenda>();
        
        int i = 0, j = 0;
        
        for (ItemVenda item : venda.getItensVenda()) {
            i++;
            
            for (ItemVenda itemaux : venda.getItensVenda()) {
                j++;
                
                if (i == j) {
                    continue;
                }
                
                if (itemaux.getIdProduto() == item.getIdProduto()) {
                    
                }
            }
        }
        
        return false;
    }
}
