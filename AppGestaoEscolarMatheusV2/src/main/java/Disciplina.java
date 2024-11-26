import java.util.ArrayList;
import java.util.List;

public class Disciplina {
    private final String id;
    private String nome;
    private double nota;
    private List<Curso> cursos = new ArrayList<>();

    public Disciplina(String id, String nome){
        this.id = id;
        this.nome = nome;
    }

    //Getters
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
