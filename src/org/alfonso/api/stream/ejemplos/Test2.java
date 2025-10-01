package org.alfonso.api.stream.ejemplos;

import org.alfonso.api.stream.ejemplos.mainclasses.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Test2
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

        Stream<Usuario> usuarioOptional = listaDeNombres.stream()
                .map(it -> new Usuario(it.split(" ")[0], it.split(" ")[1],null,null) )
                .distinct();

        usuarioOptional.forEach(it -> System.out.println(it));
    }
}
