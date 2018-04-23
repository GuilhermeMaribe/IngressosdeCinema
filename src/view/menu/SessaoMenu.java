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
public class SessaoMenu {
    
    public static final int OP_CADASTRAR = 1;
    public static final int OP_LISTAR = 2;
    public static final int OP_BUSCAR_FILME = 3;
    public static final int OP_BUSCAR_SALA = 4;
    public static final int OP_BUSCAR_HORARIO = 5;
    public static final int OP_VOLTAR = 0;

    public static String getOpcoes() {
        return ("\n--------------------------------------\n"
                + "1 - Cadastrar Sessão\n"
                + "2 - Listar Sessões\n"
                + "3 - Buscar Sessão por Filme\n"
                + "4 - Buscar Sessão por Sala\n"
                + "5 - Buscar Sessão por Horário\n"
                + "0 - Voltar"
                + "\n--------------------------------------");
    }
}