import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Utilitarios {
    private List<Curso> cursos = new ArrayList<>();
    private List<Aluno> alunos = new ArrayList<>();
    private List<Matricula> matriculas = new ArrayList<>();

    public Utilitarios() {

    }

    //Utilitários Curso

    public List<Curso> getCursos() {
        return cursos;
    }

    public Curso setCurso(String id, String nome) {
        Curso novoCurso = new Curso(id, nome);
        for (Curso curso : cursos) {
            if (curso.equals(novoCurso)) {
                JOptionPane.showMessageDialog(null, "Curso já existente");
            }
        }
        cursos.add(novoCurso);
        return novoCurso;
    }

    //Utilitários Aluno

    public void setAluno(String id, String nome, String dataNascimento, String email){
        Aluno novoAluno = new Aluno(id, nome, dataNascimento, email);
        //Verifica se o Aluno já existe;
        if(!alunos.contains(novoAluno)){
            alunos.add(novoAluno);
            JOptionPane.showMessageDialog(null, " O aluno " + nome + " foi cadastrado com sucesso!");
        } else{
            JOptionPane.showMessageDialog(null, "O aluno " + nome + " já existe!");
        }
    }

    public Aluno procuraAluno(String id){
        boolean encontrei = false;
        Aluno result = null;

        //Percorre por alunos em busca de algum com o ID fornecido
        for(Aluno aluno : alunos){
            if(aluno.getId().equals(id)){
                result = aluno;
                encontrei = true;
                break;
            }
        }
        if (!encontrei){
            JOptionPane.showMessageDialog(null, "Aluno não encontrado!");
            throw new RuntimeException("Aluno não encontrado");
        }
        return result;
    }

    //Utilitários Matricula

    public List<Matricula> getMatriculas(){
        return matriculas;
    }

    public void setMatricula(String id, Aluno aluno, String anoLetivo, Curso curso){
        Matricula novaMatricula = new Matricula(id, aluno, anoLetivo, curso);
        //Verifica se a Matrícula já existe;
        if(!matriculas.contains(novaMatricula)){
            matriculas.add(novaMatricula);
            aluno.setIdMatricula(id);
            novaMatricula.setStatus(true);
            JOptionPane.showMessageDialog(null, "A matrícula: " + id + " foi cadastrada com sucesso!");
        } else{
            JOptionPane.showMessageDialog(null, "A matrícula: " + id + " já existe!");
        }
    }

    public Matricula procuraMatricula(String id){
        boolean encontrei = false;
        Matricula result = null;

        //Percorre por Matrículas em busca de algum com o ID fornecido
        for(Matricula matricula : matriculas){
            if(matricula.getId().equals(id)){
                result = matricula;
                encontrei = true;
                break;
            }
        }
        if(!encontrei){
            JOptionPane.showMessageDialog(null, "Aluno não encontrado!");
            throw new RuntimeException(("Aluno não encontrado!"));
        }
        return result;
    }

    //Utilitários Load de Arquivos
    public void carregarPreCadastro() {
        //Neste método, é realizado a leitura do arquivo preCadastro.txt
        Curso curso;

        String nomeArquivo = "src/main/preCadastro.txt";
        String line;

        try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
            while ((line = reader.readLine()) != null) {

                if (line.contains("curso")) {
                    //Lendo o arquivo e criando as instâncias de Curso
                    String id = reader.readLine();
                    String nome = reader.readLine();

                    setCurso(id, nome);

                    JOptionPane.showMessageDialog(null, "O Curso " + nome + " foi carregado com sucesso!");
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo " + nomeArquivo + ": " + e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}