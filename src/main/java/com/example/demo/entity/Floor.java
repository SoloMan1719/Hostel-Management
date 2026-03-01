package com.example.demo.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Floor {

@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long id;

private String name;

@ManyToOne
@JoinColumn(name="building_id")
@JsonIgnoreProperties("floors")
private Building building;

@OneToMany(mappedBy="floor", cascade=CascadeType.ALL)
@JsonIgnoreProperties("floor")
private List<Block> blocks;
public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public Building getBuilding() {
	return building;
}

public void setBuilding(Building building) {
	this.building = building;
}

public List<Block> getBlocks() {
	return blocks;
}

public void setBlocks(List<Block> blocks) {
	this.blocks = blocks;
}

}