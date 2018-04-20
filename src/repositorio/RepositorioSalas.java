
package repositorio;

import java.util.ArrayList;
import java.util.List;
import model.Sala;


/**
 *
 * @author guilh
 */
public class RepositorioSalas {
    
    private List<Sala> listaSalas;
    private static RepositorioSalas instance = null;
    
    private RepositorioSalas() {
        listaSalas = new ArrayList<Sala>();
    }

    public static RepositorioSalas getInstance() {
        if(instance == null) instance = new RepositorioSalas();
        return instance;
    }
        
    public boolean add(Sala sala) {
        return (listaSalas.add(sala));
    }
    
    public boolean estaVazio(){
        return listaSalas.isEmpty();
    }

    public List<Sala> getListaSalas() {
        return listaSalas;
    }

    public boolean salaExiste(int numSala) {
        for (Sala sala : listaSalas) {
            if (sala.getnSala() == numSala){
                return true;
            } else {
            }
        }
        return false;
    }

    public Sala buscarSala(int numSala) {
        for (Sala sala : listaSalas) {
            if (sala.getnSala() == numSala) {
                return sala;
           }
        }
        return null;
    }    
}
