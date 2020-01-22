package cl.tiocomegfas.orden.Excepciones;

/**
 * Clase utilizada por InsertionSort para lanzar Excepciones, reportando algun problema
 * @see cl.tiocomegfas.orden.Excepciones.OrdenException Es la excepcion padre que hereda de RunntimeException
 *
 * @author tiocomegfas
 * @version 1.0
 * @since 2020
 */
public class InsertionSortException extends OrdenException {

    /**
     * Constructor vacio
     */
    public InsertionSortException() {
    }

    /**
     * Contructor que recibe el mensaje de error
     * @param mensaje una cadena que contenga un mensaje para informar al usuario
     */
    public InsertionSortException(String mensaje) {
        super(mensaje);
    }
}
