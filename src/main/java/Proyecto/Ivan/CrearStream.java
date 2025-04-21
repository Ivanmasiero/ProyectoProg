package Proyecto.Ivan;
/*
Los streams son objetos que implementan la interfaz Stream, no hay clase Stream por lo tanto no hay constructor.
Trabajaremos con ellos a partir de operaciones intermedias o finales.
Una vez se haga un operacion final en un stream ya no pueden hacer mas operaciones
Una vez echa una operacion de un stream a -> a uno b, ya no se podrá volver hacer operaciones sobre el stream a
Se han diseñado para trabajar con expresiones lamda.
 */

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class CrearStream {
    public static void main(String[] args) {
        //Diferentes formas de crear un Stream:

        //A partir de un coleccion llamando al metodo Stream
        //Creamos ----> S1 (lista <String> de nombres)
        List <String> listaNombres= Arrays.asList("Pablo","Israel","Pepe","Manolo");
        Stream <String> s1=listaNombres.stream(); //Conseguimos una copia de los datos, no una referencia a los originales

        //A partir de una tabla (array)
        //Creamos ----> S2 (array de numeros)
        Integer []arrayNumeros={1,2,3,4,5,6};
        Stream<Integer>s2=Stream.of(arrayNumeros);

        //ahora utilizando el método stream de la clase Arrays
        //Creamos ----> S3 (array de numeros)
        Stream <Integer> s3=Arrays.stream(arrayNumeros);

        //Inicilizandolo a traves del método stream.of
        //Creamos ----> S4 (lista <String> de saludos)
        Stream <String> s4=Stream.of("hola","adios","hasta luego");

        //Ahora veremos que podemos hacer:
        //En primer lugar podemos filtrar(operación intermedia) a través de un predicado, en caso de devolver true formarán parte
        //del nuevo stream
        //Deberemos devolver un boolean
        //Creamos ----> TerminaPorO (Un filtrado de terminados en o)
        Predicate<String> terminaPorO=s -> s.endsWith("o");

        //y ahora se lo podemos pasar a un Stream
        Stream <String> s5=listaNombres.stream()
                                        .filter(terminaPorO);

        // o podemos pasarlo como argumento directamente a través de un expresión lambda
        //Creamos ----> S6 (Usa el s4, stream de saludos, y lo filtra solo terminados en o)
        Stream<String>s6=s4.filter(s->s.endsWith("o"));

        // o podemos hacerlo promocionando una collection a stream
        //Creamos ----> S7 (listaNombres con un filtrado de solo terminados en o)
        Stream<String>s7=listaNombres.stream()
                                    .filter(s -> s.endsWith("o"));

        //para poder ver los resultados por pantalla necesiteremos mostrar cada uno de los elementos a traves de
        //un forEach (operación Final)
        //el cual nos pedirá un Consumer, que vamos a crear
        //Creamos ----> muestra (Un consumer, que no es mas que una función que se le aplicará a cada elemento de la lista)
        Consumer<String>muestra=s -> System.out.println(s);
        System.out.println("Nombres que teminan por o");
        s7.forEach(muestra);

        //o sin tener que crear explicitamente el Consumer
        //s7.forEach(s->System.out.println(s));

        //o podemos hacerlo a través de un método de referencia
        //s7.forEach(System.out::println);

        //AVISO IMPORTANTE:
        //Los streams no son reusables, al utilizar el for each en s7 ya no se puede hacer otro filtrado ya que el
        //forEach es una operación final.

        //Stream <String> s8= s7.filter(s->s.startsWith("m"));  <<<<- ESTO DA ERROR

        //Pero puedo aplicar varios filtrados sin que de error, por que son operaciones intermedias
        //Creamos ----> S8 (usa la lista de nombres y la filtra por terminados en o)
        Stream<String>s8=listaNombres.stream()
                                    .filter(s -> s.endsWith("o"));
        //Creamos ----> S9 (usa s8 y los filtra por empezados en M)
        Stream<String>s9=s8.filter(s -> s.startsWith("M"));

        // Stream<String>s10=s8.filter(s -> s.startsWith("a"));

        System.out.println("\nNombres terminan por o y que empiezan por M");
        s9.forEach(System.out::println); //<<<<- Terminamos con el forEach para mostrarlo por pantalla

        //Hacer varios filtrados creando varios Streams con una variable diferente no es eficiente para ello veremos
        //las tuberías

    }
}
