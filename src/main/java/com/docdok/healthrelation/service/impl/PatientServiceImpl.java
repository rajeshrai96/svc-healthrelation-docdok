package com.docdok.healthrelation.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.docdok.healthrelation.controller.PatientController;
import com.docdok.healthrelation.domain.Patient;
import com.docdok.healthrelation.dto.PatientDto;
import com.docdok.healthrelation.mapping.PatientMapper;
import com.docdok.healthrelation.repository.PatientRepository;
import com.docdok.healthrelation.service.PatientService;

@Service
public class PatientServiceImpl implements PatientService {
	Logger logger = LoggerFactory.getLogger(PatientController.class);

	@Autowired
	private PatientMapper patientMapper;

	@Autowired
	private PatientRepository patientRepository;

	@Override
	public PatientDto save(PatientDto patientDto) {
		logger.info("Request to save patient:{}", patientDto);
		Patient patient = patientMapper.dtoToPatient(patientDto);
		return patientMapper.patientToDto(patientRepository.save(patient));
	}

	@Override
	public PatientDto update(PatientDto patientDto) {
		logger.info("Request to update patient:{}", patientDto);
		Patient patient = patientMapper.dtoToPatient(patientDto);
		return patientMapper.patientToDto(patientRepository.save(patient));
	}

	@Override
	public PatientDto findOne(Long id) {
		logger.info("Request to get patient:{}", id);
		Optional<Patient> optional = patientRepository.findById(id);
		if (optional.isPresent()) {
			return patientMapper.patientToDto(optional.get());
		}
		return null;
	}

	@Override
	public List<PatientDto> findAll() {
		List<PatientDto> patientDtos = new ArrayList<>();
		patientRepository.findAll().forEach(p -> {
			PatientDto dto = new PatientDto();
			dto.setId(p.getId());
			dto.setName(p.getName());
			dto.setGender(p.getGender());
			dto.setMno(p.getMno());
			patientDtos.add(dto);
		});
		return patientDtos;
	}
}
