package cl.tiocomegfas.orden.Algortimos;

import cl.tiocomegfas.orden.Excepciones.CodigosErrores;
import cl.tiocomegfas.orden.Excepciones.CountingSortException;
import cl.tiocomegfas.orden.Interfaces.Clasificador;
import cl.tiocomegfas.orden.Interfaces.Ordenable;
import cl.tiocomegfas.orden.Utilidad.Rango;
import cl.tiocomegfas.orden.Utilidad.Util;

/**
 *  Esta clase se encarga de ordenar los objetos, realizando el algoritmo de Counting Sort, pero de forma generica
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
public class CountingSort extends Clasificador implements Ordenable, CodigosErrores {

    /**
     * Utilizado para mostrar un log en la consola
     */
    private static final String TAG = "CountingSort";

    /**
     * Metodo estatico para iniciar el proceso de ordenamiento.
     * @param tipo  Ascendente : ordenar en forma ascendente.
     *              Descente : ordenar en forma descendente.
     *
     * @param arreglo El arreglo generico a ordenar
     * @param <T> El tipo de dato a ordenar.
     * @throws CountingSortException Se lanza cuando existe un problema para ordenar el arreglo.
     */
    public static <T extends Comparable<T>> void aplicar(int tipo, T[] arreglo) throws CountingSortException{
        CountingSort countingSort = new CountingSort();

        if(tipo == ASCENDENTE) countingSort.ascendente(arreglo);
        else countingSort.descendente(arreglo);
    }

    /**
     * Metodo para ordenar de forma ascendente el arreglo generico.
     * @param valores El arreglo generico con la informacion a ordenar.
     * @param <T> El tipo de datos a ordenar.
     * @throws CountingSortException Se lanza cuando existe un problema para ordenar el arreglo.
     */
    @Override
    public <T extends Comparable<T>> void ascendente(T[] valores) throws CountingSortException {
        ordenar(valores,ASCENDENTE);
    }

    /**
     * Metodo para ordenar de forma descendente el arreglo generico.
     * @param valores El arreglo generico con la informacion a ordenar.
     * @param <T> El tipo de datos a ordenar.
     * @throws CountingSortException Se lanza cuando existe un problema para ordenar el arreglo.
     */
    @Override
    public <T extends Comparable<T>> void descendente(T[] valores) throws CountingSortException {
        ordenar(valores,DESCENDENTE);
    }


    /**
     * Metodo encargado de ordenar el arreglo con el metodo Counting Sort
     * @param valores El arreglo generico con la informacion a ordenar.
     * @param <T> El tipo de datos a ordenar.
     * @throws CountingSortException Se lanza cuando el arreglo es nulo
     *                               Se lanza cuando el arreglo es invalido
     *                               Se lanza cuando el tipo es invalido
     *                               Se lanza cuando el arreglo no es una instancia de Integer
     */
    private <T extends Comparable<T>> void ordenar(T[] valores, int tipo) throws CountingSortException{

        //validaciones
        if(valores == null) throw new CountingSortException(ERROR_ARREGLO_NULO);
        if (valores.length < 2) throw new CountingSortException(ERROR_ARREGLO_INVALIDO);
        if(tipo != ASCENDENTE && tipo != DESCENDENTE) throw new CountingSortException(ERROR_TIPO_INVALIDO);
        if (!(valores instanceof Integer[])) throw new CountingSortException(ERROR_COUNTING_ARREGLO_INVALIDO);

        //ordenamiento
        Integer[] temp = (Integer[]) valores;
        int indexToInsertElement = 0;

        Rango<Integer> rangeElements = Util.obtenerBajoAlto(temp);

        int lowestElement = rangeElements.obtenerBajo();
        int highestElement = rangeElements.obtenerAlto();
        int[] occurrences = new int[(highestElement - lowestElement) + 1];

        for (int i = 0; i < valores.length; i++) {
            occurrences[temp[i] - lowestElement] += 1;
        }

        int currentIndex;
        int finishIndex;
        int increment;

        if (tipo == ASCENDENTE) {
            currentIndex = 0;
            finishIndex = occurrences.length;
            increment = 1;
        } else{
            currentIndex = occurrences.length - 1;
            finishIndex = -1;
            increment = -1;
        }

        while (currentIndex != finishIndex) {
            int nrOccurrences = occurrences[currentIndex];

            for (int j = 0; j < nrOccurrences; j++) {
                temp[indexToInsertElement++] = currentIndex + lowestElement;
            }

            currentIndex += increment;
        }
    }

}
