package com.docdok.healthrelation.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.docdok.healthrelation.dto.PatientDto;

@Service
public interface PatientService {

	PatientDto save(PatientDto patientDto);

	PatientDto update(PatientDto patientDto);

	PatientDto findOne(Long id);

	List<PatientDto> findAll();

}
