package model;

/**
 *
 * @author guilh
 */
public class VendaIngresso {
    
    private Sessao sessao;
    private int nIngressos;

    public VendaIngresso(Sessao sessao, int nIngressos) {
        this.sessao = sessao;
        this.nIngressos = nIngressos;
    }
    
    public Sessao getSessao() {
        return sessao;
    }

    public int getnIngressos() {
        return nIngressos;
    }
    
}
