package cl.tiocomegfas.orden.Algortimos;

import cl.tiocomegfas.orden.Excepciones.CodigosErrores;
import cl.tiocomegfas.orden.Excepciones.SelectionSortException;
import cl.tiocomegfas.orden.Interfaces.Clasificador;
import cl.tiocomegfas.orden.Interfaces.Ordenable;

/**
 *  Esta clase se encarga de ordenar los objetos, realizando el algoritmo de Selection Sort, pero de forma generica
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
public class SelectionSort extends Clasificador implements Ordenable, CodigosErrores {

    /**
     * Utilizado para mostrar un log en la consola
     */
    private static final String TAG = "SelectionSort";

    /**
     * Metodo estatico para iniciar el proceso de ordenamiento.
     * @param tipo  Ascendente : ordenar en forma ascendente.
     *              Descente : ordenar en forma descendente.
     *
     * @param arreglo El arreglo generico a ordenar
     * @param <T> El tipo de dato a ordenar.
     * @throws SelectionSortException Se lanza cuando existe un problema para ordenar el arreglo.
     */
    public static <T extends Comparable<T>> void aplicar(int tipo,T[] arreglo) throws SelectionSortException{
        SelectionSort selectionSort = new SelectionSort();
        if(tipo == ASCENDENTE) selectionSort.ascendente(arreglo);
        else selectionSort.descendente(arreglo);
    }


    /**
     * Metodo para ordenar de forma ascendente el arreglo generico.
     * @param valores El arreglo generico con la informacion a ordenar.
     * @param <T> El tipo de datos a ordenar.
     * @throws SelectionSortException Se lanza cuando ocurre un problema con el algoritmo
     */
    @Override
    public <T extends Comparable<T>> void ascendente(T[] valores) throws SelectionSortException{
        ordenar(valores,0,0);
    }

    /**
     * Metodo para ordenar de forma descendente el arreglo generico.
     * @param valores El arreglo generico con la informacion a ordenar.
     * @param <T> El tipo de datos a ordenar.
     * @throws SelectionSortException Se lanza cuando ocurre un problema con el algoritmo
     */
    @Override
    public <T extends Comparable<T>> void descendente(T[] valores) throws SelectionSortException{
        ordenar(valores,1,1);
    }

    /**
     * Metodo encargado de ordenar el arreglo generico
     * @param valores el arreglo generico a ordenar
     * @param primero variable para definir el primer item
     * @param segundo varaible para definir el segundo item
     * @param <T> El tipo de dato a ordenar
     * @throws SelectionSortException En caso de recibir un arreglo invalido se lanza
     */
    private <T extends Comparable<T>> void ordenar(T[] valores, int primero, int segundo) throws SelectionSortException{

        if(valores == null) throw new SelectionSortException(ERROR_ARREGLO_NULO);
        if (valores.length < 2) throw new SelectionSortException(ERROR_ARREGLO_INVALIDO);

        int length = valores.length;
        int indexSwapElement;

        for (int i = 0; i < length - 1; i++) {
            indexSwapElement = i;

            for (int j = i + 1; j < length; j++) {

                if (valores[indexSwapElement + primero].compareTo(valores[j - segundo]) > 0) {
                    indexSwapElement = j;
                }
            }
            if (indexSwapElement != i) {
                intercambio(valores, i, indexSwapElement);
            }

        }
    }
}
