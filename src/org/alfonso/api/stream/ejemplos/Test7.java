package org.alfonso.api.stream.ejemplos;

import org.alfonso.api.stream.ejemplos.mainclasses.Usuario;

import java.util.ArrayList;
import java.util.List;

public class Test7
{
    public static void main(String[] args) throws Exception
    {
        List<String> listaDeNombres = new ArrayList<>();
        listaDeNombres.add("PAQUIN MACUTO");
        listaDeNombres.add("PERICO PALOTES");
        listaDeNombres.add("EUSTAQUIO CABESA");
        listaDeNombres.add("MANOLIN CORTIN");
        listaDeNombres.add("PEROLO BASESIN");
        listaDeNombres.add("TIMOTEO CABEZAHUEVO");
        listaDeNombres.add("CABESTRO CABEZAHUEVO");
        listaDeNombres.add("RAQUITIN CABEZAHUEVO");
        listaDeNombres.add("RAQUITIN BONIATIN");

        long count = listaDeNombres.stream()
                .peek(it -> System.out.println(it)) // NO USAR
                .map(it ->  {return  new Usuario(it.split(" ")[0], it.split(" ")[1],null,null);})
                .count();

        System.out.println(count);
    }
}
