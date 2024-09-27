package com.poly.schedule_manager_be.repository;

import com.poly.schedule_manager_be.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Integer> {
}
