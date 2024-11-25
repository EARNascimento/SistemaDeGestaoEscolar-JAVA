import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastrarAlunoFrame extends JFrame {
    private JTextField nomeField, dataNascimentoField, emailField;
    private JButton cadastrar, cancelar;

    public CadastrarAlunoFrame() {
        setTitle("Cadastro de Aluno");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2));

        add(new JLabel("Nome:"));
        nomeField = new JTextField();
        add(nomeField);

        add(new JLabel("Data de Nascimento:"));
        dataNascimentoField = new JTextField();
        add(dataNascimentoField);

        add(new JLabel("Email:"));
        emailField = new JTextField();
        add(emailField);

        cadastrar = new JButton("Cadastrar");
        add(cadastrar);
        
        cancelar = new JButton("Cancelar");
        add(cancelar);

        // Manipulador de Eventos para o botão Cancelar 
        cancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 setVisible(false);
            }
        });

    }

    

}
