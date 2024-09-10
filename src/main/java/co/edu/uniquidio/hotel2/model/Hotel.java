package co.edu.uniquidio.hotel2.model;
import co.edu.uniquidio.hotel2.model.builder.HotelBuilder;
import co.edu.uniquidio.hotel2.services.IClienteCrud;
import co.edu.uniquidio.hotel2.services.IConsultaServices;
import co.edu.uniquidio.hotel2.services.IHabitacionCrud;
import co.edu.uniquidio.hotel2.services.IReservaCrud;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Hotel implements IClienteCrud, IHabitacionCrud, IReservaCrud, IConsultaServices {
    private String nombre;

    public Hotel(String nombre) {
        this.nombre = nombre;
    }
    private List<Habitacion> listaHabitaciones = new ArrayList<>();
    private List<Reserva> listaReservas = new ArrayList<>();
    private List<Cliente> listaClientes = new ArrayList<>();
    private List<Servicio> listaServicios = new ArrayList<>();

    public static HotelBuilder builder() {
        return new HotelBuilder();
    }

    public String getNombre() {
        return nombre;
    }

    public List<Habitacion> getListaHabitaciones() {
        return listaHabitaciones;
    }

    public List<Reserva> getListaReservas() {
        return listaReservas;
    }

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

    public List<Servicio> getListaServicios() {
        return listaServicios;
    }

    //LOGICA DEL CRUD CLIENTE
    @Override
    public boolean crearCliente(String nombre, String dni) {
        Cliente clienteExistente = obtenerCliente(dni);
        if (clienteExistente == null) {
            Cliente cliente = Cliente.builder()
                    .nombre(nombre)
                    .dni(dni).
                    build();
            getListaClientes().add(cliente);
            return true;
        } else {
            return false;
        }
    }
    @Override
    public boolean actualizarCliente(String nombre, String dniActual, String dniNueva) {
        Cliente clienteExistente = obtenerCliente(dniActual);
        if (clienteExistente != null) {
            Cliente clienteActualizado = Cliente.builder().nombre(nombre).dni(dniNueva).build();
            listaClientes.add(clienteActualizado);
            listaClientes.remove(clienteExistente);
            return true;
        } else {
            return false;
        }
    }
    @Override
    public String obtenerDatosCliente(String dni) {
        Cliente clienteExistente = obtenerCliente(dni);
        if (clienteExistente != null) {
            return clienteExistente.mostraInfo();
        }
        return "";
    }
    @Override
    public boolean eliminarCliente(String dni) {
        Cliente clienteExistente = obtenerCliente(dni);
        if (clienteExistente != null) {
            getListaClientes().remove(clienteExistente);
            return true;
        } else {
            return false;
        }
    }

    private Cliente obtenerCliente(String dni) {
        Cliente clienteExistente = null;
        for (Cliente cliente : getListaClientes()) {
            if (cliente.getDni().equals(dni)) {
                clienteExistente = cliente;
                break;
            }
        }
        return clienteExistente;

    }
    public void imprimirListaClientes() {
        System.out.println("Lista de clientes:\n");
        for (Cliente cliente : listaClientes)
            System.out.println(cliente + " \n");

    }

    //LOGICA DEL CRUD HABITACION
    @Override
    public boolean crearHabitacion(int numeroHabitacion, TipoHabitacion tipoHabitacion) {
        Habitacion habitacionExistente = obtenerHabitacion(numeroHabitacion);
        if (habitacionExistente == null) {
            Habitacion habitacion = Habitacion
                    .builder()
                    .numeroHabitacion(numeroHabitacion)
                    .tipoHabitacion(tipoHabitacion)
                    .build();
            getListaHabitaciones().add(habitacion);
            return true;
        } else {
            return false;
        }
    }
    @Override
    public boolean actualizarHabitacion(int numeroHabitacionActual, int numeroHabitacionNuevo, TipoHabitacion tipoHabitacion) {
        Habitacion habitacionExistente = obtenerHabitacion(numeroHabitacionActual);
        if (habitacionExistente != null) {
            Habitacion habitacionActualizada = Habitacion
                    .builder()
                    .numeroHabitacion(numeroHabitacionNuevo)
                    .tipoHabitacion(tipoHabitacion)
                    .build();
            listaHabitaciones.add(habitacionActualizada);
            listaHabitaciones.remove(habitacionExistente);
            return true;
        } else {
            return false;
        }
    }
    private Habitacion obtenerHabitacion(int numeroHabitacion) {
        Habitacion habitacionExistente = null;
        for (Habitacion habitacion : getListaHabitaciones()) {
            if (habitacion.getNumeroHabitacion() == numeroHabitacion) {
                habitacionExistente = habitacion;
                break;
            }
        }
        return habitacionExistente;

    }
    @Override
    public boolean eliminarHabitacion(int numeroHabitacion) {
        Habitacion habitacionExistente = obtenerHabitacion(numeroHabitacion);
        if (habitacionExistente != null) {
            getListaHabitaciones().remove(habitacionExistente);
            return true;
        } else {
            return false;
        }
    }
    @Override
    public String obtenerDatosHabitacion(int numeroHabitacion) {
        Habitacion habitacionExistente = obtenerHabitacion(numeroHabitacion);
        if (habitacionExistente != null) {
            return habitacionExistente.toString();
        }
        return "";
    }

    //LOGICA CRUD RESERVA
    @Override
    public boolean crearReserva(LocalDate fechaEntrada, LocalDate fechaSalida) {
        Reserva reservaExistente = obtenerReserva(fechaEntrada);
        if (reservaExistente == null) {
            Reserva reserva = Reserva
                    .builder()
                    .fechaEntrada(fechaEntrada)
                    .fechaSalida(fechaSalida)
                    .build();
            getListaReservas().add(reserva);
            return true;
        } else {
            return false;
        }
    }
    @Override
    public boolean actualizarReserva(LocalDate fechaEntradaActual, LocalDate fechaEntradaNueva, LocalDate fechaSalida) {
        Reserva reservaExistente = obtenerReserva(fechaEntradaActual);
        if (reservaExistente != null) {
            Reserva reservaActualizada = Reserva
                    .builder()
                    .fechaEntrada(fechaEntradaNueva)
                    .fechaSalida(fechaSalida)
                    .build();
            getListaReservas().add(reservaActualizada);
            getListaReservas().remove(reservaExistente);
            return true;
        } else {
            return false;
        }
    }
    @Override
    public String obtenerDatosReserva(LocalDate fechaEntrada) {
        Reserva reservaExistente = obtenerReserva(fechaEntrada);
        if (reservaExistente != null) {
            return reservaExistente.mostrarDatos();
        }
        return "";
    }
    @Override
    public boolean eliminarReserva(LocalDate fechaEntrada) {
        Reserva reservaExistente = obtenerReserva(fechaEntrada);
        if (reservaExistente != null) {
            getListaReservas().remove(reservaExistente);
            return true;
        } else {
            return false;
        }
    }

    private Reserva obtenerReserva(LocalDate fechaEntrada) {
        Reserva reservaExistente = null;
        for (Reserva reserva : getListaReservas()) {
            if (reserva.getFechaEntrada().isEqual(fechaEntrada)) {
                reservaExistente = reserva;
                break;
            }
        }
        return reservaExistente;

    }
//LOGICA FUNCIONALIDADES
    @Override
    public int contarReservasCliente(String dni) {

        Cliente cliente = obtenerCliente(dni);
        if (cliente != null)
            return cliente.getListaReservasActivas().size();
        else
            return 0;

    }
    @Override
    public double totalServicioHabitacion(int numeroHabitacion) {
        double total = 0;
        Habitacion habitacion = obtenerHabitacion(numeroHabitacion);
        if (habitacion != null) {
            for (Servicio servicio : habitacion.getListaServicios()) {

                if (servicio.mostarTipo().equals("spa")) {
                    total += servicio.getDiasContratados() * Spa.precio;
                } else if (servicio.mostarTipo().equals("restaurante")) {
                    total += servicio.getDiasContratados() * Restaurante.precio;
                } else if (servicio.mostarTipo().equals("limpieza")) {
                    total += servicio.getDiasContratados() * Limpieza.precio;
                }

            }
        }
        return total;
    }

    @Override
    public int totalClientesHotel() {
        return listaClientes.size();
    }


}

