package com.danceSchool.api.room;

import jakarta.persistence.Column;

public record DataRoom(Integer numero,  String title, Integer capacidade) {
    public DataRoom(Room room){
        this(room.getNumero(), room.getTitle(), room.getCapacidade());
    }
}
