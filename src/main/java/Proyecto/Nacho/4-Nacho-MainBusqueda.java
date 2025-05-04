package Proyecto.Nacho;

import java.util.*;

public class MainBusqueda {
    public static void main(String[] args) {
        List<Cliente> lista = new ArrayList<>();
        lista.add(new Cliente("111", "Marta", "12/02/2000"));
        lista.add(new Cliente("115", "Jorge", "16/03/1999"));
        lista.add(new Cliente("112", "Carlos", "01/10/2002"));

        Collections.sort(lista); // orden natural por DNI

        int indice = Collections.binarySearch(lista, new Cliente("112"));
        System.out.println("Índice de Carlos por DNI: " + indice);

        Collections.sort(lista, new ComparaNombres());
        indice = Collections.binarySearch(lista, new Cliente(null, "Carlos", null), new ComparaNombres());
        System.out.println("Índice de Carlos por nombre: " + indice);

        Cliente nuevo = new Cliente("555", "Eva", "21/09/2003");
        indice = Collections.binarySearch(lista, nuevo);
        if (indice < 0) {
            lista.add(-indice - 1, nuevo);
        }
        System.out.println("\nLista tras añadir a Eva:");
        lista.forEach(System.out::println);
    }
}
