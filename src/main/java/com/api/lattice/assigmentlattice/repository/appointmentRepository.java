package com.api.lattice.assigmentlattice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.lattice.assigmentlattice.entity.appointment;

@Repository
public interface appointmentRepository extends JpaRepository<appointment,Integer> {

    public appointment getById(int id);
    public List<appointment> findByPatientId(int id);

    public List<appointment> findByDoctorId(int id);
    
}
