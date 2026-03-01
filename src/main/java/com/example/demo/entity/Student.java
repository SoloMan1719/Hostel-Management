package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Student {

@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long id;

private String name;

@Enumerated(EnumType.STRING)
private Gender gender;

private double totalFee;
private double paidAmount;
private double balanceAmount;

private String paymentStatus;
private boolean active;

@OneToOne
@JoinColumn(name="bed_id")
@JsonIgnoreProperties("student")

private Bed bed;

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

public Gender getGender() {
	return gender;
}

public void setGender(Gender gender) {
	this.gender = gender;
}

public double getTotalFee() {
	return totalFee;
}

public void setTotalFee(double totalFee) {
	this.totalFee = totalFee;
}

public double getPaidAmount() {
	return paidAmount;
}

public void setPaidAmount(double paidAmount) {
	this.paidAmount = paidAmount;
}

public double getBalanceAmount() {
	return balanceAmount;
}

public void setBalanceAmount(double balanceAmount) {
	this.balanceAmount = balanceAmount;
}

public String getPaymentStatus() {
	return paymentStatus;
}

public void setPaymentStatus(String paymentStatus) {
	this.paymentStatus = paymentStatus;
}

public boolean isActive() {
	return active;
}

public void setActive(boolean active) {
	this.active = active;
}

public Bed getBed() {
	return bed;
}

public void setBed(Bed bed) {
	this.bed = bed;
}

}