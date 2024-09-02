package co.edu.uniquidio.hotel2.model;

public class Spa extends Servicio{
    @Override
    public void consumir() {
        System.out.println("Servicio de spa consumido");
    }
}
