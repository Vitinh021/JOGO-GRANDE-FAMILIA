/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Telas;

import Controle.ControleFimDeJogo;
import Modelo.ThreadFase1;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Joao Cristino
 */
public class FimDeJogo extends JFrame {

    private JLabel fundofimdejogo, botaoVoltar;
    private ImageIcon fundoperdeu;
    private int escolha;
    private AudioInputStream audioInputStream, audioInputStream2;
    private Clip clip;

    public FimDeJogo() {

        setSize(1400, 800);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);

        try {
            audioInputStream = AudioSystem.getAudioInputStream(new File("src/sons/fimdejogo.wav").getAbsoluteFile());
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(ThreadFase1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ThreadFase1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (LineUnavailableException ex) {
            Logger.getLogger(ThreadFase1.class.getName()).log(Level.SEVERE, null, ex);
        }

        Random random = new Random();
        escolha = random.nextInt(3) + 1;

        if (escolha == 1) {
            fundoperdeu = new ImageIcon("src/imagens/fundofimdejogomotivacional1.png");
        } else if (escolha == 2) {
            fundoperdeu = new ImageIcon("src/imagens/fundofimdejogomotivacional2.png");
        } else if (escolha == 3) {
            fundoperdeu = new ImageIcon("src/imagens/fundofimdejogomotivacional3.png");
        }

        botaoVoltar = new JLabel(new ImageIcon("src/imagens/voltar1.png"));
        botaoVoltar.setBounds(130, 670, 200, 50);
        botaoVoltar.setVisible(true);
        botaoVoltar.addMouseListener(new ControleFimDeJogo(this, clip));
        add(botaoVoltar);

        fundofimdejogo = new JLabel(fundoperdeu);
        fundofimdejogo.setBounds(0, 0, 1400, 800);
        fundofimdejogo.setVisible(true);
        add(fundofimdejogo);

        repaint();

    }

    public JLabel getBotaoVoltar() {
        return botaoVoltar;
    }

    public void setBotaoVoltar(JLabel botaoVoltar) {
        this.botaoVoltar = botaoVoltar;
    }
}
