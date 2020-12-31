/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Telas.Controles;
import Telas.Sobre;
import Telas.TelaInicial;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;

/**
 *
 * @author Joao Cristino
 */
public class ControleSobre implements MouseListener {

    private Sobre sobre;


    public ControleSobre(Sobre so) {
        sobre = so;

    }

    @Override
    public void mouseClicked(MouseEvent me) {
        if (me.getSource() == this.sobre.getBotaoVoltar()) {
            new TelaInicial();
            sobre.dispose();
        }
        if (me.getSource() == this.sobre.getBotaocontroles()) {
            new Controles();
            sobre.dispose();
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
        if (me.getSource() == this.sobre.getBotaoVoltar()) {
            this.sobre.getBotaoVoltar().setIcon(new ImageIcon("src/imagens/voltar2.png"));
        }
        if (me.getSource() == this.sobre.getBotaocontroles()) {
            this.sobre.getBotaocontroles().setIcon(new ImageIcon("src/imagens/controle2.png"));
        }
    }

    @Override
    public void mouseExited(MouseEvent me) {
        if (me.getSource() == this.sobre.getBotaoVoltar()) {
            this.sobre.getBotaoVoltar().setIcon(new ImageIcon("src/imagens/voltar1.png"));
        }
        if (me.getSource() == this.sobre.getBotaocontroles()) {
            this.sobre.getBotaocontroles().setIcon(new ImageIcon("src/imagens/controle1.png"));
        }
    }
}
