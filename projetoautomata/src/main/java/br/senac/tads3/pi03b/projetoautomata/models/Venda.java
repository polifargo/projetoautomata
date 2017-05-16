package br.senac.tads3.pi03b.projetoautomata.models;

import java.util.ArrayList;

/**
 *
 * @author matheus_santo
 */
public class Venda {

    private ArrayList<ItemVenda> itensVenda = new ArrayList<ItemVenda>();

    private int Id;
    private int idCliente;
    private float valor;
    private String tecnico;
    private String unidade;
    private String formaPagamento;
    private String data;
    private String notasInternas;

    public int getCliente() {
        return getIdCliente();
    }

    public void setCliente(int cliente) {
        this.setIdCliente(cliente);
    }

    public String getTecnico() {
        return tecnico;
    }

    public void setTecnico(String tecnico) {
        this.tecnico = tecnico;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
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

    public ItemVenda getItem(int id) {
        for (ItemVenda item : getItensVenda()) {
            if (item.getId() == id) {
                return item;
            }
        }

        return null;
    }

    public ItemVenda getItem(String idProduto) {
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

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
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
