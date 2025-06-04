package br.com.maisunifacisa.models;

import br.com.maisunifacisa.enums.Status;

public class TarefaSimples extends Tarefa {

    public TarefaSimples(String titulo, String descricao, Status status, Usuario usuarioResponsavel) {
        super(titulo, descricao, status, usuarioResponsavel);
    }
    public TarefaSimples() {}

}
