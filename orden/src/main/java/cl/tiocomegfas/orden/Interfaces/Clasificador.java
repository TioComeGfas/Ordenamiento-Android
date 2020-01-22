package cl.tiocomegfas.orden.Interfaces;

/**
 * Clase abstracta que se utiliza para realizar el intercambio en el arreglo entre el primer elemento y el segundo
 */
public abstract class Clasificador {

    /**
     * Metodo que realiza el intercambio entre el primero y el segundo
     * @param valores El arreglo con los valores
     * @param primero El primer elemento a intercambiar
     * @param segundo El segundo elemento a intercambiar
     * @param <T> El tipo de dato que posee el arreglo
     */
    protected <T> void intercambio(T[] valores, int primero, int segundo) {
        T temp = valores[primero];
        valores[primero] = valores[segundo];
        valores[segundo] = temp;
    }


}
