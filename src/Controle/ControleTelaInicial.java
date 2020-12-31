/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Telas.Fase1;
import Telas.Sobre;
import Telas.TelaInicial;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

public class ControleTelaInicial implements ActionListener, MouseListener{
    
    private TelaInicial TelaInicial;
    
    public ControleTelaInicial (TelaInicial ti){
        TelaInicial=ti;
    }
           
    public void actionPerformed(ActionEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        if (me.getSource() == this.TelaInicial.getBotaoJogar()) {
            new Fase1();
            TelaInicial.dispose();
        }       
        if (me.getSource() == TelaInicial.getBotaoSair()){
            System.exit(0);
        }
        if (me.getSource() == TelaInicial.getBotaoSobre()){
            try {
                new Sobre();
            } catch (IOException ex) {
                Logger.getLogger(ControleTelaInicial.class.getName()).log(Level.SEVERE, null, ex);
            }
            TelaInicial.dispose();
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
        
        if (me.getSource() == this.TelaInicial.getBotaoJogar()) {
            this.TelaInicial.getBotaoJogar().setIcon(new ImageIcon("src/imagens/jogar2.png"));
        }
        
        if (me.getSource() == this.TelaInicial.getBotaoSair()) {
            this.TelaInicial.getBotaoSair().setIcon(new ImageIcon("src/imagens/sair2.png"));
        }
        if (me.getSource() == this.TelaInicial.getBotaoSobre()) {
            this.TelaInicial.getBotaoSobre().setIcon(new ImageIcon("src/imagens/sobre2.png"));
        }
        
    }

    @Override
    public void mouseExited(MouseEvent me) {
        
        if (me.getSource() == this.TelaInicial.getBotaoJogar()) {
            this.TelaInicial.getBotaoJogar().setIcon(new ImageIcon("src/imagens/jogar1.png"));
        }
        if (me.getSource() == this.TelaInicial.getBotaoSair()) {
            this.TelaInicial.getBotaoSair().setIcon(new ImageIcon("src/imagens/sair1.png"));
        }
         if (me.getSource() == this.TelaInicial.getBotaoSobre()) {
            this.TelaInicial.getBotaoSobre().setIcon(new ImageIcon("src/imagens/sobre1.png"));
        }
        
    }
    
    
}
