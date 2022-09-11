package com.henriquebs0;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

abstract public class Persistencia  {

    private String file;

    public Persistencia(String file) {
        this.file = file;
    }

    protected void gravar(String conteudo) throws IOException {
        BufferedWriter buffWrite = new BufferedWriter(new FileWriter(file));
        buffWrite.append(conteudo);
		buffWrite.close();
    }

    protected String ler() throws IOException {
        BufferedReader buffRead = new BufferedReader(new FileReader(this.file));
		String conteudo = buffRead.readLine();
        buffRead.close();
        return conteudo;
    }

    abstract public void persistir(Aluno aluno) throws JsonMappingException, JsonProcessingException, IOException;

    public static <T extends Persistencia> void persistir(T persistencia, Aluno aluno) throws JsonMappingException, JsonProcessingException, IOException {
        persistencia.persistir(aluno);
    }
}
