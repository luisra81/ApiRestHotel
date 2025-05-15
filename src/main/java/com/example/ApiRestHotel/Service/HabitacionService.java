package com.example.ApiRestHotel.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ApiRestHotel.Models.Habitacion;
import com.example.ApiRestHotel.Repository.HabitacionRepository;

@Service
public class HabitacionService {
@Autowired
    private HabitacionRepository habitacionRepository;
    
    //metodo para mostrar habitaciones
    public List<Habitacion> getAllHabitaciones(){
        return habitacionRepository.findAll();
    }

    //metodo que llamamos al crear una reserva
    public Habitacion getHabitacionId(Long id){
        return habitacionRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Habitacion no existe"));

    }

    //metodo para insertar habitacion
    public Habitacion createHabitacion(Habitacion habitacion){
        return habitacionRepository.save(habitacion);
    }

    //metodo para actualizar una habitacion
    public Habitacion updateHabitacion(Habitacion habitacion){
        return habitacionRepository.save(habitacion);
    }

    //metodo para eliminar habitacion
    public void deleteHabitacion(Long id){
        habitacionRepository.deleteById(id);
    }

}
