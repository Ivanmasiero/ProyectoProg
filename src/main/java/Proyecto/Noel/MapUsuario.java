package Proyecto.Noel;/*
Queremos almacenar cuentas de usuario con un username y la cuenta vinculada.
Obviamente los usernames no se pueden repetir.
*/

import java.util.HashMap;
import java.util.Map;

public class MapUsuario {
    public static void main(String[] args) {
        // Creamos un HashMap donde la clave es el Username
        // Y el valor es un objeto usuario (mostraremos email y teléfono)
        Map<String,Usuario> users = new HashMap<>();
        Usuario usuario;

        //Creamos varios usuarios y los registramos en el mapa
        usuario = new Usuario("ana26","ana@example.com",925525060);
        users.put(usuario.getUsername(),usuario);

        usuario = new Usuario("paco","pacoxulo@example.com",925245744);
        users.put(usuario.getUsername(),usuario);

        usuario = new Usuario("mario69","mariobros@example.com",925232081);
        users.put(usuario.getUsername(),usuario);

        System.out.println("\nImprimimos todos los usuarios:\n"+ users + "\n\n");

        //Intentamos registrar un usuario con un nombre ya existente
        usuario = new Usuario("ana26","anita@example.com", 925540955);

        System.out.println("Intentamos añadir al usuario con el username " + usuario.getUsername() + ":");
        if(users.containsKey(usuario.getUsername()))
            System.out.println("El usuario "+ usuario.getUsername() +" ya está dado de alta.\n\n");
        else {
            users.put(usuario.getUsername(),usuario);
            System.out.println("Usuario " + usuario.getUsername() + " dado de alta con éxito.\n\n");
        }

        //Comprobamos si un correo ya está registrado (con equals en Usuario).
        Usuario buscado = new Usuario("pacoimpostor","pacochulo@example.com", 696969696);
        System.out.println("Buscamos si existe el email de " + buscado.getEmail() + ":");

        if(users.containsValue(buscado))
            System.out.println("El usuario con el correo " + buscado.getEmail() + " existe.\n\n");
        else
            System.out.println("El usuario con el correo " + buscado.getEmail() + " no existe.\n\n");

        //Borramos una entrada por la clave
        users.remove("mario69");
        System.out.println("Tras borrar a mario, imprimimos usuarios:\n" + users + "\n\n");
    }
}
