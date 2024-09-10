package co.edu.uniquidio.hotel2.model.builder;

import co.edu.uniquidio.hotel2.model.Hotel;
import co.edu.uniquidio.hotel2.model.Limpieza;

public class HotelBuilder {

    protected  String nombre;


    public HotelBuilder nombre(String nombre) {
        this.nombre = nombre;
        return this; // Devuelve la instancia actual de ClienteBuilder
    }

    public Hotel build() {

        return new Hotel (nombre);
    }
}
