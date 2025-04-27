package Proyecto.Noel;

import java.util.*;

/*
La interfaz map sirve para conectar pares de clave-valor.
Al no heredar de Collections (aunque esté estrechamente relacionado con ellas), no es iterable.
Dentro de la interfaz map hay varios tipos de mapas: HashMap, TreeMap, y LinkedHashMap
Un mapa nunca puede tener objetos primitivos

El HashMap es el más rápido, ya que tiene un rendimiento de tiempo constante(O(1)),
mientras que el TreeMap solo puede garantizar un costo de tiempo logarítmico (0(log(n)),
y el LinkedHashMap, aunque trabaja con HashMap, es más lento que este.
 */
public class usoMap {
    public static void main(String[] args) {

        Map<Integer,ClienteMap> hashMap = new HashMap<>();
        Map<Integer,ClienteMap> treeMap = new TreeMap<>();
        Map<Integer,ClienteMap> linkedHashMap = new LinkedHashMap<>();
        ClienteMap cliente1 = new ClienteMap("Marta","marta@example.com",12,1);
        ClienteMap cliente2 = new ClienteMap("Arturo","arturo@example.com",16,3);
        ClienteMap cliente3 = new ClienteMap("Bea","bea@example.com",20,2);
        ClienteMap cliente4 = new ClienteMap("Candido","candido@example.com",60,6);
        ClienteMap cliente5 = new ClienteMap("Eustaquio","eustaquio@example.com",91,6);

        //Creamos una lista para añadir los clientes de una manera más eficaz a todos los mapas
        List<ClienteMap> clientes = new ArrayList<>();
        clientes.add(cliente1);
        clientes.add(cliente2);
        clientes.add(cliente3);
        clientes.add(cliente4);

        // Si descomentamos esta línea, vemos que sobreescribe los datos de cliente4, aunque no da error
        // no funciona correctamente
        //clientes.add(cliente5);
        Iterator<ClienteMap> it = clientes.iterator();

        while(it.hasNext()) {
            ClienteMap cm = it.next();
            hashMap.put(cm.getId(),cm);
            treeMap.put(cm.getId(),cm);
            linkedHashMap.put(cm.getId(),cm);
        }

        /*
        HashMap no te garantiza el orden en el que salen los datos.
         */
        System.out.println("HashMap");
        for(Integer id: hashMap.keySet()) {
            System.out.println("id = " + id + ", email " + hashMap.get(id).getEmail());
        }
        /*
        TreeMap sí te garantiza el orden; te lo ordena por el valor de la clave.
        **tendría que probar a ver que pasa si pongo un objeto en una clave, como lo ordenaria???
         */
        System.out.println("TreeMap");
        for(Integer id: treeMap.keySet()) {
            System.out.println("id = " + id + ", email " + treeMap.get(id).getEmail());
        }
        /*
        LinkedHashMap te garantiza otro tipo de orden; el orden de inserción de datos.
         */
        System.out.println("LinkedHashMap");
        for(Integer id: linkedHashMap.keySet()) {
            System.out.println("id = " + id + ", email " + linkedHashMap.get(id).getEmail());
        }
        hashMap.remove(3);
        treeMap.remove(3);
        Set<Integer> claves = hashMap.keySet();

    }
}
