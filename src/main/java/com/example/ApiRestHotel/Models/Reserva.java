package com.example.ApiRestHotel.Models;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data

public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReserva;
    private LocalDate fechaEntrada;
    private LocalDate fechaSalida;
    private Double valor;
    private String formaPago;

     //muchas reservas pueden pertenecer a un cliente
     @ManyToOne
     @JoinColumn
     @JsonIgnoreProperties("reservas")
     private Huesped huesped;
 
     //muchas reservas pueden ser a la misma habitacion
     @ManyToOne
     @JoinColumn
     @JsonIgnoreProperties("reservas")
     private Habitacion habitacion;

}
