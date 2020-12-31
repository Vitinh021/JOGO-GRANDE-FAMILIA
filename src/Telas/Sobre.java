/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Telas;

import Controle.ControleSobre;
import java.awt.Color;
import java.awt.Font;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import model.Pontuacao;

/**
 *
 * @author Joao Cristino
 */
public class Sobre extends JFrame {

    private JLabel fundosobre, botaoVoltar, botaocontroles, exibirpontos;
    String pont;
    public Sobre() throws IOException {
        this.pont = Pontuacao.leitor("src/pontuacao/pontuacao.txt");

        setSize(1400, 800);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);

        exibirpontos = new JLabel("Maior pontuação:" + pont);
        exibirpontos.setBounds(200, 375, 300, 50);
        exibirpontos.setForeground(Color.orange);
        exibirpontos.setFont(new Font("Times New Roman", Font.BOLD, 30));
        add(exibirpontos);

        botaoVoltar = new JLabel(new ImageIcon("src/imagens/voltar1.png"));
        botaoVoltar.setBounds(200, 450, 200, 50);
        botaoVoltar.setVisible(true);
        botaoVoltar.addMouseListener(new ControleSobre(this));
        add(botaoVoltar);

        botaocontroles = new JLabel(new ImageIcon("src/imagens/controle1.png"));
        botaocontroles.setBounds(200, 515, 200, 50);
        botaocontroles.setVisible(true);
        botaocontroles.addMouseListener(new ControleSobre(this));
        add(botaocontroles);

        fundosobre = new JLabel(new ImageIcon("src/imagens/sobrefundo.jpg"));
        fundosobre.setBounds(0, 0, fundosobre.getIcon().getIconWidth(), fundosobre.getIcon().getIconHeight());
        fundosobre.setVisible(true);
        add(fundosobre);

        repaint();

    }

    public JLabel getBotaoVoltar() {
        return botaoVoltar;
    }

    public void setBotaovoltar(JLabel botaoVoltar) {
        this.botaoVoltar = botaoVoltar;
    }

    public JLabel getBotaocontroles() {
        return botaocontroles;
    }

    public void setBotaocontroles(JLabel botaocontroles) {
        this.botaocontroles = botaocontroles;
    }

}
