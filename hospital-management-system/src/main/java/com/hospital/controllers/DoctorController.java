package com.hospital.controllers;

import com.hospital.dto.DoctorDTO;
import com.hospital.models.Doctor;
import com.hospital.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @GetMapping
    public List<Doctor> getAllDoctors() {
        return doctorService.getAllDoctors();
    }

    @PostMapping("/add")
    public Doctor createDoctor(@RequestBody DoctorDTO doctor) {
        Doctor docModel = new Doctor();
        docModel.setName(doctor.getName());
        docModel.setSpecialization(doctor.getSpecialization());
        return doctorService.saveDoctor(docModel);
    }

    @PutMapping("/{id}")
    public Doctor updateDoctor(@PathVariable Long id, @RequestBody Doctor doctor) {
        doctor.setId(id);
        return doctorService.updateDoctor(doctor);
    }

    @DeleteMapping("/{id}")
    public void deleteDoctor(@PathVariable Long id) {
        doctorService.deleteDoctor(id);
    }
}