package model;
import java.time.LocalTime;


/**
 *
 * @author guilh
 */
public class Sessao {
    
    private static int CODIGO_GERADO = 1;
    private int codigo;
    private Sala sala;
    private LocalTime horario;
    private Filme filme;

    public Sessao(Sala sala, LocalTime horario, Filme filme) {
        this.codigo = generateCodigo();
        this.sala = sala;
        this.horario = horario;
        this.filme = filme;
    }

    public int getCodigo() {
        return codigo;
    }
         
    public Sala getSala() {
        return sala;
    }

    public LocalTime getHorario() {
        return horario;
    }

    public Filme getFilme() {
        return filme;
    }
    
     private int generateCodigo() {
        return (CODIGO_GERADO++);
    } 
     
}
