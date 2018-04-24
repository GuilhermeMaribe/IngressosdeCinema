
package repositorio;

import java.util.ArrayList;
import java.util.List;
import model.Sessao;
import model.VendaIngresso;

/**
 *
 * @author guilh
 */
public class RepositorioVendas {
    
    private List<VendaIngresso> listaVendas;
    private static RepositorioVendas instance = null;
    
    private RepositorioVendas() {
        listaVendas = new ArrayList<VendaIngresso>();
    }
    
    public static RepositorioVendas getInstance() {
        if(instance == null) instance = new RepositorioVendas();
        return instance;
    }
    
    public boolean addVenda(VendaIngresso venda) {
        return (listaVendas.add(venda));
    }
    
     public List<VendaIngresso> getListaVendas() {
        return listaVendas;
    }
     
     public boolean vendaExiste(int codSessao) {
        for (VendaIngresso venda : listaVendas) {
            if (venda.getSessao().getCodigo() == codSessao) {
                return true;
            }
        }
        return false;
    }
     
    public List<VendaIngresso> buscarVendasPorSessao(int codSessao) {
        List<VendaIngresso> listaNova = new ArrayList<VendaIngresso>();
        for (VendaIngresso venda : listaVendas) {
            if (venda.getSessao().getCodigo() == codSessao) {
                listaNova.add(venda);
            }
        }
        return listaNova;
    }
     
    public int ingressosVendidosPorSessao(int codSessao) {
        int ingressosVendidos = 0;
        for (VendaIngresso venda : buscarVendasPorSessao(codSessao)) {
            ingressosVendidos += venda.getnIngressos();
        }
        return ingressosVendidos;
    }

}
