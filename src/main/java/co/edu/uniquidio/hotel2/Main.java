package co.edu.uniquidio.hotel2;
import co.edu.uniquidio.hotel2.factory.ModelFactory;
import co.edu.uniquidio.hotel2.model.TipoHabitacion;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        ModelFactory modelFactory = ModelFactory.getInstance();
        imprimirListaClientes(modelFactory);
        contarReservasCliente(modelFactory);
        totalServicioHabitacion(modelFactory);
        totalClientesHotel(modelFactory);
        crudCliente(modelFactory);
        crudHabitacion(modelFactory);
        crudReserva(modelFactory);


    }
//FUNCIONALIDADES
    private static void totalClientesHotel(ModelFactory modelFactory) {
        int resultado= modelFactory.totalClientesHotel();
        System.out.println("\nEl numero total de clientes hospedados en el hotel son: "+resultado);
    }
    private static void totalServicioHabitacion(ModelFactory modelFactory) {
        int numeroHabitacion=6;
        double resultado =modelFactory.totalServicioHabitacion(numeroHabitacion);
        System.out.println("\n El total de los servicios contratados de la habitacion: "
                + numeroHabitacion + " es " + resultado);
    }
    private static void contarReservasCliente(ModelFactory modelFactory) {
        String dni ="123";
        int resultado = modelFactory.contarReservasCliente(dni);

        System.out.println("\nNumero de reservas activas del cliente es: "+ resultado);
    }
//CRUD RESERVA
    private static void crudReserva(ModelFactory modelFactory) {
        crearReserva(modelFactory);
        actualizarReserva(modelFactory);
        obtenerDatosReserva(modelFactory);
        eliminarReserva(modelFactory);
    }
    private static void crearReserva(ModelFactory modelFactory) {
        LocalDate fechaEntrada= LocalDate.now();
        LocalDate fechaSalida= fechaEntrada.plusDays(5);
        Boolean resultado =modelFactory.crearReserva(fechaEntrada,fechaSalida);
        notificacionReserva(resultado,"creada");
    }
    private static void actualizarReserva(ModelFactory modelFactory) {
        LocalDate fechaEntradaActual= LocalDate.now();
        LocalDate fechaEntradaNueva= LocalDate.of(2024,9,15);
        LocalDate fechaSalida= fechaEntradaNueva.plusDays(5);
        Boolean resultado =modelFactory.actualizarReserva(fechaEntradaActual,fechaEntradaNueva,fechaSalida);
        notificacionReserva(resultado,"actualizada");
    }
    private static void obtenerDatosReserva(ModelFactory modelFactory) {

        LocalDate fechaEntrada = LocalDate.of(2024,9,15);
        String resultado= modelFactory.obtenerDatosReserva(fechaEntrada);
        System.out.println("informacion de la reserva: "+resultado);
    }
    private static void eliminarReserva(ModelFactory modelFactory) {
        LocalDate fechaEntrada = LocalDate.of(2024,9,15);
        boolean resultado= modelFactory.eliminarReserva(fechaEntrada);
        notificacionReserva(resultado, "eliminada");
    }
    private static void notificacionReserva(Boolean resultado, String mensaje) {
        if (resultado)
            System.out.println("Reserva  " + mensaje + " corectamente");
        else
            System.out.println("Reserva No " + mensaje);
    }

    //CRUD HABITACION
    private static void crudHabitacion(ModelFactory modelFactory) {
        crearHabitacion(modelFactory);
        actualizarHabitacion(modelFactory);
        obtenerDatosHabitacion(modelFactory);
        eliminarHabitacion(modelFactory);
    }
    private static void crearHabitacion(ModelFactory modelFactory) {
        int numeroHabitacion=3;
        TipoHabitacion tipohabitacion=TipoHabitacion.SENCILLA;
        boolean resultado= modelFactory.crearHabitacion(numeroHabitacion,tipohabitacion);
        notificacionHabitacion(resultado,"creada");
    }
    private static void actualizarHabitacion(ModelFactory modelFactory) {
        int numeroHabitacionActual=3;
        int numeroHabitacionNuevo=4;
        TipoHabitacion tipoHabitacion=TipoHabitacion.DOBLE;
        boolean resultado= modelFactory.actualizarHabitacion(numeroHabitacionActual, numeroHabitacionNuevo,tipoHabitacion);
        notificacionHabitacion(resultado,"Actualizada");
    }
    private static void obtenerDatosHabitacion(ModelFactory modelFactory) {
        int numeroHabitacion=4;
        String resultado= modelFactory.obtenerDatosHabitacion(numeroHabitacion);
        System.out.println("informacion de la habitacion"+resultado);
    }
    private static void eliminarHabitacion(ModelFactory modelFactory) {
        int numeroHabitacion=4;
        boolean resultado= modelFactory.eliminarHabitacion(numeroHabitacion);
        notificacionHabitacion(resultado, "eliminada");
    }
    private static void notificacionHabitacion(boolean resultado, String mensaje) {
        if (resultado)
            System.out.println("Habitacion " + mensaje + " corectamente");
        else
            System.out.println("Habitacion No " + mensaje);
    }
//CRUD CLIENTE
    private static void crudCliente(ModelFactory modelFactory) {
        crearCliente(modelFactory);
        actualizarCliente(modelFactory);
        obtenerDatosCliente(modelFactory);
        eliminarCliente(modelFactory);
    }
    private static void crearCliente(ModelFactory modelFactory) {
        String nombre = "yeral";
        String dni = "12345678";
        boolean resultado = modelFactory.crearCliente(nombre, dni);
        notificacionCliente(resultado, "creado");
    }
    private static void actualizarCliente(ModelFactory modelFactory) {
        String nombre = "Yeraldin noguera";
        String dniActual = "12345678";
        String dniNueva = "123459699";
        boolean resultado = modelFactory.actualizarCliente(nombre, dniActual, dniNueva);
        notificacionCliente(resultado, "actualizado");
    }
    private static void obtenerDatosCliente(ModelFactory modelFactory) {
        String  dni ="123459699";
        String resultado =modelFactory.obtenerDatosCliente(dni);
        System.out.println("informacion del cliente: "+ resultado);
    }
    private static void eliminarCliente(ModelFactory modelFactory) {
        String dni = "123459699";
        boolean resultado = modelFactory.eliminarCliente(dni);
        notificacionCliente(resultado, "eliminado");
    }
    private static void notificacionCliente(boolean resultado, String mensaje) {
        if (resultado)
            System.out.println("Cliente " + mensaje + " corectamente");
        else
            System.out.println("Cliente No " + mensaje);
    }

    private static void imprimirListaClientes(ModelFactory modelFactory) {
        modelFactory.imprimirListaClientes();
    }
}