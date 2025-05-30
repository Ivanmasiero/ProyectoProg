package Proyecto.Adri;
import java.util.*;
public class TiposDeColecciones {

    public static void main(String[] args) {
        /*Las colecciones son usadas como remplazo de las tablas(arrays),
         * Se utilizan las colecciones, ya que estas son dinamicas al contrario de los arrays
         * lo que lo hace más flexible*/
        //Aquí os muestro los 3 tipos fundamentales de colecciones
        //List: Este permite duplicados, y ordenada
        //Set: Sin duplicados y sin orden
        //Map: Aunque este no hereda de collection es muy importante, contiene una clave

        List<String> frutas = new ArrayList<>();
        frutas.add("Manzana");
        frutas.add("Platano");
        frutas.add("Manzana"); // Se permite repetir
        System.out.println("Salida Coleccion tipo List:  " +frutas);

        Set<String> colores = new HashSet<>();
        colores.add("Rojo");
        colores.add("Azul");
        colores.add("Rojo"); // Como vemos el propio intellij detecta que están duplicados.

        System.out.println("Salida Coleccion tipo Set:  " +colores); // [Rojo, Azul] (el orden puede variar)

        Map<Integer, String> personas = new HashMap<>();
        personas.put(1, "Ana");
        personas.put(2, "Luis");
        personas.put(1, "María"); // Remplaza "Ana" porque la clave 1 ya existe

        System.out.println("Salida Coleccion tipo Map:  " +personas); // {1=María, 2=Luis}

    }
}
