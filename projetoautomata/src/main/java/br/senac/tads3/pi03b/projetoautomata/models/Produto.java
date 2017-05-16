package br.senac.tads3.pi03b.projetoautomata.models;

/**
 *
 * @author matheus_santo
 */
public class Produto {

    private String id;
    private String modelo;
    private String unidade;
    private float valorVenda;
    private float valorCusto;
    private String notasInternas;
    private int inativo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public float getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(float valorVenda) {
        this.valorVenda = valorVenda;
    }

    public float getValorCusto() {
        return valorCusto;
    }

    public void setValorCusto(float valorCusto) {
        this.valorCusto = valorCusto;
    }

    public String getNotasInternas() {
        return notasInternas;
    }

    public void setNotasInternas(String notasInternas) {
        this.notasInternas = notasInternas;
    }

    public int getInativo() {
        return inativo;
    }

    public void setInativo(int inativo) {
        this.inativo = inativo;
    }

}
