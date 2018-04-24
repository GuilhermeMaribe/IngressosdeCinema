package model;
/**
 *
 * @author guilh
 */
public class Filme {
    
    private int codigo;
    private String nomeFilme;
    private String genero;
    private String sinopse;
    
    public Filme(int codigo, String nomeFilme, String genero, String sinopse) {
        this.codigo = codigo;
        this.nomeFilme = nomeFilme;
        this.genero = genero;
        this.sinopse = sinopse;
    }
              
    public int getCodigo() {
        return codigo;
    }

    public String getNomeFilme() {
        return nomeFilme;
    }

    public String getGenero() {
        return genero;
    }

    public String getSinopse() {
        return sinopse;
    }
    
}
