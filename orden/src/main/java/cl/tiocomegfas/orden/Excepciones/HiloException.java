package cl.tiocomegfas.orden.Excepciones;

/**
 * Clase utilizada por el Hilo para lanzar Excepciones, reportando algun problema
 * @see cl.tiocomegfas.orden.Excepciones.OrdenException Es la excepcion padre que hereda de RunntimeException
 *
 * @author tiocomegfas
 * @version 1.0
 * @since 2020
 */
public class HiloException extends OrdenException {

    /**
     * Constructor vacio
     */
    public HiloException() {
    }

    /**
     * Constructor que recibe el mensaje de error
     * @param mensaje una cadena que contenga un mensaje para informar al usuario
     */
    public HiloException(String mensaje) {
        super(mensaje);
    }
}
