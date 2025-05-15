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

import com.example.ApiRestHotel.Models.Huesped;
import com.example.ApiRestHotel.Service.HuespedService;

// define el conpostamiento de nuestros endpoints y nuestras rutas

@RestController
@RequestMapping("huesped")
public class HuespedController {
     //hacemos la inyeccion
     @Autowired
     private HuespedService huespedService;

    //GET
    @GetMapping("/all")
    public List<Huesped> listarTodo(){
        return  huespedService.getAllHuespedes();
    }
    //POST
    @PostMapping("/create")
    public Huesped crearHuesped(@RequestBody Huesped huesped){
        return huespedService.createHuesped(huesped);
    }

    //PUT
    @PutMapping("update/{id}")
    public Huesped actualizar(@RequestBody Huesped huesped, @PathVariable Long id){
        huesped.setIdHuesped(id);
        return  huespedService.updateHuesped(huesped);
    }
    
    @DeleteMapping("delete/{id}")
    public void eliminar(@PathVariable Long id){
        huespedService.deleteHuespedById(id);
    }

}
