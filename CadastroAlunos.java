package spring;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CadastroAlunos extends JFrame {

    private JTextField nomeField, cpfField, dataNascimentoField;
    private ArrayList<Aluno> listaAlunos;
    private DefaultTableModel tableModel;
    private JTable table;

    public CadastroAlunos() {
        listaAlunos = new ArrayList<>();

        JLabel nomeLabel = new JLabel("Nome:");
        nomeField = new JTextField(2);

        JLabel cpfLabel = new JLabel("CPF:");
        cpfField = new JTextField(2);

        JLabel dataNascimentoLabel = new JLabel("Data de Nascimento:");
        dataNascimentoField = new JTextField(2);

        JButton cadastrarButton = new JButton("Cadastrar");
        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrarAluno();
            }
        });

        JButton buscarButton = new JButton("Buscar por CPF");
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarAlunoPorCPF();
            }
        });

        tableModel = new DefaultTableModel();
        tableModel.addColumn("Nome");
        tableModel.addColumn("CPF");
        tableModel.addColumn("Data de Nascimento");

        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        JPanel panel = new JPanel(new GridLayout(5, 2));
        panel.add(nomeLabel);
        panel.add(nomeField);
        panel.add(cpfLabel);
        panel.add(cpfField);
        panel.add(dataNascimentoLabel);
        panel.add(dataNascimentoField);
        panel.add(cadastrarButton);
        panel.add(buscarButton);
        panel.add(new JLabel("Alunos Cadastrados:"));
        panel.add(scrollPane);

        add(panel);
        setTitle("Cadastro de Alunos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void cadastrarAluno() {
        String nome = nomeField.getText();
        String cpf = cpfField.getText();
        String dataNascimento = dataNascimentoField.getText();

        Aluno aluno = new Aluno(nome, cpf, dataNascimento);
        listaAlunos.add(aluno);

        tableModel.addRow(new String[]{nome, cpf, dataNascimento});

        JOptionPane.showMessageDialog(this, "Aluno cadastrado com sucesso!");
    }

    private void buscarAlunoPorCPF() {
        String cpfBusca = cpfField.getText();

        for (Aluno aluno : listaAlunos) {
            if (aluno.getCpf().equals(cpfBusca)) {
                JOptionPane.showMessageDialog(this, "Nome: " + aluno.getNome() + "\nData de Nascimento: " + aluno.getDataNascimento());
                return;
            }
        }

        JOptionPane.showMessageDialog(this, "Aluno com CPF " + cpfBusca + " não encontrado.");
    }

    public static void main(String[] args) {
        new CadastroAlunos();
    }
}