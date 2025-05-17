package com.danceSchool.api.room;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Integer> {
    public List<Room> findByTitleContainingIgnoreCase(String title);
}
