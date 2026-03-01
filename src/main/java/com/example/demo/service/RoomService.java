package com.example.demo.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Block;
import com.example.demo.entity.Room;
import com.example.demo.repository.BlockRepository;
import com.example.demo.repository.RoomRepository;
@Service
public class RoomService {

    @Autowired
    private RoomRepository repo;
    
    @Autowired
    private BlockRepository blockRepo;

    public Room saveRoom(Room room, Long blockId) {
        Block block = blockRepo.findById(blockId)
                .orElseThrow(() -> new RuntimeException("Block not found"));

        room.setBlock(block);

        // ERROR FIX: Kotha room create chesinapudu Available Beds = Total Beds ga set cheyali
        if (room.getTotalBeds() != null) {
            room.setAvailableBeds(room.getTotalBeds());
        } else {
            room.setAvailableBeds(0); // Default safety
        }

        return repo.save(room);
    } 

    public List<Room> getAll() {
        return repo.findAll();
    }

    public Optional<Room> getById(Long id) {
        return repo.findById(id);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    public List<Room> getByBlock(Long blockId) {
        return repo.findByBlockId(blockId);
    }
}