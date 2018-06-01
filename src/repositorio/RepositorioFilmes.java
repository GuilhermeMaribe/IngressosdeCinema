
package repositorio;

import java.util.ArrayList;
import java.util.List;
import model.Filme;

/**
 *
 * @author guilh
 */
public class RepositorioFilmes {

    private List<Filme> listafilmes;
    private static RepositorioFilmes instance = null;
    
    private RepositorioFilmes() {
        listafilmes = new ArrayList<Filme>();
    }

    public static RepositorioFilmes getInstance() {
        if(instance == null) instance = new RepositorioFilmes();
        return instance;
    }
    
    public boolean add(Filme filme) {
        return (listafilmes.add(filme));
    }
    
    public boolean estaVazio(){
        return listafilmes.isEmpty();
    }

    public List<Filme> getListaFilmes() {
        return listafilmes;
    }

    public boolean existeCodigoFilme(int codigo) {
        for (Filme filme : listafilmes) {
            if (filme.getCodigo() == codigo) {
                return true;
            }
        }
        return false;
    }

     public Filme buscarFilmePorCodigo(int codigo) {
        for (Filme filme : listafilmes) {
            if (filme.getCodigo() == codigo) {
                return filme;
            }
        }
        return null;
    }
    
     public boolean NomeFilmeExiste(String nome) {
         for (Filme filme : listafilmes) {
            if (filme.getNomeFilme() == nome) {
                return true;
            }
        }
        return false;
    }
} 
    

