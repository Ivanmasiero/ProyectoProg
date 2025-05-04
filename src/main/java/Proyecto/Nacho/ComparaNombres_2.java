package Proyecto.Nacho;

import java.util.Comparator;

public class ComparaNombres_2 implements Comparator<Cliente_1> {
    @Override
    public int compare(Cliente_1 c1, Cliente_1 c2) {
        return c1.getNombre().compareTo(c2.getNombre());
    }
}
