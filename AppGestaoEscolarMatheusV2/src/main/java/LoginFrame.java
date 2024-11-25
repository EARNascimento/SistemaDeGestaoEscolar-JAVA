import javax.swing.*;
import java.awt.*;

public class LoginFrame extends JFrame {
    private String usuario;
    private String senha;
    private boolean status;
    private static int tentativas = 0; //Contador de tentativas

    //Construtor da classe Login
    public LoginFrame(String usuario, String senha){
        this.usuario = usuario;
        this.senha = senha;
        this.status = false;
    }

    //Método Get
    public boolean getStatus(){
        return this.status;
    }

    //Método para validar o Login
    //Criando um login de acesso
    public void validarLogin(){
        if(this.usuario.equals("")){
            if(this.senha.equals("")){
                this.status = true; //Login bem-sucedido
            }
        }
    }

    public LoginFrame(){
        //Configuração da Janela de Login
        setTitle("Login");
        setSize(500,400);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(new BorderLayout());

        //Cabeçalho
        JPanel cabecalho = new JPanel();
        JLabel nomeEscola = new JLabel("UNILESTE");
        nomeEscola.setFont(new Font("Swis721 Blk BT", Font.BOLD,36));
        nomeEscola.setHorizontalAlignment(SwingConstants.LEFT);
        cabecalho.setLayout(new FlowLayout(FlowLayout.LEFT));
        cabecalho.add(nomeEscola);

        //Centro - Formulário de Login
        JPanel centro = new JPanel();
        centro.setLayout(new GroupLayout(centro));
        centro.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2)); //Adiciona uma borda preta

        //Components
        JLabel usuarioLabel= new JLabel("Usuário:");
        JTextField lerUsuario = new JTextField(20);
        JLabel senhaLabel = new JLabel("Senha:");
        JPasswordField lerSenha = new JPasswordField(20);
        JButton loginButton = new JButton("Login");
        JButton cancelarButton = new JButton ("Cancelar");

        //Layout do GroupLayout para o painel centro
        GroupLayout grupoLayout = new GroupLayout(centro);
        centro.setLayout(grupoLayout);
        grupoLayout.setAutoCreateGaps(true);
        grupoLayout.setAutoCreateGaps(true);

        grupoLayout.setHorizontalGroup(
                grupoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(grupoLayout.createSequentialGroup()
                                .addGap(20)
                                .addGroup(grupoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(usuarioLabel)
                                        .addComponent(senhaLabel))
                                .addGap(20)
                                .addGroup(grupoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(lerUsuario)
                                        .addComponent(lerSenha))
                                .addGap(20)
                        )
                        .addGroup(grupoLayout.createSequentialGroup()
                                .addGap(100)
                                .addComponent(loginButton)
                                .addGap(20)
                                .addComponent(cancelarButton)
                                .addGap(100)
                        )
        );

        grupoLayout.setVerticalGroup(
                grupoLayout.createSequentialGroup()
                        .addGap(30)
                        .addGroup(grupoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(usuarioLabel)
                                .addComponent(lerUsuario)
                        )
                        .addGap(20)
                        .addGroup(grupoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(senhaLabel)
                                .addComponent(lerSenha)
                        )
                        .addGap(30)
                        .addGroup(grupoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(loginButton)
                                .addComponent(cancelarButton)
                        )
                        .addGap(30)
        );

        //Painel para centralizar a tela de login
        JPanel painelCentralizado = new JPanel();
        painelCentralizado.setLayout(new GridBagLayout());
        painelCentralizado.add(centro);

        //Adicionando cabeçalho e centro ao Frame
        add(cabecalho, BorderLayout.NORTH);
        add(painelCentralizado, BorderLayout.CENTER);

        //Configurando ações dos botões
        loginButton.addActionListener(e -> {
            String usuario = lerUsuario.getText();
            String senha = new String(lerSenha.getPassword());

            //Criando o objeto
            LoginFrame acesso = new LoginFrame(usuario, senha);
            acesso.validarLogin();

            //Validando o acesso
            if(acesso.getStatus() == true){
                dispose(); // Fechando a tela de Login

            } else {
                //Incrementando o contador de tentativas
                tentativas ++;

                if (tentativas >= 3){
                    //Máximo de tentativas atingido
                    JOptionPane.showMessageDialog(null,"Máximo de tentativas atingido! O programa será encerrado");
                    System.exit(0);
                } else {
                    //Login Incorreto
                    JOptionPane.showMessageDialog(null, "Login incorreto! Tentativa " + tentativas + " de 3.");
                    //Limpar os campos de texto
                    lerUsuario.setText("");
                    lerSenha.setText("");
                }
            }
        });
        cancelarButton.addActionListener(e -> System.exit(0));//Fecha o programa se clicado em "Cancelar"

        //Exibe o Frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
