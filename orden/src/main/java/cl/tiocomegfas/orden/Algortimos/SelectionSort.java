package cl.tiocomegfas.orden.Algortimos;

import cl.tiocomegfas.orden.Excepciones.CodigosErrores;
import cl.tiocomegfas.orden.Excepciones.SelectionSortException;
import cl.tiocomegfas.orden.Interfaces.Clasificador;
import cl.tiocomegfas.orden.Interfaces.Ordenable;

public class SelectionSort extends Clasificador implements Ordenable, CodigosErrores {

    private static final String TAG = "SelectionSort";

    public static <T extends Comparable<T>> void aplicar(int tipo,T[] arreglo){
        SelectionSort selectionSort = new SelectionSort();
        if(tipo == ASCENDENTE) selectionSort.ascendente(arreglo);
        else selectionSort.descendente(arreglo);
    }


    @Override
    public <T extends Comparable<T>> void ascendente(T[] valores) {
        ordenar(valores,0,0);
    }

    @Override
    public <T extends Comparable<T>> void descendente(T[] valores) {
        ordenar(valores,1,1);
    }

    private <T extends Comparable<T>> void ordenar(T[] valores, int first, int second) {

        if(valores == null) throw new SelectionSortException(ERROR_ARREGLO_NULO);
        if (valores.length < 2) throw new SelectionSortException(ERROR_ARREGLO_INVALIDO);

        int length = valores.length;
        int indexSwapElement;

        for (int i = 0; i < length - 1; i++) {
            indexSwapElement = i;

            for (int j = i + 1; j < length; j++) {

                if (valores[indexSwapElement + first].compareTo(valores[j - second]) > 0) {
                    // It gets the index of the smallest/biggest element.
                    indexSwapElement = j;
                }
            }
            if (indexSwapElement != i) {
                // Put the smallest/biggest element at the index i, but only if the valores (i and
                // indexSmallestElement) have changed.
                intercambio(valores, i, indexSwapElement);
            }

        }
    }
}
