package com.api.lattice.assigmentlattice.entity;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    @NotBlank(message = "enter the doctor name ")
    @Length(min = 3, message = "size of doctor name must be greater than 3 character")
    private String doctorName;

// for the city we can use the another table and perform join operation
    @Column
    @NotBlank(message = "enter the city name")
    @Length(max = 20, message = "city length must be smaller than 20 character")
    private String City;

    @Column
    @NotBlank(message = "enter the email")
    @Email(message = "enter valid email")
    private String email;

    @Column
    @NotNull(message = "enter Phnone number")
    @Range(min = 10, message = "enter valid phone number")
    private Long phoneNumber;

    //also for specialisation we can use another table and perform join query
    @Column
    @NotBlank(message = "choose any one speciality")
    private String speciality;


    //getter and setter
public int getId() {
    return id;
}


public void setId(int id) {
    this.id = id;
}


public String getDoctorName() {
    return doctorName;
}


public void setDoctorName(String doctorName) {
    this.doctorName = doctorName;
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


public Long getPhoneNumber() {
    return phoneNumber;
}


public void setPhoneNumber(Long phoneNumber) {
    this.phoneNumber = phoneNumber;
}


public String getSpeciality() {
    return speciality;
}


public void setSpeciality(String speciality) {
    this.speciality = speciality;
}

// constructor with parameter

public doctor(int id,
        @NotBlank(message = "enter the doctor name ") @Length(min = 3, message = "size of doctor name must be greater than 3 character") String doctorName,
        @NotBlank(message = "enter the city name") @Length(max = 20, message = "city length must be smaller than 20 character") String city,
        @NotBlank(message = "enter the email") @Email(message = "enter valid email") String email,
        @NotBlank(message = "enter Phnone number") @Length(min = 10, message = "enter valid phone number") long phoneNumber,
        @NotBlank(message = "choose any one speciality") String speciality) {
    this.id = id;
    this.doctorName = doctorName;
    City = city;
    this.email = email;
    this.phoneNumber = phoneNumber;
    this.speciality = speciality;
}

//constructor without parameter

public doctor() {
} 

//to String method 


@Override
public String toString() {
    return "doctor [City=" + City + ", id=" + id + ", doctorName=" + doctorName + ", email="
            + email + ", phoneNumber=" + phoneNumber + ", speciality=" + speciality + "]";
} 




}
