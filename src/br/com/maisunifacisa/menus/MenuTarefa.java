package br.com.maisunifacisa.menus;

import br.com.maisunifacisa.enums.Status;
import br.com.maisunifacisa.models.*;

import java.time.LocalDate;
import java.util.Scanner;

public class MenuTarefa {
    public void exibirMenuTarefa(Scanner sc, GerenciadorTarefas gerenciadorTarefas) {

        int opcao = -1;
        SubmenuListagem submenuListagem = new SubmenuListagem();


        while (opcao != 9) {
            System.out.println("-".repeat(10) + "MENU TAREFAS" + "-".repeat(10));
            System.out.println("1 - Adicionar Nova Atividade");
            System.out.println("2 - Pesquisar Tarefa por Título");
            System.out.println("3 - Menu Listagens de Tarefas");
            System.out.println("4 - Excluir Tarefa pelo Título");
            System.out.println("5 - Atualizar Título da Tarefa");
            System.out.println("6 - Atualizar Descrição da Tarefa");
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
                    String resposta = sc.nextLine().toLowerCase();

                    if (resposta.equals("s")) {
                        System.out.print("Digite o prazo (formato: yyyy-MM-dd): ");
                        String prazoInput = sc.nextLine();
                        LocalDate prazo = LocalDate.parse(prazoInput);
                        TarefaComPrazo tarefaComPrazo = new TarefaComPrazo(titulo, descricao, Status.PENDENTE, null, prazo);
                        gerenciadorTarefas.adicionarTarefa(tarefaComPrazo);
                        System.out.println("Tarefa Criada com Sucesso!");

                    } else if (resposta.equals("n")) {
                        TarefaSimples tarefaSimples = new TarefaSimples(titulo, descricao, Status.PENDENTE, null);
                        gerenciadorTarefas.adicionarTarefa(tarefaSimples);
                        System.out.println("Tarefa Criada com Sucesso!");
                    } else {
                        System.out.println("Opção inválida!");
                        continue;
                    }

                    break;
                case 2:


                    if (gerenciadorTarefas.getTarefas().isEmpty()) {
                        System.out.println("Lista de Tarefas Vazia!");
                    } else {
                        System.out.print("Digite o Título da tarefa para Exibir os Detalhes: ");
                        String buscarTitulo = sc.nextLine();
                        if (gerenciadorTarefas.buscarTarefaPorTitulo(buscarTitulo)) {
                            System.out.println(gerenciadorTarefas.exibirDetalhes(buscarTitulo));


                        } else {
                            System.out.println("Tarefa não encontrada!");
                        }

                    }


                    break;
                case 3:
                    submenuListagem.exibirSubmenuListagem(sc, gerenciadorTarefas);
                    break;
                case 4:
                    if (gerenciadorTarefas.getTarefas().isEmpty()) {
                        System.out.println("Lista de Tarefas Vázia!");
                    } else {
                        System.out.print("Digite o Título da Tarefa que Deseja Excluir: ");
                        String excluirTarefaSelecionada = sc.nextLine();

                        if (gerenciadorTarefas.buscarTarefaPorTitulo(excluirTarefaSelecionada)) {
                            gerenciadorTarefas.excluirTarefa(excluirTarefaSelecionada);
                            System.out.println("Tarefa excluída com sucesso!");
                        } else {
                            System.out.println("Tarefa não encontrada!");
                        }


                    }

                    break;
                case 5:
                    if (gerenciadorTarefas.getTarefas().isEmpty()) {
                        System.out.println("Lista de Tarefas Vazia!");
                    } else {
                        System.out.print("Digite o Título da Tarefa que Deseja Alterar: ");
                        String alterarTarefaSelecionada = sc.nextLine();
                        if (gerenciadorTarefas.buscarTarefaPorTitulo(alterarTarefaSelecionada)) {
                            System.out.print("Digite o novo Título: ");
                            String novoTitulo = sc.nextLine();
                            gerenciadorTarefas.atualizarTituloTarefa(alterarTarefaSelecionada, novoTitulo);
                            System.out.println("Título Atualizado com sucesso!");
                        } else {
                            System.out.println("Tarefa não encontrada.");
                        }


                    }
                    break;
                case 6:
                    if (gerenciadorTarefas.getTarefas().isEmpty()) {
                        System.out.println("Lista de Tarefas Vazia!");
                    } else {
                        System.out.print("Digite o Título da Tarefa que Deseja Alterar a Descrição: ");
                        String tituloTarefa = sc.nextLine();
                        if (gerenciadorTarefas.buscarTarefaPorTitulo(tituloTarefa)) {
                            System.out.print("Digite uma nova descrição: ");
                            String descricaoTarefa = sc.nextLine();
                            gerenciadorTarefas.atualizarDescricaoTarefa(tituloTarefa,descricaoTarefa);
                            System.out.println("Descrição atualizada com sucesso!");
                        } else {
                            System.out.println("Tarefa não encontrada!");
                        }

                    }

                    break;
                case 7:

                    System.out.print("Digite a Título da Tarefa para Iniciar: ");
                    String tituloTarefaIniciar = sc.nextLine();
                    if (gerenciadorTarefas.buscarTarefaPorTitulo(tituloTarefaIniciar) && gerenciadorTarefas.buscarStatusTarefa(Status.PENDENTE)) {

                        gerenciadorTarefas.iniciarTarefa(tituloTarefaIniciar);
                        System.out.println("Tarefa inicializada com sucesso!");
                    } else {
                        System.out.println("Tarefa não encontrada!");
                    }
                    break;
                case 8:
                    System.out.print("Digite a Título da Tarefa para Iniciar: ");
                    String tituloTarefaFinalizar = sc.nextLine();

                    if (gerenciadorTarefas.buscarTarefaPorTitulo(tituloTarefaFinalizar) && gerenciadorTarefas.buscarStatusTarefa(Status.EM_ANDAMENTO)) {
                        gerenciadorTarefas.finalizarTarefa(tituloTarefaFinalizar);
                        System.out.println("Tarefa finalizada com sucesso!");

                    } else {
                        System.out.println("Tarefa não encontrada!");
                    }
                    break;
                case 9:
                    System.out.println("Voltando para o menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }


    }
}
