package cl.tiocomegfas.orden.Algortimos;

import cl.tiocomegfas.orden.Excepciones.CodigosErrores;
import cl.tiocomegfas.orden.Excepciones.CountingSortException;
import cl.tiocomegfas.orden.Interfaces.Clasificador;
import cl.tiocomegfas.orden.Interfaces.Ordenable;
import cl.tiocomegfas.orden.Utilidad.Rango;
import cl.tiocomegfas.orden.Utilidad.Util;

public class CountingSort extends Clasificador implements Ordenable, CodigosErrores {

    private static final String TAG = "CountingSort";


    public static <T extends Comparable<T>> void aplicar(int tipo, T[] arreglo){

        CountingSort countingSort = new CountingSort();

        if(tipo == ASCENDENTE) countingSort.ascendente(arreglo);
        else countingSort.descendente(arreglo);
    }

    @Override
    public <T extends Comparable<T>> void ascendente(T[] valores) throws CountingSortException {
        ordenar(valores,ASCENDENTE);
    }

    @Override
    public <T extends Comparable<T>> void descendente(T[] valores) throws CountingSortException {
        ordenar(valores,DESCENDENTE);
    }


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

        // Iterate through the array and count how many times each value has appeared and increment by
        // 1 every time.
        for (int i = 0; i < valores.length; i++) {
            occurrences[temp[i] - lowestElement] += 1;
        }

        // This peace of code is necessary just because we only want to create one method that will
        // sort ascending and descending, otherwise this code could be deleted.
        int currentIndex = 0;
        int finishIndex = 0;
        int increment = 0;
        if (tipo == ASCENDENTE) {
            // asendente.
            currentIndex = 0;
            finishIndex = occurrences.length;
            increment = 1;
        } else{
            // desendente.
            currentIndex = occurrences.length - 1;
            finishIndex = -1;
            increment = -1;
        }

        while (currentIndex != finishIndex) {
            int nrOccurrences = occurrences[currentIndex];

            for (int j = 0; j < nrOccurrences; j++) {
                // It is necessary to "+ lowestElement" to compensate when it was subtracted.
                temp[indexToInsertElement++] = currentIndex + lowestElement;
            }

            currentIndex += increment;
        }
    }

}
