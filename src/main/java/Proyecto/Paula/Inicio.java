package Proyecto.Paula;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Inicio {
    public static void main(String[] args) {

        //Primera forma, creando una clase explícita

        //Creamos un ArrayList de 3 libros
        //Dentro de la anotación diamante debemos indicar el tipo de objeto
        List<Libro> libros1 = new ArrayList<>();
        libros1.add(new Libro ("Libro 8","Autor f",2000));
        libros1.add(new Libro ("Libro 4","Autor z",2001));
        libros1.add(new Libro ("Libro 6","Autor s",2020));

        //Creamos un objeto CompararTitulo y lo pasamos a la función donde se va a usar
        Comparator<Libro> comparar=new CompararTitulo();
        libros1.sort(comparar);
        //Collections.sort(libros1,comparar); → Esta línea es la que pone de ejemplo en el libro ya que
        //antes las listas no tenían su propio método .sort (java 8)

        //También podríamos utilizar esta línea que hace lo mismo pero en una única línea
        //libros1.sort(new CompararTitulo());

        System.out.println("Lista de libros ordenados por título (Clase explícita):");
        for (Libro libro : libros1) {
            System.out.println(libro);
        }

        //Segunda forma, mediante una clase anónima
        //Si sólo lo vamos a utilizar una vez no merece la pena implementar una clase
        List<Libro> libros2 = new ArrayList<>();
        libros2.add(new Libro ("Libro 8","Autor f",2000));
        libros2.add(new Libro ("Libro 4","Autor z",2001));
        libros2.add(new Libro ("Libro 6","Autor s",2020));

        Comparator<Libro> comparar2=new Comparator<>() {
            public int compare (Libro l1, Libro l2) {
                return l1.getTitulo().compareTo(l2.getTitulo());
            }
        };
        libros2.sort(comparar2);

        //Otra opción es:
        /*
        libros2.sort(new Comparator<>() {
            public int compare(Libro l1, Libro l2) {
                return l1.getTitulo().compareTo(l2.getTitulo());
            }
         });
         */

        System.out.println("Lista de libros ordenados por título (Clase anónima):");
        for (Libro libro : libros2) {
            System.out.println(libro);
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

        //Otra opción en una única línea:
        //Collections.sort (libros3, (Libro l1, Libro l2) -> {return l1.getTitulo().compareTo(l2.getTitulo());});

        System.out.println("Lista de libros ordenados por título (Expresión Lambda):");
        for (Libro libro : libros3) {
            System.out.println(libro);
        }

    }

}
