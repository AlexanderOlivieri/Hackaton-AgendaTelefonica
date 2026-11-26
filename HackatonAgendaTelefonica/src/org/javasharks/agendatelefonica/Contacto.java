package org.javasharks.agendatelefonica;

public class Contacto {
   //Atributos
    private String nombre;
    private String telefono;

    //Constructor
    public Contacto(String nombre, String telefono){
        this.nombre = nombre;
        this.telefono = telefono;
    }

    // Getters and Setters

    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNombre(){
        return nombre;
    }
    public String getTelefono(){
        return telefono;
    }

    public String toString() {
        return "Nombre: " + nombre +
                "\nTeléfono: " + telefono;
    }
}
