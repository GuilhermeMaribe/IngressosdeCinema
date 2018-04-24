
package view;

import java.util.InputMismatchException;
import model.Sessao;
import model.VendaIngresso;
import repositorio.RepositorioSessoes;
import repositorio.RepositorioVendas;
import util.Console;
import view.menu.SessaoMenu;
import view.menu.VendaIngressoMenu;
import view.SessaoUI;

/**
 *
 * @author guilh
 */
public class VendaIngressoUI {
 
    public void executar() {
        int opcao = 0;
        do {
            try {
                System.out.println(VendaIngressoMenu.getOpcoes());
                opcao = Console.scanInt("Digite sua opção: ");
                switch (opcao) {
                    case VendaIngressoMenu.OP_CADASTRAR:
                        cadastrarVendas();
                        break;
                    case VendaIngressoMenu.OP_VOLTAR:
                        System.out.println("Retornando ao menu principal...");
                        break;
                    default:
                        System.out.println("Opção inválida...");
                }
            } catch (InputMismatchException ime) {
                System.out.println("Opção Inválida! Não pode digitar letras ou caracteres especiais!");
            }
        } while (opcao != VendaIngressoMenu.OP_VOLTAR);
    }

    private void cadastrarVendas() {
        
        System.out.println("\nSelecione a sessão para efetuar a venda: ");
        new SessaoUI().listarSessoes();
        int codigo = Console.scanInt("\nDigite o Código da sessão: ");

        if (RepositorioSessoes.getInstance().sessaoExiste(codigo)) {
            Sessao sessao = RepositorioSessoes.getInstance().buscarSessao(codigo);

            int qtdIngressos = Console.scanInt("\nDigite a quantidade de ingressos que irá vender: ");

            if ((RepositorioVendas.getInstance().ingressosVendidosPorSessao(codigo) + qtdIngressos) > sessao.getSala().getnAssentos()) {
                 System.out.println("Total de ingressos solicitados não estão disponíveis para esta sessão."
                                  + "\nNesta sessão há "+(sessao.getSala().getnAssentos() - RepositorioVendas.getInstance().ingressosVendidosPorSessao(codigo))+" ingressos disponíveis!");
            } else {

                VendaIngresso venda = new VendaIngresso(sessao, qtdIngressos);

                RepositorioVendas.getInstance().addVenda(venda);
                System.out.println("Venda cadastrada com sucesso!");
                if ((RepositorioVendas.getInstance().ingressosVendidosPorSessao(codigo)) == sessao.getSala().getnAssentos()) {
                    System.out.println("Esta sessão está lotada!");
                }
            }
        } else {
            System.out.println("Código da sessão não encontrado!");
        }
    }
}
    
