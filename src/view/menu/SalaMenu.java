/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.menu;

/**
 *
 * @author guilh
 */
public class SalaMenu {
    
    public static final int OP_CADASTRAR = 1;
    public static final int OP_LISTAR = 2;
    public static final int OP_BUSCAR_NUMERO = 3;
    public static final int OP_VOLTAR = 0;

    public static String getOpcoes() {
        return ("\n--------------------------------------\n"
                + "1 - Cadastrar Salas\n"
                + "2 - Listar Salas\n"
                + "3 - Buscar Sala por Número\n"
                + "0 - Voltar"
                + "\n--------------------------------------");
    }
    
}
