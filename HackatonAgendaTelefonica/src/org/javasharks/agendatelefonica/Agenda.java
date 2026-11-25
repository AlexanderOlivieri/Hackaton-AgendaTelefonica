package org.javasharks.agendatelefonica;

import java.util.ArrayList;
import java.util.List;

public class Agenda {
    //no queremos que el usuario escriba sobre el arreglo sin los métodos para ello
    private List<Contacto> contactos = new ArrayList<>();

    //constructor no es necesario, sólo los métodos
    //métodos propios
    //Verificar que no existe un contacto previamente
    public boolean existeContacto(Contacto contacto){
        return contactos.contains(contacto);
    }
    //mensajes en main, esta clase sólo contiene lógica
    public boolean anadirContacto(Contacto contacto){
        if(existeContacto(contacto)){
            return false;
        } else {
            contactos.add(contacto);
            return true;
        }
    }

    //Metodo listar contactos
    public List<Contacto> listaDeContactos(){
        return contactos;
    }

    //Metodo buscar contacto
    public Contacto buscarContacto(String nombre){
        for (Contacto contacto : contactos){
            if (contacto.getNombre().equalsIgnoreCase(nombre)){
                return contacto; //si lo encuentra te devuelve contacto
            }
        }
        return null; //si no lo encuentra devuelve un null
    }

}