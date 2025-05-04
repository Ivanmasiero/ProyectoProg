package Proyecto.Nacho;

import java.util.*;

public class MainManipulacion_5 {
    public static void main(String[] args) {
        List<Integer> datos = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println("Original: " + datos);

        Collections.swap(datos, 0, 3);
        System.out.println("Swap 0 y 3: " + datos);

        Collections.replaceAll(datos, 4, 100);
        System.out.println("Reemplazar 4 por 100: " + datos);

        Collections.fill(datos, 7);
        System.out.println("Rellenar con 7: " + datos);

        List<Integer> otrosDatos = new ArrayList<>(Arrays.asList(1, 2, 3));
        Collections.copy(datos, otrosDatos);
        System.out.println("Después de copy(): " + datos);
    }
}
