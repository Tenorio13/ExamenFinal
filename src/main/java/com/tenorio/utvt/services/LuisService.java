package com.tenorio.utvt.services;

import com.tenorio.utvt.entities.Luis;
import com.tenorio.utvt.repository.LuisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LuisService {
    private final LuisRepository luisRepository;

    @Autowired
    public LuisService(LuisRepository luisRepository){
        this.luisRepository = luisRepository;
    }

    public Luis guardarAlumno( Luis luis){
        return luisRepository.save(luis);
    }

    public List<Luis> obtenerTodosLosAlumnos(){
        return luisRepository.findAll();
    }

    public Optional<Luis> buscarAlumnosporId(Long id){
        return luisRepository.findById(id);
    }

    public void eliminarAlumnoPorId(Long id){
        luisRepository.deleteById(id);
    }
}
