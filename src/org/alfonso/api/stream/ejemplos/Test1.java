package org.alfonso.api.stream.ejemplos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Test1
{
    public static void main(String[] args)
    {
        List<String> test = new ArrayList<>();
        test.add("Vicentin");
        test.add("Periquin");
        test.add("Camelas");
        test.add("Periquin");

        test.stream().map(String::toUpperCase);
        Stream<String>stream = test.stream();

        test.forEach(a-> System.out.println(a));
        test.stream().forEach(a-> System.out.println(a));

        Stream<String> nombres = Stream.of("Vicentico", "Moniato", "Camelas", "Bleras");
        nombres.forEach(e -> System.out.println(e));

        String[] array = {"Manolin", "Eustaquio", "Marcelo", "Benito"};
        Stream<String> nombres2 = Arrays.stream(array);
        nombres2.forEach(e -> System.out.println(e));

        Arrays.stream(array).forEach(a-> System.out.println(a));

        Stream<String> nombres3 = Stream.<String>builder().add("Eustaquio").add("Meloncio").add("Moniato").add("Camelas").build();
        nombres3.forEach(a-> System.out.println(a));
    }
}
