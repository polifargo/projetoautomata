package br.senac.tads3.pi03b.projetoautomata.models;

import java.util.ArrayList;

public class ServicoPrestado {
    private ArrayList<ItemServico> itensServico = new ArrayList<ItemServico>();
    private int id;
    private int idCliente;
    private String formaPagamento;
    private String dataSolicitado;
    private double valorTotal;
    private double valorDesconto;
    private String notasInternas;
    
    public void setItens(ArrayList<ItemServico> itens) {
        for (ItemServico item : itens) {
            this.getItensServico().add(item);
        }
    }
    
    public ItemServico getItem(int id){
        for (ItemServico item : getItensServico()) {
            if (item.getId() == id) {
                return item;
            }
        }
        
        return null;
    }
    
    public ArrayList<ItemServico> getItensServico() {
        return itensServico;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public String getDataSolicitado() {
        return dataSolicitado;
    }

    public void setDataSolicitado(String dataSolicitado) {
        this.dataSolicitado = dataSolicitado;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public double getValorDesconto() {
        return valorDesconto;
    }

    public void setValorDesconto(double valorDesconto) {
        this.valorDesconto = valorDesconto;
    }

    public String getNotasInternas() {
        return notasInternas;
    }

    public void setNotasInternas(String notasInternas) {
        this.notasInternas = notasInternas;
    }
}
