package org.alfonso.api.stream.ejemplos;

import org.alfonso.api.stream.ejemplos.mainclasses.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Test11
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

        Stream<Usuario> streamDeUsuarios = listaDeNombres.stream()
                .map(nombre ->  {return  new Usuario(nombre.split(" ")[0], nombre.split(" ")[1],null,null);})
                .flatMap(it -> getUsuarioStream(it));

        streamDeUsuarios.forEach(it-> System.out.println());
    }

    private static Stream<Usuario> getUsuarioStream(Usuario it)
    {
        if (it.getNombre().equalsIgnoreCase("EUSTAQUIO"))
            return Stream.of(it);
        else
            return Stream.empty();
    }
}
