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

import com.example.demo.entity.Building;
import com.example.demo.service.BuildingService;

@RestController
@RequestMapping("/building")
@CrossOrigin("*")
public class BuildingController {

@Autowired BuildingService service;

@PostMapping("/save")
public Building save(@RequestBody Building b){
    return service.save(b);
}

@GetMapping("/all")
public List<Building> getAll(){
return service.getAll();
}
@GetMapping("/{id}")
public Optional<Building> findById(@PathVariable Long id){
    return service.getById(id);
}

@DeleteMapping("/{id}")
public void delete(@PathVariable Long id){
service.delete(id);
}

}

