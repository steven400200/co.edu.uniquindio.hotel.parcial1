package co.edu.uniquidio.hotel2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Cliente {
    private  String nombre, dni;
    List<Reserva> listaReservasActivas=new ArrayList<>();
}
