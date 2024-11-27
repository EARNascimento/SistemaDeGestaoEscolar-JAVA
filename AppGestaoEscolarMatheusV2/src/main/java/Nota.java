public class Nota {
    private double nota;
    private Aluno aluno;
    private Disciplina disciplina;

    public Nota(Aluno aluno, Disciplina disciplina, double nota){
        this.nota = nota;
        this.disciplina = disciplina;
        this.aluno = aluno;
    }

    //Getters
    public Aluno getAluno(){
        return aluno;
    }

    public double getNota(){
        return nota;
    }

    public Disciplina getDisciplina(){
        return disciplina;
    }
    //Setters
    public void setNota(){
        this.nota = nota;
    }
}
