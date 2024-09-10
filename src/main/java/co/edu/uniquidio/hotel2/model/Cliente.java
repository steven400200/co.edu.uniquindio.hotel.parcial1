package co.edu.uniquidio.hotel2.model;
import co.edu.uniquidio.hotel2.model.builder.ClienteBuilder;

import java.util.ArrayList;
import java.util.List;


public class Cliente {
    private  String nombre;
    private  String dni;
    List<Reserva> listaReservasActivas=new ArrayList<>();

    public Cliente(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
    }
    public Cliente(String nombre, String dni, List<Reserva> listaReservasActivas) {
        this.nombre = nombre;
        this.dni = dni;
        this.listaReservasActivas = listaReservasActivas;
    }

    public static ClienteBuilder builder(){
        return new ClienteBuilder();
    }

    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
    }

    public List<Reserva> getListaReservasActivas() {
        return listaReservasActivas;
    }

    @Override
    public String toString() {
        return
                "Nombre del cliente: " + nombre  +
                " ,identificacion: " + dni  +
                "\nReservas activas:" + listaReservasActivas ;
    }

    public String mostraInfo() {
        return
                "Nombre: " + nombre  +
                        "\nIdentificación: " + dni  ;
    }
}
