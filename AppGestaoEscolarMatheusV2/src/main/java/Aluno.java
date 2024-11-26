import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Aluno {
    private String nome;
    private String dataNascimento;
    private String email;
    private final String id;
    private String idMatricula;

    List<Curso> cursos = new ArrayList<>();

    //Construtor
    public Aluno(String id, String nome, String dataNascimento, String email){
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.id = id;
    }

    //Getters
    public String getId(){
        return id;
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

    public void setIdMatricula(String idMatricula){
        this.idMatricula = idMatricula;
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
