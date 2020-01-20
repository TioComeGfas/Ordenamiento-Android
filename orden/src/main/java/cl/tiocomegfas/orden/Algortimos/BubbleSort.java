package cl.tiocomegfas.orden.Algortimos;

import android.util.Log;

import cl.tiocomegfas.orden.Excepciones.BubbleSortException;
import cl.tiocomegfas.orden.Excepciones.CodigosErrores;
import cl.tiocomegfas.orden.Interfaces.Clasificador;
import cl.tiocomegfas.orden.Interfaces.Ordenable;

public class BubbleSort extends Clasificador implements Ordenable, CodigosErrores {

    private static final String TAG = "BubbleSort";

    public static <T extends Comparable<T>> void aplicar(int tipo,T[] arreglo){

        BubbleSort bubbleSort = new BubbleSort();

        if(tipo == ASCENDENTE) bubbleSort.ascendente(arreglo);
        else bubbleSort.descendente(arreglo);
    }


    /**
     *
     * @param valores
     * @param <T>
     * @throws BubbleSortException
     */
    @Override
    public <T extends Comparable<T>> void ascendente(T[] valores) throws BubbleSortException{
        ordenar(valores,0,1);
    }

    /**
     *
     * @param valores
     * @param <T>
     */
    @Override
    public <T extends Comparable<T>> void descendente(T[] valores) throws BubbleSortException{
        ordenar(valores,1,0);
    }

    /**
     *
     * @param valores
     * @param primero
     * @param segundo
     * @param <T>
     * @throws BubbleSortException
     */
    private <T extends Comparable<T>> void ordenar(T[] valores, int primero, int segundo) throws BubbleSortException{

        if ((null == valores) || (valores.length < 2)) throw new BubbleSortException(ERROR_ARREGLO_NULO);

        int length = valores.length;
        int cantidadInteracciones = 0;
        boolean estaOrdenado;

        for (int i = 1; i < length; i++) {
            estaOrdenado = true;

            for (int j = 0; j < length - i; j++) {
                cantidadInteracciones++;
                if (valores[j + primero].compareTo(valores[j + segundo]) > 0) {
                    estaOrdenado = false;
                    intercambio(valores, j + primero, j + segundo);
                }
            }

            if (estaOrdenado) break;

        }

        Log.d(TAG,"Interacciones realizadas:" + cantidadInteracciones);
    }
}
