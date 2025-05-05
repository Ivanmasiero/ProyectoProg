package Proyecto.Adri;

public class Genericos {
    /*En java, las colecciones están preparadas para tratar con todo tipo de datos
     Lo que queremos es que java verifique que esta utilizando el tipo correcto de dato,
     con esto conseguimos reutilizar codigo y que una misma clase pueda trabajar con diferentes
     tipos de datos y esto evitamos muchos errores de compilación */


    public static class Contenedor<T> {
        private T objeto;
        public void guardar(T nuevo) { objeto = nuevo; }
        public T extraer() {
            T res = objeto;
            objeto = null;
            return res;
        }
        //Aqui usamos un comodin o wildcard, este sirve para que trabaje con todo tipo de datos
        public static void verContenido(Contenedor<? extends Object> c) {
            if (c.objeto != null) {
                System.out.println("Contenido del contenedor de tipo " + c.objeto.getClass().getSimpleName() + ": " + c.objeto);
            } else {
                System.out.println("El contenedor está vacío.");
            }
        }
    }
    public static void main(String[] args) {
        // Con <Integer> nos aseguramos que si o si el tipo de dato que se utilizara sera un entero
        Contenedor<Integer> c = new Contenedor<>();
        c.guardar(5);
        Contenedor.verContenido(c);
        Integer mano=c.extraer();

        Contenedor<String> c2= new Contenedor<>();
        c2.guardar("Hola Mundo");
        Contenedor.verContenido(c2);
        String Pantalla=c2.extraer();
        //como vemos la misma clase sirve para varios tipos de dato

    }


}
