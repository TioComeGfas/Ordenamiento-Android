package cl.tiocomegfas.orden.Excepciones;

/**
 * Clase utilizada por OrdenException para lanzar Excepciones, reportando algun problema
 * @see java.lang.RuntimeException Excepcion padre de Java
 *
 * @author tiocomegfas
 * @version 1.0
 * @since 2020
 */
public class OrdenException extends RuntimeException{

    /**
     * Constructor vacio
     */
    public OrdenException(){
        super();
    }

    /**
     * Constructor que recibe el mensaje de error
     * @param mensaje una cadena que contenga un mensaje para informar al usuario
     */
    public OrdenException(String mensaje){
        super(mensaje);
    }

}
