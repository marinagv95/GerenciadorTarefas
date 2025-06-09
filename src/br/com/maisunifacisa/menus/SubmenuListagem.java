package br.com.maisunifacisa.menus;

import br.com.maisunifacisa.models.GerenciadorTarefas;

import java.util.Scanner;

public class SubmenuListagem {
    public void exibirSubmenuListagem(Scanner sc, GerenciadorTarefas gerenciadorTarefas) {
        int opcao = -1;

        while (opcao != 5) {
            System.out.println("-".repeat(10) + "MENU LISTAGEM" + "-".repeat(10));
            System.out.println("1 - Listar todas as Tarefas");
            System.out.println("2 - Listar Apenas Tarefas Pendentes");
            System.out.println("3 - Listar Apenas Tarefas Em Andamento");
            System.out.println("4 - Listar Apenas Tarefas Concluídas");
            System.out.println("5 - Voltar ao Menu de Tarefas");

            System.out.print("Digite uma Opção: ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    if (gerenciadorTarefas.getTarefas().isEmpty()) {
                        System.out.println("Lista de Tarefas Vázia!");
                    } else {
                        System.out.println(gerenciadorTarefas.listarTodasTarefas());
                    }
                    break;
                case 2:
                    if (gerenciadorTarefas.listarTarefasPendentes().isEmpty()) {
                        System.out.println("Você não possui nenhuma tarefa pendente");

                    } else {
                        System.out.println(gerenciadorTarefas.listarTarefasPendentes());

                    }
                    break;
                case 3:
                    if (gerenciadorTarefas.listarTarefasEmAndamento().isEmpty()) {
                        System.out.println("Você não possui nenhuma tarefa em andamento");

                    } else {
                        System.out.println(gerenciadorTarefas.listarTarefasEmAndamento());

                    }
                    break;
                case 4:
                    if (gerenciadorTarefas.listarTarefasConcluidas().isEmpty()) {
                        System.out.println("Você não possui nenhuma tarefa finalizada");

                    } else {
                        System.out.println(gerenciadorTarefas.listarTarefasConcluidas());

                    }
                    break;
                case 5:
                    System.out.println("Voltando ao Menu de Tarefas...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }


        }


    }
}
