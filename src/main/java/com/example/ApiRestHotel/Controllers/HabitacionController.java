package com.example.ApiRestHotel.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ApiRestHotel.Models.Habitacion;
import com.example.ApiRestHotel.Service.HabitacionService;

@RestController
@RequestMapping("habitacion")
public class HabitacionController {

    @Autowired
    HabitacionService habitacionService;

    @GetMapping("/all")
    public List<Habitacion> getAllHabitaciones(){
        return habitacionService.getAllHabitaciones();
    }

    @PostMapping("/create")
    public Habitacion createHabitacion(@RequestBody Habitacion habitacion){
        return habitacionService.createHabitacion(habitacion);
    }

    @PutMapping("/update/{id}")
    public Habitacion updateHabitacion(@RequestBody Habitacion habitacion, @PathVariable Long id){
        habitacion.setIdHabitacion(id);
        return habitacionService.updateHabitacion(habitacion);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteHabitacion(@PathVariable Long id){
        habitacionService.deleteHabitacion(id);
    }

}
