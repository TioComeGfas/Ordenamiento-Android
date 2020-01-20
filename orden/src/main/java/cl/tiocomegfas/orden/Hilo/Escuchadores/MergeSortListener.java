package cl.tiocomegfas.orden.Hilo.Escuchadores;

public interface MergeSortListener extends ErrorListener {

    <T> void onListo(T[] arreglo);
}
