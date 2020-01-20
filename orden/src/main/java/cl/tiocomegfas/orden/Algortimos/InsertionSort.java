package cl.tiocomegfas.orden.Algortimos;

import cl.tiocomegfas.orden.Excepciones.CodigosErrores;
import cl.tiocomegfas.orden.Excepciones.InsertionSortException;
import cl.tiocomegfas.orden.Interfaces.Clasificador;
import cl.tiocomegfas.orden.Interfaces.Ordenable;

public class InsertionSort extends Clasificador implements Ordenable, CodigosErrores {

    private static final String TAG = "InsertionSort";

    public static <T extends Comparable<T>> void aplicar(int tipo,T[] arreglo){
        InsertionSort insertionSort = new InsertionSort();

        if(tipo == ASCENDENTE) insertionSort.ascendente(arreglo);
        else insertionSort.descendente(arreglo);
    }


    @Override
    public <T extends Comparable<T>> void ascendente(T[] valores) throws InsertionSortException{
        ordenar(valores,0,1);
    }

    @Override
    public <T extends Comparable<T>> void descendente(T[] valores) throws InsertionSortException{
        ordenar(valores,1,0);
    }



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
