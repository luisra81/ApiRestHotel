package com.example.ApiRestHotel.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ApiRestHotel.Models.Huesped;
import com.example.ApiRestHotel.Repository.HuespedRepository;

@Service
//crear,obtner,eliminar,mostar
public class HuespedService {
    //injecta de manera resumida nuestro huesped repository
    @Autowired
    private HuespedRepository huespedRepository;

    //metodo que muestra todos los huespedes
    public List<Huesped> getAllHuespedes(){
        return huespedRepository.findAll();
    }

    //metodo que llamamos al crear una nueva reserva
    public Huesped getHuespedId(Long id){
        return huespedRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Huesped no existe"));
    }

    // crear un huesped.
    public  Huesped createHuesped(Huesped huesped){
        return huespedRepository.save(huesped);
    }
    
    public  Huesped updateHuesped(Huesped huesped){
        return huespedRepository.save(huesped);
    }

    public void deleteHuespedById(Long id){
        huespedRepository.deleteById(id);
    }

}
