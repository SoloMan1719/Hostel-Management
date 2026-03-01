package com.example.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.entity.*;
import com.example.demo.repository.*;

@Service
public class StudentService {

    @Autowired private StudentRepository studentRepo;
    @Autowired private BedRepository bedRepo;
    @Autowired private RoomRepository roomRepo;

    // 1. ADMIT STUDENT
    @Transactional
    public Student admitStudent(Student student, Long bedId) {
        Bed bed = bedRepo.findById(bedId)
                .orElseThrow(() -> new RuntimeException("Bed not found"));

        if (bed.isOccupied()) {
            throw new RuntimeException("Bed already occupied!");
        }

        calculateFeeAndStatus(student); // Logic extracted to a helper method
        student.setActive(true);

        bed.setOccupied(true);
        student.setBed(bed);
        bed.setStudent(student);

        Room room = bed.getRoom();
        if (room != null) {
            Integer available = room.getAvailableBeds();
            if (available != null && available > 0) {
                room.setAvailableBeds(available - 1);
                roomRepo.save(room);
            }
        }

        bedRepo.save(bed);
        return studentRepo.save(student);
    }

    // 2. UPDATE STUDENT FEE (New Method)
    @Transactional
    public Student updateFee(Long id, double newTotal, double newPaid) {
        Student student = studentRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        student.setTotalFee(newTotal);
        student.setPaidAmount(newPaid);
        
        // Fee recalculation logic call
        calculateFeeAndStatus(student);

        return studentRepo.save(student);
    }

    // HELPER METHOD: To avoid code duplication
    private void calculateFeeAndStatus(Student student) {
        double total = student.getTotalFee();
        double paid = student.getPaidAmount();
        double balance = total - paid;
        
        student.setBalanceAmount(balance < 0 ? 0 : balance);

        if (paid <= 0) student.setPaymentStatus("UNPAID");
        else if (balance <= 0) student.setPaymentStatus("PAID");
        else student.setPaymentStatus("PARTIAL");
    }

    // 3. SOFT REMOVE (Keep Record, Free Bed)
    @Transactional
    public void removeStudent(Long id) {
        Student student = studentRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        Bed bed = student.getBed();
        if (bed != null) {
            Room room = bed.getRoom();
            bed.setOccupied(false);
            bed.setStudent(null);
            bedRepo.save(bed);

            if (room != null) {
                room.setAvailableBeds(room.getAvailableBeds() + 1);
                roomRepo.save(room);
            }
        }
        student.setActive(false);
        student.setBed(null);
        studentRepo.save(student);
    }

    // 4. HARD DELETE
    @Transactional
    public void delete(Long id) {
        Student student = studentRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        Bed bed = student.getBed();
        if (bed != null) {
            Room room = bed.getRoom();
            bed.setOccupied(false);
            bed.setStudent(null); 
            bedRepo.save(bed);

            if (room != null) {
                room.setAvailableBeds(room.getAvailableBeds() + 1);
                roomRepo.save(room);
            }
        }
        studentRepo.delete(student);
    }

    public List<Student> getAll() { return studentRepo.findAll(); }
    public Student getById(Long id) { return studentRepo.findById(id).orElse(null); }
}