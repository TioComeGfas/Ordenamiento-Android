package cl.tiocomegfas.orden.Excepciones;

/**
 * Clase utilizada por BubbleSort para lanzar Excepciones, reportando algun problema
 * @see cl.tiocomegfas.orden.Excepciones.OrdenException Es la excepcion padre que hereda de RunntimeException
 *
 * @author tiocomegfas
 * @version 1.0
 * @since 2020
 */
public class BubbleSortException extends OrdenException{

    /**
     * Constructor vacio
     */
    public BubbleSortException(){
        super();
    }

    /**
     * Contructor que recibe el mensaje de error
     * @param mensaje una cadena que contenga un mensaje para informar al usuario
     */
    public BubbleSortException(String mensaje){
        super(mensaje);
    }
}
