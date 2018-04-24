
package view;

import java.text.ParseException;
import java.time.LocalTime;
import java.util.InputMismatchException;
import model.Filme;
import model.Sala;
import model.Sessao;
import repositorio.RepositorioFilmes;
import repositorio.RepositorioSalas;
import repositorio.RepositorioSessoes;
import repositorio.RepositorioVendas;
import util.Console;
import view.menu.SessaoMenu;

/**
 *
 * @author guilh
 */
public class SessaoUI {
    
     public void executar() throws ParseException {
        int opcao = 0;
        do {
            try {
                System.out.println(SessaoMenu.getOpcoes());
                opcao = Console.scanInt("Digite sua opção: ");
                switch (opcao) {
                    case SessaoMenu.OP_CADASTRAR:
                        cadastrarSessao();
                        break;
                    case SessaoMenu.OP_LISTAR:
                        listarSessoes();
                        break;
                    case SessaoMenu.OP_VOLTAR:
                        System.out.println("Retornando ao menu principal..");
                        break;
                    default:
                        System.out.println("Opção inválida..");
                }
            } catch (InputMismatchException ime) {
                System.out.println("Opção Inválida! Não pode digitar letras ou caracteres especiais!");
            }
        } while (opcao != SessaoMenu.OP_VOLTAR);
    }

    private void cadastrarSessao() {
        
        System.out.println("\nSelecione uma sala para cadastrar nesta sessão: ");
        new SalaUI().listarSalas();
        int numero = Console.scanInt("\nDigite o Número da Sala: ");

        if (RepositorioSalas.getInstance().salaExiste(numero)) {
            Sala sala = RepositorioSalas.getInstance().buscarSala(numero);
            String hora = Console.scanString("Hora (hh:mm): ");
            LocalTime horario;
            horario = LocalTime.parse(hora);
            if (RepositorioSessoes.getInstance().sessaoSalaHorarioOcupados(numero, horario)) {
                System.out.println("Sala e horário já estão ocupados!");
            } else {
                System.out.println("\nSelecione um filme para cadastrar nesta sessão: ");
                
                new FilmeUI().listarFilmes();
                String nome = Console.scanString("\nDigite o Nome do filme: ");
                
                if (RepositorioFilmes.getInstance().filmeExiste(nome)) {
                    Filme filme = RepositorioFilmes.getInstance().buscarFilme(nome);
                    
                    Sessao sessao = new Sessao(sala, horario, filme);
                    
                    RepositorioSessoes.getInstance().getListaSessoes().add(sessao);
                    System.out.println("Sessão cadastrada com sucesso!");
                } else {
                    System.out.println("Filme não encontrado!");
                }
            }
        } else {
            System.out.println("Sala não encontrada!");
        }
    }

    void listarSessoes() {
         System.out.println("\nLista de Sessões");
        if (RepositorioSessoes.getInstance().estaVazio()) {
            System.out.println("Nenhuma sessão foi cadastrada!");
        } else {
            System.out.println("-----------------------------\n");
            System.out.println(String.format("%-15s", "CÓDIGO SESSÃO") + "\t"
                    + String.format("%-10s", "|SALA") + "\t"
                    + String.format("%-10s", "|HORÁRIO") + "\t"
                    + String.format("%-20s", "|FILME") + "\t"
                    + String.format("%-10s", "|ASSENTOS DISPONÍVEIS"));
            for (Sessao sessao : RepositorioSessoes.getInstance().getListaSessoes()) {
                System.out.println(String.format("%-15s", sessao.getCodigo()) + "\t"
                        + String.format("%-10s", "|" + sessao.getSala().getnSala()) + "\t"
                        + String.format("%-10s", "|" + sessao.getHorario()) + "\t"
                        + String.format("%-20s", "|" + sessao.getFilme().getNomeFilme()) + "\t"
                        + String.format("%-10s", "|" + (sessao.getSala().getnAssentos() - RepositorioVendas.getInstance().ingressosVendidosPorSessao(sessao.getCodigo()))));
            }
        }
    }    
}
