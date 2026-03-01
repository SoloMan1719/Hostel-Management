package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Building;
import com.example.demo.entity.Student;
import com.example.demo.repository.BuildingRepository;
import com.example.demo.repository.StudentRepository;

@Service
public class BuildingService {

    @Autowired
    private BuildingRepository repo;

    @Autowired
    private StudentRepository studentRepo; // Student repo add cheyyandi linkages clear cheyyaniki

    public Building save(Building b){
        return repo.save(b);
    }

    public List<Building> getAll(){
        return repo.findAll();
    }

    public Optional<Building> getById(Long id) {
        return repo.findById(id);
    }

    @Transactional
    public void delete(Long id) {
        Building building = repo.findById(id).orElse(null);
        
        if (building != null) {
            // Logic: Building delete ayye mundu, aa building lo unna 
            // students andaru 'Bed' link nundi free avvali.
            // Lekunte 'Foreign Key Constraint' error vastundi.
            
            building.getFloors().forEach(floor -> {
                floor.getBlocks().forEach(block -> {
                    block.getRooms().forEach(room -> {
                        room.getBeds().forEach(bed -> {
                            if (bed.getStudent() != null) {
                                Student s = bed.getStudent();
                                s.setBed(null); // Student ki bed ni null chesi save chestunnam
                                studentRepo.save(s);
                            }
                        });
                    });
                });
            });

            // Ippudu clean ga building delete avtundi
            repo.delete(building);
        }
    }
}