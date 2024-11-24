package com.sge.telas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class CadastrarNotaFrame extends JFrame {

    private JTextField notaIdField, alunoIdField; // Campo para nome do aluno
    private JButton consultar, cancelar;
    private JTextArea resultadoArea; // Área de texto para exibir resultados

    public CadastrarNotaFrame() {
        setTitle("Cadastrar Nota");
        setSize(400, 450); // Aumentando o tamanho da janela para acomodar os novos componentes
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout()); // Usando GridBagLayout para melhor controle de posicionamento
        GridBagConstraints gbc = new GridBagConstraints(); // Constraints para posicionamento flexível

        // Adicionando o campo para pesquisa por nome
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        add(new JLabel("Nome do Aluno:"), gbc);

        alunoIdField = new JTextField(20); // Campo para nome do aluno
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(alunoIdField, gbc);

        // Botão Consultar
        consultar = new JButton("Pesquisar");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.NONE;
        add(consultar, gbc);

        // Botão Cancelar
        cancelar = new JButton("Cancelar");
        gbc.gridx = 1;
        gbc.gridy = 1;
        add(cancelar, gbc);

        // Área de texto para mostrar o resultado
        resultadoArea = new JTextArea(10, 30);
        resultadoArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultadoArea);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        add(scrollPane, gbc);

        //Inserir Nota
        // Adicionando o campo para Nota
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        add(new JLabel("Nota:"), gbc);
        
        
        notaIdField = new JTextField(20); // Campo para Inserir Nota
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(notaIdField, gbc);
        
        
        
        // Botões adicionais
        JPanel painelBotoes = new JPanel();
        painelBotoes.setLayout(new GridLayout(1, 3, 10, 10)); // Layout para os botões de ação

        JButton cadastrarButton = new JButton("Cadastrar Nota");
        
        painelBotoes.add(cadastrarButton);
        

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(painelBotoes, gbc);

        // Manipulador de eventos para o botão Consultar
        consultar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nomeAluno = notaIdField.getText();
                if (!nomeAluno.isEmpty()) {
                    // Simulação de consulta ao banco de dados
                    resultadoArea.setText("Consultando informações do aluno: " + nomeAluno);
                    // Aqui você faria a busca no banco de dados, por exemplo:
                    // String resultado = consultarAlunoNoBanco(nomeAluno);
                    // resultadoArea.setText(resultado);
                } else {
                    resultadoArea.setText("Por favor, insira o nome do aluno.");
                }
            }
        });

        // Manipulador de eventos para o botão Cancelar
        cancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aqui você pode fechar a janela atual e abrir a Tela Inicial
                setVisible(false); // Fecha a janela atual
                new TelaInicialFrame().setVisible(true); // Abre a Tela Inicial
            }
        });

        // Configurando os manipuladores para os botões "Matricular", "Alterar", e "Excluir"
        cadastrarButton.addActionListener(e -> JOptionPane.showMessageDialog(null, "Matriculando aluno..."));


        // Exibir a janela
        setVisible(true);
    }
}
