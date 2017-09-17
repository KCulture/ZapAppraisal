package com.github.KCulture.ZapAppraisal;

import java.util.List;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Responder {

	@Id
	public String id;
	public String firstName;
	public String lastName;
	public String email;
	public List<String> questions;
	public List<String> answers;

	public Responder() {
	}

	public Responder(String firstName, String lastName, String email,
	    List<String> questions, List<String> answers) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.questions = questions;
		this.answers = answers;
	}

	public Responder(String id, String firstName, String lastName, String email,
	    List<String> questions, List<String> answers) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
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

	public String getEmail() {
		return email;
	}

	public List<String> getQuestions() {
		return questions;
	}

	public List<String> getAnswers() {
		return answers;
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
