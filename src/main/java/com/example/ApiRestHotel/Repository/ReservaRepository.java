package com.example.ApiRestHotel.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ApiRestHotel.Models.Reserva;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {

}
