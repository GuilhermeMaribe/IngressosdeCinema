/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.InputMismatchException;
import model.Sala;
import repositorio.RepositorioSalas;
import util.Console;
import view.menu.SalaMenu;

/**
 *
 * @author guilh
 */
public class SalaUI {
    
    
    public void executar() {
        int opcao = 0;
        do {
            try {
                System.out.println(SalaMenu.getOpcoes());
                opcao = Console.scanInt("Digite sua opção: ");
                switch (opcao) {
                    case SalaMenu.OP_CADASTRAR:
                        cadastrarSalas();
                        break;
                    case SalaMenu.OP_LISTAR:
                        listarSalas();
                        break;
                    case SalaMenu.OP_BUSCAR_NUMERO:
                        buscarNumeroSala();
                        break;
                    case SalaMenu.OP_VOLTAR:
                        System.out.println("Retornando ao menu principal..");
                        break;
                    default:
                        System.out.println("Opção inválida..");
                }
            } catch (InputMismatchException ime) {
                System.out.println("Opção Inválida! Não pode digitar letras ou caracteres especiais!");
            }
        } while (opcao != SalaMenu.OP_VOLTAR);
    }

   
    private void cadastrarSalas() {
        int numero = Console.scanInt("Número da sala: ");
        if (RepositorioSalas.getInstance().buscarSala(numero) != null) {
            System.out.println("Sala já existente no cadastro");
        } else {
            int qtdAssentos = Console.scanInt("Quantidade de assentos: ");
            RepositorioSalas.getInstance().add(new Sala(numero, qtdAssentos));
            System.out.println("Sala número " + numero + " cadastrada com sucesso!");
        }
    }

    
    public void listarSalas() {
        System.out.println("\nLista de Salas");
        if (RepositorioSalas.getInstance().estaVazio()) {
            System.out.println("Nenhuma sala foi cadastrada!");
        } else {
            System.out.println("-----------------------------\n");
            System.out.println(String.format("%-10s", "NÚMERO") + "\t"
                    + String.format("%-20s", "|QUANTIDADE DE ASSENTOS"));
            for (Sala sala : RepositorioSalas.getInstance().getListaSalas()) {
                System.out.println(String.format("%-10s", sala.getnSala()) + "\t"
                        + String.format("%-20s", "|" + sala.getnAssentos()));
            }
        }
    }

    
    public void buscarNumeroSala() {
        System.out.println("\nBusca de sala por número");
        int numero = Console.scanInt("Digite o Número da sala: ");
        if (RepositorioSalas.getInstance().salaExiste(numero)) {
            Sala sala = RepositorioSalas.getInstance().buscarSala(numero);

            System.out.println("-----------------------------\n");
            System.out.println(String.format("%-10s", "NÚMERO") + "\t"
                    + String.format("%-20s", "|QUANTIDADE DE ASSENTOS"));

            System.out.println(String.format("%-10s", sala.getnSala()) + "\t"
                    + String.format("%-20s", "|" + sala.getnAssentos()));
        } else {
            System.out.println("Este Número de sala não está cadastrado!");
        }
    }
}
