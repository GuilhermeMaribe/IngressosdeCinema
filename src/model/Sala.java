package model;

/**
 *
 * @author guilh
 */
public class Sala {
    
    private int nSala, nAssentos;

    public Sala(int nSala, int nAssentos) {
        this.nSala = nSala;
        this.nAssentos = nAssentos;
    }
    
    public int getnSala() {
        return nSala;
    }

    public int getnAssentos() {
        return nAssentos;
    } 
    
}
