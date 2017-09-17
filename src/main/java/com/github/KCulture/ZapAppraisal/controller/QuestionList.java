package com.github.KCulture.ZapAppraisal.controller;

import java.util.ArrayList;
import java.util.List;

public class QuestionList {
	private String firstname;
	private String lastname;
	private List<String> questions = new ArrayList<String>();
  
	public QuestionList(){
		this.questions.add("Glen");
		this.questions.add("Josh");
	}

	public QuestionList(String firstname,String lastname) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.questions.add("Glen");
		this.questions.add("Josh");
		
	}
	
	public String getFirstname(){
		return this.firstname;
	}
	
	public String getLastname(){
		return this.lastname;
	}
	
	public List<String> getQuestions(){
		return this.questions;
	}
}