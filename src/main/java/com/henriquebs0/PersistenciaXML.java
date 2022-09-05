package com.henriquebs0;

import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class PersistenciaXML extends Persistencia {

    public PersistenciaXML(String file) {
        super(file + ".xml");
    }
    

    @Override
    public void persistir(Aluno aluno) throws JsonMappingException, JsonProcessingException, IOException {
        XmlMapper xmlMapper = new XmlMapper();

        String conteudo = ler();

        ArrayList<Aluno> alunos = conteudo == null ? new ArrayList<Aluno>() : xmlMapper.readValue(conteudo, new TypeReference<ArrayList<Aluno>>() {});
        alunos.add(aluno);
        gravar(xmlMapper.writeValueAsString(alunos));
    }
    
}
