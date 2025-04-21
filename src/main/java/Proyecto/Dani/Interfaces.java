package Proyecto.Dani;

import java.util.*;
import java.util.function.*;

public class Interfaces {
    public static void main(String[] args) {
        /*
        Tenemos varias interfaces principales que es necesario conocer para aplicar los streams,
        estas interfaces hay que aprender a implementar su codigo con clases anonimas y lambdas antes de
        ponernos a trabajar con streams.
        Es importante aprender también los metodos de las colecciones.
         */

        //PREDICATE
        //El predicate devuelve un boolean sirve mucho para filtrar dentro de los streams
        //Evalua una condición sobre un valor (T) y devuelve boolean.
        List<String> palabras = new ArrayList<>(Arrays.asList("Java", "Python", "C++", "JavaScript", "Go"));
        Predicate<String> empiecenJ = (s -> s.startsWith("J"));
        palabras.removeIf(empiecenJ);
        System.out.println(palabras);
        //Lo que hacemos es creamos un predicate que se llama empiecenJ,
        //este metodo removeIf si
        //alguno de los string empiezan por J lo elimina.
        //Con la lambda nos ahorramos codigo y lo hacemos en una sola linea
        //-------------------------------------
        //Esto es implementar el predicate con una clase anonima.
        Predicate<String> porG = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.startsWith("G");
            }
        };
        palabras.removeIf(porG);
        System.out.println(palabras);


        //FUNCTION
        //Transforma un valor de entrada (T) en un resultado (R).
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4);
        Function<Integer, String> transformar = i -> {
            String valor = String.valueOf(i);
            return valor;
        };
        numeros.stream().map(transformar);
        System.out.println(numeros);

        //Creamos una function que lo que hace es transmformar los valores de i que son enteros en
        //Strings y luego usamos .stream.map(le damos la function) y convertimos numeros en una lista
        //de enteros a una lista de strings.
        //-----------------------------------
        //Esto implementa function desde una clase anonima, siempre devolvemos algo.
        Function<Integer, String> trans = new Function<Integer, String>() {
            @Override
            public String apply(Integer integer) {
                return String.valueOf(integer);
            }
        };


        //CONSUMER
        //Representa una operación que acepta un solo argumento de tipo T y
        //no devuelve ningún resultado. Se usa principalmente para realizar acciones o
        // efectos secundarios (como modificar un objeto o imprimir un valor).
        Consumer<String> mayus = (s -> System.out.println(s.toUpperCase()));
        palabras.forEach(mayus);
        //Creamos un consumer que convierta a mayusculas los string.
        //------------------------------------
        //Esto implementa un consumer
        Consumer<String> minus = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s.toLowerCase());
            }
        };
        palabras.forEach(minus);


        //SUPPLIER
        //Generamos un mensaje que luego agregamos a la lista
        //El supplier sirve para generar, enteros, objetos, strings.
        //E ir añadadiendo a listas, podemos generar aleatorios.
        Supplier<String> mensaje = () -> "Hola mundo";
        List<String> listaMsj = new ArrayList<>();
        listaMsj.add(mensaje.get());
        listaMsj.add(mensaje.get());
        listaMsj.add(mensaje.get());
        System.out.println(listaMsj);
        //--------------------------
        //Clase anonima de supplier
        Supplier<String> msj = new Supplier<String>() {
            @Override
            public String get() {
                return "Hola";
            }
        };
        String nuevo = msj.get();
        //Se pueden hacer cosas interesantes como un bucle que ejecute el supplier
        //Uso UUID es un clase que genera identificadores unicos universales
        /*
        List<String> randomStrings = generarLista(() -> UUID.randomUUID().toString(), 3);
        System.out.println(randomStrings);

        public static List<String> generarLista (Supplier < String > supplier,int n){
            List<String> lista = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                lista.add(supplier.get());
            }
            return lista;
        }

         */


        //COMPARATOR
        //Usando la lista de palabras aprovechamos el comparator para ordenar por
        //Abecedario
        //Me lo pone en gris porque podriamos usar lambda compacto
        Comparator<String> comp = (s1, s2) -> s1.compareTo(s2);
        Collections.sort(palabras, comp);
        System.out.println(palabras);
        //Ordenamos por el abecedario usando el comparador comp.
        //Es necesario aprender los metodos de collections:
        //sort - binarySearch - reverse - shuffle - rotate - frequency - disjoint - unmodifiableList
        //fill - replaceAll - min - max - copy
        //-----------------------
        //Aqui comparamos de menor a mayor con clase anonima
        //Y con reverse de mayo a menor
        Comparator<Integer> num = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        };
        Collections.sort(numeros, num);
        System.out.println(numeros);
        Collections.reverse(numeros);
        System.out.println(numeros);


        //BINARY OPERATOR:
        //El binary operator se usa para suma de enteros, concatenar strings, maximo entre dos numeros
        //Y tiene algunos metodos estaticos utiles
        //Para usarlo podemos poner BinaryOperator.apply
        //Ejemplo:
        //---------------------------
        //Esto lo podemos reemplazar por un lambda compacto
        BinaryOperator<Integer> suma = (a, b) -> a + b;
        //Ejemplo
        System.out.println(suma.apply(2, 5));
        //----------------
        BinaryOperator<String> conc = (s1, s2) -> s1 + " " + s2;
        //-----------------------
        BinaryOperator<Integer> max = (a, b) -> a > b ? a : b;
        //------------------------
        //Metodos estaticos
        //Estos metodos estaticos usan comparator para comprobar
        //Ejemplo
        //Comp es un comparador creado anteriormente, podemos sacar minimo y maximo de comparadores
        //numericos
        BinaryOperator.maxBy(comp);
        BinaryOperator.minBy(num);
        //O tambien podemos usar metodos de los tipos
        BinaryOperator<Integer> operadorMax = BinaryOperator.maxBy(Integer::compare);
        BinaryOperator<String> operadorMin = BinaryOperator.minBy(String::compareToIgnoreCase);
        //Es muy util en streams para sumar elementos de una lista con reduce
        //Sale amarillo porque lo podemos reemplazar por un lambda compacto
        int total = numeros.stream()
                .reduce(0, (a, b) -> a + b); // BinaryOperator
        System.out.println(total);


        //BI FUNCTION
        //El BI FUNCTION es muy util porque se puede usar para muchas cosas complejas y sobre todo
        // en streams tiene dos parametros de entrada y uno de retorno.
        //Podemos usar el apply igual para el uso de BI FUNCTION
        //La diferencia con Binary Operator es que el BI FUNCTION recibe dos parametros de igual tipo
        //o distinto mientras que Binary Operator tiene que ser el mismo tipo.
        //------------------------------
        //Concatenamos String + Numero
        BiFunction<String, Integer, String> concatenar = (texto, numero) -> texto + ": " + numero;
        //--------------------------------
        //Combinamos listas
        BiFunction<List<String>, List<String>, List<String>> combinarListas =
                (lista1, lista2) -> {
                    List<String> resultado = new ArrayList<>(lista1);
                    resultado.addAll(lista2);
                    return resultado;
                };
        //------------------------
        //Uso en Maps avanzados
        // BiFunction para sumar 5 a cada valor
        Map<String, Integer> edades = new HashMap<>();
        edades.put("Ivan", 21);
        edades.put("Dani", 21);

        BiFunction<String, Integer, Integer> incrementarEdad = (nombre, edad) -> edad + 5;
        edades.replaceAll(incrementarEdad);
        System.out.println(edades);
        //------------------------------
        //Podemos realizar varia operaciones con andThen
        //Primero multiplicamos y luego convertimos a string, muy util
        BiFunction<Integer, Integer, Integer> multiplicar = (a, b) -> a * b;
        Function<Integer, String> convertirAString = (n) -> "Resultado: " + n;

        BiFunction<Integer, Integer, String> Final = multiplicar.andThen(convertirAString);
        //Los usos mas comunes de BI FUNCTION:
        //Transformar pares clave-valor en un Map.
        //Operaciones matemáticas con dos operandos.
        //Combinar resultados de dos flujos de datos.
        //Validaciones complejas que requieren dos inputs.


        //UNARY OPERATOR
        //El UNARY OPERATOR acepta un solo argumento de un tipo y devuelve un resultado de ese tipo
        //Opera sobre un solo elemento y devuelve un resultado del mismo tipo.
        //Es una subinterfaz de Function<T, T>, por lo que puede usarse donde se espere una Function.
        //Podemos convertir strings, cambiar signos.
        //Pero lo mas interesante que podemos transformar objetos personalizados
        //Ejemplo:

        class Producto {
            String nombre;
            double precio;

            public void setPrecio(double precio) {
                this.precio = precio;
            }

            public double getPrecio() {
                return precio;
            }
        }
        //Aplicamos un descuento del 10% y devolvemos el productos con el descuento.
        UnaryOperator<Producto> descuento =
                producto -> {
                    producto.setPrecio(producto.getPrecio() * 0.9);
                    return producto;
                };
        //La diferencia entre Function y Unary Operator es que con el Function
        //hacemos conversiones entre tipos distintos y con el Unary Operator
        //hacemos conversiones del mismo tipo
        //UnaryOperator<T> es ideal para operaciones que transforman un valor manteniendo su tipo.
        //Es más específico y legible que Function<T, T> cuando los tipos de entrada y salida coinciden.
        //Se usa frecuentemente en:
        //APIs de Java como List.replaceAll.
        //Cadenas de operaciones en programación funcional.
        //Transformaciones simples en streams.
        //Lo usamos cuando necesites una función que opere sobre un objeto y
        // devuelva otro del mismo tipo (ej: matemáticas, formateo, modificaciones de estado).




    }
}
