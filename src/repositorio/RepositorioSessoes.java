
package repositorio;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import model.Sessao;

/**
 *
 * @author guilh
 */
public class RepositorioSessoes {
    
    private List<Sessao> listaSessoes;
    private static RepositorioSessoes instance = null;
    
    private RepositorioSessoes() {
        listaSessoes = new ArrayList<Sessao>();
    }

    public static RepositorioSessoes getInstance() {
        if(instance == null) instance = new RepositorioSessoes();
        return instance;
    }
        
    public boolean add(Sessao sessao) {
        return (listaSessoes.add(sessao));
    }
    
    public boolean estaVazio(){
        return listaSessoes.isEmpty();
    }

    public List<Sessao> getListaSessoes() {
        return listaSessoes;
    }

    public boolean sessaoExiste(int codigo) {
        for (Sessao sessao : listaSessoes) {
            if (sessao.getCodigo() == codigo){
                return true;
            } else {
            }
        }
        return false;
    }

    public Sessao buscarSessao(int codigo) {
        for (Sessao sessao : listaSessoes) {
            if (sessao.getCodigo() == codigo) {
                return sessao;
           }
        }
        return null;
    }
    
    public List<Sessao> getListaSessoesPorFilme(String nome) {
        List<Sessao> sessoesPorFilme = new ArrayList<Sessao>();
        for (Sessao sessao : listaSessoes) {
            if ((sessao.getFilme().getNomeFilme().toLowerCase().contains(nome)) || (sessao.getFilme().getNomeFilme().toUpperCase().contains(nome))) {
                sessoesPorFilme.add(sessao);
            }
        }
        return (sessoesPorFilme);
    }

    
    public List<Sessao> getListaSessoesPorSala(int numero) {
        List<Sessao> sessoesPorSala = new ArrayList<Sessao>();
        for (Sessao sessao : listaSessoes) {
            if (sessao.getSala().getnSala() == numero) {
                sessoesPorSala.add(sessao);
            }
        }
        return (sessoesPorSala);
    }

    
    public List<Sessao> getListaSessoesPorHorario(LocalTime horario) {
        List<Sessao> sessoesPorHorario = new ArrayList<Sessao>();
        for (Sessao sessao : listaSessoes) {
            if (sessao.getHorario().equals(horario)) {
                sessoesPorHorario.add(sessao);
            }
        }
        return (sessoesPorHorario);
    }
    
    public boolean sessaoSalaHorarioOcupados(int numero, LocalTime horario) {
        for (Sessao sessao : listaSessoes) {
            if ((sessao.getHorario().equals(horario)) && (sessao.getSala().getnSala() == numero)) {
                return true;
            }
        }
        return false;
    }
}
