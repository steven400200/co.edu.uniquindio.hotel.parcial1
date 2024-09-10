package co.edu.uniquidio.hotel2.services;

public interface IConsultaServices {
    int contarReservasCliente(String dni);
    double totalServicioHabitacion(int numeroHabitacion);
    int totalClientesHotel();

}
