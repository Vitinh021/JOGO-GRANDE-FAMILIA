
package Telas;

import Controle.ControleTelaInicial;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class TelaInicial extends JFrame {

    private JLabel fundoinicial, botaoJogar, botaoSair, botaoSobre;
    
    public TelaInicial(){
        
        setSize(1400, 800);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setVisible(true);
   
        botaoSair = new JLabel(new ImageIcon("src/imagens/sair1.png"));
        botaoSair.setSize(200, 50);
        botaoSair.setLocation(400,300);
        botaoSair.setVisible(true);
        botaoSair.addMouseListener(new ControleTelaInicial(this));
        add(botaoSair);
        
        botaoJogar = new JLabel(new ImageIcon("src/imagens/jogar1.png"));
        botaoJogar.setBounds(400, 375, 200, 50);
        botaoJogar.setVisible(true);
        botaoJogar.addMouseListener(new ControleTelaInicial(this));
        add(botaoJogar);
        
        botaoSobre = new JLabel(new ImageIcon("src/imagens/sobre1.png"));
        botaoSobre.setBounds(400, 450, 200, 50);
        botaoSobre.setVisible(true);
        botaoSobre.addMouseListener(new ControleTelaInicial(this));
        add(botaoSobre);
        
        fundoinicial = new JLabel(new ImageIcon("src/imagens/fundoinicial.png"));
        fundoinicial.setBounds(0, 0, fundoinicial.getIcon().getIconWidth(), fundoinicial.getIcon().getIconHeight());
        fundoinicial.setVisible(true);
        add(fundoinicial);
        
        repaint();
        
    }
    
    public JLabel getBotaoSair() {
        return botaoSair;
    }

    public void setBotaoSair(JLabel botaoSair) {
        this.botaoSair = botaoSair;
    }

    public JLabel getBotaoJogar() {
        return botaoJogar;
    }

    public void setBotaoJogar(JLabel botaoJogar) {
        this.botaoJogar = botaoJogar;
    }

    public JLabel getBotaoSobre() {
        return botaoSobre;
    }

    public void setBotaoSobre(JLabel botaoSobre) {
        this.botaoSobre = botaoSobre;
    }
    
}
