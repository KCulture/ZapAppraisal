package com.github.KCulture.ZapAppraisal;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Employee {

	@Id
	public String id;
	public String firstName;
	public String lastName;
	public Date hireDate;
	public String email;
	public List<Responder> contacts;
	public Integer stage; // TODO change back to ENUM if using Jsonparser
	public List<String> superiors;
	public String evaluationYear;

	public List<String> questions;
	public List<String> answers;
	public String link;

	Employee() {
	}

	Employee(String firstName, String lastName, Date hireDate, String email,
	    List<Responder> contacts, Integer stage, List<String> superiors,
	    String evalutationYear, List<String> questions, List<String> answers) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.hireDate = hireDate;
		this.email = email;
		this.contacts = contacts;
		this.stage = stage;
		this.superiors = superiors;
		this.evaluationYear = evalutationYear;
		this.questions = questions;
		this.answers = answers;

	}

	Employee(String id, String firstName, String lastName, Date hireDate,
	    String email, List<Responder> contacts, Integer stage,
	    List<String> superiors, String evalutationYear, List<String> questions,
	    List<String> answers) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.hireDate = hireDate;
		this.email = email;
		this.contacts = contacts;
		this.stage = stage;
		this.superiors = superiors;
		this.evaluationYear = evalutationYear;
		this.questions = questions;
		this.answers = answers;

	}

	public String getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public String getEmail() {
		return email;
	}

	public List<Responder> getContacts() {
		return contacts;
	}

	public Integer getStage() {
		return stage;
	}

	public List<String> getSuperiors() {
		return superiors;
	}

	public String getEvaluationYear() {
		return evaluationYear;
	}

	public List<String> getQuestions() {
		return questions;
	}

	public List<String> getAnswers() {
		return answers;
	}

	public String getLink() {
		return link;
	}

	public String toString() {
		ObjectMapper mapper = new ObjectMapper();
		String json = "";
		try {
			json = mapper.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return json;
	}
}
