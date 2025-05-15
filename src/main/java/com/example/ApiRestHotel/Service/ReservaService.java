package com.example.ApiRestHotel.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ApiRestHotel.Models.Habitacion;
import com.example.ApiRestHotel.Models.Huesped;
import com.example.ApiRestHotel.Models.Reserva;
import com.example.ApiRestHotel.Repository.ReservaRepository;

@Service
public class ReservaService {
    @Autowired
    private ReservaRepository reservaRepository;

@Autowired
private HuespedService huespedService;

@Autowired
private HabitacionService habitacionService;

    //metodo que muestra todos las reservas
    public List<Reserva> getAllReserva(){
        return reservaRepository.findAll();
    }

    // crear una reserva.
    public  Reserva createReserva(Reserva reserva){
        Huesped huesped = huespedService.getHuespedId(reserva.getHuesped().getIdHuesped());
        Habitacion habitacion = habitacionService.getHabitacionId(reserva.getHabitacion().getIdHabitacion());
        huesped.newReserva(reserva);
        habitacion.newReserva(reserva);
        return reservaRepository.save(reserva);
    }

    public  Reserva updateReserva(Reserva reserva){
        return reservaRepository.save(reserva);
    }

    public void deleteReservaById(Long id){
        reservaRepository.deleteById(id);
    }
}
