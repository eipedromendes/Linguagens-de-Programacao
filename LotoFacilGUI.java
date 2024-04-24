import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;

public class LotoFacilGUI extends JFrame{
    private JPanel painel = new JPanel();
    private JLabel jLabelMensagem = new JLabel("Escolha um tipo de aposta para começar");
    private JButton jButtonAposta1 = new JButton("Aposta de 0 a 100");
    private JButton jButtonAposta2 = new JButton("Aposta de A á Z");
    private JButton jButtonAposta3 = new JButton("Aposta em par ou ímpar");

    public LotoFacilGUI(){
        this.setTitle("Loto Fácil - Interface Gráfica");
        this.setSize(400,250);
        painel.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 20));
        painel.setBackground(new Color(192, 192, 192)); // Cinza
        jLabelMensagem.setFont(new Font("Arial", Font.BOLD, 16));
        jLabelMensagem.setForeground(Color.BLUE); // Azul
        painel.add(jLabelMensagem);
        customizeButton(jButtonAposta1); customizeButton(jButtonAposta2); customizeButton(jButtonAposta3);
        painel.add(jButtonAposta1); painel.add(jButtonAposta2); painel.add(jButtonAposta3);
        this.getContentPane().add(painel);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);

        jButtonAposta1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String aposta = JOptionPane.showInputDialog(null,
                        "Digite um número de 0 a 100",
                        "Faça sua Aposta",
                        JOptionPane.PLAIN_MESSAGE);

                try {
                    if (aposta != null && !aposta.isEmpty()) {
                        int numeroApostado = Integer.parseInt(aposta);
                        if (numeroApostado >= 0 && numeroApostado <= 100) {
                            Random rnd = new Random();
                            int sorteio = rnd.nextInt(101);
                            if (numeroApostado == sorteio) {
                                JOptionPane.showMessageDialog(null, "Você ganhou R$ 1.000,00 reais",
                                        "Resultado da Aposta", JOptionPane.INFORMATION_MESSAGE);
                            } else {
                                JOptionPane.showMessageDialog(null, "Que pena, você perdeu! O número sorteado foi: " + sorteio,
                                        "Resultado da Aposta", JOptionPane.INFORMATION_MESSAGE);
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Por favor, digite um número entre 0 e 100.",
                                    "Erro na Aposta", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Você não digitou um número.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Por favor, digite um número válido.",
                            "Erro na Aposta", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        jButtonAposta2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Random rnd = new Random();
                char letraViciada = (char) (rnd.nextInt(26) + 'A');
                String aposta = JOptionPane.showInputDialog(null,
                        "Digite uma letra de A á Z",
                        "Faça sua Aposta",
                        JOptionPane.PLAIN_MESSAGE);

                if (aposta != null && !aposta.isEmpty()) {
                    char letraApostada = aposta.toUpperCase().charAt(0);

                    if (Character.isLetter(letraApostada)) {
                        if (letraApostada == letraViciada) {
                            JOptionPane.showMessageDialog(null, "Você ganhou R$ 500,00 reais.");
                        } else {
                            JOptionPane.showMessageDialog(null, "Que pena, você perdeu! A letra sorteada foi: " + letraViciada);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Por favor, digite uma letra válida.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Você não digitou uma letra.");
                }
            }
        });

        jButtonAposta3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Random rnd = new Random();
                int sorteio = rnd.nextInt(101);
                int numeroApostado = sorteio % 2; // Se sorteio for par, numeroApostado será 0, senão será 1

                String mensagem = "Que pena, você perdeu! O número sorteado era ";
                if (numeroApostado == 0) {
                    mensagem += "par: " + sorteio;
                } else {
                    mensagem += "ímpar: " + sorteio;
                }

                JOptionPane.showMessageDialog(null, mensagem);
            }
        });

    }

    private void customizeButton(JButton button) {
        button.setBackground(Color.WHITE); // Branco
        button.setForeground(Color.BLACK);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        button.setPreferredSize(new Dimension(180, 40));
    }

    public static void main(String[] args) {
        new LotoFacilGUI();
    }
}
