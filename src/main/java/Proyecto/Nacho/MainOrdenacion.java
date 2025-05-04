package Proyecto.Nacho;

import java.util.*;

public class MainOrdenacion {
    public static void main(String[] args) {
        List<Cliente> lista = new ArrayList<>();
        lista.add(new Cliente("111", "Marta", "12/02/2000"));
        lista.add(new Cliente("115", "Jorge", "16/03/1999"));
        lista.add(new Cliente("112", "Carlos", "01/10/2002"));

        System.out.println("Original:");
        lista.forEach(System.out::println);

        Collections.sort(lista);
        System.out.println("\nOrden natural (por DNI):");
        lista.forEach(System.out::println);

        Collections.sort(lista, new ComparaNombres());
        System.out.println("\nOrden por nombre:");
        lista.forEach(System.out::println);
    }
}
