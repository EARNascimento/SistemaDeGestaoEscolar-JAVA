
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

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
            setTitle("SGE - Login");
            setSize(500,400);
            setLocationRelativeTo(null);
            setResizable(false);
            setLayout(new BorderLayout());

            //Cabeçalho
            JPanel cabecalho = new JPanel();
            JLabel nomeEscola = new JLabel("SGE - Login");
            nomeEscola.setFont(new Font("Swis721 Blk BT", Font.BOLD,36));
            nomeEscola.setHorizontalAlignment(SwingConstants.CENTER);
            cabecalho.setLayout(new FlowLayout(FlowLayout.CENTER));
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
            setTitle("SGE - Menu Inicial");
            setSize(800, 600);
            setLocationRelativeTo(null); // Centralizando a tela no sistema
            setResizable(false);
            setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            setLayout(new BorderLayout());

            // Criando o painel do cabeçalho com o nome Unileste
            JPanel cabecalho = new JPanel();
            cabecalho.setLayout(new FlowLayout(FlowLayout.CENTER)); // Alinha o conteúdo ao centro
            JLabel unileste = new JLabel("SGE - Menu Inicial");
            unileste.setFont(new Font("Arial", Font.BOLD, 36));
            cabecalho.add(unileste); // Adiciona a label ao painel do cabeçalho
            add(cabecalho, BorderLayout.NORTH); // Adiciona o painel ao topo da janela

            // Criando as frases que vão ser alternadas
            ArrayList<String> frases = new ArrayList<>();
            frases.add("Bem-vindo ao Sistema de Gestão Escolar!");
            frases.add("SGE - Inovação em Educação!");
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
            JButton btCadastrarCurso = new JButton("<html> Cadastrar Curso </html>");
            JButton btCursoAnalise = new JButton("<html> Consultar Curso </html>");
            JButton btCadastrarAluno = new JButton("<html> Cadastrar Aluno </html>");
            JButton btConsultarAluno = new JButton("<html> Consultar Aluno </html>");

            // Centralizando o texto dentro dos botões
            btCadastrarCurso.setHorizontalAlignment(SwingConstants.CENTER);
            btCursoAnalise.setHorizontalAlignment(SwingConstants.CENTER);
            btCadastrarAluno.setHorizontalAlignment(SwingConstants.CENTER);
            btConsultarAluno.setHorizontalAlignment(SwingConstants.CENTER);

            // Adicionando o afastamento nas laterais dos botões
            btCursoAnalise.setBorder(BorderFactory.createEmptyBorder(0, 50, 0, 50)); // 10 pixels de afastamento nas laterais
            btCadastrarCurso.setBorder(BorderFactory.createEmptyBorder(0,50,0,50)); // 10 pixels de afastamento nas laterais
            btCadastrarAluno.setBorder(BorderFactory.createEmptyBorder(0, 50, 0, 50)); // 10 pixels de afastamento nas laterais
            btConsultarAluno.setBorder(BorderFactory.createEmptyBorder(0, 50, 0, 50)); // 10 pixels de afastamento nas laterais

            // Adicionando os botões ao painel
            opcoes.add(btCadastrarCurso);
            opcoes.add(btCursoAnalise);
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
            JMenuItem itemAlterarCurso = new JMenuItem("Alterar Curso");
            JMenuItem itemAlterarAluno = new JMenuItem("Alterar Aluno");
            JMenuItem itemMatricularAluno = new JMenuItem("Matricular Aluno");
            JMenuItem itemCadastrarNota = new JMenuItem("Cadastrar Nota");
            JMenuItem itemConsultarNota = new JMenuItem("Consultar Nota");
            JMenuItem itemAlterarNota = new JMenuItem("Alterar Nota");
            JMenuItem itemConsultarCurso = new JMenuItem("Consultar Curso");
            JMenuItem itemConsultarAluno = new JMenuItem("Consultar Aluno");
            JMenuItem itemConsultarMatricula = new JMenuItem("Consultar Matricula");
            JMenuItem itemCadastrarDisciplina = new JMenuItem("Cadastrar Disciplina");
            JMenuItem itemConsultarDisciplina = new JMenuItem("Consultar Disciplina");
            JMenuItem itemAlterarDisciplina = new JMenuItem("Alterar Disciplina");
            JMenuItem itemAlterarMatricula = new JMenuItem("Alterar Matricula");

            JMenuItem itemSair = new JMenuItem("Sair");

            // Adicionando os itens ao menu Cadastro
            menuCadastro.add(itemCadastrarCurso);
            menuCadastro.addSeparator();
            menuCadastro.add(itemAlterarCurso);
            menuCadastro.addSeparator();
            menuCadastro.add(itemCadastrarAluno);
            menuCadastro.addSeparator();
            menuCadastro.add(itemAlterarAluno);
            menuCadastro.addSeparator();
            menuCadastro.add(itemMatricularAluno);
            menuCadastro.addSeparator();
            menuCadastro.add(itemAlterarMatricula);
            menuCadastro.addSeparator();
            menuCadastro.add(itemCadastrarNota);
            menuCadastro.addSeparator();
            menuCadastro.add(itemAlterarNota);
            menuCadastro.addSeparator();
            menuCadastro.add(itemCadastrarDisciplina);
            menuCadastro.addSeparator();
            menuCadastro.add(itemAlterarDisciplina);



            // Adicionando os itens ao menu Consulta
            menuConsulta.add(itemConsultarCurso);
            menuConsulta.addSeparator();
            menuConsulta.add(itemConsultarAluno);
            menuConsulta.addSeparator();
            menuConsulta.add(itemConsultarMatricula);
            menuConsulta.addSeparator();
            menuConsulta.add(itemConsultarDisciplina);
            menuConsulta.addSeparator();
            menuConsulta.add(itemConsultarNota);


            // Adicionando o item Sair ao menu Logout
            menuLogout.add(itemSair);

            // Adicionando os menus à barra de menus
            menuBar.add(menuCadastro);
            menuBar.add(menuConsulta);

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

            //Manipulador de Eventos para o botão Cadastrar Curso
            btCadastrarCurso.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setVisible(false);
                    new CadastrarCursoFrame().setVisible(true);
                }
            });

            //Manipulador de Eventos para o botão Alterar Curso
            itemAlterarCurso.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setVisible(false);
                    new AlterarCursoFrame().setVisible(true);
                }
            });

            //Manipulador de Eventos para o botão Alterar Aluno
            itemAlterarAluno.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setVisible(false);
                    new AlterarAlunoFrame().setVisible(true);
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

            //Manipulador de Eventos para o botão itemMatricularAluno
            itemMatricularAluno.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setVisible(false);
                    new MatricularAlunoFrame().setVisible(true);
                }
            });

            // Manipulador de Eventos para o botão Cadastrar Disciplina
            itemCadastrarDisciplina.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setVisible(false);
                    new CadastrarDisciplinaFrame().setVisible(true);
                }
            });

            //Manipulador de Eventos para o botão Consultar Disciplina
            itemConsultarDisciplina.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setVisible(false);
                    new ConsultarDisciplinaFrame().setVisible(true);
                }
            });

            //Manipulador de Eventos para o botão Alterar Disciplina
            itemAlterarDisciplina.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setVisible(false);
                    new AlterarDisciplinaFrame().setVisible(true);
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

            //Manipulador de Eventos para o item Consultar Curso
            itemConsultarCurso.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setVisible(false);
                    new ConsultarCursoFrame().setVisible(true);
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

            //Manipulador de Eventos para o item Consultar Matricula
            itemConsultarMatricula.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setVisible(false);
                    new ConsultarMatriculaFrame().setVisible(true);
                }
            });

            //Manipulador de Eventos para o item Alterar Matrícula
            itemAlterarMatricula.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setVisible(false);
                    new AlterarMatricula().setVisible(true);
                }
            });

            //Manipulador de EVentos para o item Cadastrar Nota
            itemCadastrarNota.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setVisible(false);
                    new CadastrarNotaFrame().setVisible(true);
                }
            });

            //Manipulador de Eventos para o item Consultar Nota
            itemConsultarNota.addActionListener((new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setVisible(false);
                    new ConsultarNotaFrame().setVisible(true);
                }
            }));

            //Manipulador de Eventos para o item Alterar Nota
            itemAlterarNota.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setVisible(false);
                    new AlterarNotaFrame().setVisible(true);
                }
            });
            // Tamanho dos botões
            setButtonSize(btCursoAnalise, btCadastrarCurso, btConsultarAluno, btCadastrarAluno);

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

    class ConsultarCursoDoisFrame extends JFrame{
        private JComboBox<Curso> cursoComboBox;
        private JTextArea resultadoArea;
        private JButton consultarButton;
        private JButton voltarButton;

        public ConsultarCursoDoisFrame(){

            setTitle("Consultar Curso");
            setSize(600, 400);
            setLocationRelativeTo(null);
            setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            setLayout(new BorderLayout(10, 10));
            cursoComboBox = new JComboBox<>();

            for(Curso curso : utilitarios.getCursos()){
                this.cursoComboBox.addItem(curso);
            }

            JPanel painelSuperior = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
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
                    Curso cursoSelecionado = (Curso) cursoComboBox.getSelectedItem();
                    consultarInfoDoCurso(cursoSelecionado);
                }
            });

            voltarButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    dispose();
                    new MenuInicial().setVisible(true);
                }
            });
        }

        private void consultarInfoDoCurso(Curso curso) {
            resultadoArea.setText("ID: " + curso.getId() + "\n" +
                                    "Curso: " + curso.getName() );
        }
    }

    class ConsultarCursoFrame extends JFrame{
        private JTextField alunoIdField; // Campo para nome do aluno
        private JComboBox<Curso> cursoComboBox;
        private JButton consultar, excluir;
        private JTextArea resultadoArea; // Área de texto para exibir resultados

        public ConsultarCursoFrame(){
            setTitle("SGE - Consultar Curso");
            setSize(500, 500); // Aumentando o tamanho da janela para acomodar os novos componentes
            setLocationRelativeTo(null);
            setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            setLayout(new GridBagLayout()); // Usando GridBagLayout para melhor controle de posicionamento
            GridBagConstraints gbc = new GridBagConstraints(); // Constraints para posicionamento flexível

            // Adicionando o campo para pesquisa por nome
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.anchor = GridBagConstraints.WEST;
            add(new JLabel("Selecione o curso:"), gbc);

            //alunoIdField = new JTextField(20); // Campo para nome do aluno
            cursoComboBox = new JComboBox<>();
            for(Curso curso : utilitarios.getCursos()){
                this.cursoComboBox.addItem(curso);
            }
            gbc.gridx = 1;
            gbc.gridy = 0;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            add(cursoComboBox, gbc);

            // Botão Consultar
            consultar = new JButton("Consultar");
            gbc.gridx = 0;
            gbc.gridy = 1;
            gbc.fill = GridBagConstraints.NONE;
            add(consultar, gbc);

            // Botão Cancelar
            excluir = new JButton("Excluir Curso");
            gbc.gridx = 1;
            gbc.gridy = 1;
            add(excluir, gbc);

            // Área de texto para mostrar o resultado
            resultadoArea = new JTextArea(10, 30);
            resultadoArea.setEditable(false);
            JScrollPane scrollPane = new JScrollPane(resultadoArea);
            gbc.gridx = 0;
            gbc.gridy = 2;
            gbc.gridwidth = 2;
            gbc.fill = GridBagConstraints.BOTH;
            add(scrollPane, gbc);

            // Botões adicionais: Matricular, Alterar, Excluir
            JPanel painelBotoes = new JPanel();
            painelBotoes.setLayout(new GridLayout(1, 3, 10, 10)); // Layout para os botões de ação

            JButton matricularButton = new JButton("Adicionar Disciplina");
            JButton alterarButton = new JButton("Alterar Nome");
            JButton voltarButton = new JButton("Voltar");

            painelBotoes.add(matricularButton);
            painelBotoes.add(alterarButton);
            painelBotoes.add(voltarButton);

            gbc.gridx = 0;
            gbc.gridy = 3;
            gbc.gridwidth = 2;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            add(painelBotoes, gbc);



            // Manipulador de eventos para o botão Consultar
            consultar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Curso curso = (Curso) cursoComboBox.getSelectedItem();

                    resultadoArea.setText("Consultando informações do Curso: " + curso.getName() + "\n" +
                            "ID: " + curso.getId() + "\n" +
                            "Nome: " + curso.getName() + "\n" +
                            "Disciplinas Registradas: "  + curso.getDisciplinas() + "\n" +
                            "Alunos: " + getNomeAlunos(curso.getAlunos()));
                }
            });

            //Criando um método para consultar o ID fornecido
            // Manipulador de eventos para o botão Cancelar
            voltarButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setVisible(false); // Fecha a janela atual
                    new MenuInicial().setVisible(true);
                }
            });

            alterarButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setVisible(false);
                    new AlterarCursoFrame().setVisible(true);
                }
            });

            // Configurando os manipuladores para os botões "Matricular", "Alterar", e "Excluir"
            matricularButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setVisible(false);
                    new MatricularAlunoFrame().setVisible(true);
                }
            });
            excluir.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    utilitarios.deletarCurso((Curso)cursoComboBox.getSelectedItem());
                }
            });

        }
        private String getNomeAlunos(List<Aluno> alunos){
            StringBuilder sb = new StringBuilder();
            for(Aluno aluno: alunos){
                sb.append(aluno.getNome()).append("; ");
            }
            return sb.toString();
        }
    }

    class CadastrarCursoFrame extends JFrame{
        Curso curso;
        public CadastrarCursoFrame(){
            setTitle("SGE - Cadastro de Curso");
            setSize(400, 300);
            setLocationRelativeTo(null);
            setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            setLayout(new GridLayout(5, 2));

            add(new JLabel("ID: "));
            JTextField idFieldText = new JTextField();
            add(idFieldText);

            add(new JLabel("Nome do Curso :"));
            JTextField nomeFieldText = new JTextField();
            add(nomeFieldText);

            JButton btCadastrar = new JButton("Cadastrar");
            add(btCadastrar);

            JButton voltar = new JButton("Voltar");
            add(voltar);

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
            voltar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setVisible(false);
                    new MenuInicial().setVisible(true);
                }
            });
        }
    }

    class AlterarCursoFrame extends JFrame{
        private JComboBox<Curso> cursoComboBox;

        public AlterarCursoFrame(){
            setTitle("SGE - Alterar o Nome do Curso");
            setSize(400, 300);
            setLocationRelativeTo(null);
            setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            setLayout(new GridLayout(5, 2));
            cursoComboBox = new JComboBox<>();

            //Adiciona todos os cursos consultados
            for(Curso curso : utilitarios.getCursos()){
                this.cursoComboBox.addItem(curso);
            }
            //Adicionar uma ComboBox aqui!
            add(new JLabel("Selecione o curso: "));
            add(cursoComboBox);

            add(new JLabel("Novo Nome do Curso :"));
            JTextField idFieldText = new JTextField();
            add(idFieldText);

            JButton btCadastrar = new JButton("Alterar");
            add(btCadastrar);

            JButton voltar = new JButton("Voltar");
            add(voltar);

            //Manipulador de Eventos para Alterar
            btCadastrar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Curso curso = (Curso) cursoComboBox.getSelectedItem();
                    String novoNome = idFieldText.getText();

                    //Alter o nome do Curso
                    curso.setName(novoNome);

                    JOptionPane.showMessageDialog(null, "Curso atualizado! Novo nome: "+ novoNome);
                }
            });

            // Manipulador de Eventos para o botão Cancelar
            voltar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setVisible(false);
                    new MenuInicial().setVisible(true);
                }
            });
        }
    }

    class CadastrarAlunoFrame extends JFrame{
        private JTextField nomeField, dataNascimentoField, emailField;
        private JButton cadastrar, voltar;

        public CadastrarAlunoFrame(){
            setTitle("SGE - Cadastro de Aluno");
            setSize(400, 300);
            setLocationRelativeTo(null);
            setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            setLayout(new GridLayout(6, 2));

            add(new JLabel("ID do Aluno"));
            JTextField idFieldText = new JTextField();
            add(idFieldText);

            add(new JLabel("Nome:"));
            nomeField = new JTextField();
            add(nomeField);

            add(new JLabel("Data de Nascimento: (dd/mm/aaaa"));
            dataNascimentoField = new JTextField();
            add(dataNascimentoField);

            add(new JLabel("Email:"));
            emailField = new JTextField();
            add(emailField);

            cadastrar = new JButton("Cadastrar");
            add(cadastrar);

            voltar = new JButton("Voltar");
            add(voltar);

            cadastrar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //Obtém as informações digitadas nos Fields
                    String id = idFieldText.getText();
                    String nome = nomeField.getText();
                    String dataNascimento =  dataNascimentoField.getText();
                    String email = emailField.getText();

                    utilitarios.setAluno(id, nome, dataNascimento, email);
                }
            });

            // Manipulador de Eventos para o botão Cancelar
            voltar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setVisible(false);
                    new MenuInicial().setVisible(true);
                }
            });
        }
    }

    class ConsultarAlunoFrame extends JFrame{
        private JTextField alunoIdField; // Campo para nome do aluno
        private JButton consultar, excluir;
        private JTextArea resultadoArea; // Área de texto para exibir resultados

        public ConsultarAlunoFrame(){
            setTitle("SGE - Consultar Aluno");
            setSize(400, 450); // Aumentando o tamanho da janela para acomodar os novos componentes
            setLocationRelativeTo(null);
            setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            setLayout(new GridBagLayout()); // Usando GridBagLayout para melhor controle de posicionamento
            GridBagConstraints gbc = new GridBagConstraints(); // Constraints para posicionamento flexível

            // Adicionando o campo para pesquisa por nome
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.anchor = GridBagConstraints.WEST;
            add(new JLabel("ID do Aluno:"), gbc);

            alunoIdField = new JTextField(20); // Campo para nome do aluno
            gbc.gridx = 1;
            gbc.gridy = 0;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            add(alunoIdField, gbc);

            // Botão Consultar
            consultar = new JButton("Consultar");
            gbc.gridx = 0;
            gbc.gridy = 1;
            gbc.fill = GridBagConstraints.NONE;
            add(consultar, gbc);

            // Botão Excluir
            excluir = new JButton("Excluir");
            gbc.gridx = 1;
            gbc.gridy = 1;
            add(excluir, gbc);

            // Área de texto para mostrar o resultado
            resultadoArea = new JTextArea(10, 30);
            resultadoArea.setEditable(false);
            JScrollPane scrollPane = new JScrollPane(resultadoArea);
            gbc.gridx = 0;
            gbc.gridy = 2;
            gbc.gridwidth = 2;
            gbc.fill = GridBagConstraints.BOTH;
            add(scrollPane, gbc);

            // Botões adicionais: Matricular, Alterar, Excluir
            JPanel painelBotoes = new JPanel();
            painelBotoes.setLayout(new GridLayout(1, 3, 10, 10)); // Layout para os botões de ação

            JButton matricularButton = new JButton("Matricular");
            JButton alterarButton = new JButton("Alterar");
            JButton voltar = new JButton("Voltar");

            painelBotoes.add(matricularButton);
            painelBotoes.add(alterarButton);
            painelBotoes.add(voltar);

            gbc.gridx = 0;
            gbc.gridy = 3;
            gbc.gridwidth = 2;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            add(painelBotoes, gbc);

            // Manipulador de eventos para o botão Consultar
            consultar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String idAluno = alunoIdField.getText();
                    if (!idAluno.isEmpty()) {
                        Aluno alunoEncontrado = utilitarios.procuraAluno(idAluno);
                        resultadoArea.setText("Consultando informações do aluno: " + alunoEncontrado.getNome() + "\n" +
                        "ID: " + alunoEncontrado.getId() + "\n" +
                        "Nome: " + alunoEncontrado.getNome() + "\n" +
                        "Data Nascimento: "  + alunoEncontrado.getDataNascimento() + "\n" +
                        "E-mail: " + alunoEncontrado.getEmail());
                    } else {
                        resultadoArea.setText("Por favor, insira o ID do Aluno");
                    }
                }
            });

            //Criando um método para consultar o ID fornecido
            // Manipulador de eventos para o botão Cancelar
            voltar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setVisible(false); // Fecha a janela atual
                    new MenuInicial().setVisible(true);
                }
            });

            // Configurando os manipuladores para os botões "Matricular", "Alterar", e "Excluir"
            matricularButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setVisible(false);
                    new MatricularAlunoFrame().setVisible(true);
                }
            });

            alterarButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setVisible(false);
                    new AlterarAlunoFrame().setVisible(true);
                }
            });

            excluir.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String idAluno = alunoIdField.getText();
                    Aluno aluno = utilitarios.procuraAluno(idAluno);
                    utilitarios.deletarAluno(aluno);
                }
            });
        }
    }

    class AlterarAlunoFrame extends JFrame{
        public AlterarAlunoFrame(){
            setTitle("SGE - Alterar o E-mail do Aluno");
            setSize(400, 300);
            setLocationRelativeTo(null);
            setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            setLayout(new GridLayout(5, 2));


            //Adicionar uma ComboBox aqui!
            add(new JLabel("ID do Aluno: "));
            JTextField idAlunoFieldText = new JTextField();
            add(idAlunoFieldText);

            add(new JLabel("Novo E-mail do Aluno :"));
            JTextField idEmailFieldText = new JTextField();
            add(idEmailFieldText);

            JButton btCadastrar = new JButton("Alterar");
            add(btCadastrar);

            JButton voltar = new JButton("Voltar");
            add(voltar);

            //Manipulador de Eventos para Alterar
            btCadastrar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String novoEmail = idEmailFieldText.getText();
                    String id = idAlunoFieldText.getText();

                    utilitarios.alterarAluno(id, novoEmail);
                }
            });

            // Manipulador de Eventos para o botão Cancelar
            voltar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setVisible(false);
                    new MenuInicial().setVisible(true);
                }
            });
        }
    }

    class CadastrarDisciplinaFrame extends JFrame{
        private JComboBox<Curso> cursoComboBox;

        public CadastrarDisciplinaFrame(){
            setTitle("SGE - Cadastro de Disciplina");
            setSize(400, 300);
            setLocationRelativeTo(null);
            setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            setLayout(new GridLayout(5, 2));

            add(new JLabel("ID: "));
            JTextField idFieldText = new JTextField();
            add(idFieldText);

            add(new JLabel("Nome da Disciplina: "));
            JTextField nomeFieldText = new JTextField();
            add(nomeFieldText);

            JButton btCadastrar = new JButton("Cadastrar");
            add(btCadastrar);

            JButton voltar = new JButton("Voltar");
            add(voltar);

            //Manipulador de Eventos para Cadastrar
            btCadastrar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String id = idFieldText.getText();
                    String nome = nomeFieldText.getText();
                    Curso curso = (Curso) cursoComboBox.getSelectedItem();
                    //Cadastra Curso

                    utilitarios.setDisciplina(id, nome);
                    Disciplina disciplina = utilitarios.procuraDisciplina(id);
                    curso.addDisciplina(disciplina);
                    JOptionPane.showMessageDialog(null, "A disciplina: " + nome + " foi cadastrada!");
                }
            });

            // Manipulador de Eventos para o botão Cancelar
            voltar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setVisible(false);
                    new MenuInicial().setVisible(true);
                }
            });

        }
    }

    class ConsultarDisciplinaFrame extends JFrame{
        private JTextField disciplinaIdField; // Campo para nome do aluno
        private JButton consultar, voltar;
        private JTextArea resultadoArea; // Área de texto para exibir resultados

        public ConsultarDisciplinaFrame(){
            setTitle("SGE - Consultar Disciplina");
            setSize(400, 450); // Aumentando o tamanho da janela para acomodar os novos componentes
            setLocationRelativeTo(null);
            setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            setLayout(new GridBagLayout()); // Usando GridBagLayout para melhor controle de posicionamento
            GridBagConstraints gbc = new GridBagConstraints(); // Constraints para posicionamento flexível

            // Adicionando o campo para pesquisa por nome
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.anchor = GridBagConstraints.WEST;
            add(new JLabel("ID da Disciplina:"), gbc);

            disciplinaIdField = new JTextField(20); // Campo para o ID da disciplina
            gbc.gridx = 1;
            gbc.gridy = 0;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            add(disciplinaIdField, gbc);

            // Botão Consultar
            consultar = new JButton("Consultar");
            gbc.gridx = 0;
            gbc.gridy = 1;
            gbc.fill = GridBagConstraints.NONE;
            add(consultar, gbc);

            // Botão Cancelar
            voltar = new JButton("Voltar");
            gbc.gridx = 1;
            gbc.gridy = 1;
            add(voltar, gbc);

            // Área de texto para mostrar o resultado
            resultadoArea = new JTextArea(10, 30);
            resultadoArea.setEditable(false);
            JScrollPane scrollPane = new JScrollPane(resultadoArea);
            gbc.gridx = 0;
            gbc.gridy = 2;
            gbc.gridwidth = 2;
            gbc.fill = GridBagConstraints.BOTH;
            add(scrollPane, gbc);

            // Botões adicionais: Adicionar ao Curso, Alterar, Excluir
            JPanel painelBotoes = new JPanel();
            painelBotoes.setLayout(new GridLayout(1, 3, 10, 10)); // Layout para os botões de ação

            JButton alterarButton = new JButton("Alterar o Nome da Disciplina");
            JButton excluirButton = new JButton("Excluir a Disciplina");
            JButton adicionarNota = new JButton("Adicionar Nota à Disciplina");

            painelBotoes.add(alterarButton);
            painelBotoes.add(adicionarNota);
            painelBotoes.add(excluirButton);

            gbc.gridx = 0;
            gbc.gridy = 3;
            gbc.gridwidth = 2;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            add(painelBotoes, gbc);

            // Manipulador de eventos para o botão Consultar
            consultar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String idDisciplina = disciplinaIdField.getText();
                    if (!idDisciplina.isEmpty()) {
                        Disciplina disciplinaEncontrada = utilitarios.procuraDisciplina(idDisciplina);

                        resultadoArea.setText("Consultando informações da Matrícula: " + disciplinaEncontrada.getId() + "\n" +
                                "ID: " + idDisciplina +
                                "Nome: " + disciplinaEncontrada.getNome());

                    } else {
                        resultadoArea.setText("Por favor, insira o ID da Disciplina");
                    }
                }
            });

            //Manipulador de Eventos para o botão Alterar Curso
            alterarButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setVisible(false);
                    new AlterarDisciplinaFrame().setVisible(true);
                }
            });

            //Manipulador de Eventos para o botão Desmatricular Aluno
            excluirButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String id = disciplinaIdField.getText();
                    Matricula matricula = utilitarios.procuraMatricula(id);
                    utilitarios.desMatricula(matricula);
                }
            });

            // Manipulador de eventos para o botão Cancelar
            voltar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setVisible(false); // Fecha a janela atual
                    new MenuInicial().setVisible(true);
                }
            });
        }
    }

    class AlterarDisciplinaFrame extends JFrame{
        public AlterarDisciplinaFrame(){
            setTitle("SGE - Alterar o Nome da Aluno");
            setSize(400, 300);
            setLocationRelativeTo(null);
            setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            setLayout(new GridLayout(5, 2));

            add(new JLabel("ID da Disciplina: "));
            JTextField idDisciplinaFieldText = new JTextField();
            add(idDisciplinaFieldText);

            add(new JLabel("Novo Nome :"));
            JTextField nomeFieldText = new JTextField();
            add(nomeFieldText);

            JButton btCadastrar = new JButton("Alterar");
            add(btCadastrar);

            JButton voltar = new JButton("Voltar");
            add(voltar);

            //Manipulador de Eventos para Alterar
            btCadastrar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String novoNome = nomeFieldText.getText();
                    String id = idDisciplinaFieldText.getText();

                    Disciplina disciplina = utilitarios.procuraDisciplina(id);
                    disciplina.setNome(novoNome);
                }
            });

            // Manipulador de Eventos para o botão Cancelar
            voltar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setVisible(false);
                    new MenuInicial().setVisible(true);
                }
            });
        }
    }

    class MatricularAlunoFrame extends JFrame{
        private JTextField anoLetivoField;
        private JButton cadastrar, voltar;
        private JComboBox<Curso> cursoComboBox;

        public MatricularAlunoFrame(){
            setTitle("SGE - Matricular Aluno");
            setSize(500, 300);
            setLocationRelativeTo(null);
            setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            setLayout(new BorderLayout());
            cursoComboBox = new JComboBox<>();

            //Adiciona os cursos ao comboBox
            for(Curso curso : utilitarios.getCursos()){
                this.cursoComboBox.addItem(curso);
            }

            JPanel cabecalho = new JPanel();
            cabecalho.setLayout(new FlowLayout(FlowLayout.CENTER));
            JLabel nomeEscola = new JLabel("SGE - Matricular Aluno", SwingConstants.CENTER);
            nomeEscola.setFont(new Font("Swis721 Blk BT", Font.BOLD,22));
            cabecalho.add(nomeEscola);
            add(cabecalho, BorderLayout.NORTH);

            //Painel Central
            JPanel centro = new JPanel();
            centro.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
            centro.setLayout(new GridLayout(6,2));
            add(centro);

            centro.add(new JLabel("ID do Aluno"));
            JTextField idAlunoFieldText = new JTextField();
            centro.add(idAlunoFieldText);

            centro.add(new JLabel("ID da Matrícula: "));
            JTextField idFieldText = new JTextField();
            centro.add(idFieldText);

            centro.add(new JLabel("Ano Letivo: "));
            anoLetivoField = new JTextField();
            centro.add(anoLetivoField);

            centro.add(new JLabel("Selecione o Curso: "));
            centro.add(cursoComboBox);

            centro.add(cadastrar = new JButton("Matricular"));
            centro.add(cadastrar);

            centro.add(voltar = new JButton("Voltar"));
            centro.add(voltar);

            cadastrar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //Obtém as informações digitadas nos Fields
                    String idAluno = idAlunoFieldText.getText();
                    String id = idFieldText.getText();
                    String anoLetivo =  anoLetivoField.getText();

                    Curso cursoSelecionado = (Curso) cursoComboBox.getSelectedItem();
                    Aluno alunoSelecionado = utilitarios.procuraAluno(idAluno);

                    utilitarios.setMatricula(id, alunoSelecionado, anoLetivo, cursoSelecionado);
                }
            });

            // Manipulador de Eventos para o botão Cancelar
            voltar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setVisible(false);
                    new MenuInicial().setVisible(true);
                }
            });
        }
    }

    class ConsultarMatriculaFrame extends JFrame{
        private JTextField matriculaIdField; // Campo para nome do aluno
        private JButton consultar, voltar;
        private JTextArea resultadoArea; // Área de texto para exibir resultados

        public ConsultarMatriculaFrame(){
            setTitle("SGE - Consultar Matrícula");
            setSize(400, 450); // Aumentando o tamanho da janela para acomodar os novos componentes
            setLocationRelativeTo(null);
            setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            setLayout(new GridBagLayout()); // Usando GridBagLayout para melhor controle de posicionamento
            GridBagConstraints gbc = new GridBagConstraints(); // Constraints para posicionamento flexível

            // Adicionando o campo para pesquisa por nome
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.anchor = GridBagConstraints.WEST;
            add(new JLabel("ID da Matrícula:"), gbc);

            matriculaIdField = new JTextField(20); // Campo para o ID da matrícula
            gbc.gridx = 1;
            gbc.gridy = 0;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            add(matriculaIdField, gbc);

            // Botão Consultar
            consultar = new JButton("Consultar");
            gbc.gridx = 0;
            gbc.gridy = 1;
            gbc.fill = GridBagConstraints.NONE;
            add(consultar, gbc);

            // Botão Cancelar
            voltar = new JButton("Voltar");
            gbc.gridx = 1;
            gbc.gridy = 1;
            add(voltar, gbc);

            // Área de texto para mostrar o resultado
            resultadoArea = new JTextArea(10, 30);
            resultadoArea.setEditable(false);
            JScrollPane scrollPane = new JScrollPane(resultadoArea);
            gbc.gridx = 0;
            gbc.gridy = 2;
            gbc.gridwidth = 2;
            gbc.fill = GridBagConstraints.BOTH;
            add(scrollPane, gbc);

            // Botões adicionais: Matricular, Alterar, Excluir
            JPanel painelBotoes = new JPanel();
            painelBotoes.setLayout(new GridLayout(1, 3, 10, 10)); // Layout para os botões de ação

            JButton alterarButton = new JButton("Alterar Curso");
            JButton excluirButton = new JButton("Desmatricular Aluno");

            painelBotoes.add(alterarButton);
            painelBotoes.add(excluirButton);

            gbc.gridx = 0;
            gbc.gridy = 3;
            gbc.gridwidth = 2;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            add(painelBotoes, gbc);

            // Manipulador de eventos para o botão Consultar
            consultar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String idMatricula = matriculaIdField.getText();
                    if (!idMatricula.isEmpty()) {
                        Matricula matriculaEncontrada = utilitarios.procuraMatricula(idMatricula);
                        Aluno alunoEncontrado = matriculaEncontrada.getAluno();
                        Curso cursoEncontrado = matriculaEncontrada.getCurso();
                        resultadoArea.setText("Consultando informações da Matrícula: " + matriculaEncontrada.getId() + "\n" +
                                "Aluno: " + alunoEncontrado.getNome() + "\n" +
                                "Curso matriculado: " + cursoEncontrado.getName() + "\n" +
                                "Ano letivo: "  + matriculaEncontrada.getAnoLetivo() + "\n" +
                                "Status da matrícula: " + matriculaEncontrada.getStatus());
                    } else {
                        resultadoArea.setText("Por favor, insira o ID da Matrícula");
                    }
                }
            });

            //Manipulador de Eventos para o botão Alterar Curso
            alterarButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setVisible(false);
                    new AlterarMatricula().setVisible(true);
                }
            });

            //Manipulador de Eventos para o botão Desmatricular Aluno
            excluirButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String id = matriculaIdField.getText();
                    Matricula matricula = utilitarios.procuraMatricula(id);
                    utilitarios.desMatricula(matricula);
                }
            });

            // Manipulador de eventos para o botão Cancelar
            voltar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setVisible(false); // Fecha a janela atual
                    new MenuInicial().setVisible(true);
                }
            });

        }
    }

    class AlterarMatricula extends JFrame{
        private JComboBox<Curso> cursoComboBox;

        public AlterarMatricula(){
            setTitle("SGE - Alterar o Curso da Matrícula");
            setSize(400, 300);
            setLocationRelativeTo(null);
            setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            setLayout(new GridLayout(5, 2));
            cursoComboBox = new JComboBox<>();

            //Adiciona todos os cursos consultados
            for(Curso curso : utilitarios.getCursos()){
                this.cursoComboBox.addItem(curso);
            }
            //Adicionar uma ComboBox aqui!
            add(new JLabel("Selecione o novo curso: "));
            add(cursoComboBox);

            add(new JLabel("ID da Matrícula  :"));
            JTextField idFieldText = new JTextField();
            add(idFieldText);

            JButton btCadastrar = new JButton("Alterar");
            add(btCadastrar);

            JButton voltar = new JButton("Voltar");
            add(voltar);

            //Manipulador de Eventos para Cadastrar
            btCadastrar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Curso novoCurso = (Curso) cursoComboBox.getSelectedItem();
                    String novoCursoNome = novoCurso.getName();
                    String id = idFieldText.getText();

                    Matricula matriculaInformada = utilitarios.procuraMatricula(id);

                    //Cadastra Curso
                    utilitarios.alterarCursoMatricula(matriculaInformada, novoCurso);
                    JOptionPane.showMessageDialog(null, "O curso: " + novoCursoNome + " foi atualizado!");
                }
            });

            // Manipulador de Eventos para o botão Cancelar
            voltar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setVisible(false);
                    new MenuInicial().setVisible(true);
                }
            });
        }
    }

    class CadastrarNotaFrame extends JFrame{
        public CadastrarNotaFrame(){
            setTitle("SGE - Cadastro de Nota");
            setSize(400, 300);
            setLocationRelativeTo(null);
            setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            setLayout(new GridLayout(5, 2));

            add(new JLabel("ID do Aluno "));
            JTextField idAlunoFieldText = new JTextField();
            add(idAlunoFieldText);

            add(new JLabel("ID do Curso: "));
            JTextField idDisciplinaFieldText = new JTextField();
            add(idDisciplinaFieldText);

            add(new JLabel("Nota da Disciplina: "));
            JTextField notaFieldText = new JTextField();
            add(notaFieldText);

            JButton btCadastrar = new JButton("Cadastrar");
            add(btCadastrar);

            JButton voltar = new JButton("Voltar");
            add(voltar);

            //Manipulador de Eventos para Cadastrar
            btCadastrar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String idAluno = idAlunoFieldText.getText();
                    String idDisciplina = idDisciplinaFieldText.getText();
                    double nota = Double.parseDouble(notaFieldText.getText());

                    Aluno aluno = utilitarios.procuraAluno(idAluno);
                    Disciplina disciplina = utilitarios.procuraDisciplina(idDisciplina);

                    //Cadastra Nota
                    Nota novaNota = new Nota(aluno, disciplina, nota);
                    aluno.addNota(novaNota);
                    JOptionPane.showMessageDialog(null, "Cadastro de nota concluído!" + "\n" +
                            "Aluno: " + aluno.getNome() + " Disciplina: " + disciplina.getNome() + " Nota: " + nota);
                }
            });

            // Manipulador de Eventos para o botão Cancelar
            voltar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setVisible(false);
                    new MenuInicial().setVisible(true);
                }
            });
        }
    }

    class ConsultarNotaFrame extends JFrame{
        private JTextField idAlunoField; // Campo para nome do aluno
        private JButton consultar, voltar;
        private JTextArea resultadoArea; // Área de texto para exibir resultados

        public ConsultarNotaFrame(){
            setTitle("SGE - Consultar Notas");
            setSize(400, 450); // Aumentando o tamanho da janela para acomodar os novos componentes
            setLocationRelativeTo(null);
            setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            setLayout(new GridBagLayout()); // Usando GridBagLayout para melhor controle de posicionamento
            GridBagConstraints gbc = new GridBagConstraints(); // Constraints para posicionamento flexível

            // Adicionando o campo para pesquisa por nome
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.anchor = GridBagConstraints.WEST;
            add(new JLabel("ID do Aluno:"), gbc);

            idAlunoField = new JTextField(20); // Campo para o ID da matrícula
            gbc.gridx = 1;
            gbc.gridy = 0;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            add(idAlunoField, gbc);

            // Botão Consultar
            consultar = new JButton("Consultar");
            gbc.gridx = 0;
            gbc.gridy = 1;
            gbc.fill = GridBagConstraints.NONE;
            add(consultar, gbc);

            // Botão Cancelar
            voltar = new JButton("Voltar");
            gbc.gridx = 1;
            gbc.gridy = 1;
            add(voltar, gbc);

            // Área de texto para mostrar o resultado
            resultadoArea = new JTextArea(10, 30);
            resultadoArea.setEditable(false);
            JScrollPane scrollPane = new JScrollPane(resultadoArea);
            gbc.gridx = 0;
            gbc.gridy = 2;
            gbc.gridwidth = 2;
            gbc.fill = GridBagConstraints.BOTH;
            add(scrollPane, gbc);

            // Botões adicionais: Matricular, Alterar, Excluir
            JPanel painelBotoes = new JPanel();
            painelBotoes.setLayout(new GridLayout(1, 3, 10, 10)); // Layout para os botões de ação

            JButton alterarButton = new JButton("Alterar Nota");

            painelBotoes.add(alterarButton);

            gbc.gridx = 0;
            gbc.gridy = 3;
            gbc.gridwidth = 2;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            add(painelBotoes, gbc);

            // Manipulador de eventos para o botão Consultar
            consultar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String idAluno = idAlunoField.getText();
                    if (!idAluno.isEmpty()) {
                        Aluno alunoEncontrado = utilitarios.procuraAluno(idAluno);

                        resultadoArea.setText("Consultando informações do Aluno: " + alunoEncontrado.getId() + "\n" +
                                "Curso matriculado: " + alunoEncontrado.getCurso() + "\n" +
                                alunoEncontrado.getNotas());
                    } else {
                        resultadoArea.setText("Por favor, insira o ID da Matrícula");
                    }
                }
            });

            //Manipulador de Eventos para o botão Alterar Curso
            alterarButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setVisible(false);
                    new AlterarNotaFrame().setVisible(true);
                }
            });

            //Manipulador de Eventos para o botão Desmatricular Aluno
            /*
            * excluirButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String id = matriculaIdField.getText();
                    Matricula matricula = utilitarios.procuraMatricula(id);
                    utilitarios.desMatricula(matricula);
                }
            });
            * */

            // Manipulador de eventos para o botão Cancelar
            voltar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setVisible(false); // Fecha a janela atual
                    new MenuInicial().setVisible(true);
                }
            });
        }
    }

    class AlterarNotaFrame extends JFrame{
        public AlterarNotaFrame(){
            setTitle("SGE - Alterar a Nota");
            setSize(400, 300);
            setLocationRelativeTo(null);
            setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            setLayout(new GridLayout(5, 2));

            add(new JLabel("ID do Aluno: "));
            JTextField idAlunoFieldText = new JTextField();
            add(idAlunoFieldText);

            add(new JLabel("ID da Disciplina: "));
            JTextField idDisciplinaFieldText = new JTextField();
            add(idDisciplinaFieldText);

            add(new JLabel("Nova nota :"));
            JTextField nomeFieldText = new JTextField();
            add(nomeFieldText);

            JButton btCadastrar = new JButton("Alterar");
            add(btCadastrar);

            JButton voltar = new JButton("Voltar");
            add(voltar);

            //Manipulador de Eventos para Alterar
            btCadastrar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    double novaNota = Double.parseDouble(nomeFieldText.getText());
                    String id = idDisciplinaFieldText.getText();
                    String idAluno = idAlunoFieldText.getText();

                    Aluno aluno = utilitarios.procuraAluno(idAluno);
                    aluno.alterarNota(id, novaNota);
                }
            });

            // Manipulador de Eventos para o botão Cancelar
            voltar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setVisible(false);
                    new MenuInicial().setVisible(true);
                }
            });
        }
    }

}


