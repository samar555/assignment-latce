package com.api.lattice.assigmentlattice.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.lattice.assigmentlattice.Services.doctorService;
import com.api.lattice.assigmentlattice.entity.doctor;

import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "api/doctor")
public class doctorController {
    @Autowired
    private doctorService dc;

    @GetMapping("/getDoctor")
    private ResponseEntity getalldoctors() {

        return ResponseEntity.ok().body(dc.getAllDoctor());
    }

    @PostMapping("/addDoctor")
    private ResponseEntity creatingDoctor(@Valid @RequestBody doctor Doctor, BindingResult result) {
        try {
            if (result.hasErrors()) {
                List<String> errorMessages = result.getFieldErrors()
                        .stream()
                        .map(error -> error.getDefaultMessage())
                        .collect(Collectors.toList());
                String errorMessage = String.join(", ", errorMessages);
                return ResponseEntity.badRequest().body(errorMessage);
            } else if (!Doctor.getCity().trim().equalsIgnoreCase("Delhi")
                    && !Doctor.getCity().trim().equalsIgnoreCase("Noida")
                    && !Doctor.getCity().trim().equalsIgnoreCase("Faridabad")) {
                return ResponseEntity.badRequest().body("select City Near DElhi Ncr");
            } else if (!Doctor.getSpeciality().trim().equalsIgnoreCase("ENT specialist")
                    && !Doctor.getSpeciality().trim().equalsIgnoreCase("Dermatology")
                    && !Doctor.getSpeciality().trim().equalsIgnoreCase("Gynecology")
                    && !Doctor.getSpeciality().trim().equalsIgnoreCase("Orthopedic")) {
                return ResponseEntity.badRequest().body("select the given specialisation");
            } else {
                return ResponseEntity.ok().body(dc.createNewDoctor(Doctor));
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Something Went Wrong" + e.getMessage());
        }

    }

    @DeleteMapping("/{id}")
    private ResponseEntity deleteDoctor(@PathVariable int id) {
        if (dc.getDoctorById(id) == null) {
            return ResponseEntity.notFound().build();
        } else {
            int result = dc.deleteDoctor(id);
            if (result >= 0) {
                return ResponseEntity.ok().body("deleted doctor with id " + id);
            } else {
                return ResponseEntity.badRequest().body("can't delete");
            }
        }
    }
    //
}
