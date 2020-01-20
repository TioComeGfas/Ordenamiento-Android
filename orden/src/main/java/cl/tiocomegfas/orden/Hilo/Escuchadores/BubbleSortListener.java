package cl.tiocomegfas.orden.Hilo.Escuchadores;

public interface BubbleSortListener extends ErrorListener {

    <T> void onListo(T[] arreglo);
}
