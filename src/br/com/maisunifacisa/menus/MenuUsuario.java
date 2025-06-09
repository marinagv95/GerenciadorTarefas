package br.com.maisunifacisa.menus;

import br.com.maisunifacisa.models.GerenciadorTarefas;
import br.com.maisunifacisa.models.Usuario;

import java.util.Scanner;

public class MenuUsuario {
    public void exibirMenuUsuario(Scanner sc, Usuario usuario, GerenciadorTarefas gerenciadorTarefas) {
        int opcao = -1;

        while (opcao != 5) {
            System.out.println("-".repeat(10) + "MENU DE USUÁRIOS" + "-".repeat(10));
            System.out.println("1 - Criar Usuário");
            System.out.println("2 - Atribuir Usuário a uma tarefa");
            System.out.println("3 - Pesquisar Tarefa por Usuário");
            System.out.println("4 - Alterar Usuário Atribuido");
            System.out.println("5 - Voltar para o Menu Principal");

            System.out.print("Digite uma Opção: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do Usuário: ");
                    String nome = sc.nextLine();
                    System.out.print("Digite o seu e-mail: ");
                    String email = sc.nextLine();

                    Usuario novoUsuario = new Usuario(nome, email);
                    gerenciadorTarefas.adicionarUsuario(novoUsuario);
                    System.out.println("Usuário cadastrado com sucesso!");
                    break;
                case 2:
                    System.out.println("USUÁRIOS PARA ATRIBUIR: ");
                    System.out.print(gerenciadorTarefas.listarTodosUsuarios());
                    System.out.println("TAREFAS DISPONÍVEIS: ");
                    if (gerenciadorTarefas.listarTodosUsuarios().isEmpty()) {
                        System.out.println("Nenhuma!");
                    } else {

                        System.out.println(gerenciadorTarefas.listarTarefasNaoAtribuidas());
                        System.out.print("Digite o Título da Tarefa para ser Atribuída: ");
                        String titulo = sc.nextLine();
                        if (gerenciadorTarefas.buscarTarefaPorTitulo(titulo)) {
                            System.out.print("Digite o número do Usuário que quer atribuir: ");
                            int indexUsuario = sc.nextInt();


                            Usuario usuarioSelecionado = gerenciadorTarefas.buscarUsuarioPorIndice(indexUsuario - 1);

                            gerenciadorTarefas.atribuirUsuarioATarefa(titulo, usuarioSelecionado);
                            System.out.println("Usuário atribuído com sucesso à tarefa.");

                        } else {
                            System.out.println("Tarefa não encontrada!");
                        }
                    }
                    break;
                case 3:
                    if (gerenciadorTarefas.getUsuarios().isEmpty()) {
                        System.out.println("Nenhum Usuário cadastrado!");
                    } else {
                        System.out.print("Digite o nome do Usuário Para pesquisar as Tarefas: ");
                        String buscarUsuario = sc.nextLine();
                        if (buscarUsuario != null && gerenciadorTarefas.usuarioTemTarefa(buscarUsuario)) {
                            System.out.println(gerenciadorTarefas.buscarTarefaPorUsuario(buscarUsuario));
                        } else {
                            System.out.println("Usuário não encontrado ou sem nenhuma tarefa atribuida!");
                        }


                    }
                    break;
                case 4:
                    if (gerenciadorTarefas.getUsuarios().isEmpty()) {
                        System.out.println("Nenhum Usuário cadastrado!");
                    } else {
                        System.out.print("Digite o título da tarefa para alterar o usuário: ");
                        String tituloTarefa = sc.nextLine();

                        if (tituloTarefa != null && gerenciadorTarefas.buscarTarefaPorTitulo(tituloTarefa)) {

                            System.out.print("Qual novo usuário deseja atribuir: ");
                            String novoUsuarioAtribuido = sc.nextLine();

                            if (gerenciadorTarefas.trocarUsuarioAtribuido(tituloTarefa, novoUsuarioAtribuido)) {
                                System.out.println("Novo usuário atribuído com sucesso!");
                            } else {
                                System.out.println("Usuário informado não existe!");
                            }

                        } else {
                            System.out.println("Tarefa não encontrada!");
                        }
                    }
                    break;


            }

        }
    }
}

