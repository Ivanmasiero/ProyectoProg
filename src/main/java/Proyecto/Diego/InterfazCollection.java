package Proyecto.Diego;

import java.util.ArrayList;
import java.util.Iterator;

public class InterfazCollection {
    public static void main(String[] args) {
        //Creo un ArrayList de tipo String.
        ArrayList<String> coleccion = new ArrayList<>();
        //Uso el metodo .add para añadir los elementos que quiero a la colección
        coleccion.add("Ejemplo 1");
        coleccion.add("Ejemplo 2");
        coleccion.add("Ejemplo 3");
        //Mostramos la colección para ver los elementos que hemos añadido
        coleccion.forEach(System.out::println);
        //Vamos a usar el metodo .size para comprobar el tamaño de la colección
        System.out.println("El tamaño de la colección en este momento es: " + coleccion.size());
        //Vamos a usar el metodo .contains para ver si la colección contiene ese elemento en específico
        System.out.println("¿La colección contiene el ejemplo 1? " + coleccion.contains("Ejemplo 1"));
        //Vamos a usar el metodo .remove para quitar un elemento específico
        coleccion.remove("Ejemplo 1");
        System.out.println("Después de eliminar el ejemplo 1 la colección contiene: " + coleccion);
        //También tenemos que ver que es un Iterator, este tiene que ser del mismo tipo que la colección.
        //Sirven para recorrer la colección.
        System.out.println("Vamos a crear el iterator y a usarlo: ");
        Iterator<String> hola = coleccion.iterator();
        //El metodo .hasNext comprueba si hay elemento siguiente, no hace falta poner el aumento en el for,
        // ya que next lo hace automáticamente
        for (;hola.hasNext();) {
            //Ahora usamos el metodo .next para que avance y nos devuelva cada elemento de la colección,
            //El iterator hace referencia al primer elemento por lo que al usar el next empezara en el segundo elemento
            String p= hola.next();
            System.out.println(p);
        }
        //Usamos el metodo .clear para quitar todos los elementos de la colección
        coleccion.clear();
        System.out.println("Después de usar clear la colección contiene: "+coleccion);
        //Vamos a comprobar con .isEmpty si la colección esta vacía
        System.out.println("¿La coleccion está vacía? "+coleccion.isEmpty());
    }
}
