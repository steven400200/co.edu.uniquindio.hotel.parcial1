package co.edu.uniquidio.hotel2.model;
import co.edu.uniquidio.hotel2.model.builder.HabitacionBuilder;

import java.util.ArrayList;
import java.util.List;

public class Habitacion {
    private int numeroHabitacion;
    TipoHabitacion tipoHabitacion;
    List <Servicio> listaServicios =new ArrayList<>();


    public Habitacion(int numeroHabitacion,TipoHabitacion tipoHabitacion, List<Servicio> listaServicios) {
        this.numeroHabitacion = numeroHabitacion;
        this.tipoHabitacion=tipoHabitacion;
        this.listaServicios = listaServicios;
    }
    public Habitacion(int numeroHabitacion,TipoHabitacion tipoHabitacion) {
        this.numeroHabitacion=numeroHabitacion;
        this.tipoHabitacion=tipoHabitacion;
    }
    public static HabitacionBuilder builder(){
        return new HabitacionBuilder();
    }

    public int getNumeroHabitacion() {
        return numeroHabitacion;
    }

    public List<Servicio> getListaServicios() {
        return listaServicios;
    }

    @Override
    public String toString() {
        return "\nnumero de Habitacion: " + numeroHabitacion +
                " ,tipo de Habitacion: " + tipoHabitacion +
                " \nLista de Servicios incluidos: " + listaServicios;
    }
    public String mostrarDato(){
        return "Habitacion: "+"numero de habitacion"+numeroHabitacion+
                "\nTipo de habitacion"+tipoHabitacion+listaServicios;
    }
}
