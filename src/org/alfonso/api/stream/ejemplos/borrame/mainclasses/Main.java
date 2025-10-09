package org.alfonso.api.stream.ejemplos.borrame.mainclasses;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main
{
    public static void main(String[] args)
    {
        List<String> listaDeNombres = new ArrayList<>();
        listaDeNombres.add("PAQUITO MASITO");
        listaDeNombres.add("TOMASO PERALES");
        listaDeNombres.add("TOMASA TRICOLA");
        listaDeNombres.add("MELONCIO CABRERAS");
        listaDeNombres.add("EUSTAQUIO CABRERAS");
        listaDeNombres.add("MENTECATO PALURDO");
        listaDeNombres.add("TOMASON CABEAZON");

        Stream<Usuario> streamDeUsuarios = listaDeNombres.stream()
                .map(it ->  {return  new Usuario(it.split(" ")[0], it.split(" ")[1],13,"654321K");})
                .peek(it-> System.out.println(it));

        List<Usuario> listaDeUsuarios = streamDeUsuarios.collect(Collectors.toList());
        listaDeUsuarios.forEach(it-> System.out.println(it));
    }
}
