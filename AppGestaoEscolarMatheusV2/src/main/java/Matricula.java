import java.util.ArrayList;
import java.util.List;

public class Matricula {

    private final String id;

    private String anoLetivo;
    private boolean status;

    private List<Curso> cursos = new ArrayList<>();
    private List<Aluno> alunos = new ArrayList<>();

    public Matricula(String id, String anoLetivo){
        this.id = id;
        this.anoLetivo = anoLetivo;
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

    public List<Aluno> getAlunos(){
        return alunos;
    }

    public List<Curso> getCursos(){
        return cursos;
    }

    //Setters
    public void setAnoLetivo(String anoLetivo){
        this.anoLetivo = anoLetivo;
    }

    public void setStatus(boolean status){
        this.status = status;
    }

    public void addAluno(Aluno aluno){
        alunos.add(aluno);
    }

    public void removeAluno(Aluno aluno){
        alunos.remove(aluno);
    }

    public void addCurso(Curso curso){
        cursos.add(curso);
    }

    public void removeCurso(Curso curso){
        cursos.remove(curso);
    }

    public boolean equals(Matricula matricula1){
        return this.id.equals(matricula1.id);
    }

    //toString
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Matrícula: ").append(id).append("\n");
        sb.append("Ano Letivo: ").append(anoLetivo).append("\n");
        sb.append("Status: ").append(status).append("\n");
        sb.append("\n");
        return sb.toString();
    }
}
