package cl.tiocomegfas.orden.Algortimos;

import java.util.List;

import cl.tiocomegfas.orden.Excepciones.CodigosErrores;
import cl.tiocomegfas.orden.Excepciones.MergeSortException;
import cl.tiocomegfas.orden.Interfaces.Clasificador;
import cl.tiocomegfas.orden.Interfaces.Ordenable;
import cl.tiocomegfas.orden.Utilidad.Util;

/**
 *  Esta clase se encarga de ordenar los objetos, realizando el algoritmo de Merge Sort, pero de forma generica
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
public class MergeSort extends Clasificador implements Ordenable, CodigosErrores {

    /**
     * Utilizado para mostrar un log en la consola
     */
    private static final String TAG = "MergeSort";

    /**
     * Metodo estatico para iniciar el proceso de ordenamiento.
     * @param tipo  Ascendente : ordenar en forma ascendente.
     *              Descente : ordenar en forma descendente.
     *
     * @param arreglo El arreglo generico a ordenar
     * @param <T> El tipo de dato a ordenar.
     * @throws MergeSortException Se lanza cuando existe un problema para ordenar el arreglo.
     */
    public static <T extends Comparable<T>> void aplicar(int tipo,T[] arreglo) throws MergeSortException {
        MergeSort mergeSort = new MergeSort();

        if(tipo == ASCENDENTE) mergeSort.ascendente(arreglo);
        else mergeSort.descendente(arreglo);
    }

    /**
     * Metodo para ordenar de forma ascendente el arreglo generico.
     * @param valores El arreglo generico con la informacion a ordenar.
     * @param <T> El tipo de datos a ordenar.
     * @throws MergeSortException Se lanza cuando existe un problema para ordenar el arreglo.
     */
    @Override
    public <T extends Comparable<T>> void ascendente(T[] valores) throws MergeSortException {
        mergeSort(valores, 0, valores.length - 1, ASCENDENTE);
    }

    /**
     * Metodo para ordenar de forma descendente el arreglo generico.
     * @param valores El arreglo generico con la informacion a ordenar.
     * @param <T> El tipo de datos a ordenar.
     * @throws MergeSortException Se lanza cuando existe un problema para ordenar el arreglo.
     */
    @Override
    public <T extends Comparable<T>> void descendente(T[] valores) throws MergeSortException {
        mergeSort(valores, 0, valores.length - 1, DESCENDENTE);
    }


    /* METODOS QUE UTILIZA EL ALGPRITMO MERGE SORT */
    
    private <T extends Comparable<T>> void mergeSort(T[] valores, int bajo, int alto, int tipo) throws MergeSortException {
        if (bajo < alto) {
            int medio = bajo + ((alto - bajo) / 2);
            
            mergeSort(valores, bajo, medio, tipo);
            mergeSort(valores, medio + 1, alto, tipo);
            
            merge(valores, bajo, medio, alto, tipo);
        }
    }
    
    private <T extends Comparable<T>> void merge(T[] valores, int bajo, int medio, int alto, int tipo) throws MergeSortException {
        int numbersToSort = (alto - bajo) + 1;
        
        List<T> arTemp = Util.newList(numbersToSort);

        int i = bajo;
        int j = medio + 1;
        T bajoValor = null;
        T altoValor = null;
        for (int k = 0; k < numbersToSort; k++) {

            bajoValor = (i <= medio) ? valores[i] : null;
            altoValor = (j <= alto) ? valores[j] : null;

            if (verificaGrandePequenio(bajoValor, altoValor, tipo)) {
                arTemp.add(valores[i++]);
            } else {
                arTemp.add(valores[j++]);
            }
        }
        
        for (int k = 0; k < numbersToSort; k++) {
            valores[bajo + k] = arTemp.get(k);
        }
    }

    private <T extends Comparable<T>> boolean verificaGrandePequenio(T bajoValor, T altoValor, int tipo) {
        if ((bajoValor != null) && (altoValor == null)) {
            return true;
        } else if ((bajoValor == null) && (altoValor != null)) {
            return false;
        }

        if (ASCENDENTE == tipo) {
            return bajoValor.compareTo(altoValor) <= 0;
        } else {
            return bajoValor.compareTo(altoValor) >= 0;
        }
    }

}
