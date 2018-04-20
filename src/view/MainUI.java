
package view;

import util.Console;
import view.menu.MainMenu;
import repositorio.RepositorioFilmes;
import repositorio.RepositorioSalas;
/**
 *
 * @author guilh
 */
public class MainUI {
    
        
    public void executar() {
        int opcao = 0;
        do {
            System.out.println(MainMenu.getOpcoes());
            opcao = Console.scanInt("Digite sua opção:");
            switch (opcao) {
                case MainMenu.OP_FILMES:
                    new FilmeUI().executar();
                    break;
                case MainMenu.OP_SESSAO:
                    new SessaoUI().executar();
                    break;
                case MainMenu.OP_SALA:
                    new SalaUI().executar();
                    break;
                case MainMenu.OP_VENDAINGRESSO:
                    new VendaIngressoUI().executar();
                    break;
                case MainMenu.OP_HISTORICO:
                    new HistoricoUI().executar();
                    break;
                case MainMenu.OP_SAIR:
                    System.out.println("Aplicação finalizada!!!");
                    break;
                default:
                    System.out.println("Opção inválida..");

            }
        } while (opcao != MainMenu.OP_SAIR);
    }

}
