package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Bed;

public interface BedRepository extends JpaRepository<Bed, Long>{

	List<Bed> findByRoomId(Long roomId);

}
