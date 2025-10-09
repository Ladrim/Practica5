package org.alfonso.api.stream.ejemplos;

import org.alfonso.api.stream.ejemplos.mainclasses.Usuario;

import java.util.ArrayList;
import java.util.List;

public class Test10
{
    public static void main(String[] args) throws Exception
    {
        List<String> listaDeNombres = new ArrayList<>();
        listaDeNombres.add("TOMASITO PERALES");
        listaDeNombres.add("MELONCIO LIMONES");
        listaDeNombres.add("EUSTAQUIO MENTECATO");
        listaDeNombres.add("EUSTAQUIO MACUTO");
        listaDeNombres.add("BURRACO CENUTRIO");

        Usuario usuario = listaDeNombres.stream()
                .map(it ->  {return  new Usuario(it.split(" ")[0], it.split(" ")[1],null,null);})
                .filter(it-> it.getId().equals(1))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("ERROR"));

        System.out.println(usuario);
    }
}
