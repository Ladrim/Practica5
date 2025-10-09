package org.alfonso.api.stream.ejemplos;

import org.alfonso.api.stream.ejemplos.mainclasses.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Test14
{
    public static void main(String[] args)
    {
        List<Usuario> lista = new ArrayList<>();
        lista.add(new Usuario("Bartolo","Palotes",20,"32645A"));
        lista.add(new Usuario("Palurdo","Garcia",31,"83456C"));
        lista.add(new Usuario("Vicentin","Cabeson",23,"34669F"));
        lista.add(new Usuario("Baturro","Berbenero",53,"46698A"));
        lista.add(new Usuario("Donkey Kong","Bananza", 73,"56771A"));
        lista.add(new Usuario("Vicentin","Paletin", 34,"78391D"));

        Stream<String> streamDeUsuarios = lista.stream()
                .map(it -> it.getNombre() + " " + it.getApellido())
                .filter(it -> it.equalsIgnoreCase("Donkey Kong Bananza"));

        streamDeUsuarios.forEach(it -> System.out.println(it));
    }
}
