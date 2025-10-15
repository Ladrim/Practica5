package org.alfonso.api.stream.ejemplos;

import java.util.Arrays;
import java.util.List;

public class Test27
{
    public static void main(String[] args)
    {
        List<Alumno> alumnosAula1 = Arrays.asList(
                new Alumno("Pepito"),
                new Alumno("Juanito"),
                new Alumno("Pepon")
        );

        List<Alumno>alumnosAula2 = Arrays.asList(
                new Alumno("Fachito"),
                new Alumno("Santito"),
                new Alumno("Cucon"),
                new Alumno("Pepito")
        );

        Aula aula1 = new Aula(alumnosAula1);
        Aula aula2 = new Aula(alumnosAula2);

        List<Aula>aulas = Arrays.asList(aula1, aula2);

        List<List<Alumno>> listasAlumnos = aulas.stream()
                .map( it -> it.alumnos )
                .toList();

        List<Alumno> alumnos = aulas.stream()
                .flatMap( it -> it.alumnos.stream() )
                .toList();

        listasAlumnos.forEach(System.out::println);

        alumnos.forEach(System.out::println);
    }

    public static class Aula
    {
        public List<Alumno>alumnos;

        public Aula(List<Alumno> alumnos)
        {
            this.alumnos = alumnos;
        }
    }

    public static class Alumno
    {
        public String nombre;

        public Alumno(String nombre)
        {
            this.nombre = nombre;
        }

        @Override
        public String toString() {
            return nombre;
        }
    }
}
