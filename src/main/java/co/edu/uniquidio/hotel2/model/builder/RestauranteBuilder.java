package co.edu.uniquidio.hotel2.model.builder;
import co.edu.uniquidio.hotel2.model.Restaurante;

public class RestauranteBuilder {
    protected int diasContratados;


    public RestauranteBuilder diasContratados(int diasContratados) {
        this.diasContratados = diasContratados;
        return this;
    }

    public Restaurante build() {

        return new Restaurante (diasContratados);
    }

}
