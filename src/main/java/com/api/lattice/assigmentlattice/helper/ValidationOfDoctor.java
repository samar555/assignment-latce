package com.api.lattice.assigmentlattice.helper;

import java.beans.JavaBean;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.api.lattice.assigmentlattice.Services.doctorService;
import com.api.lattice.assigmentlattice.Services.patientService;
import com.api.lattice.assigmentlattice.entity.doctor;
import com.api.lattice.assigmentlattice.entity.patient;

@Service
public class ValidationOfDoctor {
    @Autowired
    private doctorService dos;
    @Autowired
    private patientService pas;

    public List<doctor> validation(int id) {
        List<doctor> suggestingDoctors = new ArrayList<>();
        int perticularSymtomsDotor = 0;
        if (pas.getpPatientById(id) == null) {
            System.out.println("r1");
            return suggestingDoctors;
        } else {
            patient Pateint = pas.getpPatientById(id);
            List<doctor> doctors = dos.getAllDoctor();

            if (Pateint.getSymptoms().trim().equalsIgnoreCase("Arthritis")
                    || Pateint.getSymptoms().trim().equalsIgnoreCase("Back Pain")
                    || Pateint.getSymptoms().trim().equalsIgnoreCase("Tissue injuries")) {
                suggestingDoctors.clear();
                perticularSymtomsDotor = 0;
                for (doctor d : doctors) {
                    if (d.getSpeciality().trim().equalsIgnoreCase("Orthopedic")) {
                        perticularSymtomsDotor++;
                     
                            suggestingDoctors.add(d);
                        
                    }
                }
              
                    System.out.println("r4");
                    return suggestingDoctors;
                

            } else if (Pateint.getSymptoms().trim().equalsIgnoreCase("Dysmenorrhea")) {
                suggestingDoctors.clear();
                perticularSymtomsDotor = 0;
                for (doctor d : doctors) {
                    if (d.getSpeciality().trim().equalsIgnoreCase("Gynecology")) {
                        perticularSymtomsDotor++;
                      
                            suggestingDoctors.add(d);
                        
                    }
                }
               
                    System.out.println("r7");
                 return suggestingDoctors;
                

            } else if (Pateint.getSymptoms().trim().equalsIgnoreCase("Ear pain")) {
                suggestingDoctors.clear();
                perticularSymtomsDotor = 0;
                for (doctor d : doctors) {
                    if (d.getSpeciality().trim().equalsIgnoreCase("ENT specialist")) {
                        perticularSymtomsDotor++;
                     
                            suggestingDoctors.add(d);
                        
                    }
                }
               
                    System.out.println("r10");
                    return suggestingDoctors;
                

            } else if (Pateint.getSymptoms().trim().equalsIgnoreCase("Skin infection")
                    || Pateint.getSymptoms().trim().equalsIgnoreCase("skin burn")) {
                suggestingDoctors.clear();
                perticularSymtomsDotor = 0;
                for (doctor d : doctors) {
                    if (d.getSpeciality().trim().equalsIgnoreCase("Dermatology")) {
                        perticularSymtomsDotor++;
                   
                            suggestingDoctors.add(d);
                        
                    }
                }
              
                    System.out.println("r13");
                    return suggestingDoctors;
                

            }
            System.out.println("r14");
            return suggestingDoctors;
        }
    }
}
