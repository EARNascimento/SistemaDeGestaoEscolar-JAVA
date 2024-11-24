package com.sge.util;

public class Matricula {

    private Aluno aluno;
    private Curso curso;
    private String anoLetivo;
    private boolean status;

    public Matricula(Aluno aluno, Curso curso, String anoLetivo){
        this.aluno = aluno;
        this.curso = curso;
        this.anoLetivo = anoLetivo;
        this.status = false;
    }


}
