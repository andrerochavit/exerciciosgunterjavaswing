package spring;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Concessionaria extends JFrame {
    private List<Veiculo> veiculos = new ArrayList<>();
    private DefaultTableModel tableModel;
    private JTable veiculosTable;
    
    public Concessionaria() {
        setTitle("Sistema de Gerenciamento de Veículos");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        
        tableModel = new DefaultTableModel(new String[]{"Tipo", "Marca", "Modelo", "Ano", "Detalhes"}, 0);
        veiculosTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(veiculosTable);
        panel.add(scrollPane, BorderLayout.CENTER);
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        
        JButton addButton = new JButton("Adicionar Veículo");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adicionarVeiculo();
            }
        });
        buttonPanel.add(addButton);
        
        JButton editButton = new JButton("Editar Veículo");
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editarVeiculo();
            }
        });
        buttonPanel.add(editButton);
        
        JButton removeButton = new JButton("Remover Veículo");
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removerVeiculo();
            }
        });
        buttonPanel.add(removeButton);
        
        panel.add(buttonPanel, BorderLayout.SOUTH);
        
        add(panel);
        setVisible(true);
    }
    
    private void adicionarVeiculo() {
        String tipoVeiculo = JOptionPane.showInputDialog(this, "Tipo de veículo (Carro/Moto/Caminhão):");
        if (tipoVeiculo.equalsIgnoreCase("Carro")) {
            adicionarCarro();
        } else if (tipoVeiculo.equalsIgnoreCase("Moto")) {
            adicionarMoto();
        } else if (tipoVeiculo.equalsIgnoreCase("Caminhão")) {
            adicionarCaminhao();
        } else {
            JOptionPane.showMessageDialog(this, "Tipo de veículo inválido.");
        }
    }
    
    private void adicionarCarro() {
        String marca = JOptionPane.showInputDialog(this, "Marca:");
        String modelo = JOptionPane.showInputDialog(this, "Modelo:");
        int ano = Integer.parseInt(JOptionPane.showInputDialog(this, "Ano:"));
        String combustivel = JOptionPane.showInputDialog(this, "Tipo de combustível:");
        Carro carro = new Carro(marca, modelo, ano, combustivel);
        veiculos.add(carro);
        atualizarTabela();
    }
    
    private void adicionarMoto() {
        String marca = JOptionPane.showInputDialog(this, "Marca:");
        String modelo = JOptionPane.showInputDialog(this, "Modelo:");
        int ano = Integer.parseInt(JOptionPane.showInputDialog(this, "Ano:"));
        int cilindrada = Integer.parseInt(JOptionPane.showInputDialog(this, "Cilindrada:"));
        Moto moto = new Moto(marca, modelo, ano, cilindrada);
        veiculos.add(moto);
        atualizarTabela();
    }
    
    private void adicionarCaminhao() {
        String marca = JOptionPane.showInputDialog(this, "Marca:");
        String modelo = JOptionPane.showInputDialog(this, "Modelo:");
        int ano = Integer.parseInt(JOptionPane.showInputDialog(this, "Ano:"));
        double capacidadeCarga = Double.parseDouble(JOptionPane.showInputDialog(this, "Capacidade de carga:"));
        Caminhao caminhao = new Caminhao(marca, modelo, ano, capacidadeCarga);
        veiculos.add(caminhao);
        atualizarTabela();
    }
    
    private void editarVeiculo() {
        int selectedRow = veiculosTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Selecione um veículo para editar.");
            return;
        }
        Veiculo veiculoSelecionado = veiculos.get(selectedRow);
        if (veiculoSelecionado instanceof Carro) {
            editarCarro((Carro) veiculoSelecionado);
        } else if (veiculoSelecionado instanceof Moto) {
            editarMoto((Moto) veiculoSelecionado);
        } else if (veiculoSelecionado instanceof Caminhao) {
            editarCaminhao((Caminhao) veiculoSelecionado);
        }
    }
    
    private void editarCarro(Carro carro) {
        String marca = JOptionPane.showInputDialog(this, "Nova marca:", carro.getMarca());
        String modelo = JOptionPane.showInputDialog(this, "Novo modelo:", carro.getModelo());
        int ano = Integer.parseInt(JOptionPane.showInputDialog(this, "Novo ano:", carro.getAno()));
        String combustivel = JOptionPane.showInputDialog(this, "Novo tipo de combustível:", carro.getCombustivel());
        carro.setMarca(marca);
        carro.setModelo(modelo);
        carro.setAno(ano);
        carro.setCombustivel(combustivel);
        atualizarTabela();
    }
    
    private void editarMoto(Moto moto) {
        String marca = JOptionPane.showInputDialog(this, "Nova marca:", moto.getMarca());
        String modelo = JOptionPane.showInputDialog(this, "Novo modelo:", moto.getModelo());
        int ano = Integer.parseInt(JOptionPane.showInputDialog(this, "Novo ano:", moto.getAno()));
        int cilindrada = Integer.parseInt(JOptionPane.showInputDialog(this, "Nova cilindrada:", moto.getCilindrada()));
        moto.setMarca(marca);
        moto.setModelo(modelo);
        moto.setAno(ano);
        moto.setCilindrada(cilindrada);
        atualizarTabela();
    }
    
    private void editarCaminhao(Caminhao caminhao) {
        String marca = JOptionPane.showInputDialog(this, "Nova marca:", caminhao.getMarca());
        String modelo = JOptionPane.showInputDialog(this, "Novo modelo:", caminhao.getModelo());
        int ano = Integer.parseInt(JOptionPane.showInputDialog(this, "Novo ano:", caminhao.getAno()));
        double capacidadeCarga = Double.parseDouble(JOptionPane.showInputDialog(this, "Nova capacidade de carga:", caminhao.getCapacidadeCarga()));
        caminhao.setMarca(marca);
        caminhao.setModelo(modelo);
        caminhao.setAno(ano);
        caminhao.setCapacidadeCarga(capacidadeCarga);
        atualizarTabela();
    }
    
    private void removerVeiculo() {
        int selectedRow = veiculosTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Selecione um veículo para remover.");
            return;
        }
        veiculos.remove(selectedRow);
        atualizarTabela();
    }
    
    private void atualizarTabela() {
        tableModel.setRowCount(0);
        for (Veiculo veiculo : veiculos) {
            String tipo;
            if (veiculo instanceof Carro) {
                tipo = "Carro";
            } else if (veiculo instanceof Moto) {
                tipo = "Moto";
            } else {
                tipo = "Caminhão";
            }
            Object[] rowData = {tipo, veiculo.getMarca(), veiculo.getModelo(), veiculo.getAno(), veiculo.toString()};
            tableModel.addRow(rowData);
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Concessionaria();
            }
        });
    }
}
