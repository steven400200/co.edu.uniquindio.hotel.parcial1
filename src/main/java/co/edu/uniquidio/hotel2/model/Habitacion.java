package co.edu.uniquidio.hotel2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Habitacion {
    private int numero;
    private double precio;
    List <Servicio> listaServicios =new ArrayList<>();

}
