package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Bed {

@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long id;

private String bedNumber;
private boolean occupied;
@ManyToOne
@JoinColumn(name="room_id")
@JsonIgnoreProperties("beds") 
private Room room;

@OneToOne(mappedBy="bed")
@JsonIgnoreProperties("bed") 
private Student student;

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getBedNumber() {
	return bedNumber;
}

public void setBedNumber(String bedNumber) {
	this.bedNumber = bedNumber;
}

public boolean isOccupied() {
	return occupied;
}

public void setOccupied(boolean occupied) {
	this.occupied = occupied;
}

public Room getRoom() {
	return room;
}

public void setRoom(Room room) {
	this.room = room;
}

public Student getStudent() {
	return student;
}

public void setStudent(Student student) {
	this.student = student;
}

}