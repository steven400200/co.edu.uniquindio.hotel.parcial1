package co.edu.uniquidio.hotel2.services;

import co.edu.uniquidio.hotel2.model.TipoHabitacion;

public interface IHabitacionCrud {
    boolean crearHabitacion(int numeroHabitacion, TipoHabitacion tipoHabitacion);
    boolean eliminarHabitacion(int numeroHabitacion);
    boolean actualizarHabitacion(int numeroHabitacionActual, int numeroHabitacionNuevo, TipoHabitacion tipoHabitacion);
    String obtenerDatosHabitacion(int numeroHabitacion);
}
