package com.docdok.healthrelation.mapping;

import org.springframework.stereotype.Component;

import com.docdok.healthrelation.domain.Patient;
import com.docdok.healthrelation.dto.PatientDto;

@Component
public class PatientMapper {

	public PatientDto patientToDto(Patient patient) {
		PatientDto patientDto = new PatientDto();
		patientDto.setId(patient.getId());
		patientDto.setName(patient.getName());
		patientDto.setMno(patient.getMno());
		patientDto.setGender(patient.getGender());
		return patientDto;
	}

	public Patient dtoToPatient(PatientDto dto) {
		Patient patient = new Patient();
		patient.setId(dto.getId());
		patient.setName(dto.getName());
		patient.setMno(dto.getMno());
		patient.setGender(dto.getGender());
		return patient;
	}

}
