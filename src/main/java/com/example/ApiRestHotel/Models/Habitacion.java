package com.example.ApiRestHotel.Models;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;


@Entity
@Data

public class Habitacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idHabitacion;
    private Integer numHabitacion;
    private String descripcion;

     // Una habitacion puede pertenecer a varias reservas, aunque no en la misma fecha
    @OneToMany(mappedBy = "habitacion", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("habitacion")

    private List<Reserva> reservas = new ArrayList<Reserva>();
     
    public Habitacion() {
    }

    public Habitacion(Integer numHabitacion, String descripcion) {
        this.numHabitacion = numHabitacion;
        this.descripcion = descripcion;
    }
    
    public void newReserva(Reserva reserva){
        this.reservas.add(reserva);
        reserva.setHabitacion(this);
    }
}

