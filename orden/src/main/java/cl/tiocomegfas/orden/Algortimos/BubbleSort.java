package cl.tiocomegfas.orden.Algortimos;

import cl.tiocomegfas.orden.Excepciones.BubbleSortException;
import cl.tiocomegfas.orden.Excepciones.CodigosErrores;
import cl.tiocomegfas.orden.Interfaces.Clasificador;
import cl.tiocomegfas.orden.Interfaces.Ordenable;

/**
 * Esta clase se encarga de ordenar los objetos, realizando el algoritmo de Bubble sort, pero de forma generica
 * Solo requiere pasar el arreglo con los objetos que desea y el tipo (ascendente y descendente)
 *
 * @author tiocomegfas
 * @version 1.0
 * @since 2020
 * @see cl.tiocomegfas.orden.Excepciones.CodigosErrores Interfaz que almacena todas las constantes necesarias.
 * @see cl.tiocomegfas.orden.Interfaces.Ordenable Interfaz para generalizar los metodos ascendente y descendente.
 * @see cl.tiocomegfas.orden.Interfaces.Clasificador Clase padre que es utilizada para realizar el intercambio en el arreglo.
 */

public class BubbleSort extends Clasificador implements Ordenable, CodigosErrores {

    /**
     * Utilizado para mostrar un log en la consola
     */
    private static final String TAG = "BubbleSort";

    /**
     * Metodo estatico para iniciar el proceso de ordenamiento.
     * @param tipo  Ascendente : ordenar en forma ascendente.
     *              Descente : ordenar en forma descendente.
     *
     * @param arreglo El arreglo generico a ordenar
     * @param <T> El tipo de dato a ordenar.
     * @throws BubbleSortException Se lanza cuando existe un problema para ordenar el arreglo.
     */
    public static <T extends Comparable<T>> void aplicar(int tipo,T[] arreglo) throws BubbleSortException{
        BubbleSort bubbleSort = new BubbleSort();

        if(tipo == ASCENDENTE) bubbleSort.ascendente(arreglo);
        else bubbleSort.descendente(arreglo);
    }

    /**
     * Metodo para ordenar de forma ascendente el arreglo generico.
     * @param valores El arreglo generico con la informacion a ordenar.
     * @param <T> El tipo de datos a ordenar.
     * @throws BubbleSortException
     */
    @Override
    public <T extends Comparable<T>> void ascendente(T[] valores) throws BubbleSortException{
        ordenar(valores,0,1);
    }

    /**
     * Metodo para ordenar de forma descendente el arreglo generico.
     * @param valores El arreglo generico con la informacion a ordenar.
     * @param <T> El tipo de datos a ordenar.
     */
    @Override
    public <T extends Comparable<T>> void descendente(T[] valores) throws BubbleSortException{
        ordenar(valores,1,0);
    }

    /**
     * Metodo encargado de ordenar el arreglo generico
     * @param valores el arreglo generico a ordenar
     * @param primero variable para definir el primer item
     * @param segundo varaible para definir el segundo item
     * @param <T> El tipo de dato a ordenar
     * @throws BubbleSortException En caso de recibir un arreglo invalido se lanza
     */
    private <T extends Comparable<T>> void ordenar(T[] valores, int primero, int segundo) throws BubbleSortException{

        if ((null == valores) || (valores.length < 2)) throw new BubbleSortException(ERROR_ARREGLO_NULO);

        int length = valores.length;
        boolean estaOrdenado;

        for (int i = 1; i < length; i++) {
            estaOrdenado = true;

            for (int j = 0; j < length - i; j++) {
                if (valores[j + primero].compareTo(valores[j + segundo]) > 0) {
                    estaOrdenado = false;
                    intercambio(valores, j + primero, j + segundo);
                }
            }

            if (estaOrdenado) break;

        }
    }
}
