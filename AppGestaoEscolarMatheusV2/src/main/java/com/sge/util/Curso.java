package com.sge.util;

public class Curso {
    private final String id;
    private String name;

    public Curso(String id, String name){
        this.id = id;
        this.name = name;
    }

    //Getters
    public String getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    //Setters
    public void setName(String name){
        this.name = name;
    }

    public void addAluno(Aluno aluno){

    }

    public void removeAluno(Aluno aluno){

    }

    //Verificando o ID
    public boolean equals(Curso curso2){
        return this.id.equals(curso2.id);
    }
    //Retornando informações do Curso
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Nome: ").append(name).append("\n");
        sb.append("ID: ").append(id).append("\n");
        return sb.toString();
    }
}
