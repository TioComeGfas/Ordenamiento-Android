package cl.tiocomegfas.orden.Algortimos;

import cl.tiocomegfas.orden.Excepciones.CodigosErrores;
import cl.tiocomegfas.orden.Interfaces.Clasificador;
import cl.tiocomegfas.orden.Interfaces.Ordenable;

public class QuickSort extends Clasificador implements Ordenable, CodigosErrores {

    private static final String TAG = "QuickSort";


    public static <T extends Comparable<T>> void aplicar(int tipo, T[] arreglo){
        QuickSort quickSort = new QuickSort();
        if(tipo == ASCENDENTE) quickSort.ascendente(arreglo);
        else quickSort.descendente(arreglo);
    }


    @Override
    public <T extends Comparable<T>> void ascendente(T[] valores) {

    }

    @Override
    public <T extends Comparable<T>> void descendente(T[] valores) {

    }


    private <T extends Comparable<T>> void ordenar(T[] values, int first, int second) {

        //if ((null == values) || (values.length < 2)) {
            //return results.stopTimer();
        //}


        //implementar metodo de ordenamientos
    }
}
