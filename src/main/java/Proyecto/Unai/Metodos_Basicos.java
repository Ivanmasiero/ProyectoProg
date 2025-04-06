package Proyecto.Unai;

import java.util.ArrayList;
import java.util.List;

public class Metodos_Basicos {
    public static void main(String[] args) {
        List<String> frutas = new ArrayList<>();

        //add para añadir elementos
        frutas.add("Manzana");
        frutas.add("Platano");
        frutas.add("Kiwi");
        System.out.println("frutas = " + frutas);

        frutas.add(1, "Mandarina");
        System.out.println("Add en posición 1: " + frutas);

        //Si descomentas da error, está fuera de rango
        //frutas.add(-1,"Melocotón");
        frutas.add(3,"Melocotón");
        System.out.println("Add en 3 = " + frutas);

        System.out.println("frutas.get(1) = " + frutas.get(1));

        //Cambiar el objeto de una posición con set
        frutas.set(0,"Albaricoque");
        System.out.println("frutas = " + frutas);

        //Eliminar por índice
        frutas.remove(2);
        System.out.println("Después de remove 2: " + frutas);
        frutas.remove("Mandarina");
        //Este no funciona, sensible a mayúsculas
        //frutas.remove("mandarina");
        System.out.println("Después de remove \"Mandarina\": " + frutas);

        System.out.println("¿Contiene 'Mandarina'? " + frutas.contains("Mandarina"));

        // indexOf(Object o) - Índice de la primera aparición
        // lastIndexOf(Object o) - Índice de la última aparición
        // isEmpty() - ¿Está vacía?
        // size() - Tamaño de la lista
        // iterator() - Recorrer usando Iterator
        // listIterator() - Recorrer con ListIterator
        // forEach() - Recorrer con forEach (Java 8+)
        // subList() - Obtener sublista
        // toArray() - Convertir a array
        // toArray(T[] a) - Convertir a array de tipo específico
        // clear() - Vaciar la lista




    }
}
