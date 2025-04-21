package Proyecto.Sula;

import java.util.*;

public class Punto_12_4 {
    public static void main(String[] args) {
        // 12.4 INTERFAZ SET
        /* Conjunto de datos que elimina las repeticiones "sin un orden preestablecido".
         *  Todos los métodos los hereda de Collection, lo único que añade es la restricción
         *  de no permitir duplicados.
         *  Si intentamos insertar un elemento ya existente no lo hará, simplemente devolverá false.*/

        Set<Integer> hs= new HashSet<>(); // HashSet-> tiene buen rendimiento, pero no garantiza ningún orden en la inserción.

        Set<Integer> ts= new TreeSet<>(); // TreeSet-> peor rendimiento, ordena según valor, el criterio de ordenación es el proporcionado por el compareTo.

        Set<Integer> lhs= new LinkedHashSet<>(); // LinkedHashSet-> inserta los elementos al final, garantiza orden basado en la inserción

        List<Set<Integer>> lista=Arrays.asList(hs,ts,lhs);
        lista.forEach(Punto_12_4::agregaNumeros);
        lista.forEach(s -> System.out.println(s+" "+ s.getClass()));

    }

    private static void agregaNumeros(Set<Integer> s){
        s.add(60);
        s.add(20);
        s.add(7);
        s.add(2);
    }
}
