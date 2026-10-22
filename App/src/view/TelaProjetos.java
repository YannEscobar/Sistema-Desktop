package view;

import javax.swing.*;

public class TelaProjetos extends JFrame {

    private JLabel labelNome;
    private JTextField campoNome;
    private JButton botaoCadastrar;

    public TelaProjetos() {

        setTitle("Cadastro de Projetos");
        setSize(600, 400);
        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        labelNome = new JLabel("Nome:");

        campoNome = new JTextField(30);

        botaoCadastrar = new JButton("Cadastrar");

        JPanel painel = new JPanel();

        painel.add(labelNome);
        painel.add(campoNome);
        painel.add(botaoCadastrar);

        add(painel);
    }

    public static void main(String[] args) {

        TelaProjetos tela = new TelaProjetos();

        tela.setVisible(true);
    }
}