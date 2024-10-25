package com.poly.schedule_manager_be.repository;

import com.poly.schedule_manager_be.entity.Room;
import com.poly.schedule_manager_be.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RoomRepository extends JpaRepository<Room, Integer> {
    List<Room> findAllByBuildingAreaId(Integer areaId);
    Optional<Room> findByRoom(String room);
}
