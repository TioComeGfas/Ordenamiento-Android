package cl.tiocomegfas.orden.Excepciones;

public class OrdenException extends RuntimeException{

    public OrdenException(){
        super();
    }

    public OrdenException(String mensaje){
        super(mensaje);
    }

}
