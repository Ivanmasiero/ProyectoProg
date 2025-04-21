package Proyecto.Paula;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Creamos un ArrayList de 3 libros
        List<Libro> libros1 = new ArrayList<>();
            libros1.add(new Libro ("Libro 8","Autor f",2000));
            libros1.add(new Libro ("Libro 4","Autor z",2001));
            libros1.add(new Libro ("Libro 6","Autor s",2020));

        //Primera forma, creando una clase explícita

        //Dentro de la anotación diamante debemos indicar el tipo de objeto a comparar
        Comparator<Libro> comparar=new CompararTitulo();
        //Collections.sort(libros1,comparar); → Esta línea es la que pone de ejemplo en el libro ya que
        //antes las listas no tenían su propio método .sort (java 8)
        libros1.sort(comparar);

        System.out.println("Lista de libros ordenados por título (Clase explícita):");
        for (int i=0;i<libros1.size();i++) {
            System.out.println(libros1.get(i));
        }

        //Segunda forma, mediante una clase anónima

        List<Libro> libros2 = new ArrayList<>();
        libros2.add(new Libro ("Libro 8","Autor f",2000));
        libros2.add(new Libro ("Libro 4","Autor z",2001));
        libros2.add(new Libro ("Libro 6","Autor s",2020));

        Comparator<Libro> comparar2=new Comparator<>() {
            public int compare (Libro l1, Libro l2) {
                return l1.getTitulo().compareTo(l2.getTitulo());
            }
        };
        Collections.sort(libros2,comparar2);

        System.out.println("Lista de libros ordenados por título (Clase anónima):");
        for (int i=0;i<libros2.size();i++) {
            System.out.println(libros2.get(i));
        }

        //Tercera forma (Expresiones lambda)

        List<Libro> libros3 = new ArrayList<>();
        libros3.add(new Libro ("Libro 8","Autor f",2000));
        libros3.add(new Libro ("Libro 4","Autor z",2001));
        libros3.add(new Libro ("Libro 6","Autor s",2020));

        //Java infiere los tipos y podríamos escribir directamente (l1,l2)
        //Además no es necesario poner el return ni las llaves ya que sólo contiene una línea
        Comparator<Libro> comparar3=(Libro l1,Libro l2) -> {return l1.getTitulo().compareTo(l2.getTitulo());};
        libros3.sort(comparar3);


        //Collections.sort (libros3, (Libro l1, Libro l2) -> {return l1.getTitulo().compareTo(l2.getTitulo());});

        System.out.println("Lista de libros ordenados por título (Expresión Lambda):");
        for (int i=0;i<libros3.size();i++) {
            System.out.println(libros3.get(i));
        }

    }

}
