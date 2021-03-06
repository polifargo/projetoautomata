package br.senac.tads3.pi03b.projetoautomata.models;

import java.util.ArrayList;
import br.senac.tads3.pi03b.projetoautomata.models.Cliente;

/**
 *
 * @author matheus_santo
 */
public class Venda {

    private ArrayList<ItemVenda> itensVenda = new ArrayList<ItemVenda>();

    private int Id;
    private Cliente cliente;
    private int idCliente;
    private double valor;
    private String tecnico;
    private String unidade;
    private String formaPagamento;
    private String data;
    private String notasInternas;

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

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public ArrayList getProdutos() {
        return getItensVenda();
    }

    public void setItem(ItemVenda item) {
            this.getItensVenda().add(item);
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
    
    public Cliente getCliente() {
        return cliente;
    }
    
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
