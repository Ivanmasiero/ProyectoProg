package Proyecto.Sula;
import java.util.*;

public class Punto_12_5 {
    private static final Random R = new Random();

    public static void main(String[] args) {
        /* Una característica interesante de los conjuntos/colecciones es la posibilidad
         *  de crear unas a partir de otras, del mismo o distinto tipo, por medio de los constructores
         * */

        // 1. Set a Set
        System.out.println("PRIMERA FORMA: Set a Set");
        Set<String> lhs = new LinkedHashSet<>(), ts = new TreeSet<>();
        List<Set<String>> listaSet = Arrays.asList(lhs,ts);
        listaSet.forEach(Punto_12_5::agregaLetras);
        listaSet.forEach(s ->
                System.out.println(s + " (" + s.getClass() + ")")
        );
        lhs = new LinkedHashSet<>(ts);
        System.out.println(lhs + " (" + lhs.getClass() + ")\n");

        // 2. List a Set
        System.out.println("SEGUNDA FORMA: List a Set");
        List<Integer> arrayList = new ArrayList<>();
        agregaNumeros(arrayList);
        Set<Integer> setList = new TreeSet<>(arrayList);
        System.out.println(setList + "\n");

        // 3. Collection a Set
        System.out.println("TERCERA FORMA: Collection a Set");
        Collection<Integer> col = new ArrayList<>();
        agregaNumeros(col);
        Set<Integer> setOrdenado = new TreeSet<>(col);
        System.out.println(setOrdenado + " ("+setOrdenado.getClass()+")"+ "\n");

        // 4. Set a List
        System.out.println("CUARTA FORMA: Set a List");
        Set<String> frutas = Set.of("pera","manzana","kiwi");
        List<String> listaFrutas = new ArrayList<>(frutas);
        System.out.println(listaFrutas + " (" + listaFrutas.getClass() + ")");
    }

    private static void agregaLetras(Set<String> s){
        s.addAll(List.of("c","b","a"));
    }

    private static void agregaNumeros(Collection<Integer> s){
        for(int i=0; i<7; i++){
            s.add(R.nextInt(1,7));
        }
        System.out.println(s + " (" + s.getClass() + ")");
    }
}
