package org.alfonso.api.stream.ejemplos;

import org.alfonso.api.stream.ejemplos.mainclasses.Usuario;

import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.IntStream;

public class Test3
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

        IntStream  largoNombres = listaDeNombres.stream()
                .map(it -> new Usuario(it.split(" ")[0], it.split(" ")[1],null,null) )
                .distinct()
                .mapToInt(it -> it.getNombre().length()+it.getApellido().length())
                .peek(it -> System.out.println(it));

        IntSummaryStatistics stats = largoNombres.summaryStatistics();
        System.out.println("Total " + stats.getSum());
        System.out.println("Average " + stats.getAverage());
        System.out.println("Max " + stats.getMax());
        System.out.println("Min " + stats.getMin());
    }
}
