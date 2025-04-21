package Proyecto.Paula;

import java.util.Comparator;

class CompararTitulo implements Comparator<Libro> {
    public int compare (Libro l1, Libro l2) {
        return l1.getTitulo().compareTo(l2.getTitulo());
    }
}
