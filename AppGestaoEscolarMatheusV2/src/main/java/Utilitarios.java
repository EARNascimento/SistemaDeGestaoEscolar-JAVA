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
    private List<Disciplina> disciplinas = new ArrayList<>();

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

    public void deletarCurso(Curso curso){
        for(Aluno aluno : curso.getAlunos()){
            aluno.removeCurso(curso);
        }

        cursos.remove(curso);
        JOptionPane.showMessageDialog(null, "O curso: " + curso.getName() + " foi removido com sucesso!");
    }

    //Utilitários Aluno

    public List<Aluno> getAlunos(){
        return alunos;
    }

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

    public void alterarAluno(String id, String email){
       Aluno aluno = procuraAluno(id);
       aluno.setEmail(email);
       JOptionPane.showMessageDialog(null, "Email do aluno: " + aluno.getNome() + " atualizado para " + email);
    }

    public void deletarAluno(Aluno aluno){
        for(Curso curso: aluno.getCursos()){
            curso.removeAluno(aluno);
        }
        alunos.remove(aluno);
        JOptionPane.showMessageDialog(null, "O aluno: " + aluno.getNome() + " foi removido com sucesso");

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
            aluno.setMatricula(novaMatricula);
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

    public void alterarCursoMatricula(Matricula matricula, Curso curso){
        matricula.setCurso(curso);
    }

    public void desMatricula(Matricula matricula){
        matricula.setCurso(null);
        matricula.setStatus(false);
        matricula.setAnoLetivo(null);

        Aluno alunoMatriculado = matricula.getAluno();

        JOptionPane.showMessageDialog(null, "O aluno " + alunoMatriculado.getNome() + " foi desmatriculado!");
        JOptionPane.showMessageDialog(null, "O ID de Matrícula: " + matricula.getId() + " foi desativado!");
    }

    //Utiitários Disciplina

    public List<Disciplina> getDisciplina(){
        return disciplinas;
    }

    public void setDisciplina(String id, String nome){
        Disciplina novaDisciplina = new Disciplina(id, nome);
        if(!disciplinas.contains(novaDisciplina)){
            disciplinas.add(novaDisciplina);
            JOptionPane.showMessageDialog(null, "A disciplina: " + id + " foi cadastrada com sucesso!");
        } else{
            JOptionPane.showMessageDialog(null, "A matrícula: " + id + " já existe!");
        }
    }

    public Disciplina procuraDisciplina(String id){
        boolean encontrei = false;
        Disciplina result = null;

        for(Disciplina disciplina : disciplinas){
            if(disciplina.getId().equals(id)){
                result = disciplina;
                encontrei = true;
                break;
            }
        }
        if(!encontrei){
            JOptionPane.showMessageDialog(null, "Disciplina não encontrada!");
            throw new RuntimeException("Disciplina não encontrada");
        }
        return result;
    }

    //Utilitarios Nota

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