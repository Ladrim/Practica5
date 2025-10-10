package org.alfonso.api.stream.ejemplos;

import java.util.Optional;

public class Test21
{
    public static void main(String[] args)
    {

        String resultado = formatearNombre(Optional.ofNullable(null),"Cenutrio");
        System.out.println(resultado);
    }

    public static String formatearNombre(Optional<String> nombreOptional, String apellidos)
    {
        nombreOptional
                .map( it -> it.toUpperCase())
                .map( it -> "NOMBRE: " + it );

        String apellidoModificado = apellidos.replace("e","i");

        //Uno de los 2
        String nombre = nombreOptional.orElseThrow( () -> new RuntimeException("Nombre no puede ser nullo") );

        return nombre + " " + apellidoModificado;
    }
}
