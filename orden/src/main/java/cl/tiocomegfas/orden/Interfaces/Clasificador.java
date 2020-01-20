package cl.tiocomegfas.orden.Interfaces;

public abstract class Clasificador {

    protected <T> void intercambio(T[] valores, int primero, int segundo) {
        T temp = valores[primero];
        valores[primero] = valores[segundo];
        valores[segundo] = temp;
    }


}
