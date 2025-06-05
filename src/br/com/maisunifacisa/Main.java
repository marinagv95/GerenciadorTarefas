package br.com.maisunifacisa;


import br.com.maisunifacisa.menus.MenuTarefa;
import br.com.maisunifacisa.menus.MenuUsuario;
import br.com.maisunifacisa.models.*;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Usuario usuario = new Usuario();
        GerenciadorTarefas gerenciadorTarefas = new GerenciadorTarefas();
        TarefaComPrazo tarefaComPrazo = new TarefaComPrazo();
        TarefaSimples tarefaSimples = new TarefaSimples();

        MenuTarefa menuTarefa = new MenuTarefa();
        MenuUsuario menuUsuario = new MenuUsuario();

        List<Usuario> listaUsuarios = new ArrayList<Usuario>();


        int opcao = -1;


        while (opcao != 3) {
            System.out.println("-".repeat(10) + "MENU" + "-".repeat(10));
            System.out.println("1 - Tarefas ");
            System.out.println("2 - Usuário ");
            System.out.println("3 - Sair do Programa ");
            System.out.print("Digite uma Opção: ");
            opcao = sc.nextInt();
            switch (opcao) {
                case 1:
                    menuTarefa.exibirMenuTarefa(sc, gerenciadorTarefas);
                    break;
                case 2:
                    menuUsuario.exibirMenuUsuario(sc, usuario, gerenciadorTarefas);
                    break;
                case 3:
                    System.out.println("Saindo do programa, até logo!");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }


        }


        sc.close();


    }
}