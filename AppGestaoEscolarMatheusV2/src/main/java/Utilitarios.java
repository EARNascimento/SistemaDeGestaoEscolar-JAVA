import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Utilitarios {

    private List<Curso> cursos = new ArrayList<>();
    private List<Aluno> alunos = new ArrayList<>();

    public Utilitarios(){

    }

    public Curso setCurso(String id, String nome){
        Curso novoCurso = new Curso(id, nome);
        for(Curso curso : cursos){
            if (curso.equals(novoCurso)){
                JOptionPane.showMessageDialog(null, "Curso já existente");
            }

        }
        cursos.add(novoCurso);
        return novoCurso;
    }
}
