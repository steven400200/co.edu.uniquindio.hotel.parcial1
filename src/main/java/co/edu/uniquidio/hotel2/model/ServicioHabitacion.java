package co.edu.uniquidio.hotel2.model;

import co.edu.uniquidio.hotel2.model.builder.ClienteBuilder;
import co.edu.uniquidio.hotel2.model.builder.ServicioHabitacionBuilder;

public class ServicioHabitacion extends Servicio {


    public ServicioHabitacion(int diasContratados) {
        super(diasContratados);
    }

    public static ServicioHabitacionBuilder builder(){
        return new ServicioHabitacionBuilder();
    }


    @Override
    public void consumir() {
        System.out.println("Servicio de habitacion consumido");

    }

}
