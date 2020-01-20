package cl.tiocomegfas.orden.Hilo.Escuchadores;

public interface InsertionSortListener extends ErrorListener {

    <T> void onListo(T[] arreglo);
}
