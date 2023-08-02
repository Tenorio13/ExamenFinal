package com.tenorio.utvt.controllers;

import com.tenorio.utvt.entities.Luis;
import com.tenorio.utvt.services.LuisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public class LuisController {
    private final LuisService luisService;

    @Autowired
    public LuisController(LuisService luisService) {
        this.luisService = luisService;
    }

    @PostMapping
    public Luis guardarAlumno(@RequestBody Luis luis){
        return luisService.guardarAlumno(luis);
    }

    @GetMapping
    public List<Luis> obtenerTodosLosAlumnos(){
        return luisService.obtenerTodosLosAlumnos();
    }

    @PutMapping("/{id")
    public Optional<Luis> buscarAlumnoporId(@PathVariable Long id){
        return luisService.buscarAlumnosporId(id);
    }

    @DeleteMapping("/{id}")
    public void eliminarAlumnoPorId(@PathVariable Long id){
        luisService.eliminarAlumnoPorId(id);
    }
}
