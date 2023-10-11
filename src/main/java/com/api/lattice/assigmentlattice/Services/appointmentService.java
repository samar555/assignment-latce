package com.api.lattice.assigmentlattice.Services;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.lattice.assigmentlattice.entity.appointment;
import com.api.lattice.assigmentlattice.repository.appointmentRepository;

@Service
public class appointmentService {

    @Autowired
    private appointmentRepository appRepo;

    public appointment getaAppointmentbyid(int id) {
        return appRepo.getById(id);
    }

    public java.util.List<appointment> getAllAppoinment() {
        return appRepo.findAll();
    }

    public appointment saveAppointment(appointment app) {
        return appRepo.save(app);
    }

    public java.util.List<appointment> getallDoctorAppointments(int id) {
        return appRepo.findByDoctorId(id);
    }

    public java.util.List<appointment> getallPatientAppointments(int id) {
        return appRepo.findByPatientId(id);
    }
}
