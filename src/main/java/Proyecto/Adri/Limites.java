package Proyecto.Adri;

public class Limites {
    /* Hay veces que queremos limitar una clase a un determinado tipo de dato*/

    // con extends hacemos que T sea cualquier tipo de dato que herede de Number
    class Calculadora<T extends Number> {
        T a, b;
    }
    //El extends tambien se puede utilizar con interfaces

    //esto tambien se puede hacer hacia arriba es decir a superclases
    //<T super Cliente>


}
