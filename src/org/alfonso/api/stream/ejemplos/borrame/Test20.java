package org.alfonso.api.stream.ejemplos.borrame;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test20
{
    public static void main(String[] args)
    {
        List<String> nombres = new ArrayList<>();
        nombres.add("Trolero");
        nombres.add("Donkey Kong");
        nombres.add("Calculin");
        nombres.add("Peponcio");
        nombres.add("Regulin");
        nombres.add("Tomasito");
        nombres.add("Vicentico");
        nombres.add("Ridiculin");

        for(String nombre : nombres)
        {
            System.out.println(nombre);
        }
        System.out.println();

        nombres.forEach(nombre-> System.out.println(nombre + "\n"));

        Stream<String> stream = nombres.stream()
                .map(it -> it.toUpperCase())
                .map(it -> it.replace("e","i"))
                .peek(it -> System.out.println(it));


        List<String> nombresToUpperCase = stream.collect(Collectors.toList());

        nombresToUpperCase.forEach(nombre-> System.out.println(nombre + "\n") );


        List<String> streamToUpperCase2 = nombres.stream()
                .map(it -> it.toUpperCase())
                .map(it -> it.replace("e","i"))
                .peek(it -> System.out.println(it)).collect(Collectors.toList());
    }

    private static void printList(List<String>list)
    {
        list.forEach(it -> System.out.println(it));
    }
}
