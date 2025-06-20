package com.danceSchool.api.controller;

import com.danceSchool.api.entity.sala.DataSala;
import com.danceSchool.api.entity.sala.Sala;
import com.danceSchool.api.entity.sala.SalaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.MessageFormat;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rooms")
public class SalaController {
    @Autowired
    SalaRepository salaRepository;

    @PostMapping("/add")
    public void addRoom(@RequestBody DataSala dataSala) {
        Sala sala = new Sala(dataSala);
        salaRepository.save(sala);
    }

    @GetMapping
    public List<DataSala> getAllRooms() {
        return salaRepository.findAll().stream().map(DataSala::new).toList();
    }

    @GetMapping("/{number}")
    public DataSala getRoomById(@PathVariable Integer number) {
        return salaRepository.findById(number).map(DataSala::new).orElseThrow(EntityNotFoundException::new);
    }

    @GetMapping("/name/{name}")
    public List<DataSala> getRoomById(@PathVariable String name) {
        return salaRepository.findByTitleContainingIgnoreCase(name)
                .stream()
                .map(DataSala::new)
                .toList();
    }

    @PutMapping("/update")
    public void updateRoom(@RequestBody DataSala dataSala) {
        Optional<Sala> room = salaRepository.findById(dataSala.numero());

        if(room.isEmpty()){
            throw new EntityNotFoundException("A sala buscada não existe ou não foi encontrada.");
        }

        room.get().setTitle(dataSala.title());
        room.get().setCapacidade(dataSala.capacidade());

        salaRepository.save(room.get());
    }

    @DeleteMapping("/delete/{number}")
    public void deleteRoom(@PathVariable Integer number) {
        Optional<Sala> room = salaRepository.findById(number);
        if(room.isEmpty()){
            throw new EntityNotFoundException(MessageFormat.format("A sala {0} não existe ou não foi encontrada.", number));
        }

        salaRepository.deleteById(number);
    }
}
