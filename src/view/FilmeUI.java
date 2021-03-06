
package view;

import java.text.ParseException;
import java.util.InputMismatchException;
import model.Filme;
import repositorio.RepositorioFilmes;
import util.Console;
import view.menu.FilmeMenu;

/**
 *
 * @author guilh
 */
public class FilmeUI {
       
    public void executar() throws ParseException {
        int opcao = 0;
        do {
            try{
            System.out.println(FilmeMenu.getOpcoes());
                opcao = Console.scanInt("Digite sua opção: ");
                switch (opcao) {
                    case FilmeMenu.OP_CADASTRAR:
                        cadastrarFilmes();
                        break;
                    case FilmeMenu.OP_LISTAR:
                        listarFilmes();
                        break;
                    case FilmeMenu.OP_BUSCAR_COD:
                        buscarCodFilme();
                        break;
                    case FilmeMenu.OP_VOLTAR:
                        System.out.println("Retornando ao menu principal...");
                        break;
                    default:
                        System.out.println("Opção inválida...");
                }
            } catch (InputMismatchException ime) {
                System.out.println("Opção Inválida! Não pode digitar letras ou caracteres especiais!");
            }
        } while (opcao != FilmeMenu.OP_VOLTAR);
    }

    private void cadastrarFilmes() {
        String nomeFilme = Console.scanString("Nome do Filme: ");
        if (RepositorioFilmes.getInstance().NomeFilmeExiste(nomeFilme)) {
            System.out.println("Filme já existente no cadastro");
        } else {
            int codigo = Console.scanInt("Código: ");
            String genero = Console.scanString("Gênero: ");
            String sinopse = Console.scanString("Sinopse: ");
            
            RepositorioFilmes.getInstance().add(new Filme(codigo, nomeFilme, genero, sinopse));
            System.out.println("O filme " + nomeFilme + " foi cadastrado com sucesso!");
            
            
        }
    }
    public void listarFilmes() {
          System.out.println("\nLista de Filmes");
          if (RepositorioFilmes.getInstance().estaVazio()) {
              System.out.println("Nenhum filme foi cadastrado!");
          } else { System.out.println("-----------------------------\n");
              System.out.println(String.format("%-10s", "CÓDIGO") + "\t"
                      + String.format("%-20s", "|NOME") + "\t"
                      + String.format("%-20s", "|GÊNERO") + "\t"
                      + String.format("%-20s", "|SINOPSE"));
             for (Filme filme : RepositorioFilmes.getInstance().getListaFilmes()) {
                  System.out.println(String.format("%-10s", filme.getCodigo()) + "\t"
                          + String.format("%-20s", "|" + filme.getNomeFilme()) + "\t"
                          + String.format("%-20s", "|" + filme.getGenero()) + "\t"
                          + String.format("%-20s", "|" + filme.getSinopse()));
              }
          }
    }  
      
    public void buscarCodFilme() {
          System.out.println("\nBusca de filme por Codigo");
          int codigo = Console.scanInt("Digite o codigo do filme: ");
          if (RepositorioFilmes.getInstance().existeCodigoFilme(codigo)) {
              Filme filme = RepositorioFilmes.getInstance().buscarFilmePorCodigo(codigo);

              System.out.println("-----------------------------\n");
              System.out.println(String.format("%-10s", "CÓDIGO") + "\t"
                      + String.format("%-20s", "|NOME") + "\t"
                      + String.format("%-20s", "|GÊNERO") + "\t"
                      + String.format("%-20s", "|SINOPSE"));

              System.out.println(String.format("%-10s", filme.getCodigo()) + "\t"
                      + String.format("%-20s", "|" + filme.getNomeFilme()) + "\t"
                      + String.format("%-20s", "|" + filme.getGenero()) + "\t"
                      + String.format("%-20s", "|" + filme.getSinopse()));
          } else {
              System.out.println("Este filme não está cadastrado na lista de filmes!");
          }
    }      
}
