package cl.tiocomegfas.orden.Hilo.Escuchadores;

public interface CountingSortListener extends ErrorListener {

    <T> void onListo(T[] arreglo);
}
