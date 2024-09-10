package co.edu.uniquidio.hotel2.model.builder;
import co.edu.uniquidio.hotel2.model.Cliente;

public class ClienteBuilder {
    protected String nombre;
    protected String dni;

    public ClienteBuilder nombre(String nombre) {
        this.nombre = nombre;
        return this; // Devuelve la instancia actual de ClienteBuilder
    }
    public ClienteBuilder dni(String dni) {
        this.dni = dni;
        return this; // Devuelve la instancia actual de ClienteBuilder
    }

    public Cliente build() {
        return new Cliente (nombre,dni);
    }

}
