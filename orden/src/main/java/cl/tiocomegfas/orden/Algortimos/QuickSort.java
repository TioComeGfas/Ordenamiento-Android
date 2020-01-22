package cl.tiocomegfas.orden.Algortimos;

import cl.tiocomegfas.orden.Excepciones.CodigosErrores;
import cl.tiocomegfas.orden.Excepciones.QuickSortException;
import cl.tiocomegfas.orden.Interfaces.Clasificador;
import cl.tiocomegfas.orden.Interfaces.Ordenable;

/**
 *  Esta clase se encarga de ordenar los objetos, realizando el algoritmo de Quick Sort, pero de forma generica
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
public class QuickSort extends Clasificador implements Ordenable, CodigosErrores {

    /**
     * Utilizado para mostrar un log en la consola
     */
    private static final String TAG = "QuickSort";

    /**
     * Metodo estatico para iniciar el proceso de ordenamiento.
     * @param tipo  Ascendente : ordenar en forma ascendente.
     *              Descente : ordenar en forma descendente.
     *
     * @param arreglo El arreglo generico a ordenar
     * @param <T> El tipo de dato a ordenar.
     * @throws QuickSortException Se lanza cuando existe un problema para ordenar el arreglo.
     */
    public static <T extends Comparable<T>> void aplicar(int tipo, T[] arreglo) throws QuickSortException {
        QuickSort quickSort = new QuickSort();
        if(tipo == ASCENDENTE) quickSort.ascendente(arreglo);
        else quickSort.descendente(arreglo);
    }

    /**
     * Metodo para ordenar de forma ascendente el arreglo generico.
     * @param valores El arreglo generico con la informacion a ordenar.
     * @param <T> El tipo de datos a ordenar.
     * @throws QuickSortException Se lanza cuando ocurre un problema con el algoritmo
     */
    @Override
    public <T extends Comparable<T>> void ascendente(T[] valores) throws QuickSortException {
        validar(valores);
        ordenar(valores,0,valores.length-1,ASCENDENTE);
    }

    /**
     * Metodo para ordenar de forma descendente el arreglo generico.
     * @param valores El arreglo generico con la informacion a ordenar.
     * @param <T> El tipo de datos a ordenar.
     * @throws QuickSortException Se lanza cuando ocurre un problema con el algoritmo
     */
    @Override
    public <T extends Comparable<T>> void descendente(T[] valores) throws QuickSortException {
        validar(valores);

        ordenar(valores,0,valores.length-1,DESCENDENTE);
    }

    private <T extends Comparable<T>> void validar(T[] arreglo) throws QuickSortException{
        if(arreglo == null) throw new QuickSortException(ERROR_ARREGLO_NULO);
        if(arreglo.length < 2) throw new QuickSortException(ERROR_ARREGLO_INVALIDO);
    }

    /**
     * Metodo encargado de ordenar el arreglo generico
     * @param valores el arreglo generico a ordenar
     * @param primero variable para definir el primer item
     * @param segundo varaible para definir el segundo item
     * @param <T> El tipo de dato a ordenar
     * @throws QuickSortException En caso de recibir un arreglo invalido se lanza
     */
    private <T extends Comparable<T>> void ordenar(T[] valores, int primero, int segundo, int tipo) throws QuickSortException {

        if(primero < segundo){

            int i = primero, j = segundo;
            T x = valores[(i + j) / 2];

            do {

                if(tipo == ASCENDENTE){
                    while (valores[i].compareTo(x) < 0) i++;
                    while (x.compareTo(valores[j]) < 0) j--;
                }else{
                    while (valores[i].compareTo(x) > 0) i++;
                    while (x.compareTo(valores[j]) > 0) j--;
                }


                if ( i <= j) {
                    T tmp = valores[i];
                    valores[i] = valores[j];
                    valores[j] = tmp;
                    i++;
                    j--;
                }

            } while (i <= j);

            ordenar(valores, primero, j,tipo);
            ordenar(valores, i, segundo,tipo);

        }
    }
}