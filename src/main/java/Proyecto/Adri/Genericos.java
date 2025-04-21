package Proyecto.Adri;

public class Genericos {
    /*En java, las colecciones están preparadas para tratar con todo tipo de datos
     Lo que queremos es que java verifique que esta utilizando el tipo correcto de dato,
     con esto conseguimos reutilizar codigo y que una misma clase pueda trabajar con diferentes
     tipos de datos y esto evitamos muchos errores de compilación */

    //He aqui un ejemplo de una clase generica
    class Contenedor<T> {
        private T objeto;

        public void guardar(T nuevo) { objeto = nuevo; }

        public T extraer() {
            T res = objeto;
            objeto = null;
            return res;
        }
        //Aqui usamos un comodin o wildcard, este sirve para que trabaje con todo tipo de datos
        public static void verContenido(Contenedor<?> c) {
            System.out.println("Contenido: " + c.objeto);
        }
    }


    public void main(String[] args) {
        // Con <Integer> nos aseguramos que si o si el tipo de dato que se utilizara sera un entero
        Contenedor<Integer> c = new Contenedor<>();
        c.guardar(5);
        Integer mano=c.extraer();

        Contenedor<String> c2= new Contenedor<>();
        c2.guardar("Hola Mundo");
        String Pantalla=c2.extraer();
        //como vemos la misma clase sirve para varios tipos de dato


        //
        Contenedor.verContenido(c);
        Contenedor.verContenido(c2);
    }


}
