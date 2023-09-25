package com.api.lattice.assigmentlattice.entity;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class patient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    @NotBlank(message = "enter the doctor name ")
    @Length(min = 3, message = "size of doctor name must be greater than 3 character")
    private String patientName;

    @Column
    @NotBlank(message = "enter the city name")
    @NotNull(message = "value is null")
    @Length(max = 20, message = "city length must be smaller than 20 character")
    private String City;

    @Column
    @NotBlank(message = "enter the email")
    @Email(message = "enter valid email")
    private String email;

    @Column
    @NotNull(message = "enter Phnone number")
    @Length(min  = 10,message = "enter valid phone number")
    private String phoneNumber;

    @Column
    @NotBlank(message = "choose any one speciality")
    private String symptoms;

    // getter and setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    // constructor with parameter
    public patient(int id,
            @NotBlank(message = "enter the doctor name ") @Length(min = 3, message = "size of doctor name must be greater than 3 character") String patientName,
            @NotBlank(message = "enter the city name") @Length(max = 20, message = "city length must be smaller than 20 character") String city,
            @NotBlank(message = "enter the email") @Email(message = "enter valid email") String email,
            @NotBlank(message = "enter Phnone number") @Length(min = 10, message = "enter valid phone number") String phoneNumber,
            @NotBlank(message = "choose any one speciality") String symptoms) {
        this.id = id;
        this.patientName = patientName;
        this.City = city;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.symptoms = symptoms;
    }

    // constructor without parameter
    public patient() {
    }

    // to String method
    @Override
    public String toString() {
        return "patient [id=" + id + ", patientName=" + patientName + ", City=" + City + ", email=" + email
                + ", phoneNumber=" + phoneNumber + ", symptoms=" + symptoms + "]";
    }

}
