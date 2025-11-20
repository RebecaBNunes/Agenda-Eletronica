package agenda;

import java.util.List;
import java.util.Scanner;

import agenda.dominio.*;
import agenda.exceptions.ContatoExistenteException;
import agenda.exceptions.ContatoNaoEncontradoException;

public class AgendaApplication {

    public static void exibirMenu() {
            System.out.println("\n**************************");
            System.out.println("           Menu           ");
            System.out.println("**************************");
            System.out.println("Opções:");
            System.out.println("1 - Adicionar Contato");
            System.out.println("2 - Buscar Contato");
            System.out.println("3 - Remover Contato");
            System.out.println("4 - Listar Todos os Contatos");
            System.out.println("5 - Salvar em CSV");
            System.out.println("6 - Carregar de CSV");
            System.out.println("7 - Sair");    

            System.out.print("Selecione a opção: ");
    }

    public static void main(String args[]) {
        
        Scanner console = new Scanner(System.in);
        AgendaManager manager = new AgendaManager();
        String arquivoPadrao = "contatos.csv";
        int resposta = 0;

        manager.carregarContatosCSV(arquivoPadrao);

        while(resposta != 7) {
            exibirMenu();

            try {
                resposta = console.nextInt();
            } catch (Exception e) {
                resposta = 0;
                console.nextLine();
            }

            console.nextLine();

            try {
            switch (resposta) {
                case 1: 
                    System.out.println("\n--- Adicionar Contato ---");
                    System.out.print("Nome: ");
                    String nome = console.nextLine();
                    System.out.print("Telefone: ");
                    String tel = console.nextLine();
                    System.out.print("Email: ");
                    String email = console.nextLine();

                    Contato novoContato = new Contato(nome, tel, email);
                    manager.adicionarContato(novoContato);
                    System.out.println("Sucesso! Contato adicionado.");
                    break;
                case 2: 
                    System.out.println("\n--- Buscar Contato ---");
                    System.out.print("Digite o nome: ");
                    String nomeBusca = console.nextLine();
                    Contato c = manager.buscarContato(nomeBusca);
                    System.out.println("Contato encontrado: " + c);
                    break;
                case 3: 
                    System.out.println("\n--- Remover Contato ---");
                    System.out.print("Digite o nome para remover: ");
                    String nomeRemover = console.nextLine();
                    manager.removerContato(nomeRemover);
                    System.out.println("Contato removido com sucesso.");
                    break;
                case 4: 
                    System.out.println("\n--- Lista de Contatos ---");
                    List<Contato> lista = manager.listarContatosOrdenados();
                    if (lista.isEmpty()) {
                        System.out.println("Agenda vazia.");
                    } else {
                        for(Contato cont : lista) {
                            System.out.println(cont);
                        }
                    }
                    break;

                case 5: 
                    System.out.println("Salvando...");
                    manager.salvarContatosCSV(arquivoPadrao);
                    break;

                case 6: 
                    System.out.println("Carregando...");
                    manager.carregarContatosCSV(arquivoPadrao);
                    break;

                case 7: 
                    System.out.println("Saindo...");
                    break;
                
                default:
                    System.out.println("Opção inválida, escolha um número de 1 a 7.");
                    break;
            }

            } catch (ContatoExistenteException e) {
                System.out.println("ERRO: " + e.getMessage());
            } catch (ContatoNaoEncontradoException e) {
                System.out.println("ERRO: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("ERRO INESPERADO: " + e.getMessage());
            }
        }
        
        console.close();
    }
}