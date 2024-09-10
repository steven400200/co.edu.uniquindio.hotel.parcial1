package co.edu.uniquidio.hotel2.model.builder;
import co.edu.uniquidio.hotel2.model.Cliente;

public class ClienteBuilder {
    protected String nombre;
    protected String dni;

    public ClienteBuilder nombre(String nombre) {
        this.nombre = nombre;
        return this;
    }
    public ClienteBuilder dni(String dni) {
        this.dni = dni;
        return this;
    }

    public Cliente build() {
        return new Cliente (nombre,dni);
    }

}
