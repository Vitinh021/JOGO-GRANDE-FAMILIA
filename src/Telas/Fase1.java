/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Telas;

import Classes.Inimigo;
import Classes.Jogador;
import Classes.Tiro;
import Modelo.ThreadFase1;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author ALUNO
 */
public class Fase1 extends JFrame {

    private JLabel fundo1, fundo2, inimigo;
    private JPanel painel;
    private Jogador jogador;
    private ArrayList<Tiro> tiros;
    private ArrayList<Inimigo> inimigos;
    public int movimentoinimigo = 2;
    private int pontos;
    private JLabel exibirpontos;

    public Fase1() {

        setSize(1400, 800);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        painel = new JPanel();
        painel.setSize(1400, 800);
        painel.setVisible(true);
        painel.setLayout(null);
        add(painel);

        tiros = new ArrayList<Tiro>();
        inimigos = new ArrayList<Inimigo>();
        pontos = 0;
        
        exibirpontos = new JLabel("Pontos:" +(int) pontos + "");
        exibirpontos.setBounds(0, 0, 300, 50);
        exibirpontos.setForeground(Color.ORANGE);
        exibirpontos.setFont(new Font("Times New Roman",Font.BOLD,30));
        painel.add(exibirpontos);
        
        
        jogador = new Jogador();
        jogador.setBounds(painel.getSize().width / 2, painel.getHeight() / 2, jogador.getIcon().getIconWidth(), jogador.getIcon().getIconHeight());
        painel.add(jogador);

        fundo1 = new JLabel(new ImageIcon("src/imagens/ruaa.png"));
        fundo1.setBounds(0, 0, 1400, 800);
        painel.add(fundo1);

        fundo2 = new JLabel(new ImageIcon("src/imagens/ruaa.png"));
        fundo2.setBounds(0, -799, 1400, 800);
        painel.add(fundo2);

        addKeyListener(new ControleFase1(this));

        new ThreadFase1(this).start();
    }

    public JLabel getInimigo() {
        return inimigo;
    }

    public void setInimigo(JLabel inimigo) {
        this.inimigo = inimigo;
    }

    public Jogador getJogador() {
        return jogador;
    }

    public void setJogador(Jogador jogador) {
        this.jogador = jogador;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public JPanel getPainel() {
        return painel;
    }

    public void setPainel(JPanel painel) {
        this.painel = painel;
    }

    public ArrayList<Tiro> getTiros() {
        return tiros;
    }

    public void setTiros(ArrayList<Tiro> tiros) {
        this.tiros = tiros;
    }

    public JLabel getFundo1() {
        return fundo1;
    }

    public void setFundo1(JLabel fundo1) {
        this.fundo1 = fundo1;
    }

    public JLabel getFundo2() {
        return fundo2;
    }

    public void setFundo2(JLabel fundo2) {
        this.fundo2 = fundo2;
    }

    public int getMovimentoinimigo() {
        return movimentoinimigo;
    }

    public void setMovimentoinimigo(int movimentoinimigo) {
        this.movimentoinimigo = movimentoinimigo;
    }

    public ArrayList<Inimigo> getInimigos() {
        return inimigos;
    }

    public void setInimigos(ArrayList<Inimigo> inimigos) {
        this.inimigos = inimigos;
    }

    public JLabel getExibirpontos() {
        return exibirpontos;
    }

    public void setExibirpontos(JLabel exibirpontos) {
        this.exibirpontos = exibirpontos;
    }

}
