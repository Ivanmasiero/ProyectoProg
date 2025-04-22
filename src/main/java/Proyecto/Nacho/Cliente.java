package Proyecto.Nacho;

public class Cliente implements Comparable<Cliente> {
    private String dni;
    private String nombre;
    private String fechaNacimiento;

    public Cliente(String dni, String nombre, String fechaNacimiento) {
        this.dni = dni;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
    }

    public Cliente(String dni) {
        this(dni, null, null);
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public int compareTo(Cliente o) {
        return this.dni.compareTo(o.dni);
    }

    @Override
    public String toString() {
        return nombre + " (" + dni + ")";
    }
}