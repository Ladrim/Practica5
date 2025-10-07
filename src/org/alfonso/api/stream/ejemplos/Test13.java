package org.alfonso.api.stream.ejemplos;

import java.util.stream.Stream;

public class Test13
{
    public static void main(String[] args)
    {
        Stream.generate(() -> "BANANZA Best game ever played!!!!")
                .limit(20)
                .forEach(it -> System.out.println(it));
    }
}
