package br.senac.tads3.pi03b.projetoautomata.models;

import java.util.ArrayList;

/**
 *
 * @author matheus_santo
 */
public class Venda {
    private ArrayList<ItemVenda> itensVenda = new ArrayList<ItemVenda>();
    
    private int Id;
    private String idCliente;
    private float valor;
    //private String tecnico;
    //private String unidade;
    private String formaPagamento;
    private String data;
    private String notasInternas;
    
    public String getCliente() {
        return getIdCliente();
    }

    public void setCliente(String cliente) {
        this.setIdCliente(cliente);
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public ArrayList getProdutos() {
        return getItensVenda();
    }

    public void setItens(ArrayList<ItemVenda> itens) {
        for (ItemVenda item : itens) {
            this.getItensVenda().add(item);
        }
    }
    
    public ItemVenda getItem(int id){
        for (ItemVenda item : getItensVenda()) {
            if (item.getId() == id) {
                return item;
            }
        }
        
        return null;
    }
    
    public ItemVenda getItem(String idProduto){
        for (ItemVenda item : getItensVenda()) {
            if (item.getIdProduto().trim().equals(idProduto.trim())) {
                return item;
            }
        }
        
        return null;
    }
    
    public ArrayList<ItemVenda> getItensVenda() {
        return itensVenda;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public int getId() {
        return Id;
    }
    
    public void setId(int Id) {
        this.Id = Id;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getNotasInternas() {
        return notasInternas;
    }

    public void setNotasInternas(String notasInternas) {
        this.notasInternas = notasInternas;
    }
}
