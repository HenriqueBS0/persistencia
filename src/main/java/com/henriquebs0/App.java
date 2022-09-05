package com.henriquebs0;

import java.io.IOException;
import java.util.Date;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;


public class App 
{
    final static String file = "DB/alunos";
    public static void main( String[] args ) throws JsonMappingException, JsonProcessingException, IOException {
        Persistencia persistencia = new PersistenciaXML(file);
        // Persistencia persistencia = new PersistenciaXML(file);
        
        Aluno aluno = new Aluno("Henrique Borges dos Santos", 123123, "12839458942", new Date(), "henrique.10agr@gmail.com");

        persistencia.persistir(aluno);
    }
}
