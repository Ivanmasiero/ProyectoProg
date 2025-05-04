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
        System.out.println(users);

        //Intentamos registrar un usuario con un nombre ya existente
        usuario = new Usuario("ana26","anita@example.com", 925540955);
        if(users.containsKey(usuario.getUsername())) {
            System.out.println("El usuario "+ usuario.getUsername() +" ya está dado de alta.");
        } else {
            users.put(usuario.getUsername(),usuario);
            System.out.println("Usuario " + usuario.getUsername() + " dado de alta con éxito.");
        }

        //Comprobamos si un correo ya está registrado (con equals en Usuario).
        Usuario buscado = new Usuario("pacoimpostor","pacochulo@example.com", 696969696);
        if(users.containsValue(buscado)) {
            System.out.println("El usuario con el correo " + buscado.getEmail() + " existe. ");
        } else {
            System.out.println("El usuario con el correo " + buscado.getEmail() + " no existe. ");
        }

        //Borramos una entrada por la clave
        users.remove("mario69");
        System.out.println(users);
    }
}
