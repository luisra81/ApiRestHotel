package com.example.ApiRestHotel.Models;

import java.time.LocalDate;
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

public class Huesped {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idHuesped;
    private String nombre;
    private String apellido;
    private LocalDate fechaNacimiento;
    private String nacionalidad;
    private String telefono;

    // al eliminar un huesped se actualiza en cascada
    // un huesped puede tener muchas reservas
    @OneToMany(mappedBy = "huesped", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("huesped")
    private List<Reserva> reservas = new ArrayList<>();

    public Huesped() {
    }

    public Huesped(Long idHuesped, String nombre, String apellido, LocalDate fechaNacimiento, String nacionalidad, String telefono) {
        this.idHuesped = idHuesped;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.nacionalidad = nacionalidad;
        this.telefono = telefono;
    }
    
    public void newReserva(Reserva reserva){
        this.reservas.add(reserva);
        reserva.setHuesped(this);
    }
}
