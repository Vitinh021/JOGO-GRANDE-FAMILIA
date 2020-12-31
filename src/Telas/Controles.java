/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Telas;

import Controle.ControleTelaControles;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Joao Cristino
 */
public class Controles extends JFrame{
    
        private JLabel fundocontrole, botaoVoltar;

    
    
    public Controles(){
        
        setSize(1400, 800);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);
        
        botaoVoltar = new JLabel(new ImageIcon("src/imagens/voltar1.png"));
        botaoVoltar.setBounds(200, 515, 200, 50);
        botaoVoltar.setVisible(true);
        botaoVoltar.addMouseListener(new ControleTelaControles(this));
        add(botaoVoltar);
        
        fundocontrole = new JLabel(new ImageIcon("src/imagens/fundocontroles.jpg"));
        fundocontrole.setBounds(0, 0, fundocontrole.getIcon().getIconWidth(), fundocontrole.getIcon().getIconHeight());
        fundocontrole.setVisible(true);
        add(fundocontrole);
        
        repaint();
    
    }

    public JLabel getBotaoVoltar() {
        return botaoVoltar;
    }

    public void setBotaoVoltar(JLabel botaoVoltar) {
        this.botaoVoltar = botaoVoltar;
    }
    
}
