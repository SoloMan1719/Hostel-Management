package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;

@RestController
@RequestMapping("/students")
@CrossOrigin("*")
public class StudentController {

    @Autowired
    private StudentService service;

    @PostMapping("/admit/{bedId}")
    public ResponseEntity<?> admit(@RequestBody Student student, @PathVariable Long bedId) {
        try {
            // Success case
            service.admitStudent(student, bedId);
            return ResponseEntity.ok("Saved Successfully"); 
        } catch (RuntimeException e) {
            // Error case: "Bed already occupied!" ikkadiki vasthundi
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public List<Student> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Student get(@PathVariable Long id) {
        return service.getById(id);
    }
    @PutMapping("/update-fee/{id}")
    public Student updateFee(@PathVariable Long id, @RequestParam double total, @RequestParam double paid) {
        return service.updateFee(id, total, paid);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}