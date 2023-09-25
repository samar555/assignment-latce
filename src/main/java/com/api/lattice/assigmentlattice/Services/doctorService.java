package com.api.lattice.assigmentlattice.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.lattice.assigmentlattice.entity.doctor;
import com.api.lattice.assigmentlattice.repository.doctorRepository;

@Service
public class doctorService {

    @Autowired
    private doctorRepository dr;

    public List<doctor> getAllDoctor() {
        List<doctor> docs = new ArrayList<>();
        docs = dr.findAll();
        System.out.println("this is run for service method " + docs);
        return docs;
    }

    public doctor createNewDoctor(doctor doctor) {

        return dr.save(doctor);
    }

    public doctor getDoctorById(int id) {
        return dr.findById(id);
    }

    public int deleteDoctor(int id) {
        try {
            dr.deleteById(id);
            return id;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}
