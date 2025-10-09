package org.alfonso.api.stream.ejemplos.borrame;

import org.alfonso.api.stream.ejemplos.borrame.mainclasses.Usuario;

import java.util.ArrayList;
import java.util.List;

public class Test16
{
    public static void main(String[] args) {
        List<Usuario> lista = new ArrayList<>();
        lista.add(new Usuario("Manolin", "Garcia", 25, "23456B"));
        lista.add(new Usuario("Vicentico", "Cabeson", 35, "34567C"));
        lista.add(new Usuario("Eustaquio", "Berbenero", 55, "45678D"));
        lista.add(new Usuario("Manolita", "Rigrofreda", 72, "56789E"));
        lista.add(new Usuario("Vicentica", "Perales", 55, "67899F"));
        lista.add(new Usuario("Perico", "Palotes", 15, "12345A"));

        long t1 = System.currentTimeMillis();

        String resultado = lista.stream().parallel()
                .map(it -> toNombreYApellido(it))
                .filter(it -> equalsPericoPalotes(it))
                .findAny().orElse(" ");

        long t2 = System.currentTimeMillis();
        System.out.println("Tiempo total: " + (t2 - t1));

        System.out.println("Resultado: " + resultado);
    }

    private static String toNombreYApellido(Usuario usuario) {
        try {
            System.out.println("map");
            Thread.sleep(1000);
            return usuario.getNombre() + " " + usuario.getApellido();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static boolean equalsPericoPalotes(String it) {
        System.out.println("equals");
        return it.equalsIgnoreCase("Perico Palotes");
    }
}
