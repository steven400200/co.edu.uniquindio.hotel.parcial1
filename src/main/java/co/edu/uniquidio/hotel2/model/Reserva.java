package co.edu.uniquidio.hotel2.model;
import co.edu.uniquidio.hotel2.model.builder.ReservaBuilder;
import java.time.LocalDate;

public class Reserva {
    private LocalDate fechaEntrada;
    private LocalDate fechaSalida;
    private Habitacion habitacion;

    public Reserva(LocalDate fechaEntrada, LocalDate fechaSalida) {
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida= fechaSalida;
    }
    public Reserva(LocalDate fechaEntrada, LocalDate fechaSalida, Habitacion habitacion) {
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.habitacion = habitacion;
    }
    public LocalDate getFechaEntrada() {
        return fechaEntrada;
    }

    public LocalDate getFechaSalida() {
        return fechaSalida;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }
    public static ReservaBuilder builder(){
        return new ReservaBuilder();
    }

    @Override
    public String toString() {
        return "\nReserva: " +
                "\nFecha entrada: " + fechaEntrada +
                "\nFecha salida:" + fechaSalida +
                "\nHabitacion: " + habitacion ;
    }
    public String mostrarDatos() {
        return "\nReserva: " +
                "\nFecha entrada: " + fechaEntrada +
                "\nFecha salida:" + fechaSalida ;

}
}
