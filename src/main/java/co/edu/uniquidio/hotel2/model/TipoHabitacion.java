package co.edu.uniquidio.hotel2.model;

public enum TipoHabitacion {
    SENCILLA(20.0),

    DOBLE(30.0),

    SUITE(40.0);

     double costoHabitacion;

    private TipoHabitacion(double costoHabitacion) {
        this.costoHabitacion = costoHabitacion;
    }
}
