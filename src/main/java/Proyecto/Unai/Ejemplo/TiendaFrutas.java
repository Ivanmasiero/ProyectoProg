package Proyecto.Unai.Ejemplo;

import java.util.ArrayList;
import java.util.List;

public class TiendaFrutas {
    private List<String> frutas;

    public TiendaFrutas() {
        frutas = new ArrayList<>();
    }

    // Método para añadir una fruta
    public void agregarFruta(String fruta) {
        frutas.add(fruta);
    }

    // Método para eliminar una fruta por nombre
    public void eliminarFruta(String fruta) {
        if (frutas.remove(fruta)) {
            System.out.println(fruta + " eliminada correctamente.");
        } else {
            System.out.println(fruta + " no está en la lista.");
        }
    }

    // Mostrar todas las frutas
    public void mostrarFrutas() {
        System.out.println("Frutas disponibles: " + frutas);
    }

    // Verificar si una fruta existe
    public boolean contieneFruta(String fruta) {
        return frutas.contains(fruta);
    }

    // Obtener una fruta por índice
    public String obtenerFruta(int index) {
        if (index >= 0 && index < frutas.size()) {
            return frutas.get(index);
        } else {
            return "Índice fuera de rango.";
        }
    }


}
