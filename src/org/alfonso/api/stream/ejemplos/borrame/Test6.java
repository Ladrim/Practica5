package org.alfonso.api.stream.ejemplos.borrame;

import org.alfonso.api.stream.ejemplos.borrame.mainclasses.Usuario;

import java.util.ArrayList;
import java.util.List;

public class Test6
{
    public static void main(String[] args) throws Exception
    {
        List<String> listaDeNombres = new ArrayList<>();
        listaDeNombres.add("TOMASITO PERALES");
        listaDeNombres.add("MELONCIO LIMONES");
        listaDeNombres.add("EUSTAQUIO MENTECATO");
        listaDeNombres.add("EUSTAQUIO MACUTO");

        boolean existe = listaDeNombres.stream()
                .map(it ->  crearUsuario(it))
                .anyMatch(it -> it.getId().equals(2));

        System.out.println(existe);
    }

    private static Usuario crearUsuario(String it)
    {
        String[] valor = it.split("");
        String nombre = valor[0];
        String apellido = valor[1];
        return new Usuario(nombre, apellido, null, null);
    }
}
