package org.alfonso.api.stream.ejemplos;

import org.alfonso.api.stream.ejemplos.mainclasses.Usuario;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Test22
{
    public static void main(String[] args) {
        List<Integer> listaDeNumeros = new ArrayList<>();
        listaDeNumeros.add(32);
        listaDeNumeros.add(1);
        listaDeNumeros.add(5);
        listaDeNumeros.add(52);
        listaDeNumeros.add(56);
        listaDeNumeros.add(31);

        List<Usuario> listaDeUsuarios = new ArrayList<>();
        listaDeUsuarios.add(new Usuario("Donkey","Bananza",54,"12345A"));
        listaDeUsuarios.add(new Usuario("Pablin","Gordin",14,"23456B"));
        listaDeUsuarios.add(new Usuario("Tontin","Camelon",54,"34567C"));
        listaDeUsuarios.add(new Usuario("Eustamato","Cabesin",32,"45678D"));
        listaDeUsuarios.add(new Usuario("Bonanto","Tontin",15,"56789E"));
        listaDeUsuarios.add(new Usuario("Cenu","Cabesa",25,"67899F"));
        listaDeUsuarios.add(new Usuario("Cabesin","Cabahuevo",25,"675439F"));

        List<Integer> listaOrdenada = listaDeNumeros.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        Integer numeroMasGrande = listaDeNumeros.stream()
                .sorted()
                .findFirst().orElseThrow(() -> new RuntimeException("La lista está completamente vacía!!!!"));

        System.out.println(numeroMasGrande);

        List<Usuario> listaOrdenadaPorEdad = listaDeUsuarios.stream()
                .sorted(Comparator.comparing( it -> it.getEdad()))
                .collect(Collectors.toList());

        List<Usuario> listaOrdenadaPorEdadyDni = listaDeUsuarios.stream()
                .sorted(Comparator.comparing((Usuario it)-> it.getDni()).thenComparing((Usuario it) -> it.getDni()))
                .collect(Collectors.toCollection(() -> new ArrayList<>()));

        Usuario usuarioMasEdad = listaDeUsuarios.stream()
                .min(Comparator.comparing(Usuario::getEdad).reversed().thenComparing(Usuario::getNombre)).orElseThrow(() -> new RuntimeException("No se ha encontrado a nadie!!"));

        List<Usuario> listaPim = listaDeUsuarios.stream()
                .sorted( Comparator.comparing( it -> it.getEdad() ))
                .toList();

        List<Usuario> usuariosEncontradosMayores30 = listaDeUsuarios.stream()
                .filter(it -> it.getEdad()>30)
                .collect(Collectors.toList());

        Usuario usuarioMayor30ConDniMenor = listaDeUsuarios.stream()
                .filter(it -> it.getEdad() > 20)
                .min(Comparator.comparing(Usuario::getDni)).orElseThrow(() -> new RuntimeException("No se ha encontrado a nadie!!!!!!"));

        Usuario usuarioMayor30ConDniMenorTestOrElse = listaDeUsuarios.stream()
                .filter(it -> it.getEdad() > 20)
                .min(Comparator.comparing(Usuario::getDni)).orElse(new Usuario("test","test2",34,"12345k"));

        long cantidadDeUsuarios = listaDeUsuarios.stream()
                .count();

        long cantidadDeUsuariosMayores20 = listaDeUsuarios.stream()
                .filter(it -> it.getEdad()>20)
                .count();

        String representation = listaOrdenadaPorEdadyDni.stream()
                .map(Usuario::toString)
                .collect(Collectors.joining(""));

        System.out.println("REPRESENTATION: " + representation);

        System.out.println(listaOrdenadaPorEdadyDni);
        System.out.println(usuarioMasEdad);
        System.out.println(usuariosEncontradosMayores30);
        System.out.println(usuarioMayor30ConDniMenor);
        System.out.println("La cantidad de usuarios es de " + cantidadDeUsuarios);
        System.out.println("Cantidad de usuarios mayores de 20 años es de " + cantidadDeUsuariosMayores20);
    }
}
