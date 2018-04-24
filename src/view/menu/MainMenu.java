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
public class MainMenu {
    
    public static final int OP_FILMES = 1;
    public static final int OP_SALA = 2;
    public static final int OP_SESSAO = 3;
    public static final int OP_VENDAINGRESSO = 4;
    public static final int OP_SAIR = 0;

    public static String getOpcoes() {
        return ("\n--------------------------------------\n"
                + "----------------CINEMA----------------\n"
                + "1- Menu Filmes\n"
                + "2- Menu Sala\n"
                + "3- Menu Sessao\n"
                + "4- Menu Venda de Ingressos\n"
                + "0- Sair da Aplicação"
                + "\n--------------------------------------");
    }
}
