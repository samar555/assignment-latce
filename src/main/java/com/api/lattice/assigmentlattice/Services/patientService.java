package com.api.lattice.assigmentlattice.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.lattice.assigmentlattice.entity.patient;
import com.api.lattice.assigmentlattice.repository.patientRepository;

@Service
public class patientService {
    @Autowired
    private patientRepository pr;

    public List<patient> getAllPatient() {
        try {
            return pr.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public patient addPatient(patient Patient) {
        System.out.println(Patient);
        return pr.save(Patient);
    }

    public patient getpPatientById(int id) {
        return pr.findById(id);
    }

    public int DeletePateint(int id) {
        try {
            pr.deleteById(id);
            return id;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

}
