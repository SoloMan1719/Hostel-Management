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

import com.example.demo.entity.Floor;
import com.example.demo.service.FloorService;

@RestController
@RequestMapping("/floor")
@CrossOrigin("*")
public class FloorController {

    @Autowired
    FloorService service;

    
    @PostMapping("/{buildingId}")
    public Floor saveFloor(
            @RequestBody Floor floor,
            @PathVariable Long buildingId){

        return service.saveFloor(floor, buildingId);
    }

    @GetMapping("/all")
    public List<Floor> findAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Floor> findById(
            @PathVariable Long id){

        return service.getById(id);
    }

    
    @GetMapping("/by-building/{buildingId}")
    public List<Floor> getByBuilding(
            @PathVariable Long buildingId){

        return service.getByBuilding(buildingId);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id); 
    }
}