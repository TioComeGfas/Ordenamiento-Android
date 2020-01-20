package cl.tiocomegfas.orden.Utilidad;

import java.util.ArrayList;
import java.util.List;

import cl.tiocomegfas.orden.Excepciones.CodigosErrores;
import cl.tiocomegfas.orden.Excepciones.OrdenException;

public class Util implements CodigosErrores {

    /**
     * Iterates over all the elements in the array and return an object (RangeElements) with the lowest and highest
     * element from it.
     *
     * @param valores
     * @return An object with the lowest and highest element from it.
     */
    public static <T extends Comparable<T>> Rango<T> obtenerBajoAlto(T[] valores) throws OrdenException {
        if ((null == valores) || (valores.length < 1)) throw new OrdenException(ERROR_ARREGLO_INVALIDO);

        Rango<T> rango = new Rango<T>();
        T elementoBajo = valores[0];
        T elementoAlto = valores[0];

        for (int i = 1; i < valores.length; i++) {
            if (elementoBajo.compareTo(valores[i]) > 0) elementoBajo = valores[i];
            if (elementoAlto.compareTo(valores[i]) < 0) elementoAlto = valores[i];
        }

        rango.insertarBajo(elementoBajo);
        rango.insertarAlto(elementoAlto);
        return rango;
    }

    /**
     * Return a list of type T.
     *
     * @param initialCapacity
     *          the initial capacity of the list.
     * @return List<T>
     */
    public static <T> List<T> newList(int initialCapacity) {
        return new ArrayList<T>(initialCapacity);
    }

}
