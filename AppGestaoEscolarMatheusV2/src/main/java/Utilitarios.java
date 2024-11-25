import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Utilitarios {
    private List<Curso> cursos = new ArrayList<>();
    private List<Aluno> alunos = new ArrayList<>();

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