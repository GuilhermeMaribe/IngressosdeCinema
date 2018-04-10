
package repositorio;

import java.util.ArrayList;
import java.util.List;
import model.Filme;

/**
 *
 * @author guilh
 */
public class RepositorioFilmes {

 
    private List<Filme> filmes;
    private static RepositorioFilmes instance = null;
    
    private RepositorioFilmes() {
        filmes = new ArrayList<Filme>();
    }

    public static RepositorioFilmes getInstance() {
        if(instance == null) instance = new RepositorioFilmes();
        return instance;
    }
    
    

    public boolean add(Filme filme) {
        return (filmes.add(filme));
    }
    
    public boolean estaVazio(){
        return filmes.isEmpty();
    }

    public List<Filme> getFilmes() {
        return filmes;
    }

    public boolean filmeExiste(String nomeFilme ) {
        for (Filme filme : filmes) {
            if (filme.getNomeFilme().equals(nomeFilme)) {
                return true;
            }
        }
        return false;
    }

    public Filme buscarFilme(String nomeFilme) {
        for (Filme filme : filmes) {
            if (filme.getNomeFilme().equals(nomeFilme)) {
                return filme;
           }
        }
        return null;
    }
} 
    

