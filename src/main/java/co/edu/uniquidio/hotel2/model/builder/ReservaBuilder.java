package co.edu.uniquidio.hotel2.model.builder;
import co.edu.uniquidio.hotel2.model.Habitacion;
import co.edu.uniquidio.hotel2.model.Reserva;

import java.time.LocalDate;

public class ReservaBuilder {
    protected LocalDate fechaEntrada;
    protected LocalDate fechaSalida;
    protected Habitacion habitacion;

    public ReservaBuilder fechaEntrada(LocalDate fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
        return this;
    }

    public ReservaBuilder fechaSalida(LocalDate fechaSalida) {
        this.fechaSalida = fechaSalida;
        return this;
    }

    public ReservaBuilder habitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
        return this;
    }

    public Reserva build() {
        return new Reserva(fechaEntrada, fechaSalida,habitacion);
    }

}
