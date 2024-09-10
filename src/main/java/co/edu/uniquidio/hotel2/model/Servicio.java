package co.edu.uniquidio.hotel2.model;
import co.edu.uniquidio.hotel2.services.IConsumible;
public abstract class Servicio implements IConsumible {
    private int diasContratados;

    @Override
    public abstract void consumir();

    public Servicio(int diasContratados) {
        this.diasContratados = diasContratados;
    }

    public int getDiasContratados() {
        return diasContratados;
    }

    @Override
    public String toString() {
        return "Servicio:" +
                "\nDias Contratados:" + diasContratados;
    }
}
