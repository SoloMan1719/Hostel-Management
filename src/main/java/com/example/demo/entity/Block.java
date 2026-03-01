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
public class Block {

@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long id;

private String name;

@ManyToOne
@JoinColumn(name="floor_id")
@JsonIgnoreProperties("blocks")
private Floor floor;

@OneToMany(mappedBy="block", cascade=CascadeType.ALL)
@JsonIgnoreProperties("block")
private List<Room> rooms;

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

public Floor getFloor() {
	return floor;
}

public void setFloor(Floor floor) {
	this.floor = floor;
}

public List<Room> getRooms() {
	return rooms;
}

public void setRooms(List<Room> rooms) {
	this.rooms = rooms;
}

}