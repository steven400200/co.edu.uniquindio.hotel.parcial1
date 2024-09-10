package co.edu.uniquidio.hotel2.model.builder;

import co.edu.uniquidio.hotel2.model.ServicioHabitacion;
import co.edu.uniquidio.hotel2.model.Spa;

public class ServicioHabitacionBuilder {


    protected int diasContratados;


    public ServicioHabitacionBuilder diasContratados(int diasContratados) {
        this.diasContratados = diasContratados;
        return this; // Devuelve la instancia actual de ClienteBuilder
    }


    public ServicioHabitacion build() {

        return new ServicioHabitacion (diasContratados);
    }

}
