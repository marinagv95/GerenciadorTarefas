package br.com.maisunifacisa.models;

import br.com.maisunifacisa.enums.Status;


public abstract class Tarefa {
    private String titulo;
    private String descricao;
    private Status status;
    private Usuario usuarioResponsavel;


    public Tarefa(String titulo, String descricao, Status status, Usuario usuarioResponsavel) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.status = Status.PENDENTE;
        this.usuarioResponsavel = usuarioResponsavel;
    }
    public Tarefa(){}

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Usuario getUsuarioResponsavel() {
        return usuarioResponsavel;
    }

    public void setUsuarioResponsavel(Usuario usuarioResponsavel) {
        this.usuarioResponsavel = usuarioResponsavel;
    }


    @Override
    public String toString() {
        return "Tarefa{" +
                "titulo='" + titulo + '\'' +
                ", descricao='" + descricao + '\'' +
                ", status=" + getStatus() +
                ", usuarioResponsavel=" + getUsuarioResponsavel() +
                '}';
    }
}
