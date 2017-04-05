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
    private Date mediaConclusao;
    private Date mediaHoras;
    private float valor;

    public Servico(int id, String descricao, String tipo, Date mediaConclusao, Date mediaHoras, float valor) {
        this.id = id;
        this.descricao = descricao;
        this.tipo = tipo;
        this.mediaConclusao = mediaConclusao;
        this.mediaHoras = mediaHoras;
        this.valor = valor;
    }

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

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Date getMediaConclusao() {
        return mediaConclusao;
    }

    public void setMediaConclusao(Date mediaConclusao) {
        this.mediaConclusao = mediaConclusao;
    }

    public Date getMediaHoras() {
        return mediaHoras;
    }

    public void setMediaHoras(Date mediaHoras) {
        this.mediaHoras = mediaHoras;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

}
