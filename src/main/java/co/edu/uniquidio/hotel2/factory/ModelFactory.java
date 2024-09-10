package co.edu.uniquidio.hotel2.factory;
import co.edu.uniquidio.hotel2.model.*;
import co.edu.uniquidio.hotel2.services.IClienteCrud;
import co.edu.uniquidio.hotel2.services.IConsultaServices;
import co.edu.uniquidio.hotel2.services.IHabitacionCrud;
import co.edu.uniquidio.hotel2.services.IReservaCrud;
import java.time.LocalDate;

public class ModelFactory implements IClienteCrud, IHabitacionCrud, IReservaCrud, IConsultaServices {
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
        //1 CLIENTE CON 2 RESERVAS
        Cliente cliente1 = Cliente
                .builder()
                .nombre("Juan")
                .dni("123")
                .build();

        Habitacion habitacion1 = Habitacion.
                builder()
                .tipoHabitacion(TipoHabitacion.SENCILLA)
                .numeroHabitacion(1)
                .build();
        Habitacion habitacion2 = Habitacion.
                builder()
                .tipoHabitacion(TipoHabitacion.SUITE)
                .numeroHabitacion(6)
                .build();

        Spa spa1 = Spa.builder()
                .diasContratados(3)
                .build();
        Restaurante restaurante1 = Restaurante
                .builder()
                .diasContratados(4)
                .build();
        Limpieza limpieza2 = Limpieza
                .builder()
                .diasContratados(6)
                .build();

        Restaurante restaurante2 = Restaurante
                .builder()
                .diasContratados(6)
                .build();

        habitacion1.getListaServicios().add(spa1);
        habitacion1.getListaServicios().add(restaurante1);
        habitacion2.getListaServicios().add(limpieza2);
        habitacion2.getListaServicios().add(restaurante2);
        hotel.getListaHabitaciones().add(habitacion1);
        hotel.getListaHabitaciones().add(habitacion2);

        LocalDate localDate = LocalDate.now();
        Reserva reserva1 = Reserva.
                builder().
                fechaEntrada(localDate)
                .fechaSalida(localDate.plusDays(4))
                .habitacion(habitacion1)
                .build();
        Reserva reserva2 = Reserva.
                builder().
                fechaEntrada(localDate)
                .fechaSalida(localDate.plusDays(6))
                .habitacion(habitacion2)
                .build();

        cliente1.getListaReservasActivas().add(reserva1);
        cliente1.getListaReservasActivas().add(reserva2);

        hotel.getListaClientes().add(cliente1);
        hotel.getListaReservas().add(reserva1);
        hotel.getListaReservas().add(reserva2);

        // CLIENTE 2 CON 1 RESERVA
        Cliente cliente2 = Cliente
                .builder()
                .nombre("steven")
                .dni("5678")
                .build();

        Habitacion habitacion3 = Habitacion
                .builder()
                .tipoHabitacion(TipoHabitacion.DOBLE)
                .numeroHabitacion(2)
                .build();

        Spa spa3 = Spa.builder()
                .diasContratados(1)
                .build();

        Restaurante restaurante3 = Restaurante
                .builder()
                .diasContratados(2)
                .build();

        habitacion3.getListaServicios().add(spa3);
        habitacion3.getListaServicios().add(restaurante3);
        hotel.getListaHabitaciones().add(habitacion3);

        Reserva reserva3 = Reserva.
                builder().
                fechaEntrada(localDate)
                .fechaSalida(localDate.plusDays(3))
                .habitacion(habitacion2)
                .build();

        cliente2.getListaReservasActivas().add(reserva3);
        hotel.getListaClientes().add(cliente2);
        hotel.getListaReservas().add(reserva3);
    }

    //CRUD CLIENTE
    @Override
    public boolean crearCliente(String nombre,
                                String dni) {
        return hotel.crearCliente(nombre, dni);
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
    @Override
    public boolean eliminarCliente(String dni) {
        return hotel.eliminarCliente(dni);
    }

    public void imprimirListaClientes() {
        hotel.imprimirListaClientes();
    }

    //CRUD HABITACION
    @Override
    public boolean crearHabitacion(int numeroHabitacion, TipoHabitacion tipoHabitacion) {
        return hotel.crearHabitacion(numeroHabitacion, tipoHabitacion);
    }
    @Override
    public boolean actualizarHabitacion(int numeroHabitacionActual, int numeroHabitacionNuevo, TipoHabitacion tipoHabitacion) {
        return hotel.actualizarHabitacion(numeroHabitacionActual, numeroHabitacionNuevo, tipoHabitacion);
    }
    @Override
    public String obtenerDatosHabitacion(int numeroHabitacion) {
        return hotel.obtenerDatosHabitacion(numeroHabitacion);
    }
    @Override
    public boolean eliminarHabitacion(int numeroHabitacion) {
        return hotel.eliminarHabitacion(numeroHabitacion);
    }

    //CRUD RESERVA
    @Override
    public boolean crearReserva(LocalDate fechaEntrada, LocalDate fechaSalida) {
        return hotel.crearReserva(fechaEntrada, fechaSalida);
    }
    @Override
    public boolean actualizarReserva(LocalDate fechaEntradaActual, LocalDate fechaEntradaNueva, LocalDate fechaSalida) {
        return hotel.actualizarReserva(fechaEntradaActual, fechaEntradaNueva, fechaSalida);
    }
    @Override
    public String obtenerDatosReserva(LocalDate fechaEntrada) {
        return hotel.obtenerDatosReserva(fechaEntrada);
    }
    @Override
    public boolean eliminarReserva(LocalDate fechaEntrada) {
        return hotel.eliminarReserva(fechaEntrada);
    }
    //FUNCIONALIDADES DEL HOTEL
    @Override
    public int contarReservasCliente(String dni) {
        return hotel.contarReservasCliente(dni);
    }
    @Override
    public double totalServicioHabitacion(int numeroHabitacion) {
        return hotel.totalServicioHabitacion(numeroHabitacion);
    }
    @Override
    public int totalClientesHotel() {
        return hotel.totalClientesHotel();
    }
}
