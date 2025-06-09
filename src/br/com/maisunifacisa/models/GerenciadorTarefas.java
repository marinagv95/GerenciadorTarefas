package br.com.maisunifacisa.models;

import br.com.maisunifacisa.enums.Status;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GerenciadorTarefas {
    List<Tarefa> tarefas = new ArrayList<>();
    ArrayList<Usuario> usuarios = new ArrayList<Usuario>();


    public List<Tarefa> getTarefas() {
        return tarefas;
    }

    public void setTarefas(List<Tarefa> tarefas) {
        this.tarefas = tarefas;
    }


    public void adicionarTarefa(Tarefa tarefa) {
        tarefas.add(tarefa);
    }


    public String exibirDetalhes(String titulo) {
        for (Tarefa tarefa : tarefas) {
            if (tarefa.getTitulo().equalsIgnoreCase(titulo)) {
                return tarefa.toString();
            }
        }
        return null;
    }


    public boolean excluirTarefa(String titulo) {
        for (Tarefa tarefa : tarefas) {
            if (tarefa.getTitulo().equalsIgnoreCase(titulo)) {
                tarefas.remove(tarefa);
                return true;
            }
        }
        return false;
    }

    public void atualizarTituloTarefa(String novoTitulo) {
        for (Tarefa tarefa : tarefas) {
            tarefa.setTitulo(novoTitulo);
        }
    }

    public void atualizarDescricaoTarefa(String novaDescricao) {
        for (Tarefa tarefa : tarefas) {
            tarefa.setDescricao(novaDescricao);
        }
    }

    public void trocarUsuarioAtribuido(Usuario usuario) {
        for (Tarefa tarefa : tarefas) {
            if (tarefa.getUsuarioResponsavel().equals(usuario)) {
                tarefa.setUsuarioResponsavel(usuario);
            }
        }
    }
    public boolean atribuirUsuarioATarefa(String titulo, Usuario usuario) {
        for (Tarefa tarefa : tarefas) {
            if (tarefa.getTitulo().equalsIgnoreCase(titulo)) {
                if (tarefa.getUsuarioResponsavel() != null) {
                    System.out.println("Erro: Esta tarefa já tem um usuário atribuído.");
                    return false;
                }
                tarefa.setUsuarioResponsavel(usuario);
                return true;
            }
        }
        return false;
    }


    public Usuario buscarUsuarioPorIndice(int index) {
        if (index >= 0 && index < usuarios.size()) {
            return usuarios.get(index);
        }
        return null;
    }



    public boolean iniciarTarefa(String titulo) {
        for (Tarefa tarefa : tarefas) {
            if (tarefa.getTitulo().equalsIgnoreCase(titulo)) {
                tarefa.setStatus(Status.EM_ANDAMENTO);
                return true;
            }
        }
        return false;
    }

    public boolean finalizarTarefa(String titulo) {
        for (Tarefa tarefa : tarefas) {
            if (tarefa.getTitulo().equalsIgnoreCase(titulo)) {
                tarefa.setStatus(Status.CONCLUIDA);
                return true;
            }
        }
        return false;
    }


    public String listarTodasTarefas() {
        String retorno = "";
        for (Tarefa tarefa : tarefas) {
            retorno += tarefa + "\n";
        }
        return retorno;

    }

    public String listarTarefasPendentes() {
        String retorno = "";
        for (Tarefa tarefa : tarefas) {
            if (tarefa.getStatus().equals(Status.PENDENTE)) {
                retorno += tarefa + "\n";
            }
        }
        return retorno;
    }

    public String listarTarefasEmAndamento() {
        String retorno = "";
        for (Tarefa tarefa : tarefas) {
            if (tarefa.getStatus().equals(Status.EM_ANDAMENTO)) {
                retorno += tarefa + "\n";
            }
        }
        return retorno;
    }


    public String listarTarefasConcluidas() {
        String retorno = "";
        for (Tarefa tarefa : tarefas) {
            if (tarefa.getStatus().equals(Status.CONCLUIDA)) {
                retorno += tarefa + "\n";
            }
        }
        return retorno;
    }

    public Boolean buscarTarefaPorTitulo(String titulo) {
        for (Tarefa tarefa : tarefas) {
            if (tarefa.getTitulo().equalsIgnoreCase(titulo)) {
                return true;
            }
        }
        return false;
    }

    public Boolean buscarStatusTarefa(Status status) {
        for (Tarefa tarefa : tarefas) {
            if (tarefa.getStatus().equals(status)) {
                return true;
            }
        }
        return false;
    }

    public void adicionarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public String listarTodosUsuarios() {
        String retorno = "";
        for (int i = 0; i < usuarios.size(); i++) {
            retorno += (i + 1) + " - " + usuarios.get(i).toString() + "\n";
        }
        return retorno;
    }


    public String listarTarefasNaoAtribuidas() {
        String retorno = "";
        for (Tarefa tarefa : tarefas) {
            if (tarefa.getUsuarioResponsavel() == null) {
                retorno += tarefa + "\n";
            }
        }

        return retorno;
    }



}









