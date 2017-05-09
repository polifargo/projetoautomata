package br.senac.tads3.pi03b.projetoautomata.models;

/**
 *
 * @author matheus_santo
 */
public class Venda {
    private String idCliente;
    private float valor;
    private String tecnico;
    private Object[] produtos;
    private String unidade;
     
    public String getCliente() {
        return idCliente;
    }

    public void setCliente(String cliente) {
        this.idCliente = cliente;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getTecnico() {
        return tecnico;
    }

    public void setTecnico(String tecnico) {
        this.tecnico = tecnico;
    }

    public Object[] getProdutos() {
        return produtos;
    }

    public void setProdutos(Object[] produtos) {
        this.produtos = produtos;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }
    
    
}
