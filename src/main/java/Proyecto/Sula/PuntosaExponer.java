package Proyecto.Sula;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class PuntosaExponer {
    public static void main(String[] args) {
        // 12.4 INTERFAZ SET
        /* Conjunto de datos que elimina las repeticiones "sin un orden preestablecido".
         *  Todos los métodos los hereda de Collection, lo único que añade es la restricción
         *  de no permitir duplicados.
         *  Si intentamos insertar un elemento ya existente no lo hará, simplemente devolverá false.*/

        Set<Integer> hs= new HashSet<>(); // HashSet-> tiene buen rendimiento, pero no garantiza ningún orden en la inserción.

        Set<Integer> ts= new TreeSet<>(); // TreeSet-> peor rendimiento, ordena según valor, el criterio de ordenación es el proporcionado por el compareTo.

        Set<Integer> lhs= new LinkedHashSet<>(); // LinkedHashSet-> inserta los elementos al final, garantiza orden basado en la inserción

        añadeNumeros(hs);
        añadeNumeros(ts);
        añadeNumeros(lhs);

    }

    private static void añadeNumeros(Set<Integer> s){
        s.add(60);
        s.add(20);
        s.add(7);
        s.add(2);
        System.out.println(s);
    };
}
