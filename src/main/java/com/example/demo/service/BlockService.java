package com.example.demo.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Block;
import com.example.demo.entity.Floor;
import com.example.demo.repository.BlockRepository;
import com.example.demo.repository.FloorRepository;

@Service
public class BlockService {

@Autowired BlockRepository repo;
@Autowired FloorRepository floorRepo;

public Block save(Block block, Long floorId){

    Floor floor = floorRepo.findById(floorId)
            .orElseThrow(() -> new RuntimeException("Floor not found"));

    block.setFloor(floor);

    return repo.save(block);
}
public List<Block>getAll(){
	return repo.findAll();
}
public Optional<Block> getById(Long id) {
	return repo.findById(id);
}  
public void delete(Long id) {
	repo.deleteById(id);
	

}
public List<Block> getByFloor(Long floorId) {
	
	return repo.findByFloorId(floorId);
}  


}
