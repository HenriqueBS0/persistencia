package com.henriquebs0;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;


public class App 
{
    final static String file = "DB/alunos";
    public static void main( String[] args ) throws JsonMappingException, JsonProcessingException, IOException {
        Aluno aluno = new Aluno("Henrique Borges dos Santos", 123123, "12839458942", new Date(), "henrique.10agr@gmail.com");
        Persistencia.persistir(getTipoPersistencia(), aluno);
    }

    public static Persistencia getTipoPersistencia() {
        List<Persistencia> persistencias = new ArrayList<Persistencia>();
        persistencias.add(new PersistenciaXML(file));
        persistencias.add(new PersistenciaJSON(file));

        int opcao;

        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Formato 1 - <XML> 2 - <JSON>");
            opcao = scanner.nextInt();
            scanner.nextLine();
        } while (opcao != 1 && opcao != 2);

        scanner.close();

        return persistencias.get(opcao -1);
    }
}
