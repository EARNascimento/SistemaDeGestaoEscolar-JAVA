
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Hub extends JFrame{
    private Utilitarios utilitarios = new Utilitarios();

    public Hub(){
        //Propriedades
        setTitle("SGE - Hub");
        setSize(500, 150);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        //Cabeçalho
        JLabel nomeEscola = new JLabel("Sistema de Gestão Escolar", SwingConstants.CENTER);
        nomeEscola.setFont(new Font("Swis721 Blk BT", Font.BOLD,36));
        add(nomeEscola, BorderLayout.NORTH);

        //Centro - Botões
        JPanel centro = new JPanel();
        centro.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        //Botões
        JButton loginButton = new JButton("Tela de Login");
        JButton sobreNosButton = new JButton("Sobre Nós");
        JButton cancelarButton = new JButton ("Cancelar");

        //Manipulador de Eventos loginButton
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new Login().setVisible(true);
            }
        });

        sobreNosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, """
                        Aluno: Matheus / RA: \n
                        E-mail: matheus1030br@gmail.com \n
                        Função: Front-End
                        -------------------------------------------------------- \n
                        Aluno: Eduardo A. R. Nascimento / RA: \n
                        E-mail: eduardo.alfredo@a.unileste.edu.br \n
                        Função: Back-End
                        -------------------------------------------------------- \n
                        Aluno: Gabriel Camilo / RA: \n
                        E-mail: \n
                        Função:""");
            }
        });

        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        centro.add(loginButton);
        centro.add(sobreNosButton);
        centro.add(cancelarButton);

        //Adicionando cabeçalho e centro ao Frame
        add(centro, BorderLayout.CENTER);

    }
    //Tela de Login
    class Login extends JFrame {
        private String usuario;
        private String senha;
        private boolean status;
        private static int tentativas = 0; //Contador de tentativas

        //Construtor da classe Login
        public Login(String usuario, String senha){
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

        public Login(){
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
                Login acesso = new Login(usuario, senha);
                acesso.validarLogin();

                //Validando o acesso
                if(acesso.getStatus() == true){
                    dispose(); // Fechando a tela de Login
                    new MenuInicial().setVisible(true);
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

    class MenuInicial extends JFrame{
        private JLabel frase;

        public MenuInicial(){
            setSize(800, 600);
            setLocationRelativeTo(null); // Centralizando a tela no sistema
            setResizable(false);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLayout(new BorderLayout());

            // Criando o painel do cabeçalho com o nome Unileste
            JPanel cabecalho = new JPanel();
            cabecalho.setLayout(new FlowLayout(FlowLayout.LEFT)); // Alinha o conteúdo à esquerda
            JLabel unileste = new JLabel("UNILESTE");
            unileste.setFont(new Font("Arial", Font.BOLD, 36));
            cabecalho.add(unileste); // Adiciona a label ao painel do cabeçalho
            add(cabecalho, BorderLayout.NORTH); // Adiciona o painel ao topo da janela

            // Criando as frases que vão ser alternadas
            ArrayList<String> frases = new ArrayList<>();
            frases.add("Bem-vindo ao Sistema de Gestão Escolar!");
            frases.add("Sistema Unileste - Inovação em Educação!");
            frases.add("Aqui, o conhecimento transforma o futuro.");
            frases.add("A educação é o passaporte para o futuro!");

            // Criando a frase explicativa centralizada
            frase = new JLabel(frases.get(0)); // A primeira frase inicial
            frase.setFont(new Font("Arial", Font.PLAIN, 24));
            frase.setHorizontalAlignment(SwingConstants.CENTER); // Alinha ao centro
            add(frase, BorderLayout.CENTER); // Adiciona a frase no centro da janela

            // Criando um painel principal para a parte inferior, que conterá os botões e a frase do rodapé
            JPanel painelInferior = new JPanel();
            painelInferior.setLayout(new BoxLayout(painelInferior, BoxLayout.Y_AXIS)); // Layout para empilhar verticalmente

            // Criando o painel para as opções (botões)
            JPanel opcoes = new JPanel();
            opcoes.setLayout(new GridLayout(2, 3, 25, 25)); // Mantém o espaçamento entre os botões

            // Botões
            JButton btCursoAnalise = new JButton("<html> Cursos </html>");
            JButton btCadastrarCurso = new JButton("<html> Cadastrar Curso </html>");
            JButton btCadastrarAluno = new JButton("<html> Cadastrar Aluno </html>");
            JButton btConsultarAluno = new JButton("<html> Consultar Aluno </html>");

            // Centralizando o texto dentro dos botões
            btCursoAnalise.setHorizontalAlignment(SwingConstants.CENTER);
            btCadastrarCurso.setHorizontalAlignment(SwingConstants.CENTER);
            btCadastrarAluno.setHorizontalAlignment(SwingConstants.CENTER);
            btConsultarAluno.setHorizontalAlignment(SwingConstants.CENTER);

            // Adicionando o afastamento nas laterais dos botões
            btCursoAnalise.setBorder(BorderFactory.createEmptyBorder(0, 50, 0, 50)); // 10 pixels de afastamento nas laterais
            btCadastrarCurso.setBorder(BorderFactory.createEmptyBorder(0,50,0,50)); // 10 pixels de afastamento nas laterais
            btCadastrarAluno.setBorder(BorderFactory.createEmptyBorder(0, 50, 0, 50)); // 10 pixels de afastamento nas laterais
            btConsultarAluno.setBorder(BorderFactory.createEmptyBorder(0, 50, 0, 50)); // 10 pixels de afastamento nas laterais

            // Adicionando os botões ao painel
            opcoes.add(btCursoAnalise);
            opcoes.add(btCadastrarCurso);
            opcoes.add(btCadastrarAluno);
            opcoes.add(btConsultarAluno);

            // Criando um painel para a frase final (rodapé)
            JPanel rodape = new JPanel();
            rodape.setLayout(new FlowLayout(FlowLayout.CENTER)); // Alinhamento centralizado
            JLabel fraseRodape = new JLabel("Projeto desenvolvido por Matheus, Eduardo e Gabriel");
            rodape.add(fraseRodape);

            // Adicionando os componentes (botões e rodapé) ao painel principal (painelInferior)
            painelInferior.add(opcoes);
            painelInferior.add(Box.createVerticalStrut(35)); // Espaço entre os botões e a frase do rodapé
            painelInferior.add(rodape);

            // Adicionando o painelInferior ao BorderLayout.SOUTH
            add(painelInferior, BorderLayout.SOUTH);

            // Criando a barra de menu
            JMenuBar menuBar = new JMenuBar();

            // Criando os menus
            JMenu menuCadastro = new JMenu("Cadastro");
            JMenu menuConsulta = new JMenu("Consulta");
            JMenu menuLogout = new JMenu("Logout");

            // Criando os itens do Menu
            JMenuItem itemCadastrarCurso = new JMenuItem("Cadastrar Curso");
            JMenuItem itemCadastrarAluno = new JMenuItem("Cadastrar Aluno");
            JMenuItem itemCadastrarNota = new JMenuItem("Cadastrar Nota");

            JMenuItem itemConsultarAluno = new JMenuItem("Consultar Aluno");

            JMenuItem itemSobreNos = new JMenuItem("Sobre Nós");
            JMenuItem itemSair = new JMenuItem("Sair");

            // Adicionando os itens ao menu Cadastro
            menuCadastro.add(itemCadastrarCurso);
            menuCadastro.addSeparator();
            menuCadastro.add(itemCadastrarAluno);
            menuCadastro.addSeparator();
            menuCadastro.add(itemCadastrarNota);

            // Adicionando os itens ao menu Consulta
            menuConsulta.add(itemConsultarAluno);

            // Adicionando o item Sair ao menu Logout
            menuLogout.add(itemSair);

            // Adicionando os menus à barra de menus
            menuBar.add(menuCadastro);
            menuBar.add(menuConsulta);
            menuBar.add(itemSobreNos);

            // Criando um espaço entre os menus à esquerda e o menu de logout à direita
            menuBar.add(Box.createHorizontalGlue());
            menuBar.add(menuLogout);

            setJMenuBar(menuBar);

            // Configurar o timer para trocar as frases
            Timer timer = new Timer(3000, new ActionListener() { // Troca a cada 3 segundos
                private int currentIndex = 0;

                @Override
                public void actionPerformed(ActionEvent e) {
                    // Atualiza a frase
                    currentIndex = (currentIndex + 1) % frases.size(); // Ciclo de frases
                    frase.setText(frases.get(currentIndex));
                }
            });
            timer.start(); // Inicia o timer

            // Manipulador de Eventos para o botão Sair
            itemSair.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.exit(0);
                }
            });

            //Manipulador de Eventos para o item Cadastrar Curso
            itemCadastrarCurso.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setVisible(false);
                    new CadastrarCursoFrame().setVisible(true);
                }
            });

            // Manipulador de Eventos para o item Cadastrar Alunos
            itemCadastrarAluno.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setVisible(false);
                    new CadastrarAlunoFrame().setVisible(true);
                }
            });

            // Manipulador de Eventos para o botão Cadastrar Alunos
            btCadastrarAluno.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setVisible(false);
                    new CadastrarAlunoFrame().setVisible(true);
                }
            });

            // Manipulador de Eventos para o botão Cadastrar Notas
            itemCadastrarNota.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setVisible(false);
                    new CadastrarNotaFrame().setVisible(true);
                }
            });

            // Manipulador de Eventos para o item Consultar Aluno
            itemConsultarAluno.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setVisible(false);
                    new ConsultarAlunoFrame().setVisible(true);
                }
            });

            // Manipulador de Eventos para o botão Consultar Aluno
            btConsultarAluno.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setVisible(false);
                    new ConsultarAlunoFrame().setVisible(true);
                }
            });

            // Manipulador de Eventos para o botão Consultar Curso
            btCursoAnalise.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setVisible(false);
                    new ConsultarCursoFrame().setVisible(true);
                }
            });

            //Manipulador de Eventos para o botão Cadastrar Curso
            btCadastrarCurso.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setVisible(false);
                    new CadastrarCursoFrame().setVisible(true);
                }
            });

            // Manipulador de Eventos para o item Sobre Nós
            itemSobreNos.addActionListener(e -> JOptionPane.showMessageDialog(null, """
                O Centro Universitário Católica do Leste de Minas Gerais Unileste,
                fundado em 1969 pela Congregação Padres do Trabalho, uma das principais
                instituições de ensino superior da região do Vale do Aço e uma das mais
                reconhecidas de Minas Gerais. Com mais de 20 cursos de graduação e diversas
                opções de pós-graduação, a instituição já formou mais de seis mil profissionais
                nos últimos cinco anos. Com dois campi (em Coronel Fabriciano e Ipatinga), oferece
                infraestrutura de ponta, incluindo um parque tecnológico atualizado, biblioteca com
                mais de 80 mil livros, centros esportivos, teatros, auditórios e mais de 100 laboratórios."""));

            // Tamanho dos botões
            setButtonSize(btCursoAnalise, btCadastrarCurso, btCadastrarAluno, btConsultarAluno);

            //Funçao dos Botões
            // Adicionando um MouseListener para trocar as frases quando o mouse passa por cima
            frase.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    // Troca a frase para uma nova quando o mouse entra
                    frase.setText("Explore o melhor da educação e tecnologia!");
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    // Retorna à frase original quando o mouse sai
                    frase.setText(frases.get(0));
                }
            });
        }

        // Método para definir o tamanho dos botões
        private void setButtonSize(JButton... buttons) {
            for (JButton button : buttons) {
                button.setFont(new Font("Arial", Font.PLAIN, 24)); // Definindo a fonte
                button.setPreferredSize(new Dimension(100, 100)); // Definindo o tamanho do botão
            }
        }
    }
}


