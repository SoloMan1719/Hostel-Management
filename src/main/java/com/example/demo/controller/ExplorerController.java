package com.example.controller;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Bed;
import com.example.demo.repository.BedRepository;

@RestController                 // ✅ REST API controller
@RequestMapping("/explorer")   // ✅ Base URL
@CrossOrigin                   // ✅ Allow frontend requests
public class ExplorerController {

    @Autowired
    private BedRepository bedRepository;   // ✅ Inject repository


    // ====================================================
    // GET FULL HOSTEL VIEW BY BUILDING
    // URL : /explorer/{buildingId}
    // ====================================================
    @GetMapping("/{buildingId}")
    public List<Map<String, Object>> getFullView(
            @PathVariable Long buildingId) {

        List<Bed> beds = bedRepository.findAll();

        List<Map<String, Object>> response = new ArrayList<>();

        for (Bed bed : beds) {

            // ✅ Filter beds by building
            if (bed.getRoom()
                    .getBlock()
                    .getFloor()
                    .getBuilding()
                    .getId()
                    .equals(buildingId)) {

                Map<String, Object> data = new HashMap<>();

                data.put("floorName",
                        bed.getRoom()
                           .getBlock()
                           .getFloor()
                           .getName());

                data.put("blockName",
                        bed.getRoom()
                           .getBlock()
                           .getName());

                data.put("roomNo",
                        bed.getRoom()
                           .getRoomNo());

                data.put("bedNumber",
                        bed.getBedNumber());

                data.put("occupied",
                        bed.isOccupied());

                response.add(data);
            }
        }

        return response;
    }
}
