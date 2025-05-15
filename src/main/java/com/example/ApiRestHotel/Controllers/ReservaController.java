package com.example.ApiRestHotel.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ApiRestHotel.Models.Reserva;
import com.example.ApiRestHotel.Service.ReservaService;

@RestController
@RequestMapping("reserva")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @GetMapping("/all")
    public List<Reserva> getAllReservas(){
        return reservaService.getAllReserva();
    }

    @PostMapping("/create")
    public Reserva createReserva(@RequestBody Reserva reserva){
        return reservaService.createReserva(reserva);
    }

    @PutMapping("/update/{id}")
    public Reserva updateReserva(@PathVariable Long id, @RequestBody Reserva reserva) {
        reserva.setIdReserva(id);
        return reservaService.updateReserva(reserva);
    }
    
    @DeleteMapping("/delete/{id}")
    public void deleteReserva(@PathVariable Long id){
        reservaService.deleteReservaById(id);
    }

    @PostMapping("/createe")
    public ResponseEntity<Reserva> createeReserva(@RequestBody Reserva reserva) {
        try {
            Reserva savedReserva = reservaService.createReserva(reserva);
            return ResponseEntity.ok(savedReserva);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
