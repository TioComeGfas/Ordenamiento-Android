package cl.tiocomegfas.orden.Algortimos;

import java.util.List;

import cl.tiocomegfas.orden.Excepciones.CodigosErrores;
import cl.tiocomegfas.orden.Interfaces.Clasificador;
import cl.tiocomegfas.orden.Interfaces.Ordenable;
import cl.tiocomegfas.orden.Utilidad.Util;

public class MergeSort extends Clasificador implements Ordenable, CodigosErrores {

    private static final String TAG = "MergeSort";


    public static <T extends Comparable<T>> void aplicar(int tipo,T[] arreglo){
        MergeSort mergeSort = new MergeSort();

        if(tipo == ASCENDENTE) mergeSort.ascendente(arreglo);
        else mergeSort.descendente(arreglo);
    }

    @Override
    public <T extends Comparable<T>> void ascendente(T[] valores) {
        mergeSort(valores, 0, valores.length - 1, ASCENDENTE);
    }

    @Override
    public <T extends Comparable<T>> void descendente(T[] valores) {
        mergeSort(valores, 0, valores.length - 1, DESCENDENTE);
    }



    private <T extends Comparable<T>> void mergeSort(T[] valores, int bajo, int alto, int tipo) {
        if (bajo < alto) {
            // Get the medio of the array.
            int medio = bajo + ((alto - bajo) / 2);

            // Divide.
            mergeSort(valores, bajo, medio, tipo);
            mergeSort(valores, medio + 1, alto, tipo);

            // Conquer.
            merge(valores, bajo, medio, alto, tipo);
        }
    }


    private <T extends Comparable<T>> void merge(T[] valores, int bajo, int medio, int alto, int tipo) {
        // The amount of numbers to sort.
        int numbersToSort = (alto - bajo) + 1;

        // Temp array to contain the sorted elements of this iteration.
        List<T> arTemp = Util.newList(numbersToSort);

        int i = bajo;
        int j = medio + 1;
        T bajoValor = null;
        T altoValor = null;
        for (int k = 0; k < numbersToSort; k++) {

            bajoValor = (i <= medio) ? valores[i] : null;
            altoValor = (j <= alto) ? valores[j] : null;

            if (checkBiggerSmaller(bajoValor, altoValor, tipo)) {
                arTemp.add(valores[i++]);
            } else {
                arTemp.add(valores[j++]);
            }
        }

        // Transfer the sorted elements to the original array.
        for (int k = 0; k < numbersToSort; k++) {
            valores[bajo + k] = arTemp.get(k);
        }
    }



    private <T extends Comparable<T>> boolean checkBiggerSmaller(T bajoValor, T altoValor, int tipo) {
        if ((bajoValor != null) && (altoValor == null)) {
            return true;
        } else if ((bajoValor == null) && (altoValor != null)) {
            return false;
        }

        if (ASCENDENTE == tipo) {
            // Ascending.
            return bajoValor.compareTo(altoValor) <= 0;
        } else {
            // Descending.
            return bajoValor.compareTo(altoValor) >= 0;
        }
    }

}
