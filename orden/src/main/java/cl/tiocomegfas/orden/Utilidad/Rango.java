package cl.tiocomegfas.orden.Utilidad;

public class Rango<T> {

    private T bajo;
    private T alto;

    public Rango(){

    }

    public T obtenerAlto() {
        return alto;
    }

    public T obtenerBajo() {
        return bajo;
    }

    public void insertarAlto(T alto) {
        this.alto = alto;
    }

    public void insertarBajo(T bajo) {
        this.bajo = bajo;
    }
}
