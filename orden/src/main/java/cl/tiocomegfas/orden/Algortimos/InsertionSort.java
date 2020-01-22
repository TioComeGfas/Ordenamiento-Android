package cl.tiocomegfas.orden.Algortimos;

import cl.tiocomegfas.orden.Excepciones.CodigosErrores;
import cl.tiocomegfas.orden.Excepciones.InsertionSortException;
import cl.tiocomegfas.orden.Interfaces.Clasificador;
import cl.tiocomegfas.orden.Interfaces.Ordenable;

/**
 *  Esta clase se encarga de ordenar los objetos, realizando el algoritmo de Insertion Sort, pero de forma generica
 *  Solo requiere pasar el arreglo con los objetos que se desea ordenar y el tipo (ascendente y descendente)
 *
 *  @see cl.tiocomegfas.orden.Excepciones.CodigosErrores Interfaz que almacena todas las constantes necesarias.
 *  @see cl.tiocomegfas.orden.Interfaces.Ordenable Interfaz para generalizar los metodos ascendente y descendente.
 *  @see cl.tiocomegfas.orden.Interfaces.Clasificador Clase padre que es utilizada para realizar el intercambio en el arreglo.
 *
 *  @author tiocomegfas
 *  @version 1.0
 *  @since 2020
 */
public class InsertionSort extends Clasificador implements Ordenable, CodigosErrores {

    /**
     * Utilizado para mostrar un log en la consola
     */
    private static final String TAG = "InsertionSort";

    /**
     * Metodo estatico para iniciar el proceso de ordenamiento.
     * @param tipo  Ascendente : ordenar en forma ascendente.
     *              Descente : ordenar en forma descendente.
     *
     * @param arreglo El arreglo generico a ordenar
     * @param <T> El tipo de dato a ordenar.
     * @throws InsertionSortException Se lanza cuando existe un problema para ordenar el arreglo.
     */
    public static <T extends Comparable<T>> void aplicar(int tipo,T[] arreglo) throws InsertionSortException{
        InsertionSort insertionSort = new InsertionSort();

        if(tipo == ASCENDENTE) insertionSort.ascendente(arreglo);
        else insertionSort.descendente(arreglo);
    }

    /**
     * Metodo para ordenar de forma ascendente el arreglo generico.
     * @param valores El arreglo generico con la informacion a ordenar.
     * @param <T> El tipo de datos a ordenar.
     * @throws InsertionSortException Se lanza cuando existe un problema para ordenar el arreglo.
     */
    @Override
    public <T extends Comparable<T>> void ascendente(T[] valores) throws InsertionSortException{
        ordenar(valores,0,1);
    }

    /**
     * Metodo para ordenar de forma descendente el arreglo generico.
     * @param valores El arreglo generico con la informacion a ordenar.
     * @param <T> El tipo de datos a ordenar.
     * @throws InsertionSortException Se lanza cuando existe un problema para ordenar el arreglo.
     */
    @Override
    public <T extends Comparable<T>> void descendente(T[] valores) throws InsertionSortException{
        ordenar(valores,1,0);
    }

    /**
     * Metodo encargado de ordenar el arreglo con el metodo Counting Sort
     * @param valores El arreglo generico con la informacion a ordenar.
     * @param <T> El tipo de datos a ordenar.
     * @throws InsertionSortException Se lanza cuando el arreglo es nulo
     *                               Se lanza cuando el arreglo es invalido
     */
    private <T extends Comparable<T>> void ordenar(T[] valores, int primer, int segundo) throws InsertionSortException{

        if(valores == null) throw new InsertionSortException(ERROR_ARREGLO_NULO);
        if (valores.length < 2) throw new InsertionSortException(ERROR_ARREGLO_INVALIDO);

        int length = valores.length;
        int j;

        for (int i = 1; i < length; i++) {
            j = i;
            while ((j > 0) && (valores[j - primer].compareTo(valores[j - segundo]) < 0)) {
                intercambio(valores, j - primer, j - segundo);
                j--;
            }
        }
    }

}
