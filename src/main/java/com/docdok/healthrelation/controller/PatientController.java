package com.docdok.healthrelation.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.docdok.healthrelation.dto.PatientDto;
import com.docdok.healthrelation.service.PatientService;

@RestController
@RequestMapping("/api")
public class PatientController {

	Logger logger = LoggerFactory.getLogger(PatientController.class);

	@Autowired
	private PatientService patientService;

	@GetMapping()
	public String getMessage() {
		return "Hello Users";
	}

	@PostMapping("/patient")
	public ResponseEntity<PatientDto> save(@RequestBody PatientDto patientDto) {
		logger.info("REST to create patient:{}", patientDto);
		patientDto = patientService.save(patientDto);
		return new ResponseEntity<>(patientDto, HttpStatus.CREATED);
	}

	@PutMapping("/patient")
	public ResponseEntity<PatientDto> update(@RequestBody PatientDto patientDto) {
		logger.debug("REST to update patient:{}", patientDto);
		patientDto = patientService.update(patientDto);
		return new ResponseEntity<>(patientDto, HttpStatus.OK);
	}

	@GetMapping("/patient/{id}")
	public ResponseEntity<PatientDto> findOne(@PathVariable Long id) {
		logger.debug("REST to create patient:{}", id);
		return new ResponseEntity<>(patientService.findOne(id), HttpStatus.OK);
	}

	@GetMapping("/patient")
	public ResponseEntity<List<PatientDto>> findAll() {
		logger.debug("REST to create patient:{}");
		return new ResponseEntity<>(patientService.findAll(), HttpStatus.OK);
	}
}
