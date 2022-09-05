package com.henriquebs0;

import java.util.Date;

public class Aluno extends Pessoa {
    
    public int matricula;

    public String cpf;

    public Date dataNascimento;

    public String email;

    public Aluno(String nome, int matricula, String cpf, Date dataNascimento, String email) {
        super(nome);
        this.matricula = matricula;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.email = email;
    }

    public Aluno() {
        super(null);
    }
}
