package org.javasharks.agendatelefonica;

public class Contacto {
   //Atributos
    private String nombre;
    private String apellido;
    private String telefono;

    //Constructor
    public Contacto(String nombre, String apellido, String telefono){
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
    }

    // Getters and Setters

    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setApellido(String apellido){
        this.apellido = apellido;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getNombre(){
        return nombre;
    }
    public String getApellido(){
        return apellido;
    }
    public String getTelefono(){
        return telefono;
    }

    public String toString() {
        return "Nombre: " + nombre + " " + apellido +
                "\nTeléfono: " + telefono;
    }
}
