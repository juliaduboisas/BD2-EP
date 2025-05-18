package com.danceSchool.api.controller;

import com.danceSchool.api.room.DataRoom;
import com.danceSchool.api.room.Room;
import com.danceSchool.api.room.RoomRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.MessageFormat;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rooms")
public class RoomController {
    @Autowired
    RoomRepository roomRepository;

    @PostMapping("/add")
    public void addRoom(@RequestBody DataRoom dataRoom) {
        Room room = new Room(dataRoom);
        roomRepository.save(room);
    }

    @GetMapping
    public List<DataRoom> getAllRooms() {
        return roomRepository.findAll().stream().map(DataRoom::new).toList();
    }

    @GetMapping("/{number}")
    public DataRoom getRoomById(@PathVariable Integer number) {
        return roomRepository.findById(number).map(DataRoom::new).orElseThrow(EntityNotFoundException::new);
    }

    @GetMapping("/name/{name}")
    public List<DataRoom> getRoomById(@PathVariable String name) {
        return roomRepository.findByTitleContainingIgnoreCase(name)
                .stream()
                .map(DataRoom::new)
                .toList();
    }

    @PutMapping("/update")
    public void updateRoom(@RequestBody DataRoom dataRoom) {
        Optional<Room> room = roomRepository.findById(dataRoom.numero());

        if(room.isEmpty()){
            throw new EntityNotFoundException("A sala buscada não existe ou não foi encontrada.");
        }

        room.get().setTitle(dataRoom.title());
        room.get().setCapacidade(dataRoom.capacidade());

        roomRepository.save(room.get());
    }

    @DeleteMapping("/delete/{number}")
    public void deleteRoom(@PathVariable Integer number) {
        Optional<Room> room = roomRepository.findById(number);
        if(room.isEmpty()){
            throw new EntityNotFoundException(MessageFormat.format("A sala {0} não existe ou não foi encontrada.", number));
        }

        roomRepository.deleteById(number);
    }
}
