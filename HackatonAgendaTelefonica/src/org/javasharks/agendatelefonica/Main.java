package org.javasharks.agendatelefonica;

import javax.swing.*;
import java.util.List;

public class Main {

    private static Agenda agenda;

    public static void main(String[] args) {

        agenda = new Agenda();

        String menu = """
                ************* BIENVENIDO *************
                
                Selecciona una opción:
                
                1.- Ver la lista de contactos.
                2.- Añadir contacto.
                3.- Editar número de contacto.
                4.- Buscar contacto.
                5.- Eliminar contacto.
                6.- Salir.
                """;


        
    }

    // Listar contactos
    public static String listarContactos() {
        List<Contacto> contactos = agenda.listaDeContactos();

        StringBuilder sb = new StringBuilder();

        if (!contactos.isEmpty()) {
            for (Contacto contacto : contactos) {
                sb.append(contacto.toString()).append("\n");
            }

            return sb.toString();
        }

        return "Lista de contactos vacía.";
    }

    // Crear contacto
    public static String crearContacto(Contacto contacto){
        boolean existeContacto = agenda.anadirContacto(contacto);
        boolean agendaLlena = agenda.agendaLlena();

        if(!agendaLlena){
            return "La agenda de contactos está llena.";
        }else if(!existeContacto){
            return "El contacto ya se encuentra en la lista.";
        }

        return "Contacto añadido correctamente.";
    }

    // Editar contacto
    public static String editarContacto(String nombre, String nuevoTelefono){

        boolean contactoEditado = agenda.editarContacto(nombre, nuevoTelefono);

        if(contactoEditado){
            return "El contacto se editó correctamente.";
        }

        return "El contacto no se logró editar.";
    }

    // Buscar contacto
    public static String buscarContacto(String nombre){
        Contacto contacto = agenda.buscarContacto(nombre);

        if(contacto == null){
            return "No se encontró el contacto.";
        }

        return contacto.toString();
    }

    // Eliminar contacto
    public static String eliminarContacto(String nombre){

        boolean contactoEliminado = agenda.elminarContacto(nombre);

        if(contactoEliminado){
            return "Contacto eliminado correctamente.";
        }

        return "No se logró eliminar el contacto.";
    }
}
