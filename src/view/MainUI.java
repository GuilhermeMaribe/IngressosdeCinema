
package view;

import java.text.ParseException;
import java.util.InputMismatchException;
import util.Console;
import view.menu.MainMenu;
import repositorio.RepositorioFilmes;
import repositorio.RepositorioSalas;
/**
 *
 * @author guilh
 */
public class MainUI {
    
        
    public void executar() throws ParseException {
        int opcao = 0;
        do {
            try{
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
            } catch (InputMismatchException ime) {
                System.out.println("Opção Inválida! Não pode digitar letras ou caracteres especiais!");
            }
        } while (opcao != MainMenu.OP_SAIR);
    }

}
