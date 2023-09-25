package com.api.lattice.assigmentlattice.repository;
import com.api.lattice.assigmentlattice.entity.doctor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface doctorRepository extends JpaRepository<doctor,Integer>{
    public doctor findById(int id);
    
}
