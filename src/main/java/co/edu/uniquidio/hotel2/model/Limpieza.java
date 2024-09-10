package co.edu.uniquidio.hotel2.model;
import co.edu.uniquidio.hotel2.model.builder.LimpiezaBuilder;

public class Limpieza extends Servicio {
private final double precio=30.0;

    @Override
    public void consumir() {
        System.out.println("Servicio de Limpieza consumido");

    }

    public Limpieza(int diasContratados) {
        super(diasContratados);
    }

    public double getPrecio() {
        return precio;
    }

    public static LimpiezaBuilder builder(){
        return new LimpiezaBuilder();
    }

    @Override
    public String toString() {
        return "Limpieza" +
                "\nPrecio: $" + precio + super.toString();
    }
}
