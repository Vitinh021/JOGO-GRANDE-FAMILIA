/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Classes.Inimigo;
import Classes.Jogador;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import Telas.Fase1;
import Telas.FimDeJogo;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import model.Pontuacao;

/**
 *
 * @author Aluno
 */
public class ThreadFase1 extends Thread {

    private Fase1 fase;
    private int pontoDaFase, pontoDoArquivo;
    private String pontoDaFaseSTR, pontoDoArquivoSTR;
    private Clip clip, clip2;
    private AudioInputStream audioInputStream, audioInputStream2;

    public ThreadFase1(Fase1 fase) {
        this.fase = fase;
    }

    public void run() {
        
                try {
            audioInputStream = AudioSystem.getAudioInputStream(new File("src/sons/grandefamilia.wav").getAbsoluteFile());
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.loop(Integer.MAX_VALUE);
        } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(ThreadFase1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ThreadFase1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (LineUnavailableException ex) {
            Logger.getLogger(ThreadFase1.class.getName()).log(Level.SEVERE, null, ex);
        }
                
        while (true) {

            for (int i = 0; i < fase.getTiros().size(); i++) {
                JLabel tiro = fase.getTiros().get(i);
                tiro.setLocation(tiro.getX(), tiro.getY() - 5);

                for (int j = 0; j < fase.getInimigos().size(); j++) {
                    Inimigo inimigo = fase.getInimigos().get(j);

                    if (tiro.getBounds().intersects(inimigo.getBounds()) && tiro.isVisible()) {

                        fase.setPontos(fase.getPontos() + inimigo.getPontos());
                        fase.getExibirpontos().setText("Pontos:" + (int) fase.getPontos() + "");

                        fase.getPainel().remove(tiro);
                        fase.getTiros().remove(tiro);

                        fase.getPainel().remove(inimigo);
                        fase.getInimigos().remove(inimigo);

                    } else if (tiro.getLocation().getY() < 0) {

                        fase.getPainel().remove(tiro);
                        fase.getTiros().remove(tiro);
                    }

                }

            }

            if (fase.getFundo1().getY() < fase.getHeight()) {
                fase.getFundo1().setLocation(0, fase.getFundo1().getY() + 5);
            } else {
                fase.getFundo1().setLocation(0,
                        fase.getFundo1().getY() + 10
                        - (fase.getFundo1().getIcon().getIconHeight() * 2));
            }
            if (fase.getFundo2().getY() < fase.getHeight()) {
                fase.getFundo2().setLocation(0, fase.getFundo2().getY() + 5);
            } else {
                fase.getFundo2().setLocation(0,
                        fase.getFundo2().getY() + 10
                        - (fase.getFundo2().getIcon().getIconHeight() * 2));
            }

            Random random = new Random();
            if (random.nextInt(100) < 2) {
                Inimigo inimigo = new Inimigo(random.nextInt(3) + 1);
                inimigo.setBounds(random.nextInt(1300), -random.nextInt(1000), inimigo.getIcon().getIconWidth(), inimigo.getIcon().getIconHeight());
                fase.getPainel().add(inimigo);
                inimigo.setVisible(true);
                fase.getPainel().setComponentZOrder(inimigo, 0);
                fase.getInimigos().add(inimigo);
            }

            for (int p = 0; p < fase.getInimigos().size(); p++) {
                Inimigo inimigo = fase.getInimigos().get(p);

                if (inimigo.getPontos() == 10) {
                    inimigo.setLocation(inimigo.getX(), inimigo.getY() + fase.movimentoinimigo);
                }

                if (inimigo.getPontos() == 30) {
                    inimigo.setLocation(inimigo.getX(), inimigo.getY() + fase.movimentoinimigo + 2);
                }
                if (inimigo.getPontos() == 60) {
                    inimigo.setLocation(inimigo.getX(), inimigo.getY() + 7);

                }

                if (inimigo.getBounds().intersects(fase.getJogador().getBounds()) && inimigo.isVisible()) {
                    //String pont = Pontuacao.leitor(arquivo);

                    pontoDaFase = fase.getPontos();
                    pontoDaFaseSTR = pontoDaFase + "";
                    System.out.println(pontoDaFaseSTR);
                    try {
                        System.out.println("try");
                        pontoDoArquivoSTR = Pontuacao.leitor("src/pontuacao/pontuacao.txt");
                        pontoDoArquivo = Integer.parseInt(pontoDoArquivoSTR);

                        if (pontoDaFase > pontoDoArquivo) {

                            Pontuacao.escritor("src/pontuacao/pontuacao.txt", pontoDaFaseSTR);
                            System.out.println(pontoDaFaseSTR);
                        }

                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(ThreadFase1.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(ThreadFase1.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    clip.stop();
                    new FimDeJogo();
                    fase.dispose();
                    Thread.currentThread().stop();

                }

            }

            try {
                sleep(20);
            } catch (InterruptedException ex) {
                Logger.getLogger(ThreadFase1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
