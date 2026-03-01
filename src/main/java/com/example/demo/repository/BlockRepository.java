package com.example.demo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.Block;

public interface BlockRepository extends JpaRepository<Block, Long> {

    List<Block> findByFloorId(Long floorId);

}