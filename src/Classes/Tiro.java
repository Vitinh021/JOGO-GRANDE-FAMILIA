/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Joao Cristino
 */
public class Tiro extends JLabel{

    public Tiro(int direcao, int dano) {

        setIcon(new ImageIcon("src/imagens/cartao.png"));
    
    }
}
