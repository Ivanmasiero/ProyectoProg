package Proyecto.Adri;

import java.util.*;

public class InterfacesGenericos {
    /* Tambien existen interfaces los cuales usan tipos de datos genericos como:
    Comparable o Comparator
     */

    //Suponemos que la clase Cliente tiene datos
    public static class Cliente implements Comparable<Cliente> {
        String dni;
        String nombre;

        // Constructor que asigna los valores
        public Cliente(String nie, String nombreCliente) {
            dni = nie;
            nombre = nombreCliente;
        }

        // Orden natural por dni
        @Override
        public int compareTo(Cliente o) {
            return dni.compareTo(o.dni);
        }
    }
    //Comparator hay que usarlo fuera de la propia clase
    public void main(String[] args) {
        List<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente("123A", "Noel"));
        clientes.add(new Cliente("456B", "Pedro"));
        Collections.sort(clientes); // Se ordenan por dni automáticamente
        for (Cliente c : clientes) {
            System.out.println(c.dni + " - " + c.nombre);
        }
    }
}
