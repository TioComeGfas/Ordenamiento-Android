package cl.tiocomegfas.orden.Hilo.Escuchadores;

public interface QuickSortListener extends ErrorListener {

    <T> void onListo(T[] arreglo);
}
