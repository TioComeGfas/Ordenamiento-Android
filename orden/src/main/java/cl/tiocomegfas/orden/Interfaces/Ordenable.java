package cl.tiocomegfas.orden.Interfaces;

/**
 * Esta interface es para permitir tener los mismos metodos en todos los algoritomos de orden
 */
public interface Ordenable{

    /**
     * Este metodo permite ordenar el arreglo en forma ascendente
     * @param valores El arreglo con los objetos a ordenar
     * @param <T> El tipo de dato que contiene el arreglo
     */
    <T extends Comparable<T>> void ascendente(T[] valores);

    /**
     * Este metodo permite ordenar el arreglo en forma descendente
     * @param valores El arreglo con los objetos a ordenar
     * @param <T> El tipo de dato que contiene el arreglo
     */
    <T extends Comparable<T>> void descendente(T[] valores);

}
