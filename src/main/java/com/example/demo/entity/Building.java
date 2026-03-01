package com.example.demo.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Building {

@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long id;

private String name;

@Enumerated(EnumType.STRING)
@Column(name = "hostelType")
private HostelType hostelType;

@OneToMany(mappedBy="building",
cascade=CascadeType.ALL)
@JsonIgnore
private List<Floor> floors;  

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

public HostelType getHostelType() {
	return hostelType;
}

public void setHostelType(HostelType hostelType) {
	this.hostelType = hostelType;
}

public List<Floor> getFloors() {
	return floors;
}

public void setFloors(List<Floor> floors) {
	this.floors = floors;
}


}