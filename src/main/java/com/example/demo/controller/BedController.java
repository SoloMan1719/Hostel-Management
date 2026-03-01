package com.example.demo.controller;import java.util.List;
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

import com.example.demo.entity.Bed;
import com.example.demo.service.BedService;

@RestController
@RequestMapping("/bed")
@CrossOrigin("*")
public class BedController {
 @Autowired
 private BedService service;
 
 @PostMapping("/{roomId}")
 public Bed save(@RequestBody Bed bed,@PathVariable Long roomId) {
 return service.saveBed(bed, roomId);
 
 }
 @GetMapping("/all")
 public List<Bed>findAll(){
	 return service.getAll();
 }
 @GetMapping("/{id}")
 public Optional<Bed>findById(@PathVariable Long id){
	 return service.getById(id);   
 }
 @GetMapping("/by-room/{roomId}")
 public List<Bed> getRoom(@PathVariable Long roomId){
     return service.getByRoom(roomId);
 }
 @DeleteMapping("/{id}")
 public void delete(@PathVariable Long id){
     service.delete(id); 
 }
 
}
