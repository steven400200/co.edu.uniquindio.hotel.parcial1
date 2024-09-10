package co.edu.uniquidio.hotel2.services;

public interface IClienteCrud {
    boolean crearCliente(String nombre, String dni);
    boolean eliminarCliente(String dni);
    boolean actualizarCliente(String nombre, String dniActual, String dniNueva);
    String obtenerDatosCliente(String dni);
}
