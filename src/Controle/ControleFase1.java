/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Telas;

import Classes.Jogador;
import Classes.Tiro;
import Telas.Fase1;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author ALUNO
 */
class ControleFase1 implements KeyListener {

    private Fase1 Fase1;

    public ControleFase1(Fase1 aThis) {
        Fase1=aThis;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
        if (e.getKeyChar()=='w' || e.getKeyChar() == 'W' && Fase1.getJogador().getY() > 0 ){
        Fase1.getJogador().setLocation(Fase1.getJogador().getX(),
                Fase1.getJogador().getY()-10);
        
        }
        if (e.getKeyChar()=='a' || e.getKeyChar() == 'A' && Fase1.getJogador().getX() > 0){
        Fase1.getJogador().setLocation(Fase1.getJogador().getX()-10,
                Fase1.getJogador().getY());
        }
        if (e.getKeyChar()=='d' || e.getKeyChar() == 'D' && Fase1.getJogador().getX() < 1300){
                Fase1.getJogador().setLocation(Fase1.getJogador().getX()+10,
                Fase1.getJogador().getY());
        }
        if (e.getKeyChar()=='s' || e.getKeyChar() == 'S' && Fase1.getJogador().getY() < 650){
        Fase1.getJogador().setLocation(Fase1.getJogador().getX(),
                Fase1.getJogador().getY()+10);
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
        
        if (e.getKeyChar()=='t' && Fase1.getTiros().size() < 5){
            Tiro tiro = new Tiro(-5, 10);
            tiro.setBounds(Fase1.getJogador().getX() + (int) (Fase1.getJogador().getIcon().getIconWidth() / 2),
                    Fase1.getJogador().getY(), tiro.getIcon().getIconWidth(), tiro.getIcon().getIconHeight());
            tiro.setVisible(true);
            Fase1.getPainel().add(tiro);
            Fase1.getPainel().setComponentZOrder(tiro, 0);
            Fase1.getTiros().add(tiro);
        
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {
        
    }
    
}
