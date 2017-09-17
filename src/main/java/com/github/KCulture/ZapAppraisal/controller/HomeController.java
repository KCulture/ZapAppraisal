package com.github.KCulture.ZapAppraisal.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.KCulture.ZapAppraisal.Employee;
import com.github.KCulture.ZapAppraisal.EmployeeRepository;
import com.github.KCulture.ZapAppraisal.Responder;
import com.github.KCulture.ZapAppraisal.ResponderRepository;
import com.github.KCulture.ZapAppraisal.service.QuestionReadService;

@RestController
public class HomeController {

	@Autowired
	QuestionReadService questionReadService;

	@Autowired
	EmployeeRepository employeeRespository;

	@Autowired
	ResponderRepository responderRepository;

	@RequestMapping(value = "/employeeAppraisal/{id}", method = RequestMethod.GET, produces = "application/json")
	public String home(@ModelAttribute("model") ModelMap model,
	    @PathVariable String id) {
		Employee employee = employeeRespository.findOne(id);
		model.addAllAttributes(Arrays.asList(employee));
		return "index.html";
	}

	// @RequestMapping(value="Employee/{id}")
	// public String findUserById(@PathVariable() String
	// id,@ModelAttribute("model") ModelMap model){
	// String userJSON = mongoService.findOne(id).getId();
	// model.addAllAttributes(Arrays.asList(userJSON));
	// return "employeepage";
	// }

	@RequestMapping(value = "employees/{empId}/responders/{responderId}", method = RequestMethod.GET, consumes = "application/json", produces = "application/json")
	public Responder getResponder(@PathVariable String empId,
	    @PathVariable String responderId) {
		Employee employee = employeeRespository.findOne(empId);
		Responder responder = responderRepository.findOne(responderId);
		return responder;
	}
}
