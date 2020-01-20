package cl.tiocomegfas.orden.Excepciones;

public interface CodigoErrorHilo {


    public static final String ERROR_TIPO_ES_NULO = "EL hilo no se puede iniciar, porque aun no se a definido el tipo";
    public static final String ERROR_ACCION_ES_NULA = "El hilo no se puede inciar, sin una accion a aplicar";
    public static final String ERROR_ARREGLO_INVALIDO = "El hilo no se puede inciar, porque el arreglo ingresado es invalido o nulo";

    public static final String ERROR_BUBBLE_SORT_LISTENER_NULO = "El escuchador para el metodo bubble sort es nulo";
    public static final String ERROR_COUNTING_SORT_LISTENER_NULO = "El escuchador para el metodo counting sort es nulo";
    public static final String ERROR_INSERTION_SORT_LISTENER_NULO = "El escuchador para el metodo insertion sort es nulo";
    public static final String ERROR_MERGE_SORT_LISTENER_NULO = "El escuchador para el metodo merge sort es nulo";
    public static final String ERROR_QUICK_SORT_LISTENER_NULO = "El escuchador para el metodo quick sort es nulo";
    public static final String ERROR_SELECTION_SORT_LISTENER_NULO = "El escuchador para el metodo selection sort es nulo";
}
