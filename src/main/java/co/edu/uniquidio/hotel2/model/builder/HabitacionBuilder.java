package co.edu.uniquidio.hotel2.model.builder;
import co.edu.uniquidio.hotel2.model.Habitacion;
import co.edu.uniquidio.hotel2.model.TipoHabitacion;

public class HabitacionBuilder {
    protected int numeroHabitacion;
    protected TipoHabitacion tipoHabitacion;

    public HabitacionBuilder numeroHabitacion(int numeroHabitacion) {
        this.numeroHabitacion = numeroHabitacion;
        return this; // Devuelve la instancia actual de ClienteBuilder
    }
    public HabitacionBuilder tipoHabitacion(TipoHabitacion tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
        return this; // Devuelve la instancia actual de ClienteBuilder
    }
    public Habitacion build() {
        return new Habitacion (numeroHabitacion,tipoHabitacion);
    }
}
