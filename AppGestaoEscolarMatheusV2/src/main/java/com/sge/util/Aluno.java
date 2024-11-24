package com.sge.util;

import java.util.Objects;

public class Aluno {
    private String nome;
    private String dataNascimento;
    private String email;
    private final String id;

    public Aluno(String nome, String dataNascimento, String email, String id ){
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.id = id;
    }

    public String getId(){
        return id;
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
