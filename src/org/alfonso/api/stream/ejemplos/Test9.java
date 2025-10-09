package org.alfonso.api.stream.ejemplos;

import org.alfonso.api.stream.ejemplos.mainclasses.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Test9
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

        Usuario tontin = new Usuario("TONTIN","MENTECATO",43,"123456789K");

        Optional<Usuario> usuarioOptional = listaDeNombres.stream()
                .map(it -> new Usuario(it.split(" ")[0], it.split(" ")[1],null,null) )
                .filter(it -> it.getNombre().equals("EUSTAQUIOX"))
                .findFirst();

        if(usuarioOptional.isPresent())
        {
            System.out.println(usuarioOptional.get().getNombre());
        }
        else System.out.println("No se encontró");

        Usuario usuario = usuarioOptional.get();
        Usuario usuario2 = usuarioOptional.orElse(new Usuario("Perico","Cabreras",67,"12345679K"));
        Usuario usuario3 = usuarioOptional.orElseThrow( () -> new RuntimeException("") );

        System.out.println(usuario);


        if(!usuarioOptional.isEmpty()) System.out.println(usuarioOptional.orElseThrow());

        System.out.println(usuarioOptional.orElseThrow(() -> new RuntimeException("Error")));
    }
}
