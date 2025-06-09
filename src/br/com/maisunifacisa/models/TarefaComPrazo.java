package br.com.maisunifacisa.models;

import br.com.maisunifacisa.enums.Status;

import java.time.LocalDate;

public class TarefaComPrazo extends Tarefa {
    private LocalDate prazo;

    public TarefaComPrazo(String titulo, String descricao, Status status, Usuario usuarioResponsavel, LocalDate prazo) {
        super(titulo, descricao, status, usuarioResponsavel);
        this.prazo = prazo;
    }
    public TarefaComPrazo(){
        super();

    }

    public LocalDate getPrazo() {
        return prazo;
    }

    public void setPrazo(LocalDate prazo) {
        this.prazo = prazo;
    }

    public Boolean tarefaAtrasada(LocalDate prazo) {
        if (LocalDate.now().isAfter(prazo)) {
            return true;
        } else {
            return false;

        }

    }


    @Override
    public String toString() {
        return super.toString() +
                " Prazo: " + prazo +
                " - " + (prazo.isBefore(LocalDate.now()) ? "Atrasada" : "No prazo");
    }

}
