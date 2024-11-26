import java.util.ArrayList;
import java.util.List;

public class Matricula {

    private final String id;

    private String anoLetivo;
    private Aluno aluno;
    private Curso curso;
    private boolean status;

    public Matricula(String id, Aluno aluno, String anoLetivo, Curso curso){
        this.id = id;
        this.aluno = aluno;
        this.anoLetivo = anoLetivo;
        this.curso = curso;
        this.status = false;
    }

    //Getters
    public String getId(){
        return id;
    }

    public String getAnoLetivo(){
        return anoLetivo;
    }

    public boolean getStatus(){
        return status;
    }

    public Aluno getAluno(){
        return aluno;
    }

    public Curso getCurso(){
        return curso;
    }

    //Setters
    public void setAnoLetivo(String anoLetivo){
        this.anoLetivo = anoLetivo;
    }

    public void setStatus(boolean status){
        this.status = status;
    }

    public void setCurso(Curso curso){
        this.curso = curso;
    }

    public void removeCurso(Curso curso){
        this.curso = null;
    }

    public boolean equals(Matricula matricula1){
        return this.id.equals(matricula1.id);
    }

    //toString
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Matrícula: ").append(id).append("\n");
        sb.append("Aluno: ").append(aluno.getNome()).append("\n");
        sb.append("Ano Letivo: ").append(anoLetivo).append("\n");
        sb.append("Curso: ").append(curso.getName()).append("\n");
        sb.append("Status: ").append(status).append("\n");
        sb.append("\n");
        return sb.toString();
    }
}
