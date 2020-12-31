/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Telas.FimDeJogo;
import Telas.TelaInicial;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;

/**
 *
 * @author Joao Cristino
 */
public class ControleFimDeJogo implements MouseListener {

    private FimDeJogo fimdejogo;
    private Clip clip;

    public ControleFimDeJogo(FimDeJogo fim, Clip clip) {
        fimdejogo = fim;
        clip = clip;
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        if (me.getSource() == this.fimdejogo.getBotaoVoltar()) {
            new TelaInicial();
            fimdejogo.dispose();
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
        if (me.getSource() == this.fimdejogo.getBotaoVoltar()) {
            this.fimdejogo.getBotaoVoltar().setIcon(new ImageIcon("src/imagens/voltar2.png"));
        }
    }

    @Override
    public void mouseExited(MouseEvent me) {
        if (me.getSource() == this.fimdejogo.getBotaoVoltar()) {
            this.fimdejogo.getBotaoVoltar().setIcon(new ImageIcon("src/imagens/voltar1.png"));
        }
    }

}
