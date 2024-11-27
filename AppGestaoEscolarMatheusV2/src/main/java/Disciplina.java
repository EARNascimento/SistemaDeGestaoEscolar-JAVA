import java.util.ArrayList;
import java.util.List;

public class Disciplina {
    private final String id;
    private String nome;


    public Disciplina(String id, String nome){
        this.id = id;
        this.nome = nome;
<<<<<<< HEAD
        this.nota = nota;
    }

    //Getters
    public List<Curso> getCursos(){
        return cursos;
=======
>>>>>>> monolito
    }

    public String getId(){
        return id;
    }

    public String getNome(){
        return nome;
    }

    //Setters
    public void setNome(String nome){
        this.nome = nome;
    }

}
