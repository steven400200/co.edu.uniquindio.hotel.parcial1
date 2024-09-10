package co.edu.uniquidio.hotel2.model;

import co.edu.uniquidio.hotel2.model.builder.HotelBuilder;
import co.edu.uniquidio.hotel2.services.IClienteCrud;
import co.edu.uniquidio.hotel2.services.IHabitacionCrud;
import co.edu.uniquidio.hotel2.services.IReservaCrud;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Hotel implements IClienteCrud, IHabitacionCrud, IReservaCrud {

    private String nombre;

    public Hotel(String nombre) {
        this.nombre = nombre;
    }

    public static HotelBuilder builder() {
        return new HotelBuilder();
    }

    private List<Habitacion> listaHabitaciones = new ArrayList<>();
    private List<Reserva> listaReservas = new ArrayList<>();
    private List<Cliente> listaClientes = new ArrayList<>();
    private List<Servicio> listaServicios = new ArrayList<>();

    public String getNombre() {
        return nombre;
    }

    public List<Habitacion> getListaHabitaciones() {
        return listaHabitaciones;
    }

    public void setListaHabitaciones(List<Habitacion> listaHabitaciones) {
        this.listaHabitaciones = listaHabitaciones;
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


    //LOGICA DEL CRUD CLIENTE---------------------------------------------------------------------------
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
    public boolean eliminarCliente(String dni) {
        Cliente clienteExistente = obtenerCliente(dni);
        if (clienteExistente != null) {
            getListaClientes().remove(clienteExistente);
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
        System.out.println("Imprimiendo la lista de los clientes\n");

        for (Cliente cliente : listaClientes)
            System.out.println(cliente + " \n");

    }

    //LOGICA DEL CRUD HABITACION------------------------------------------------------------------------
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


    @Override
    public String obtenerDatosHabitacion(int numeroHabitacion) {
        Habitacion habitacionExistente = obtenerHabitacion(numeroHabitacion);
        if (habitacionExistente != null) {
            return habitacionExistente.toString();
        }
        return "";
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

    //LOGICA CRUD RESERVA---------------------------------------------------------------------------------
    @Override
    public boolean crearReserva(LocalDate fechaEntrada, LocalDate fechaSalida) {
        Reserva reservaExistente = obtenerReserva(fechaEntrada);
        if (reservaExistente == null) {
            reservaExistente = Reserva
                    .builder()
                    .fechaEntrada(fechaEntrada)
                    .fechaSalida(fechaSalida)
                    .build();
            getListaReservas().add(reservaExistente);
            return true;
        } else {
            return false;
        }
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
            return  reservaExistente.mostrarDatos();
        }
        return  "";
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
}

