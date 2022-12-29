package com.docdok.healthrelation.dto;

import java.io.Serializable;

public class PatientDto implements Serializable {
	private Long id;
	private String name;
	private String gender;
	private String mno;

	public PatientDto() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMno() {
		return mno;
	}

	public void setMno(String mno) {
		this.mno = mno;
	}

	@Override
	public String toString() {
		return "PatientDto [id=" + id + ", name=" + name + ", gender=" + gender + ", mno=" + mno + "]";
	}
	
}
