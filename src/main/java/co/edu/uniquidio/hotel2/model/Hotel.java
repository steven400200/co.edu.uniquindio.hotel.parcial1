package co.edu.uniquidio.hotel2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Hotel {
    private  String nombre;
    List <Habitacion>listaHabitaciones=new ArrayList<>();
    List <Reserva>listaReservas=new ArrayList<>();
    List <Cliente>listaClientes=new ArrayList<>();
    List <Servicio>listaServicios=new ArrayList<>();
}
