package view;

import model.Projeto;
import service.PrjService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class TelaPrincipal extends JFrame {

    private JComboBox<String> comboCategoria;
    private JComboBox<String> comboStatus;

    private JTable tabela;
    private DefaultTableModel modelo;

    private JTextField campoNome;
    private JTextField campoDescricao;

    private JButton botaoCadastrar;
    private  JButton botaoLimpar;

    private PrjService service = new PrjService();

    public TelaPrincipal() {
        System.out.println("Diretório atual: " + System.getProperty("user.dir"));
        setTitle("Sistema de Projetos");
        setSize(800, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        criarComponentes();
        criarEventos();

    }

    private void carregarTabela() {

        modelo.setRowCount(0);

        for (Projeto projeto : service.listar()) {

            modelo.addRow(
                    new Object[]{
                            projeto.getId(),
                            projeto.getNome(),
                            projeto.getCategoria(),
                            projeto.getStatus()
                    }
            );
        }
    }
    private void criarComponentes() {

        campoNome = new JTextField(20);

        campoDescricao = new JTextField(20);

        comboCategoria = new JComboBox<>();

        comboCategoria.addItem("Web");
        comboCategoria.addItem("Software");
        comboCategoria.addItem("Mobile");
        comboCategoria.addItem("Outro");

        comboStatus = new JComboBox<>();

        comboStatus.addItem("Planejado");
        comboStatus.addItem("Em desenvolvimento");
        comboStatus.addItem("Concluído");

        botaoCadastrar = new JButton("Cadastrar");

        botaoLimpar = new JButton("Limpar");

        modelo = new DefaultTableModel();

        modelo.addColumn("ID");
        modelo.addColumn("Nome");
        modelo.addColumn("Categoria");
        modelo.addColumn("Status");

        tabela = new JTable(modelo);

        JPanel painelFormulario = new JPanel();

        painelFormulario.add(new JLabel("Nome:"));
        painelFormulario.add(campoNome);

        painelFormulario.add(new JLabel("Descrição:"));
        painelFormulario.add(campoDescricao);

        painelFormulario.add(new JLabel("Categoria:"));
        painelFormulario.add(comboCategoria);

        painelFormulario.add(new JLabel("Status:"));
        painelFormulario.add(comboStatus);

        painelFormulario.add(botaoCadastrar);
        painelFormulario.add(botaoLimpar);

        setLayout(new BoxLayout(
                getContentPane(),
                BoxLayout.Y_AXIS
        ));

        add(painelFormulario);

        add(new JScrollPane(tabela));
    }

    private void criarEventos() {

        botaoLimpar.addActionListener(e -> limparFormulario());

        botaoCadastrar.addActionListener(e -> {
            try {
                cadastrar();
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });
    }

    private void limparFormulario() {

        campoNome.setText("");

        campoDescricao.setText("");

        comboCategoria.setSelectedIndex(0);

        comboStatus.setSelectedIndex(0);

        campoNome.requestFocus();
    }

    private void cadastrar() throws Exception {

        String nome = campoNome.getText();
        String descricao = campoDescricao.getText();
        String categoria =
                comboCategoria.getSelectedItem().toString();

        String status =
                comboStatus.getSelectedItem().toString();

        if (nome.isBlank()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Informe o nome."
            );

            return;
        }

        Projeto projeto = new Projeto(
                nome,
                descricao,
                categoria,
                status
        );

        PrjService.adicionar(projeto);

        service.salvar();

        JOptionPane.showMessageDialog(
                this,
                "Projeto cadastrado com sucesso!"
        );

        limparFormulario();

        carregarTabela();
    }

    public static void main(String[] args) {

        TelaPrincipal tela = new TelaPrincipal();

        tela.setVisible(true);
    }
}