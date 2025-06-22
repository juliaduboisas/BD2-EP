package com.danceSchool.api.entity.sala;

public record DataSala(Integer numero, String title, Integer capacidade) {
    public DataSala(Sala sala){
        this(sala.getNumero(), sala.getTitle(), sala.getCapacidade());
    }
}
