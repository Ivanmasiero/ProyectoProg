package Proyecto.Ivan;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

/*
Vamos a ver el uso de las tuberías, que es una forma mucho mas eficiente de usar la interfaz stream para poder manipular
colecciones
 */

public class Tuberias {
    public static void main(String[] args) {
        //Creamos una lista con nombres
        List<String> nombres= Arrays.asList("Mateo","Juan","Lucas","Pedro","Marta");
        //A través de stream aplicamos dos filtrados y después hacemos un forEach
        System.out.println("Nombres empezado en M y teminado en a");
        nombres.stream()
                .filter(s -> s.startsWith("M"))
                .filter(s -> s.endsWith("a"))
                .forEach(System.out::println);
        //Ponemos cada operación en una línea diferente para que se pueda leer mejor

        //Ahora vamos a ordenar, la función sorted los ordena por su orden natural. En caso de que nuestra clase no
        //implemente Comparable, tendremos que implementar el método de ordenación inline a través de un expresión lambda
        //o si queremos ordenarlos por otro orden que no sea el natural, con un comparator o inline, como nosotros queramos.
        System.out.println("\nNombres ordenados alfabeticamente");
        nombres.stream().
                sorted().
                forEach(System.out::println);


        //Creamos una lista de peliculas para hacer diferentes operaciones con ella
        List <Pelicula> peliculas=Arrays.asList(new Pelicula("El resplandor",1980,"Stanley kubrik"),
                new Pelicula("Pulp fiction",1994,"Quentin Tarantino"),
                new Pelicula("Vertigo",1958,"Alfred Hitchcock"),
                new Pelicula("Mulholland drive",2001,"David Lynch"),
                new Pelicula("Que bello es vivir",1946,"Frank Capra"),
                new Pelicula("Ciudadano Kane",1941,"Orson Walles"),
                new Pelicula("Taxi Driver",1976,"Martin Scorsese"),
                new Pelicula("Vestida para matar",1980,"Brian de Palma"));

        //Podemos solo quedarnos con el dato que queramos de cada pelicula como por ejemplo su director, a traves de la
        //interfaz map creando una Function
        //Function<Pelicula, String> director=d -> d.getDirector();
        //peliculas.stream().map(director).forEach(System.out::println);

        //O lo podemos hacer inline si tener que crear la variable director
        System.out.println("\nDirectores de peliculas:");
        peliculas.stream().
                map(Pelicula::getDirector).
                forEach(System.out::println);
        //Podemos ver que peliculas hay a partir de 1980
        System.out.println("\nPeliculas a partir de 1980 y ordenadas");
        peliculas.stream().
                filter(p->p.getAño()>=1980).
                sorted((a,b)->a.getAño()- b.getAño()).
                forEach(System.out::println);

        //Ahora vamos a ver cuantas peliculas hay en el año 1980 a traves de la funcion count, que devuelve un long
        //long num=peliculas.stream().filter(p->p.getAño()==1980).count();
        //System.out.println(num);
        //o directamente haciendo el sout del stream
        System.out.println("\n¿Cuántas peliculas son de 1980?");
        System.out.println(peliculas.stream()
                .filter(p->p.getAño()==1980)
                .count());
        //Promedio de año a traves de la funcion averag, tambien utilizamos getAsDouble para que nos lo convierta a double
        System.out.println("\nEl año promedio es: "+ peliculas.stream()
                .mapToInt(Pelicula::getAño)
                .average()
                .getAsDouble());

        //Podemos concatenar Streams a través del metodo estatico concat de Stream
        //creamos 2 streams con diferentes datos
        Stream <Integer>s1=Arrays.asList(1,2,3).stream();
        Stream <Integer>s2=Arrays.asList(4,5,6).stream();
        System.out.println("\nStreams concatenados");
        //Los concatenamos
        Stream.concat(s1,s2).forEach(System.out::println);

        //Podemos crear un array a partir de un stream utilizando la funcion toArray, en este caso filtrando solo
        //los numeros pares
        Integer[] nums=Arrays.asList(1,2,3,4,5,6,7,8).
                stream().
                filter(n->n%2==0).
                toArray(Integer[]::new);
        System.out.println("\nArray de numeros pares\n"+Arrays.deepToString(nums));

        //FUNCION COLLECT!!!!

        //Podemos hacer una lista de un stream, en este caso filtrando los mayores de 5. Gracias a la funcion collect
        //utilizamos la funcion estatica toList de la clase Collectors
        List <Integer> listaMayor5=Arrays.asList(1,6,2,19,2,4,3,20,21).stream().
                filter(i->i>5).
                collect(Collectors.toList());
        System.out.println("\nLista de numero mayores a 5");
        listaMayor5.forEach(System.out::println);

        //Tambien se podria con un conjunto aplicando toSet para eliminar automaticamente los repetidos
        //importamos la clase Collectors de forma "estatica" para no tener que ponerla cada vez que queramos un
        // metodo estatico suyo
        Set<Integer> conjuntoMayor5=Arrays.asList(10,7,8,2,6,6,6,3,1,7,5,9,10,10,10).
                stream().
                filter(i->i>5).
                collect(toSet());
        System.out.println("\nConjunto de numeros mayores a 5");
        conjuntoMayor5.forEach(System.out::println);

        //Podemos obtener dos atributos de nuestra clase para tener clave valor de cada objeto de una lista a traves de map
        Map<String,Integer>mapPeliculaAño=peliculas.stream().
                                            collect(toMap(Pelicula::getNombre,Pelicula::getAño));
        System.out.println("\nMap de pelicula-año:\n"+mapPeliculaAño);

        //A partir de aqui lo vamos hacer dentro de un sout para no tener que crear variables!!!

        //Podemos calcular diversos parametros estadisticos a la vez a traves de summarizingInt
        System.out.println(peliculas.stream().
                                    collect(summarizingInt(Pelicula::getAño)));
        //Podemos concatenar elementos de un stream de cadenas eligiendo un separador con la funcion joining
        System.out.println("\nlista de nombres de peliculas separadas por coma");
        System.out.println(peliculas.stream()
                .map(Pelicula::getNombre)
                .collect(joining(", ")));
        //Podemos poner un prefijo y un sufijo
        System.out.println("\n"+peliculas.stream()
                .map(Pelicula::getDirector)
                .collect(joining(", ","Nombres de directores -> ", ".")));
    }
}
