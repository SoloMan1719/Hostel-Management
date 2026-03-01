package com.example.demo.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Bed;
import com.example.demo.entity.Room;
import com.example.demo.repository.BedRepository;
import com.example.demo.repository.RoomRepository;

@Service
public class BedService {

@Autowired BedRepository repo;
@Autowired RoomRepository roomRepo;


public Bed saveBed(Bed bed, Long roomId){

    Room room = roomRepo.findById(roomId)
            .orElseThrow(() -> new RuntimeException("Room not found"));

    bed.setRoom(room);
    bed.setOccupied(false);

    return repo.save(bed);
}
public List<Bed>getAll(){
	return repo.findAll();
}
public List<Bed> getByRoom(Long roomId){
    return repo.findByRoomId(roomId);
}
public Optional<Bed>getById(long id){
	return repo.findById(id);
}  
public void delete(Long id) {
	repo.deleteById(id);
}

}