package Proyecto.Noel;

public class ClienteMap {
    private String email;
    private int edad;
    private String nombre;
    private int id;
    public ClienteMap(String nombre,String email, int edad,int id) {
        this.nombre = nombre;
        this.email = email;
        this.edad = edad;
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }
}
