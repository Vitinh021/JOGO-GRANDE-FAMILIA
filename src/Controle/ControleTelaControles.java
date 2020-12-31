/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Telas.Controles;
import Telas.Sobre;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 *
 * @author Joao Cristino
 */
public class ControleTelaControles implements MouseListener {

    private Controles controle;

    public ControleTelaControles(Controles co) {
        controle = co;
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        if (me.getSource() == this.controle.getBotaoVoltar()) {
            try {
                new Sobre();
            } catch (IOException ex) {
                Logger.getLogger(ControleTelaControles.class.getName()).log(Level.SEVERE, null, ex);
            }
            controle.dispose();
        }
    }

    @Override
    public void mousePressed(MouseEvent me) {
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        if (me.getSource() == this.controle.getBotaoVoltar()) {
            this.controle.getBotaoVoltar().setIcon(new ImageIcon("src/imagens/voltar2.png"));
        }
    }

    @Override
    public void mouseExited(MouseEvent me) {
        if (me.getSource() == this.controle.getBotaoVoltar()) {
            this.controle.getBotaoVoltar().setIcon(new ImageIcon("src/imagens/voltar1.png"));
        }
    }

}
