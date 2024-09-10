package co.edu.uniquidio.hotel2.model;
import co.edu.uniquidio.hotel2.model.builder.RestauranteBuilder;
public class Restaurante extends Servicio{
    static final double precio=40.0;

    public Restaurante(int diasContratados) {
        super(diasContratados);
    }
    public double getPrecio() {return precio;}

    @Override
    public void consumir() {
        System.out.println("Servicio de restaurante consumido");

    }

    public static RestauranteBuilder builder(){
        return new RestauranteBuilder();
    }

    @Override
    public String toString() {
        return "Restaurante:" +
                "\nPrecio: $" + precio +super.toString();
    }

    @Override
    public String mostarTipo() {
        return "restaurante";
    }


}
