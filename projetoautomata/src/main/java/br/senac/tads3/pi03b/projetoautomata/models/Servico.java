package br.senac.tads3.pi03b.projetoautomata.models;

import java.util.Date;

/**
 *
 * @author matheus_santo
 */
public class Servico {

    private long id;
    private String descricao;
    private String tipo;
    private String tecnico;
    private Date mediaConclusao;
    private Date mediaHoras;
    private float valor;

    public Servico(long id, String descricao, String tipo, String tecnico, Date mediaConclusao, Date mediaHoras, float valor) {
        this.id = id;
        this.descricao = descricao;
        this.tipo = tipo;
        this.tecnico = tecnico;
        this.mediaConclusao = mediaConclusao;
        this.mediaHoras = mediaHoras;
        this.valor = valor;
    }

    public Servico(String descricao, String tipo, String tecnico, Date mediaConclusao, Date mediaHoras, float valor) {
        this.descricao = descricao;
        this.tipo = tipo;
        this.tecnico = tecnico;
        this.mediaConclusao = mediaConclusao;
        this.mediaHoras = mediaHoras;
        this.valor = valor;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
