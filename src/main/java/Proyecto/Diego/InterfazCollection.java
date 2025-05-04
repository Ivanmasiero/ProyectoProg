package Proyecto.Diego;

import java.util.ArrayList;
import java.util.Iterator;

public class InterfazCollection {
    public static void main(String[] args) {
        //Creo un ArrayList de tipo String.
        ArrayList<String> coleccion = new ArrayList<>();
        //Uso el metodo .add para añadir los elementos que quiero a la colección7
        coleccion.add("Ejemplo 1");
        coleccion.add("Ejemplo 2");
        coleccion.add("Ejemplo 3");
        //Mostramos la colección para ver los elementos que hemos añadido
        System.out.println("La colección tiene estos elementos:");
        coleccion.forEach(System.out::println);
        //Vamos a usar el metodo .size para comprobar el tamaño de la colección
        System.out.println("\nEl tamaño de la colección en este momento es: " + coleccion.size());
        //Vamos a usar el metodo .contains para ver si la colección contiene ese elemento en específico
        System.out.println("\n¿La colección contiene el ejemplo 1? " + coleccion.contains("Ejemplo 1"));
        //Vamos a usar el metodo .remove para quitar un elemento específico
        coleccion.remove("Ejemplo 1");
        System.out.println("\nDespués de eliminar el ejemplo 1 la colección contiene: " + coleccion);
        //También tenemos que ver que es un Iterator, este tiene que ser del mismo tipo que la colección.
        //Sirven para recorrer la colección.
        System.out.println("\nVamos a crear el iterator y a usarlo: ");
        Iterator<String> hola = coleccion.iterator();
        //El metodo .hasNext comprueba si hay elemento siguiente, no hace falta poner el aumento en el for,
        // ya que next lo hace automáticamente
        for (;hola.hasNext();) {
            //Ahora usamos el metodo .next para que avance y nos devuelva cada elemento de la colección,
            //El iterator hace referencia al primer elemento por lo que al usar el next empezara en el segundo elemento
            String p= hola.next();
            System.out.println(p);
        }
        //Vamos a crear otra colección del mismo tipo para explicar los métodos que faltan.
        ArrayList<String> coleccion2 = new ArrayList<>();
        //Añadimos nuevos elementos a esta colección.
        coleccion2.add("Ejemplo 4");
        coleccion2.add("Ejemplo 5");
        coleccion2.add("Ejemplo 6");
        System.out.println("\nLa colección2 contiene: "+coleccion2);
        //En este caso usaremos el metodo constainsAll que lo que hace es que si todos los elementos de la
        //segunda colección están en la primera devolverá true, si no es asi devuelve false.
        System.out.println("\nLa colección2 tiene los mismos elementos que colección: "+coleccion.containsAll(coleccion2));
        //Ahora usaremos el metodo adAll que añade a la colección que hace la llamada todos los elementos
        //de la colección a la que llama.
        coleccion.addAll(coleccion2);
        System.out.println("\nLa colección ahora tiene estos elementos: "+coleccion);
        //El próximo metodo es el removeAll que elimina de la colección que hace la llamada los elementos
        //que están en la colección que has llamado.
        coleccion.removeAll(coleccion2);
        System.out.println("\nDespués de hacer el borrado la colección contiene: "+coleccion);
        //Otro metodo es el retainAll el cual elimina todos los elementos de la colección que hace la llamada
        //excepto los que coincidan con los elementos que están en la colección llamada.
        coleccion.retainAll(coleccion2);
        System.out.println("\nLa colección ahora contiene: "+coleccion);
        //Usamos el metodo .clear con la colección2 para quitar todos los elementos de la colección.
        coleccion2.clear();
        System.out.println("\nDespués de usar clear la colección2 contiene: "+coleccion2);
        //Por último vamos a comprobar con .isEmpty si la colección esta vacía.
        System.out.println("\n¿La colección2 está vacía? "+coleccion2.isEmpty());
    }
}
