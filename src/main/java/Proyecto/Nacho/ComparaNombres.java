package Proyecto.Nacho;

import java.util.Comparator;

public class ComparaNombres implements Comparator<Cliente> {
    @Override
    public int compare(Cliente c1, Cliente c2) {
        return c1.getNombre().compareTo(c2.getNombre());
    }
}
