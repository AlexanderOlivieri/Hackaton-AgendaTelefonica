package org.javasharks.agendatelefonica;

import javax.swing.*;
import java.util.List;

import static java.lang.System.exit;

public class Main {

    // Declaración de la variable Agenda
    private static Agenda agenda;

    public static void main(String[] args) {

        // Instancia e inicializa la variable agenda
        agenda = new Agenda();

        // Variables
        String name;
        String telefono;

        // Mensaje de bienvenida y menú de opciones
        String menu = """
                ***************** BIENVENIDO *****************
                
                Selecciona una opción:
                
                1.- Ver la lista de contactos.
                2.- Añadir contacto.
                3.- Editar número de contacto.
                4.- Buscar contacto.
                5.- Eliminar contacto.
                6.- Salir.
                
                """;

        // Bucle
        while (true) {

            String opcion = mostrarCampoDeEntrada(menu);

            if (opcion == null){
                mostrarMensaje("Hasta luego, vuelve pronto.");
                break;
            }

            opcion = opcion.trim();

            switch (opcion) {
                case "1":

                    mostrarMensaje(listarContactos());
                    break;

                case "2":

                    name = mostrarCampoDeEntrada("Ingresa el nombre del contacto:");
                    if(name == null) break;

                    telefono = mostrarCampoDeEntrada("Ingresa el teléfono del contacto");
                    if(telefono == null) break;

                    name.trim();
                    telefono.trim();

                    if (name.isBlank() || telefono.isBlank()) {
                        mostrarMensaje("Ninguno de los campos puede quedar vacío.");
                        break;
                    } else if (!validarTelefono(telefono)) {
                        mostrarMensaje("El teléfono debe contener 10 carácteres numéricos.");
                        break;
                    }

                    Contacto nuevoContacto = new Contacto(name, telefono);

                    mostrarMensaje(crearContacto(nuevoContacto));
                    break;

                case "3":

                    name = mostrarCampoDeEntrada("Ingresa el nombre del contacto:");
                    if(name == null) break;

                    telefono = mostrarCampoDeEntrada("Ingresa el nuevo número de teléfono:");
                    if(telefono == null) break;

                    name.trim();
                    telefono.trim();

                    if (name.isBlank() || telefono.isBlank()) {
                        mostrarMensaje("Ninguno de los campos puede quedar vacío.");
                        break;
                    } else if (!validarTelefono(telefono)) {
                        mostrarMensaje("El número debe contener 10 carácteres númericos.");
                        break;
                    }

                    mostrarMensaje(editarContacto(name, telefono));
                    break;

                case "4":

                    name = mostrarCampoDeEntrada("Ingresa el nombre del usuario que deseas buscar:");
                    if(name == null) break;

                    name.trim();

                    if (name.isBlank()) {
                        mostrarMensaje("El campo no puede estar vacío.");
                        break;
                    }

                    mostrarMensaje(buscarContacto(name));
                    break;

                case "5":
                    name = mostrarCampoDeEntrada("Ingresa el nombre del contacto que deseas eliminar:");
                    if(name == null) break;

                    name.trim();

                    if (name.isBlank()) {
                        mostrarMensaje("El campo no puede estar vacío.");
                        break;
                    }

                    mostrarMensaje(eliminarContacto(name));
                    break;

                case "6":
                case "salir":

                    mostrarMensaje("Hasta luego, vuelve pronto.");
                    exit(0);
                    break;

                default:

                    if (opcion.isBlank()) {
                        mostrarMensaje("El campo no puede estar vacío.");
                        break;
                    }

                    mostrarMensaje("La opción ingresada no se encuentra dentro del menú.");
            }
        }
    }

    // Listar contactos
    public static String listarContactos() {
        List<Contacto> contactos = agenda.listaDeContactos();

        StringBuilder sb = new StringBuilder();

        if (!contactos.isEmpty()) {

            sb.append("Lista de contactos:\n\n");

            for (Contacto contacto : contactos) {
                sb.append(contacto.toString()).append("\n\n");
            }

            return sb.toString();
        }

        return "La agenda de contactos se encuentra vacía.";
    }

    // Crear contacto
    public static String crearContacto(Contacto contacto) {
        boolean agendaLlena = agenda.agendaLlena();
        boolean existeContacto = agenda.existeContacto(contacto);

        if (!agendaLlena) {
            return "La agenda de contactos está llena.";
        } else if (existeContacto) {
            return "El contacto ya se encuentra en la lista.";
        }

        agenda.anadirContacto(contacto);

        return "Contacto añadido correctamente." +
                "\nEspacio disponible: " + agenda.espacioLibre();
    }

    // Editar contacto
    public static String editarContacto(String nombre, String nuevoTelefono) {

        boolean contactoEditado = agenda.editarContacto(nombre, nuevoTelefono);

        if (contactoEditado) {
            return "El contacto se editó correctamente.";
        }

        return "No se logró editar el contacto.";
    }

    // Buscar contacto
    public static String buscarContacto(String nombre) {
        Contacto contacto = agenda.buscarContacto(nombre);

        if (contacto == null) {
            return "No se encontró el contacto ingresado.";
        }

        return "Usuario encontrado:\n\n" +
                contacto;
    }

    // Eliminar contacto
    public static String eliminarContacto(String nombre) {

        boolean contactoEliminado = agenda.elminarContacto(nombre);

        if (contactoEliminado) {
            return "Contacto eliminado correctamente.";
        }

        return "No se logró eliminar el contacto.";
    }

    // Muestra  un mensaje y un campo de texto en una ventana emergente
    public static String mostrarCampoDeEntrada(String mensaje) {
        return JOptionPane.showInputDialog(null, mensaje, "Agenda JavaSharks", JOptionPane.PLAIN_MESSAGE);
    }

    // Muestra  un mensaje en una ventana emergente
    public static void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Agenda JavaSharks", JOptionPane.PLAIN_MESSAGE);
    }

    // Valida que  el número de teléfono contenga 10 números seguidos
    public static boolean validarTelefono(String telefono) {
        if (!telefono.matches("\\d{10}")) {
            return false;
        }

        return true;
    }
}
