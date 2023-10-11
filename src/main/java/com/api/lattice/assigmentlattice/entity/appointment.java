package com.api.lattice.assigmentlattice.entity;

import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;


@Entity
public class appointment {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;


    @Column
    @NotNull(message = "date and time can't be empty")
    private LocalDateTime dateTime;
    
   
    @ManyToOne(cascade = CascadeType.ALL)

    private doctor doctor;
   
  
    @ManyToOne(cascade = CascadeType.ALL)
   
    private patient patient;



     //gettter setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(doctor doctor) {
        this.doctor = doctor;
    }

    public patient getPatient() {
        return patient;
    }

    public void setPatient(patient patient) {
        this.patient = patient;
    }

    public appointment(int id, @NotNull(message = "date and time can't be empty") LocalDateTime dateTime,
            com.api.lattice.assigmentlattice.entity.@NotNull(message = "doctor can't be null") doctor doctor,
            com.api.lattice.assigmentlattice.entity.@NotNull(message = "pateint can't be null") patient patient) {
        this.id = id;
        this.dateTime = dateTime;
        this.doctor = doctor;
        this.patient = patient;
    }

    public appointment() {
    }

    @Override
    public String toString() {
        return "appointment [id=" + id + ", dateTime=" + dateTime + ", doctor=" + doctor + ", patient=" + patient + "]";
    }

    


   


    
    
}
