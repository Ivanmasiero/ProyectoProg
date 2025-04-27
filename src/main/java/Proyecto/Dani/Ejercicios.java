package Proyecto.Dani;


import java.time.LocalDate;
import java.util.*;
import java.util.function.*;

public class Ejercicios {
    public static void main(String[] args) {


        /*
        REGLAS:
        Usar expresiones lambda en todos los ejercicios.
        Para los ejercicios que modifican estructuras (como Consumer),
        asegurarse de que los cambios sean visibles fuera de la operación.
        En el ejercicio de Comparator, asumir que la clase Persona tiene getters para nombre y edad.
         */




        //Ejercicio Function:
        //Crear una Function<String, Integer> que convierta un número romano (String)
        // a su valor numérico (Integer).
        //Ejemplo: "XIV" → 14.
        Scanner sc = new Scanner(System.in);
        String num = sc.nextLine();
        num = num.toUpperCase();
        sc.close();
        String finalNum = num;
        Function<String, Integer> trans = s -> {
            Map<Character, Integer> romanos = new HashMap<>();
            romanos.put('I', 1);
            romanos.put('V', 5);
            romanos.put('X', 10);
            romanos.put('L', 50);
            romanos.put('C', 100);
            romanos.put('D', 500);
            romanos.put('M', 1000);
            int resultado = 0;
            int valorAnterior = 0;
            int repeticiones=1;
            for (int i = finalNum.length() - 1; i >= 0; i--) {
                char letra = finalNum.charAt(i);
                if(!romanos.containsKey(letra)) {
                    throw new IllegalArgumentException("Letra no existe o no encontrada");
                }
                int valorActual = romanos.get(letra);
                if (i < s.length() - 1 && letra == s.charAt(i + 1)) {
                    repeticiones++;
                    if ((letra == 'V' || letra == 'L' || letra == 'D') && repeticiones > 1) {
                        throw new IllegalArgumentException(letra + " no puede repetirse");
                    }
                    if ((letra == 'I' || letra == 'X' || letra == 'C' || letra == 'M') && repeticiones > 3) {
                        throw new IllegalArgumentException(letra + " no puede repetirse más de 3 veces");
                    }
                } else {
                    repeticiones = 1;
                }
                if (valorActual < valorAnterior) {
                    boolean restaValida = (letra == 'I' && (valorAnterior == 5 || valorAnterior == 10)) ||
                            (letra == 'X' && (valorAnterior == 50 || valorAnterior == 100)) ||
                            (letra == 'C' && (valorAnterior == 500 || valorAnterior == 1000));
                    if (!restaValida) {
                        throw new IllegalArgumentException("Resta inválida: " + letra + " antes de " + s.charAt(i + 1));
                    }
                }
                if (valorAnterior>valorActual){
                    resultado -= valorActual;
                }else {
                    resultado += valorActual;
                }
                valorAnterior=valorActual;
            }
            return resultado;
        };
        try{
            int numero = trans.apply(num.toUpperCase());
            System.out.println("El resultado es: "+ numero);

        }catch (IllegalArgumentException e){
            e.printStackTrace();
        }


        //Ejercicio Predicate:
        //Implementar un Predicate<String> que verifique si una cadena
        // es un palíndromo (se lee igual al derecho y al revés).
        //Ejemplo: "anilina" → true, "java" → false.
        Predicate<String> ver = s ->{
            if (s.isEmpty() || s == null){
                return false;
            }
            int i = 0;
            int j = s.length() - 1;
            while (j>i){
                if (s.charAt(i) != s.charAt(j)){
                    return false;
                }
                i++;
                j--;
            }
            return true;
        };
        System.out.println(ver.test("reconocer"));




        //Ejercicio Consumer:
        //Crear un Consumer<List<Integer>> que modifique una lista de
        // números multiplicando cada elemento por 2.
        //Ejemplo: [1, 2, 3] → [2, 4, 6] (debe modificar la lista original).
        List<Integer> numeros = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        Consumer<List<Integer>> mutl = l -> {
            int nuevo = 0;
            for (int i = 0; i<l.size();i++){
                nuevo = l.get(i);
                nuevo *=2;
                l.remove(i);
                l.add(nuevo);
            }
        };
        mutl.accept(numeros);
        System.out.println(numeros);




        //Ejercicio Supplier:
        //Implementar un Supplier<LocalDate> que siempre devuelva
        // la fecha de hoy más 7 días (próxima semana).
        //Ejemplo: Si hoy es 2023-10-05, devuelve 2023-10-12.
        Supplier<LocalDate> fecha = () -> {
            LocalDate l = LocalDate.now();
            return l.plusDays(7);
        };
        LocalDate h = fecha.get();
        System.out.println(h);






        //Ejercicio UnaryOperator:
        //Crear un UnaryOperator<String> que capitalice la primera
        // letra de una cadena y el resto en minúsculas.
        //Ejemplo: "jAvA" → "Java".
        UnaryOperator<String> cap = s -> {
            if (s == null) return s;
            return s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();
        };
        System.out.println(cap.apply("java"));




        //Ejercicio BinaryOperator:
        //Implementar un BinaryOperator<Integer> que calcule
        // el máximo común divisor (MCD) de dos números.
        //Ejemplo: (12, 18) → 6.

        BinaryOperator<Integer> mcd = (integer, integer2) -> {
          while(integer2 != 0){
              int temp = integer2;
              integer2 = integer%integer2;
              integer = temp;
          }
          return integer;
        };
        System.out.println(mcd.apply(12,18));





        //Ejercicio BiFunction:
        //Crear una BiFunction<String, String, String> que concatene dos cadenas con un guión medio.
        //Ejemplo: ("Hola", "Mundo") → "Hola-Mundo".
        BiFunction<String, String, String> conc = (s, s2) -> s + "-" + s2;
        System.out.println(conc.apply("Hola", "Mundo"));
        //Si te resulta facil te propongo que crees un map con valores de string y numero por ejemplo nombre y
        // edad y primero multipliques todos los valores por 2
        //Luego crea una Function que pase de integer a strings





        //Ejercicio:
        //Implementar un Comparator<Persona> que ordene objetos
        // Persona primero por edad (ascendente) y luego por nombre (alfabético).
        //Ejemplo:
        //List<Persona> personas = Arrays.asList(
        //    new Persona("Ana", 30),
        //    new Persona("Juan", 25),
        //    new Persona("Ana", 25)
        //);
        //// Orden esperado: [Ana(25), Juan(25), Ana(30)]
        class Persona {
            String nombre;
            int edad;

            public Persona(String nombre, int edad) {
                this.nombre = nombre;
                this.edad = edad;
            }

            public String getNombre() {
                return nombre;
            }

            public void setNombre(String nombre) {
                this.nombre = nombre;
            }

            public int getEdad() {
                return edad;
            }

            public void setEdad(int edad) {
                this.edad = edad;
            }

            @Override
            public String toString() {
                return "Persona{" +
                        "nombre='" + nombre + '\'' +
                        ", edad=" + edad +
                        '}';
            }
        }
        List<Persona> personas = Arrays.asList(
                    new Persona("Ana", 30),
                    new Persona("Juan", 25),
                    new Persona("Ana", 25)
        );
        Comparator<Persona> ed = (p1,p2) -> p1.getEdad() - p2.getEdad();
        Comparator<Persona> nom = (p1,p2) -> p1.getNombre().compareTo(p2.getNombre());
        personas.sort(ed.thenComparing(nom));
        System.out.println(personas);








    }


}
