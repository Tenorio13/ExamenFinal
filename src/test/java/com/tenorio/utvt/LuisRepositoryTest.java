package com.tenorio.utvt;

import com.tenorio.utvt.entities.Luis;
import com.tenorio.utvt.repository.LuisRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(SpringRunner.class)
@DataJpaTest
public class LuisRepositoryTest {

    @Autowired
    private LuisRepository luisRepository;

    @Test
    @DisplayName("Test para encontrar una entidad por ID")
    public void testFindById() {
        // Crea una entidad y guárdala en la base de datos
        Luis entity = new Luis();
        entity.setNombre("Luis");
        luisRepository.save(entity);

        // Busca la entidad por ID
        Optional<Luis> foundEntity = luisRepository.findById(entity.getId());

        // Asegúrate de que la entidad se haya encontrado
        assertTrue(foundEntity.isPresent());
        assertEquals(entity.getNombre(), foundEntity.get().getNombre());
    }
}
