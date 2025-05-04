package Proyecto.Noel;

import java.util.HashMap;
import java.util.Map;

/*
Un Map es una estructura de datos de tipo clave-valor.
esto significa que por cada clave (Key) tiene un valor (value) asociado.


Hay distintos tipos de mapas: HashMap, LinkedHashMap, TreeMap.
    De todos estos, vamos a explicar el HashMap, más común y rápido.

Las claves NO se pueden repetir, mientras que los valores sí

En caso de repetir una key, lo que hará es actualizar su valor.

Aunque está estrechamente relacionado con las colecciones, Map no extiende de Collection, por lo que no es Iterable directamente.
Para recorrerlo se podría usar entrySet(), keySet() o forEach.

HashMap no puede usar tipos primitivos directamente, pero sí puede usar sus wrappers.

HashMap permite una clave tipo null, y valores tipo null.

 */
public class MapBasico {
    public static void main(String[] args) {
        //Creamos un mapa con una clave tipo Integer y valores tipo String
        Map<Integer, String> empleados = new HashMap<>();

        //Insertamos varios registros
        empleados.put(1,"Juanjo");
        empleados.put(2,"Pepe");
        empleados.put(3,"Héctor");

        //Mostramos el contenido del mapa.
        System.out.println(empleados); // Se muestra con llaves porque es un mapa, no una Collection
        System.out.println(empleados.entrySet()); //Aquí, al transformarlo en un Set, ahora sí es Iterable.

        //Sobreescribimos a Pepe
        empleados.put(2, "Manuel");
        System.out.println(empleados);

        //Eliminamos una entrada por su clave
        empleados.remove(1); //También se podría especificar el valor que tiene que tener

        //Mostramos el valor de una entrada por su clave
        System.out.println(empleados.get(2)); // mostrar el valor de una clave
        System.out.println(empleados.getOrDefault(5,"Valor por defecto")); //También se puede mostrar un valor por defecto si no existe la clave.

        //Comprobamos si existe alguna entrada con esta clave
        System.out.println(empleados.containsKey(2)
                ? "Sí hay un empleado con esta clave"
                : "No hay un empleado con esta clave");

        //Comprobamos si existe alguna entrada con este valor.
        System.out.println(empleados.containsValue("Julio")
                ? "Sí hay un empleado con este valor"
                : "No hay un empleado con este valor");

        empleados.forEach((id, nombre) -> System.out.println(id + ": " + nombre));

    }
}
