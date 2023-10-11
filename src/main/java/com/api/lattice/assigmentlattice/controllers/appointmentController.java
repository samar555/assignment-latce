package com.api.lattice.assigmentlattice.controllers;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.lattice.assigmentlattice.Services.appointmentService;
import com.api.lattice.assigmentlattice.Services.doctorService;
import com.api.lattice.assigmentlattice.Services.patientService;
import com.api.lattice.assigmentlattice.entity.appointment;
import com.api.lattice.assigmentlattice.entity.doctor;
import com.api.lattice.assigmentlattice.entity.patient;
import com.api.lattice.assigmentlattice.helper.ValidationOfDoctor;

import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/api/appointments")
public class appointmentController {
    @Autowired
    private appointmentService appointmentService;

    @Autowired
    private doctorService doctorService;
    @Autowired
    private patientService patientService;
    @Autowired
    ValidationOfDoctor validationDoctor ;

    @GetMapping("/")
    private ResponseEntity getAllAppoinment() {
        return ResponseEntity.ok().body(appointmentService.getAllAppoinment());
    }

    @PostMapping("/fixAppointment")
    private ResponseEntity setAppointment(@Valid @RequestBody appointment app,
            @RequestParam(value = "doctorid") int doctor_id, @RequestParam(value = "patientid") int patient_id) {
        // System.out.println(app);
        // System.out.println(patient_id);
        // System.out.println(doctor_id);
       
        doctor doc = doctorService.getDoctorById(doctor_id);
        patient pat = patientService.getpPatientById(patient_id);
        List<doctor> validateDocotrs = validationDoctor.validation(patient_id);
        System.out.println(validateDocotrs);
        boolean havedoctor = false;
        if(validateDocotrs==null){
            return ResponseEntity.badRequest().body("not found any doctor");
        }
        for (doctor vdoc : validateDocotrs) {
            if (vdoc.getId() == doctor_id) {
                System.out.println(vdoc.getId());
                havedoctor = true;
            }
        }
        if(havedoctor){
           List<appointment> alldocsapp= appointmentService.getallDoctorAppointments(doctor_id);
           for(appointment appointment:alldocsapp){
            System.out.println(appointment.getDateTime());
            System.out.println(app.getDateTime());
        System.out.println(appointment.getDateTime().toString().equals(app.getDateTime().toString()));
            if(appointment.getDateTime().toString().equals(app.getDateTime().toString())){
                LocalDateTime oneHourBeforeT1 = appointment.getDateTime().minus(1, ChronoUnit.HOURS);
                LocalDateTime oneHourAfterT1 = appointment.getDateTime().plus(1, ChronoUnit.HOURS);
                System.out.println(oneHourBeforeT1);
                System.out.println(oneHourAfterT1);
                if (app.getDateTime().isAfter(oneHourBeforeT1) && app.getDateTime().isBefore(oneHourAfterT1)) {
                    // Step 3: If the condition is met, run your method
                    return ResponseEntity.badRequest().body("Please Select Another Time Doctor is Busy At This Time");
                 
                }
           
            }
           }
        }
        if (havedoctor) {
            if (doc != null && pat != null) {
                if (app.getDateTime() == null) {
                    return ResponseEntity.badRequest().body("Date and time is null");
                } else {
                    app.setDateTime(app.getDateTime());
                    app.setDoctor(doc);
                    app.setPatient(pat);
                    return ResponseEntity.ok().body(appointmentService.saveAppointment(app));
                }
            } else {
                return ResponseEntity.badRequest().body("doctor or patient not found");
            }
        } else {
            return ResponseEntity.ok().body("Please check pateint id or doctor id");
        }
    }

    @GetMapping("/doctor")
    private ResponseEntity getAllAppointmentByDocotorId(@RequestParam("doctorid") int id) {
        List<appointment> appointments = appointmentService.getallDoctorAppointments(id);
        if (appointments.size() == 0) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(appointments);
    }

    @GetMapping("/patient")
    private ResponseEntity getAllAppointmentByPateintId(@RequestParam("patientid") int id) {
        List<appointment> appointments = appointmentService.getallPatientAppointments(id);
        if (appointments.size() == 0) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok().body(appointments);
        }
    }
}
