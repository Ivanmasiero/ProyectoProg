package Proyecto.Unai;

import java.util.*;


public class MetodosList {
    public static void main(String[] args) {
        List<String> frutas = new ArrayList<>();

        //Usamos el método add para añadir elementos
        frutas.add("Manzana");
        frutas.add("Platano");
        frutas.add("Kiwi");
        System.out.println("frutas: " + frutas);

        //También podemos añadir en posiciones concretas de la lista
        frutas.add(1, "Mandarina");
        System.out.println("\nAdd 'Mandarina' en posición 1: " + frutas);

        //Si descomentas da error, está fuera de rango
        //frutas.add(-1,"Melocotón");
        frutas.add(3,"Melocotón");
        System.out.println("\nAdd 'Melocotón' en posición 3 = " + frutas);

        System.out.println("\nfrutas.get(1) = " + frutas.get(1));


        //Copia que usaremos más adelante con las sublistas
        List<String> frutas2 = new ArrayList<>(frutas);
        //Si descomentamos esta línea dará error más adelante porque no crea realmente una copia
        //solo hace que la lista frutas2 apunte al mismo sitio que frutas, asi que todos los cambios
        //que hagamos en frutas también se verán en frutas2.
        //List<String> frutas2 = frutas;


        //Cambiar el objeto de una posición con set
        frutas.set(0,"Albaricoque");
        System.out.println("\nfrutas : " + frutas);

        //Eliminar por índice
        frutas.remove(2);
        System.out.println("\n\nDespués de remove posición 2: " + frutas);
        frutas.remove("Mandarina");
        //Este no funciona, sensible a mayúsculas
        //frutas.remove("mandarina");
        System.out.println("\nDespués de remove \"Mandarina\": " + frutas);

        System.out.println("¿Contiene 'Mandarina'? " + frutas.contains("Mandarina"));

        //Podemos buscar el índice de un objeto de la lista
        System.out.println("\n\nPosición de Kiwi: " + frutas.indexOf("Kiwi"));
        //¡CUIDADO! Solo nos dice el índice de la primera vez que aparece el objeto de
        frutas.add("Kiwi");
        System.out.println(frutas);
        System.out.println("\nPrimera posición de Kiwi: " + frutas.indexOf("Kiwi"));

        //Si queremos saber la última posición donde aparece usamos lastIndexOf()
        System.out.println("Ultima posición de Kiwi: " + frutas.lastIndexOf("Kiwi"));

        //Tanto indexOf() como lastIndexOf() devuelven -1 si no está el objeto en la lista

        //Podemos comprobar si la lista está vacía o no
        System.out.print("\n\nAntes del clear: ");
        System.out.println(frutas.isEmpty()?"La lista está vacía":"La lista tiene elementos");


        //También podemos vaciar la lista
        System.out.print("Después del clear: ");
        frutas.clear();
        System.out.println(frutas.isEmpty()?"La lista está vacía":"La lista tiene elementos");


        //List.of no es un método de la interfaz List, si no de la clase List en java.util.List
        //Pero es útil para llenar listas rápido. HAY QUE TENER EN CUENTA QUE LAS LISTAS CREADAS CON
        //List.of SON INMUTABLES
        List<Character> letras = List.of('a', 'b', 'c', 'a', 'd', 'a');
        //Si descomentas esto da error
        //letras.clear();

        //Así podemos comprobar el tamaño de las listas
        System.out.println("\nTamaño de la lista 'letras' "+letras.size());

        //Podemos devolver un objeto Iterator para recorrer los elementos de la lista y así
        //aprovechar los métodos de Iterator, pero con este Iterator SOLO podemos ir hacia delante.
        Iterator <Character> it=letras.iterator();
        System.out.println("\n\nRecorriendo la lista con Iterator: ");
        while(it.hasNext())
            System.out.print(it.next());

        //Hay un iterador pensado para listas que extiende a Iterator y nos permite recorrerlo
        //en las dos direcciones
        ListIterator <Character> lit = letras.listIterator();
        System.out.println("\n\n\nRecorriendo la lista con ListIterator hacia delante: ");
        while (lit.hasNext())
            System.out.print(lit.next());
        System.out.println("\nRecorriendo la lista con ListIterator hacia atrás: ");
        while (lit.hasPrevious())
            System.out.print(lit.previous());
        System.out.println();

        //Podemos usar el método forEach de Iterable con las listas
        System.out.println("\n\nImprimiendo contenido de la lista con forEach: ");
        letras.forEach(System.out::print);

        //Podemos crear sublistas a partir de otra indicando las posiciones de la lista padre
        //en las que empieza y acaba la sublista
        List<Character> letritas =letras.subList(3,5);
        System.out.println("\n\nSublista letritas = " + letritas);


        //También podemos usar sublistas como un rango
        System.out.println("\n\nAntes del clear con sublist: "+frutas2);
        frutas2.subList(1,3).clear();
        System.out.println("Después del clear con sublist: "+frutas2);

        //Podemos convertir una lista en array y usar metodos de la clase Arrays con ellos
        System.out.println("\n\nClase usando toArray sin tipo: "+letras.toArray().getClass());
        System.out.println("Array de Objects: "+Arrays.toString(letras.toArray()));


        //Si no especificamos el tipo del array, nos devuelve un array de Objects
        Character [] array=letras.toArray(new Character[letras.size()]);
        System.out.println("\n\nClase usando toArray con tipo Character"+array.getClass());
        System.out.println("Array de Character: "+Arrays.toString(array));

    }
}
