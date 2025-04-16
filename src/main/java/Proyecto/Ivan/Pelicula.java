package Proyecto.Ivan;

public class Pelicula {
    private String nombre;
    private int año;
    private String director;
    public Pelicula(String nombre, int año,String director){
        this.nombre= nombre;
        this.año=año;
        this.director=director;
    }
    public int getAño() {return año;}
    public String getNombre() {return nombre;}
    public String getDirector() {return director;}

    @Override
    public String toString(){return nombre+" del año "+año+ " dirigida por "+director;}
}
