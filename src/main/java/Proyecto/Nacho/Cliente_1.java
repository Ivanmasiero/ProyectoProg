package Proyecto.Nacho;

public class Cliente_1 implements Comparable<Cliente_1> {
    private String dni;
    private String nombre;
    private String fechaNacimiento;

    public Cliente_1(String dni, String nombre, String fechaNacimiento) {
        this.dni = dni;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
    }

    public Cliente_1(String dni) {
        this(dni, null, null);
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public int compareTo(Cliente_1 o) {
        return this.dni.compareTo(o.dni);
    }

    @Override
    public String toString() {
        return nombre + " (" + dni + ")";
    }
}