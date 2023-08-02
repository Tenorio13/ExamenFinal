package com.tenorio.utvt;

import static org.mockito.Mockito.*;
import static org.skyscreamer.jsonassert.JSONAssert.assertEquals;

import com.tenorio.utvt.controllers.LuisController;
import com.tenorio.utvt.entities.Luis;
import com.tenorio.utvt.services.LuisService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class LuisControllerTest {

    // Mock del servicio
    @Mock
    private LuisService luisService;

    // Controlador que se está probando, el servicio mock se inyecta automáticamente
    @InjectMocks
    private LuisController luisController;

    @Test
    public void testGetLuisById() {
        // Datos de prueba
        Long luisId = 1L;
        Luis luis = new Luis();
        luis.setId(luisId);
        luis.setNombre("Luis Test");

        // Configuramos el comportamiento del mock del servicio
        when(luisService.buscarAlumnosporId(luisId)).thenReturn(Optional.of(luis));

        // Ejecutamos el método del controlador que queremos probar
        Optional<Luis> response = luisController.buscarAlumnoporId(luisId);
    }
}

