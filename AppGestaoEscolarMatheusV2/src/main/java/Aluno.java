import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Aluno {
    private String nome;
    private String dataNascimento;
    private String email;
    private final String id;
    private Matricula matricula;
    private Curso curso;
    private List<Nota> notas = new ArrayList<>();
    List<Curso> cursos = new ArrayList<>();

    //Construtor
    public Aluno(String id, String nome, String dataNascimento, String email){
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.id = id;
    }

    //Getters

    public List<Nota> getNotas(){
        return notas;
    }
    public String getId(){
        return id;
    }

    public Curso getCurso(){
        return curso;
    }

    public Matricula getMatricula(){
        return matricula;
    }

    public String getNome(){
        return nome;
    }

    public String getDataNascimento(){
        return dataNascimento;
    }

    public String getEmail(){
        return email;
    }

    public List<Curso> getCursos(){
        return cursos;
    }

    //Setters

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setDataNascimento(String dataNascimento){
        this.dataNascimento = dataNascimento;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void addCurso(Curso curso){
        cursos.add(curso);
    }

    public void removeCurso(Curso curso){
        cursos.remove(curso);
    }

    public void setMatricula(Matricula matricula){
        this.matricula = matricula;
    }

    public void setCurso(Curso curso){
        this.curso = curso;
    }

    public void addNota(Nota nota){
        notas.add(nota);
    }

    public String listarNotas(){
        for(Nota nota : notas){
            return "Disciplina: " + nota.getDisciplina().getNome() + "Nota: " + nota.getNota();
        }
        return "";
    }

    //Verificar se o ID está sendo usado
    public boolean equals(Object obj){
        if (obj instanceof Aluno other){
            return Objects.equals(id, other.id);
        }
        return false;
    }

    //Retornar os dados do aluno
    public String toString(){
        return "Nome: " + nome + "\n" +
                "Data de Nascimento: " + dataNascimento + "\n" +
                "E-mail: " + email + "\n" +
                "Matrícula: " + id;
    }

}
