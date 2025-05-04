package Proyecto.Unai.Ejemplo;

public class ClienteTienda {
    public static void main(String[] args) {
        TiendaFrutas tienda = new TiendaFrutas();

        tienda.agregarFruta("Manzana");
        tienda.agregarFruta("Plátano");
        tienda.agregarFruta("Kiwi");

        tienda.mostrarFrutas();

        tienda.eliminarFruta("Kiwi");
        tienda.mostrarFrutas();

        System.out.println("¿Tiene Plátano? " + tienda.contieneFruta("Plátano"));
        System.out.println("Fruta en posición 0: " + tienda.obtenerFruta(0));
    }
}
