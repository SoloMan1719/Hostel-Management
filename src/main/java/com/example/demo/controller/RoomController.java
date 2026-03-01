package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Room;
import com.example.demo.service.RoomService;

@RestController
@RequestMapping("/room")
@CrossOrigin("*")
public class RoomController {

@Autowired RoomService service;

@PostMapping("/{blockId}")
public Room save(@RequestBody Room room,@PathVariable Long blockId){
  return service.saveRoom(room,blockId);
} 
@GetMapping("/all")
public List<Room>findAll(){
	return service.getAll();
}
@GetMapping("/{id}")
public Optional<Room> findById(@PathVariable Long id) {
	return service.getById(id);
}  
@GetMapping("/by-block/{blockId}")
public List<Room> getByBlock(@PathVariable Long blockId){
    return service.getByBlock(blockId);
}
@DeleteMapping("/{id}")
public void delete(@PathVariable Long id){
    service.delete(id); 
}

}