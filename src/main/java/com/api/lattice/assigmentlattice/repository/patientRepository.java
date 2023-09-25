package com.api.lattice.assigmentlattice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.lattice.assigmentlattice.entity.patient;
import java.util.List;

@Repository
public interface patientRepository extends JpaRepository<patient,Integer>{
    public patient findById(int id);
    
}
