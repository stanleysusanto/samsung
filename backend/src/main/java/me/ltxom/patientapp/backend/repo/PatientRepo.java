package me.ltxom.patientapp.backend.repo;

import me.ltxom.patientapp.backend.entity.Patient;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PatientRepo extends MongoRepository<Patient, String> {

    Patient findByPatientId(String patientId);

}