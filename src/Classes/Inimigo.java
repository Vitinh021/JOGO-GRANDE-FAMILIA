/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Joao Cristino
 */
public class Inimigo extends JLabel {

    public static int INIMIGO_1 = 1;
    public static final int INIMIGO_2 = 2;
    public static final int INIMIGO_3 = 3;

    private boolean statusinimigo;
    private int pontos;

    public Inimigo(int opcaoInimigo) {

        if (opcaoInimigo == INIMIGO_1) {
            setIcon(new ImageIcon("src/imagens/waze0.png"));
            pontos = 10;
        } else if (opcaoInimigo == INIMIGO_2) {
            setIcon(new ImageIcon("src/imagens/uber0.png"));
            pontos = 30;
        } else if (opcaoInimigo == INIMIGO_3) {
            setIcon(new ImageIcon("src/imagens/buzao.png"));
            pontos = 60;
        }
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public void setIcon(String srcimagensbooongif) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
