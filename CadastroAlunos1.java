package spring;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CadastroAlunos1 extends JFrame {

	private JTextField nomeField, cpfField, dataNascimentoField;
	private ArrayList<Aluno1> listaAlunos1;
	private DefaultTableModel tableModel;
	private JTable table;
	
	public CadastroAlunos1(){
		listaAlunos1 = new ArrayList<>();
		
		JLabel nomeLabel = new JLabel("Nome:");
		nomeField = new JTextField(2);                   
		
		JLabel cpfLabel = new JLabel("CPF:");
		cpfField = new JTextField(2);
		
		JLabel dataNascimentoLabel = new JLabel("Data de Nascimento:");
		dataNascimentoField = new JTextField(2);
		
		JButton cadastrarButton = new JButton("Cadastrar: ");
		cadastrarButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cadastrarAluno1();
			}
		});
		
		JButton buscarButton = new JButton("Buscar Cpf ");
		cadastrarButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				buscaralunoporcpf1();
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
		
	
	protected void buscaralunoporcpf1() {
		String cpfbsuca = cpfField.getText();
		for(Aluno1 aluno : listaAlunos1) {
			if(aluno.getCpf().equals(cpfbsuca)) {
                JOptionPane.showMessageDialog(this, "Nome: " + aluno.getNome() + "\nData de Nascimento: " + aluno.getDatNascimento());
                return;
			}
		        JOptionPane.showMessageDialog(this, "Aluno com CPF " + cpfbsuca + " não encontrado.");
		}
	}

	protected void cadastrarAluno1() {
		String nome = nomeField.getText();
		String cpf = cpfField.getText();
		String dataNascimento = dataNascimentoField.getText();
		
		Aluno1 aluno = new Aluno1(nome, cpf, dataNascimento);
		listaAlunos1.add(aluno);
		
		tableModel.addRow(new String[] {nome, cpf , dataNascimento});
		
	}

	public static void main(String[] args) {
        new CadastroAlunos1();
    }	
}
