package com.henriquebs0;

import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


public class PersistenciaJSON extends Persistencia {

    public PersistenciaJSON(String file) {
        super(file + ".json");
    }
    
    @Override
    public void persistir(Aluno aluno) throws JsonProcessingException, IOException {
        ObjectMapper jsonMapper = new ObjectMapper();

        String conteudo = ler();
 
        ArrayList<Aluno> alunos = conteudo == null ? new ArrayList<Aluno>() : jsonMapper.readValue(conteudo, new TypeReference<ArrayList<Aluno>>() {});
        alunos.add(aluno);
        gravar(jsonMapper.writeValueAsString(alunos));
    }
}
