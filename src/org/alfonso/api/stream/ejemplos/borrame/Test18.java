package org.alfonso.api.stream.ejemplos.borrame;

import java.util.ArrayList;
import java.util.List;

public class Test18
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

        String resultado = listaDeNombres.stream()
                .distinct()
                .reduce("PRUEBA: ",(a,b) -> a + ", " + b);

        System.out.println(resultado);
    }
}
