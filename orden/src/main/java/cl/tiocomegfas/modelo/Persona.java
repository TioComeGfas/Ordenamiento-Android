package cl.tiocomegfas.modelo;

import androidx.annotation.NonNull;

public class Persona implements Comparable<Persona> {

    private int id;

    private String nombre;

    public Persona(int id, String nombre){
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @NonNull
    @Override
    public String toString() {
        return "id= "+id+", nombre= "+nombre;
    }

    @Override
    public int compareTo(Persona persona) {

        if(this.id == persona.id) return 0;
        else if(this.id > persona.id) return 1;
        else return -1;
    }
}
