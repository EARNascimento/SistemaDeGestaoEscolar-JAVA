import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastrarCursoFrame extends JFrame{
    Curso curso;
    private Utilitarios utilitarios = new Utilitarios();

    public CadastrarCursoFrame(){
        setTitle("Cadastro de Curso");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2));

        add(new JLabel("ID: "));
        JTextField idFieldText = new JTextField();
        add(idFieldText);

        add(new JLabel("Nome do Curso :"));
        JTextField nomeFieldText = new JTextField();
        add(nomeFieldText);

        JButton btCadastrar = new JButton("Cadastrar");
        add(btCadastrar);

        JButton cancelar = new JButton("Cancelar");
        add(cancelar);

        //Manipulador de Eventos para Cadastrar
        btCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = idFieldText.getText();
                String nome = nomeFieldText.getText();

                //Cadastra Curso
                utilitarios.setCurso(id, nome);
                JOptionPane.showMessageDialog(null, "O curso: " + nome + " foi cadastrado!");
            }
        });

        // Manipulador de Eventos para o botão Cancelar
        cancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new TelaInicialFrame().setVisible(true);
            }
        });
    }
}