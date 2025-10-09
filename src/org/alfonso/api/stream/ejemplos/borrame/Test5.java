package org.alfonso.api.stream.ejemplos.borrame;

import org.alfonso.api.stream.ejemplos.borrame.mainclasses.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test5
{
    public static void main(String[] args)
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

        Stream<Usuario> streamDeUsuarios = listaDeNombres.stream()
                .map(nombre ->  {return  new Usuario(nombre.split(" ")[0], nombre.split(" ")[1],null,null);})
                .filter(it-> it.getNombre().equals("EUSTAQUIO"))
                .peek(it-> System.out.println(it));

        List<Usuario> listaDeUsuarios = streamDeUsuarios.collect(Collectors.toList());
        listaDeUsuarios.forEach(it-> System.out.println(it.getApellido()));
    }
}
