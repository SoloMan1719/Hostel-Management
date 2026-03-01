package com.example.demo.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Building;
import com.example.demo.entity.Floor;
import com.example.demo.repository.BuildingRepository;
import com.example.demo.repository.FloorRepository;

@Service
public class FloorService {

@Autowired
FloorRepository repo;

@Autowired
BuildingRepository buildingRepo;


public Floor saveFloor(Floor floor, Long buildingId){

    Building building =
            buildingRepo.findById(buildingId)
            .orElseThrow();

    floor.setBuilding(building);

    return repo.save(floor);
}

public List<Floor>getAll(){
	return repo.findAll();
	
} 
public Optional<Floor> getById(Long id){
	return repo.findById(id); 
}
public void delete(Long id) {
	repo.deleteById(id);
}
public List<Floor> getByBuilding(Long buildingId){
    return repo.findByBuildingId(buildingId);
}

}   