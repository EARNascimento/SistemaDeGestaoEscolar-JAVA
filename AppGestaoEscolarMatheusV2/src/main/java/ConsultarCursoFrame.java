import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class ConsultarCursoFrame extends JFrame {
    private JComboBox<String> cursoComboBox;
    private JTextArea resultadoArea;
    private JButton consultarButton;
    private JButton voltarButton;

    public ConsultarCursoFrame() {
        setTitle("Consultar Curso");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        JPanel painelSuperior = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        String[] cursos = {"Análise e Desenvolvimento de Sistemas", "Ciência da Computação", "Engenharia de Software"};
        cursoComboBox = new JComboBox<>(cursos);
        painelSuperior.add(new JLabel("Selecione o curso:"));
        painelSuperior.add(cursoComboBox);

        consultarButton = new JButton("Consultar");
        painelSuperior.add(consultarButton);

        add(painelSuperior, BorderLayout.NORTH);

        resultadoArea = new JTextArea();
        resultadoArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultadoArea);
        add(scrollPane, BorderLayout.CENTER);

        voltarButton = new JButton("Voltar");
        JPanel painelInferior = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        painelInferior.add(voltarButton);
        add(painelInferior, BorderLayout.SOUTH);

        consultarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cursoSelecionado = (String) cursoComboBox.getSelectedItem();
                consultarAlunosDoCurso(cursoSelecionado);
            }
        });

        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    private void consultarAlunosDoCurso(String curso) {
        resultadoArea.setText("");
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/seuBancoDeDados", "usuario", "senha")) {
            String query = "SELECT nome, data_nascimento, email FROM alunos WHERE curso = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, curso);
            ResultSet rs = pstmt.executeQuery();

            StringBuilder resultado = new StringBuilder();
            resultado.append("Alunos matriculados em ").append(curso).append(":\n\n");
            while (rs.next()) {
                resultado.append("Nome: ").append(rs.getString("nome")).append("\n");
                resultado.append("Data de Nascimento: ").append(rs.getString("data_nascimento")).append("\n");
                resultado.append("Email: ").append(rs.getString("email")).append("\n\n");
            }
            resultadoArea.setText(resultado.toString());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erro ao consultar o banco de dados: " + ex.getMessage());
        }
    }
}