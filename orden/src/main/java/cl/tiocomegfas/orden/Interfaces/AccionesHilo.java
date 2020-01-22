package cl.tiocomegfas.orden.Interfaces;

/**
 * Interface utilizada para almacenar las constantes que se utlizaran en el hilo
 */

public interface AccionesHilo {

    public static final int APLICAR_METODO_BUBBLE_SORT = 1;
    public static final int APLICAR_METODO_COUNTING_SORT = 2;
    public static final int APLICAR_METODO_INSERTION_SORT = 3;
    public static final int APLICAR_METODO_MERGE_SORT = 4;
    public static final int APLICAR_METODO_QUICK_SORT = 5;
    public static final int APLICAR_METODO_SELECTION_SORT = 6;

    public static final int TIPO_ORDENAMIENTO_SIN_APLICAR = -1;
    public static final int TIPO_ORDENAMIENTO_ASCENDENTE = 1;
    public static final int TIPO_ORDENAMIENTO_DESCENDENTE = 2;

}
