package co.edu.uniquidio.hotel2.services;
import java.time.LocalDate;

public interface IReservaCrud {
    boolean crearReserva(LocalDate fechaEntrada,LocalDate fechaSalida);
    boolean actualizarReserva(LocalDate fechaEntradaActual,LocalDate fechaEntradaNueva, LocalDate fechaSalida);
    String obtenerDatosReserva(LocalDate fechaEntrada);
    boolean eliminarReserva(LocalDate fechaEntrada);

}
