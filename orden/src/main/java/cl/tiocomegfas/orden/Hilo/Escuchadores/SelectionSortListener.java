package cl.tiocomegfas.orden.Hilo.Escuchadores;

public interface SelectionSortListener extends ErrorListener {

    <T> void onListo(T[] arreglo);
}
