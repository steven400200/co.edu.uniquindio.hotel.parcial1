package co.edu.uniquidio.hotel2.model.builder;
import co.edu.uniquidio.hotel2.model.ServicioHabitacion;


public class ServicioHabitacionBuilder {


    protected int diasContratados;


    public ServicioHabitacionBuilder diasContratados(int diasContratados) {
        this.diasContratados = diasContratados;
        return this;
    }

    public ServicioHabitacion build() {

        return new ServicioHabitacion (diasContratados);
    }

}
