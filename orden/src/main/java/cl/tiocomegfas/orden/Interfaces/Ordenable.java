package cl.tiocomegfas.orden.Interfaces;

public interface Ordenable{

    <T extends Comparable<T>> void ascendente(T[] valores);

    <T extends Comparable<T>> void descendente(T[] valores);

}
