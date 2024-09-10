package co.edu.uniquidio.hotel2.factory;

import co.edu.uniquidio.hotel2.model.*;
import co.edu.uniquidio.hotel2.services.IClienteCrud;
import co.edu.uniquidio.hotel2.services.IHabitacionCrud;
import co.edu.uniquidio.hotel2.services.IReservaCrud;

import java.time.LocalDate;
import java.util.List;

public class ModelFactory implements IClienteCrud, IHabitacionCrud, IReservaCrud {
    private static ModelFactory modelFactory;
    private Hotel hotel;

    private ModelFactory() {
        inicializarDatos();
    }

    public static ModelFactory getInstance() {
        if (modelFactory == null) {
            modelFactory = new ModelFactory();
        }
        return modelFactory;
    }

    public void inicializarDatos() {
        hotel = Hotel.
                builder()
                .nombre("Sosua")
                .build();

        Cliente cliente1 = Cliente
                .builder()
                .nombre("Juan")
                .dni("1234")
                .build();


        Habitacion habitacion1 = Habitacion.
                builder()
                .tipoHabitacion(TipoHabitacion.SENCILLA)
                .numeroHabitacion(1)
                .build();

        Spa spa = Spa.builder()
                .diasContratados(3)
                .build();
        Restaurante restaurante = Restaurante
                .builder()
                .diasContratados(4)
                .build();

        habitacion1.getListaServicios().add(spa);
        habitacion1.getListaServicios().add(restaurante);

        LocalDate localDate = LocalDate.now();
        Reserva reserva1 = Reserva.
                builder().
                fechaEntrada(localDate)
                .fechaSalida(localDate.plusDays(4))
                .habitacion(habitacion1)
                .build();

        cliente1.getListaReservasActivas().add(reserva1);
        hotel.getListaClientes().add(cliente1);

        //segundo

        Cliente cliente2 = Cliente
                .builder()
                .nombre("steven")
                .dni("5678")
                .build();

        Habitacion habitacion2 = Habitacion
                .builder()
                .tipoHabitacion(TipoHabitacion.DOBLE)
                .numeroHabitacion(2)
                .build();

        Spa spa2 = Spa.builder()
                .diasContratados(1)
                .build();

        Restaurante restaurante2 = Restaurante
                .builder()
                .diasContratados(2)
                .build();

        habitacion2.getListaServicios().add(spa);
        habitacion2.getListaServicios().add(restaurante);


        Reserva reserva2 = Reserva.
                builder().
                fechaEntrada(localDate)
                .fechaSalida(localDate.plusDays(3))
                .habitacion(habitacion2)
                .build();

        cliente2.getListaReservasActivas().add(reserva2);

        hotel.getListaClientes().add(cliente2);
    }

//CRUD CLIENTE-------------------------------------------------------------------------------------
    @Override
    public boolean crearCliente(String nombre,
                                String dni) {
        return hotel.crearCliente(nombre, dni);
    }

    @Override
    public boolean eliminarCliente(String dni) {
        return hotel.eliminarCliente(dni);
    }

    @Override
    public boolean actualizarCliente(String nombre, String dniActual, String dniNueva) {
        return hotel.actualizarCliente(
                nombre, dniActual, dniNueva);
    }

    @Override
    public String obtenerDatosCliente(String dni) {
        return hotel.obtenerDatosCliente(dni);
    }


    public void imprimirListaClientes() {
        hotel.imprimirListaClientes();
    }
//CRUD HABITACION-----------------------------------------------------------------------------------
    @Override
    public boolean crearHabitacion(int numeroHabitacion, TipoHabitacion tipoHabitacion) {
        return hotel.crearHabitacion(numeroHabitacion, tipoHabitacion);
    }

    @Override
    public boolean eliminarHabitacion(int numeroHabitacion) {
        return hotel.eliminarHabitacion(numeroHabitacion);
    }

    @Override
    public boolean actualizarHabitacion(int numeroHabitacionActual, int numeroHabitacionNuevo, TipoHabitacion tipoHabitacion) {
        return hotel.actualizarHabitacion(numeroHabitacionActual, numeroHabitacionNuevo,tipoHabitacion);
    }

    @Override
    public String obtenerDatosHabitacion(int numeroHabitacion) {
        return hotel.obtenerDatosHabitacion(numeroHabitacion);
    }
//CRUD RESERVA-------------------------------------------------------------------------
    @Override
    public boolean crearReserva(LocalDate fechaEntrada, LocalDate fechaSalida) {
        return hotel.crearReserva(fechaEntrada,fechaSalida);
    }

    @Override
    public boolean eliminarReserva(LocalDate fechaEntrada) {
        return hotel.eliminarReserva(fechaEntrada);
    }

    @Override
    public boolean actualizarReserva(LocalDate fechaEntradaActual, LocalDate fechaEntradaNueva, LocalDate fechaSalida) {
        return hotel.actualizarReserva(fechaEntradaActual, fechaEntradaNueva,fechaSalida);
    }

    @Override
    public String obtenerDatosReserva(LocalDate fechaEntrada) {
        return hotel.obtenerDatosReserva(fechaEntrada);
    }
}
