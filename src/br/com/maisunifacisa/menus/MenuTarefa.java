package br.com.maisunifacisa.menus;

import br.com.maisunifacisa.enums.Status;
import br.com.maisunifacisa.models.*;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class MenuTarefa {
    public void exibirMenuTarefa(Scanner sc, Usuario usuario, GerenciadorTarefas gerenciadorTarefas, List<Usuario> listaUsuarios, TarefaComPrazo tarefaComPrazo, TarefaSimples tarefaSimples) {
        sc = new Scanner(System.in);
        int opcao = -1;
        String resposta = "s";

        while (opcao != 9) {
            System.out.println("-".repeat(10) + "MENU" + "-".repeat(10));
            System.out.println("1 - Adicionar Nova Atividade");
            System.out.println("2 - Pesquisar Tarefa por Título e Por Usuário");
            System.out.println("3 - Excluir Tarefa pelo Título");
            System.out.println("4 - Atualizar Título da Tarefa");
            System.out.println("5 - Atualizar Descrição da Tarefa");
            System.out.println("6 - Trocar Usuário Responsável");
            System.out.println("7 - Iniciar Tarefa");
            System.out.println("8 - Finalizar Tarefa");
            System.out.println("9 - Voltar Para o Menu Principal");

            System.out.print("Escolha uma Opção: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o Título da Tarefa: ");
                    String titulo = sc.nextLine();
                    System.out.print("Digite a Descrição da Tarefa: ");
                    String descricao = sc.nextLine();

                    System.out.print("Deseja por prazo para essa tarefa? (s/n): ");
                    resposta = sc.nextLine().toLowerCase();

                    if (resposta.equals("s")) {
                        System.out.print("Digite o prazo (formato: yyyy-MM-dd): ");
                        String prazoInput = sc.nextLine();
                        LocalDate prazo = LocalDate.parse(prazoInput);
                        tarefaComPrazo = new TarefaComPrazo(titulo, descricao, Status.PENDENTE, null, prazo);
                        gerenciadorTarefas.adicionarTarefa(tarefaComPrazo);
                        System.out.println("Tarefa Criada com Sucesso!");

                    } else if (resposta.equals("n")) {
                        tarefaSimples = new TarefaSimples(titulo, descricao, Status.PENDENTE, null);
                        gerenciadorTarefas.adicionarTarefa(tarefaSimples);
                        System.out.println("Tarefa Criada com Sucesso!");
                    } else {
                        System.out.println("Opção inválida!");
                        continue;
                    }

                    System.out.print("Deseja atribuir um usuário a essa tarefa? (s/n): ");
                    resposta = sc.nextLine().toLowerCase();

                    if (listaUsuarios.isEmpty() && resposta.equals("s")) {
                        System.out.println("Lista de Usuários está vazia!");
                    } else if (resposta.equals("s") && !listaUsuarios.isEmpty()) {
                        for (int i = 0; i < listaUsuarios.size(); i++) {
                            System.out.println(i + 1 + "-" + listaUsuarios.get(i).toString());
                        }
                        System.out.print("Digite o número do usuário que deseja atribuir: ");
                        int atribuirNovoUsuario = sc.nextInt();
                        sc.nextLine();

                        if (atribuirNovoUsuario >= 0 && atribuirNovoUsuario < listaUsuarios.size()) {
                            Usuario usuarioEscolhido = listaUsuarios.get(atribuirNovoUsuario + 1);
                            gerenciadorTarefas.atribuirUsuarioATarefa(titulo, usuarioEscolhido);
                            System.out.println("Usuário atribuído com sucesso!");
                        } else {
                            System.out.println("Número inválido.");
                        }


                    }
                    break;
                case 2:
                    System.out.print("Digite o Título da tarefa: ");
                    String buscarTitulo = sc.nextLine();

                    System.out.print("Digite o nome do usuário a ser pesquisado: ");
                    String nomeUsuarioBusca = sc.nextLine();

                    Usuario buscarUsuario = null;
                    for (Usuario user : listaUsuarios) {
                        if (user.getNome().equalsIgnoreCase(nomeUsuarioBusca)) {
                            buscarUsuario = user;
                            break;
                        }
                    }
                    if (buscarUsuario == null) {
                        System.out.println("Usuário não encontrado.");
                    } else {
                        System.out.println(gerenciadorTarefas.exibirDetalhes(buscarTitulo, buscarUsuario));
                    }


                    break;
                case 3:
                    System.out.println("3 - Excluir Tarefa pelo Título");
                    break;
                case 4:
                    System.out.println("4 - Atualizar Título da Tarefa");
                    break;
                case 5:
                    System.out.println("5 - Atualizar Descrição da Tarefa");
                    break;
                case 6:
                    System.out.println("6 - Trocar Usuário Responsável");
                    break;
                case 7:
                    System.out.println("7 - Iniciar Tarefa");
                    break;
                case 8:
                    System.out.println("8 - Finalizar Tarefa");
                    break;
                case 9:
                    System.out.println("Voltando para o menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }


        sc.close();
    }
}
