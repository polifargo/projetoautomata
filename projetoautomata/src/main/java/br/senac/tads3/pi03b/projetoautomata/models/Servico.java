package br.senac.tads3.pi03b.projetoautomata.models;

import java.util.Date;

/**
 *
 * @author matheus_santo
 */
public class Servico {

    private int id;
    private String descricao;
    private String tipo;
    private String tecnico;
    private String mediaConclusao;
    private String mediaHoras;
    private float valor;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTipo() {
        return tipo;
    }

    public String getTecnico() {
        return tecnico;
    }

    public void setTecnico(String tecnico) {
        this.tecnico = tecnico;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMediaConclusao() {
        return mediaConclusao;
    }

    public void setMediaConclusao(String mediaConclusao) {
        this.mediaConclusao = mediaConclusao;
    }

    public String getMediaHoras() {
        return mediaHoras;
    }

    public void setMediaHoras(String mediaHoras) {
        this.mediaHoras = mediaHoras;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

}
