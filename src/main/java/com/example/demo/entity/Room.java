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
public class Room {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

private String roomNo;



private String roomType;

@ManyToOne
@JoinColumn(name="block_id")
@JsonIgnoreProperties("rooms") 
private Block block;

@OneToMany(mappedBy="room", cascade=CascadeType.ALL)
@JsonIgnoreProperties("room") // ManagedReference badulu idi clean ga untundi
private List<Bed> beds;
private Integer totalBeds;
private Integer availableBeds;



public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getRoomNo() {
	return roomNo;
}

public void setRoomNo(String roomNo) {
	this.roomNo = roomNo;
}

public String getRoomType() {
	return roomType;
}

public void setRoomType(String roomType) {
	this.roomType = roomType;
}

public Block getBlock() {
	return block;
}

public void setBlock(Block block) {
	this.block = block;
}

public List<Bed> getBeds() {
	return beds;
}

public void setBeds(List<Bed> beds) {
	this.beds = beds;
}

public Integer getTotalBeds() {
	return totalBeds;
}

public void setTotalBeds(Integer totalBeds) {
	this.totalBeds = totalBeds;
}

public Integer getAvailableBeds() {
	return availableBeds;
}

public void setAvailableBeds(Integer availableBeds) {
	this.availableBeds = availableBeds;
}





}