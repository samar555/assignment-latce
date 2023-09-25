package com.api.lattice.assigmentlattice.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.lattice.assigmentlattice.Services.patientService;
import com.api.lattice.assigmentlattice.entity.patient;

import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "api/patient")
public class patientController {

    @Autowired
    patientService ps;

    @GetMapping("/getPatient")
    private ResponseEntity getpatient() {
        try {
            return ResponseEntity.ok().body(ps.getAllPatient());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/addPatient")
    private ResponseEntity addPetient(@Valid @RequestBody patient Patient, BindingResult result) {
        System.out.println(Patient);

        if (result.hasErrors()) {
            List<String> errorMessages = result.getFieldErrors()
                    .stream()
                    .map(error -> error.getDefaultMessage())
                    .collect(Collectors.toList());
            String errorMessage = String.join(", ", errorMessages);
            return ResponseEntity.badRequest().body(errorMessage);
        } else if (!Patient.getSymptoms().trim().equalsIgnoreCase("Arthritis")
                && !Patient.getSymptoms().trim().equalsIgnoreCase("Back Pain")
                && !Patient.getSymptoms().trim().equalsIgnoreCase("Tissue injuries")
                && !Patient.getSymptoms().trim().equalsIgnoreCase("Dysmenorrhea")
                && !Patient.getSymptoms().trim().equalsIgnoreCase("Skin infection")
                && !Patient.getSymptoms().trim().equalsIgnoreCase("skin burn")
                && !Patient.getSymptoms().trim().equalsIgnoreCase("Ear pain")) {
            return ResponseEntity.badRequest().body("Select Specific Symtoms");
        } else {
            return ResponseEntity.ok().body(ps.addPatient(Patient));
        }

    }

    @DeleteMapping("/{id}")
    private ResponseEntity DeletePateint(@PathVariable int id) {
        if (ps.getpPatientById(id) == null) {
            return ResponseEntity.notFound().build();
        } else {
            int result = ps.DeletePateint(id);
            if (result >= 0) {
                return ResponseEntity.ok().body("deleted Pateint With id " + result);
            } else {
                return ResponseEntity.badRequest().body("Something Went Wrong!!");
            }
        }
    }

}
