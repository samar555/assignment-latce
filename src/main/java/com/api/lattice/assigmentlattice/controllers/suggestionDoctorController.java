package com.api.lattice.assigmentlattice.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.lattice.assigmentlattice.Services.doctorService;
import com.api.lattice.assigmentlattice.Services.patientService;
import com.api.lattice.assigmentlattice.entity.doctor;
import com.api.lattice.assigmentlattice.entity.patient;

@RestController
@RequestMapping(path = "/api/suggest-doctor")
public class suggestionDoctorController {
    @Autowired
    doctorService ds;
    @Autowired
    patientService ps;

    @GetMapping("/{id}")
    private ResponseEntity getDoctor(@PathVariable int id) {
        int perticularSymtomsDotor = 0;
        if (ps.getpPatientById(id) == null) {
            return ResponseEntity.notFound().build();
        } else {
            patient Pateint = ps.getpPatientById(id);
            List<doctor> doctors = ds.getAllDoctor();
            List<doctor> suggestingDoctors = new ArrayList<>();
            if (Pateint.getSymptoms().trim().equalsIgnoreCase("Arthritis")
                    || Pateint.getSymptoms().trim().equalsIgnoreCase("Back Pain")
                    || Pateint.getSymptoms().trim().equalsIgnoreCase("Tissue injuries")) {
                suggestingDoctors.clear();
                perticularSymtomsDotor = 0;
                for (doctor d : doctors) {
                    if (d.getSpeciality().trim().equalsIgnoreCase("Orthopedic")) {
                        perticularSymtomsDotor++;
                        if (d.getCity().trim().equalsIgnoreCase(Pateint.getCity().trim())) {
                            suggestingDoctors.add(d);
                        }
                    }
                }
                if (suggestingDoctors.isEmpty()) {
                    if (perticularSymtomsDotor > 0) {
                        return ResponseEntity.ok().body("We are still waiting to expand to your location");
                    } else {
                        return ResponseEntity.ok()
                                .body("There isn’t any doctor present at your location for your symptom");

                    }
                } else {
                    return ResponseEntity.ok().body(suggestingDoctors);
                }

            } else if (Pateint.getSymptoms().trim().equalsIgnoreCase("Dysmenorrhea")) {
                suggestingDoctors.clear();
                perticularSymtomsDotor = 0;
                for (doctor d : doctors) {
                    if (d.getSpeciality().trim().equalsIgnoreCase("Gynecology")) {
                        perticularSymtomsDotor++;
                        if (d.getCity().trim().equalsIgnoreCase(Pateint.getCity().trim())) {
                            suggestingDoctors.add(d);
                        }
                    }
                }
                if (suggestingDoctors.isEmpty()) {
                    if (perticularSymtomsDotor > 0) {
                        return ResponseEntity.ok().body("We are still waiting to expand to your location");
                    } else {
                        return ResponseEntity.ok()
                                .body("There isn’t any doctor present at your location for your symptom");

                    }
                } else {
                    return ResponseEntity.ok().body(suggestingDoctors);
                }

            } else if (Pateint.getSymptoms().trim().equalsIgnoreCase("Ear pain")) {
                suggestingDoctors.clear();
                perticularSymtomsDotor = 0;
                for (doctor d : doctors) {
                    if (d.getSpeciality().trim().equalsIgnoreCase("ENT specialist")) {
                        perticularSymtomsDotor++;
                        if (d.getCity().trim().equalsIgnoreCase(Pateint.getCity().trim())) {
                            suggestingDoctors.add(d);
                        }
                    }
                }
                if (suggestingDoctors.isEmpty()) {
                    if (perticularSymtomsDotor > 0) {
                        return ResponseEntity.ok().body("We are still waiting to expand to your location");
                    } else {
                        return ResponseEntity.ok()
                                .body("There isn’t any doctor present at your location for your symptom");

                    }
                } else {
                    return ResponseEntity.ok().body(suggestingDoctors);
                }

            } else if (Pateint.getSymptoms().trim().equalsIgnoreCase("Skin infection")
                    || Pateint.getSymptoms().trim().equalsIgnoreCase("skin burn")) {
                suggestingDoctors.clear();
                perticularSymtomsDotor = 0;
                for (doctor d : doctors) {
                    if (d.getSpeciality().trim().equalsIgnoreCase("Dermatology")) {
                        perticularSymtomsDotor++;
                        if (d.getCity().trim().equalsIgnoreCase(Pateint.getCity().trim())) {
                            suggestingDoctors.add(d);
                        }
                    }
                }
                if (suggestingDoctors.isEmpty()) {
                    if (perticularSymtomsDotor > 0) {
                        return ResponseEntity.ok().body("We are still waiting to expand to your location");
                    } else {
                        return ResponseEntity.ok()
                                .body("There isn’t any doctor present at your location for your symptom");

                    }
                } else {
                    return ResponseEntity.ok().body(suggestingDoctors);
                }

            }

            return ResponseEntity.ok().body("There isn’t any doctor present at your location for your symptom");
        }

    }
}
