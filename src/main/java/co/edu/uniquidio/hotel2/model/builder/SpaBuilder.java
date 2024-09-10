package co.edu.uniquidio.hotel2.model.builder;

import co.edu.uniquidio.hotel2.model.Restaurante;
import co.edu.uniquidio.hotel2.model.Spa;

public class SpaBuilder {


    protected int diasContratados;


    public SpaBuilder diasContratados(int diasContratados) {
        this.diasContratados = diasContratados;
        return this; // Devuelve la instancia actual de ClienteBuilder
    }

    public Spa build() {

        return new Spa (diasContratados);
    }

}
