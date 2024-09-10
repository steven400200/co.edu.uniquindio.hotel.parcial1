package co.edu.uniquidio.hotel2.model.builder;

import co.edu.uniquidio.hotel2.model.Cliente;
import co.edu.uniquidio.hotel2.model.Limpieza;

public class LimpiezaBuilder {


    protected int diasContratados;


    public LimpiezaBuilder diasContratados(int diasContratados) {
        this.diasContratados = diasContratados;
        return this; // Devuelve la instancia actual de ClienteBuilder
    }

    public Limpieza build() {

        return new Limpieza (diasContratados);
    }

}
