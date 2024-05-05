package spring;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Clinica extends JFrame {

    private List<Medico> medicos = new ArrayList<>();
    private List<Paciente> pacientes = new ArrayList<>();
    private List<Consulta> consultas = new ArrayList<>();
    private DefaultTableModel tableModel;
    private JTable medicosTable, pacientesTable, horariosTable;

    public Clinica() {
        setTitle("Clinica Fica Flinstones");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        DefaultTableModel medicosTableModel = new DefaultTableModel(new String[]{"Nome", "Especialidade", "Crm", "Horarios Disponíveis"}, 0);
        medicosTable = new JTable(medicosTableModel);
        JScrollPane scrollPane = new JScrollPane(medicosTable);
        panel.add(scrollPane, BorderLayout.NORTH);

        DefaultTableModel pacientesTableModel = new DefaultTableModel(new String[]{"Nome", "CPF", "Endereco", "Contato", "Histórico médico"}, 0);
        pacientesTable = new JTable(pacientesTableModel);
        JScrollPane scrollPane1 = new JScrollPane(pacientesTable);
        panel.add(scrollPane1, BorderLayout.CENTER);

        DefaultTableModel horariosTableModel = new DefaultTableModel(new String[]{"Horário", "Médico", "Paciente"}, 0);
        horariosTable = new JTable(horariosTableModel);
        JScrollPane scrollPane11 = new JScrollPane(horariosTable);

        JPanel southPanel = new JPanel(new BorderLayout());
        southPanel.add(scrollPane11, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        JButton addMedicoButton = new JButton("Adicionar Médico");
        addMedicoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adicionarMedico();
            }
        });
        buttonPanel.add(addMedicoButton);


        JButton addPacienteButton = new JButton("Adicionar Paciente");
        addPacienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adicionarPaciente();
            }
        });
        buttonPanel.add(addPacienteButton);

        JButton addmarcarConsultaButton = new JButton("Marcar Consulta");
        addmarcarConsultaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                marcarConsulta();
            }
        });
        buttonPanel.add(addmarcarConsultaButton);


        JButton addRemoverPacienteButton = new JButton("Remover Paciente");
        addRemoverPacienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removerPaciente();
            }
        });
        buttonPanel.add(addRemoverPacienteButton);


        JButton addRemoverMedicoButton = new JButton("Remover Médico");
        addRemoverMedicoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removerMedico();
            }
        });
        buttonPanel.add(addRemoverMedicoButton);


        JButton addRemoverConsultaButton = new JButton("Remover consulta");
        addRemoverConsultaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removerConsulta();
            }
        });
        buttonPanel.add(addRemoverConsultaButton);

        southPanel.add(buttonPanel, BorderLayout.SOUTH);
        panel.add(southPanel, BorderLayout.SOUTH);

        add(panel);
        setVisible(true);
    }

    private void atualizarTabelaMedico() {
        DefaultTableModel medicosTableModel = (DefaultTableModel) medicosTable.getModel();
        medicosTableModel.setRowCount(0);
        for (Medico medico : medicos) {
            Object[] rowData = {medico.getNome(), medico.getEspecialidade(), medico.getCrm(), medico.getHorariosDisponiveis()};
            medicosTableModel.addRow(rowData);
        }
    }

    private void atualizarTabelaPaciente() {
        DefaultTableModel pacientesTableModel = (DefaultTableModel) pacientesTable.getModel();
        pacientesTableModel.setRowCount(0);
        for (Paciente paciente : pacientes) {
            Object[] rowData = {paciente.getNome(), paciente.getCpf(), paciente.getEndereco(), paciente.getContato().concat(paciente.getHistoricoMedico())};
            pacientesTableModel.addRow(rowData);
        }
    }

    private void atualizarTabelaHorarios() {
        DefaultTableModel horariosTableModel = (DefaultTableModel) horariosTable.getModel();
        horariosTableModel.setRowCount(0);
        for (Consulta consulta : consultas) {
            Object[] rowData = {consulta.getHorario(), consulta.getMedico().getNome(), consulta.getPaciente().getNome()};
            horariosTableModel.addRow(rowData);
        }
    }

    private void removerConsulta() {
        int selectedRow = horariosTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Selecione uma consulta para remover.");
            return;
        }
        consultas.remove(selectedRow);
        atualizarTabelaHorarios();
    }

    protected void removerMedico() {
        int selectedRow = medicosTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Selecione um veículo para remover.");
            return;
        }
        medicos.remove(selectedRow);
        atualizarTabelaMedico();
    }

    protected void removerPaciente() {
        int selectedRow = pacientesTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Selecione um veículo para remover.");
            return;
        }
        pacientes.remove(selectedRow);
        atualizarTabelaPaciente();
    }


    private void marcarConsulta() {
        int selectedMedicoRow = medicosTable.getSelectedRow();
        int selectedPacienteRow = pacientesTable.getSelectedRow();
        if (selectedMedicoRow == -1 || selectedPacienteRow == -1) {
            JOptionPane.showMessageDialog(this, "Selecione um médico e um paciente para marcar a consulta.");
            return;
        }
        Medico medico = medicos.get(selectedMedicoRow);
        Paciente paciente = pacientes.get(selectedPacienteRow);
        String horariosDisponiveis = medico.getHorariosDisponiveis();
        String horarioEscolhido = (String) JOptionPane.showInputDialog(this, "Escolha um horário para a consulta:",
                "Horários Disponíveis", JOptionPane.PLAIN_MESSAGE, null, horariosDisponiveis.split(","), horariosDisponiveis.split(",")[0]);
        if (horarioEscolhido != null) {
            Consulta consulta = new Consulta(medico, paciente, horarioEscolhido);
            consultas.add(consulta);
            atualizarTabelaHorarios();
        }
    }

    protected void adicionarPaciente() {
        String nome = JOptionPane.showInputDialog(this, "Nome:");
        String cpf = JOptionPane.showInputDialog(this, "Cpf:");
        String endereco = JOptionPane.showInputDialog(this, "Endereco:");
        String contato = JOptionPane.showInputDialog(this, "Contato");
        String historicoMedico = JOptionPane.showInputDialog(this, "Historico Medico:");
        Paciente paciente = new Paciente(nome, cpf, endereco, contato, historicoMedico);
        pacientes.add(paciente);
        atualizarTabelaPaciente();
    }

    protected void adicionarMedico() {
        String nome = JOptionPane.showInputDialog(this, "Nome:");
        String especialidade = JOptionPane.showInputDialog(this, "Especialidade:");
        String crm = JOptionPane.showInputDialog(this, "Crm:");
        String horariosDisponiveis = JOptionPane.showInputDialog(this, "Contato");
        Medico medico = new Medico(nome, especialidade, crm, horariosDisponiveis);
        medicos.add(medico);
        atualizarTabelaMedico();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Clinica();
            }
        });
    }
}
