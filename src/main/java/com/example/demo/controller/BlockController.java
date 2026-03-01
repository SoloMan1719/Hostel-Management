package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Block;
import com.example.demo.service.BlockService;

@RestController
@RequestMapping("/block")
@CrossOrigin("*")
public class BlockController {

@Autowired BlockService service;

@PostMapping("/{floorId}")
public Block save(@RequestBody Block block,@PathVariable Long floorId){
  return service.save(block,floorId);
}
@GetMapping("/all")
public List<Block>findAll(){
	return service.getAll();
}
@GetMapping("/by-floor/{floorId}")
public List<Block> getByFloor(@PathVariable Long floorId){
    return service.getByFloor(floorId);
} 
@DeleteMapping("/{id}")
public void delete(@PathVariable Long id){
    service.delete(id); 
}

}