package Proyecto.Nacho;

import java.util.*;

public class MainUtilidades_6 {
    public static void main(String[] args) {
        List<Integer> datos = new ArrayList<>(Arrays.asList(1, 2, 3, 1, 7, 7));

        Collections.shuffle(datos);
        System.out.println("Desordenado: " + datos);

        System.out.println("Frecuencia del 7: " + Collections.frequency(datos, 7));
        System.out.println("Máximo (natural): " + Collections.max(datos));
        System.out.println("Mínimo (natural): " + Collections.min(datos));

        Collections.reverse(datos);
        System.out.println("Reverso: " + datos);

        datos.removeAll(Collections.singleton(7));
        System.out.println("Eliminar 7 con singleton: " + datos);
    }
}
